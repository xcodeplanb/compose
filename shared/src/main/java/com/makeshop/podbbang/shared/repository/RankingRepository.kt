package com.makeshop.podbbang.shared.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.makeshop.podbbang.shared.api.Resource
import com.makeshop.podbbang.shared.api.WebService
import com.makeshop.podbbang.shared.api.safeApiCall
import com.makeshop.podbbang.shared.data.CategoryList
import com.makeshop.podbbang.shared.data.EpisodePaging
import com.makeshop.podbbang.shared.data.RankingPaging
import com.makeshop.podbbang.shared.repository.EpisodeRepository.Companion.PAGING_LIMIT
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RankingRepository @Inject constructor(private val webService: WebService) {
    fun rankingList(
        type: String,
        categoryId: String?
    ): Flow<PagingData<RankingPaging.RankEntity>> {

        return Pager(config = PagingConfig(
            pageSize = RankingPagingSource.PAGE_SIZE, enablePlaceholders = true
        ), pagingSourceFactory = {
            RankingPagingSource(
                webService, type, categoryId
            )
        }).flow
    }

    suspend fun categoryList(
        isRanking: Boolean
    ): Resource<CategoryList> = safeApiCall {
        webService.getCategoryList(isRanking)
    }
}