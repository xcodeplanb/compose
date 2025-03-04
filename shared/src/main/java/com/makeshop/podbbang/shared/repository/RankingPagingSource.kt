package com.makeshop.podbbang.shared.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.makeshop.podbbang.shared.api.Resource
import com.makeshop.podbbang.shared.api.WebService
import com.makeshop.podbbang.shared.api.safeApiCall
import com.makeshop.podbbang.shared.data.RankingPaging
import com.makeshop.podbbang.shared.util.LineLog

class RankingPagingSource(
    private val webService: WebService,
    val type: String,
    var cateGoryId: String?
) : PagingSource<String, RankingPaging.RankEntity>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, RankingPaging.RankEntity> {
        val startKey = params.key
        LineLog.d("MusicService RankingPagingSource")
        return try {
            val response =
                safeApiCall {
                    webService.getRankingList(type, LIMIT_SIZE, cateGoryId, startKey)
                }

            if (response is Resource.Success) {
                val nextKey: String = response.value.next
                val data = response.value.data
                LoadResult.Page(
                    data = data,
                    prevKey = startKey,
                    nextKey = if (data.isEmpty()) null else nextKey
                )
            } else {
                LoadResult.Error(Throwable())
            }
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<String, RankingPaging.RankEntity>): String? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
                ?: state.closestPageToPosition(anchorPosition)?.nextKey
        }
    }

    companion object {
        const val PAGE_SIZE = 20
        const val LIMIT_SIZE = 50
    }
}