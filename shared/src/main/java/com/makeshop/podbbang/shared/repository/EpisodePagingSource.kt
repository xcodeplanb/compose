package com.makeshop.podbbang.shared.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.makeshop.podbbang.shared.api.Resource
import com.makeshop.podbbang.shared.api.WebService
import com.makeshop.podbbang.shared.api.safeApiCall
import com.makeshop.podbbang.shared.data.EpisodeEntity
import com.makeshop.podbbang.shared.util.LineLog

class EpisodePagingSource(
    private val webService: WebService,
    val castId: String,
    val offset: Int?,
    val limit: Int?,
    val sort: String?,
    val with: String?
) : PagingSource<String, EpisodeEntity>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, EpisodeEntity> {
        val startKey = params.key
        LineLog.d("MusicService EpisodePagingSource")
        return try {
            val response =
                safeApiCall {
                    webService.getEpisodeList(castId, offset, limit, sort, with)
                }

            if (response is Resource.Success) {
                val nextKey: String = response.value.next
                val data = response.value.data
//                val nextKey: String = response.value.paging?.next.toString()
//                val data = response.value.data
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

    override fun getRefreshKey(state: PagingState<String, EpisodeEntity>): String? {
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