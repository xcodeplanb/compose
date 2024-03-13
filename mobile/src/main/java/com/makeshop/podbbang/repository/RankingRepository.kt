package com.makeshop.podbbang.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.makeshop.podbbang.api.WebService
import com.makeshop.podbbang.data.RankingPaging
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
}
