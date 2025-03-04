package com.makeshop.podbbang.shared.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.makeshop.podbbang.shared.api.Resource
import com.makeshop.podbbang.shared.api.WebService
import com.makeshop.podbbang.shared.api.safeApiCall
import com.makeshop.podbbang.shared.data.EpisodeEntity
import com.makeshop.podbbang.shared.data.EpisodePaging
import com.makeshop.podbbang.shared.data.RecommendCastList
import com.makeshop.podbbang.shared.util.LineLog
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EpisodeRepository @Inject constructor(private val webService: WebService) {
    companion object {
        const val PAGING_LIMIT = 10
        const val SORT_DESC = "desc"
    }

    /**
     * 정렬을 기준으로 에피소드 목록 조회
     */
    fun episodeList(
        castId: String,
        offset: Int,
        limit: Int = PAGING_LIMIT,
        sort: String = SORT_DESC,
        with: String,
    ): Flow<PagingData<EpisodeEntity>> {
        return Pager(config = PagingConfig(
            pageSize = EpisodePagingSource.PAGE_SIZE, enablePlaceholders = true
        ), pagingSourceFactory = {
            EpisodePagingSource(
                webService, castId, offset, limit, sort, with
            )
        }).flow
    }

    suspend fun episodeList(
        castId: String,
        offset: Int,
        limit: Int = PAGING_LIMIT,
        sort: String = "desc"
    ): Resource<EpisodePaging> = safeApiCall {
        webService.getEpisodeList(castId, offset, limit, sort, "")
    }

}