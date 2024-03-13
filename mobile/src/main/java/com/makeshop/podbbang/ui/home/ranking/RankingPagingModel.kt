package com.makeshop.podbbang.ui.home.ranking

import com.makeshop.podbbang.data.RankingPaging
import com.makeshop.podbbang.data.ThumbNailBanners
import java.util.UUID

sealed class PagingUiModel() {
    data class Item(var item: RankingPaging.RankEntity) : PagingUiModel()
    //    data class Advertise(var banner: ThumbNailBanners.ThumbNailBanner?): DataModel(DataType.ADVERTISE)
    data class SeparatorItem(val id : String = UUID.randomUUID().toString()) : PagingUiModel()
    data class Footer(val id : String = UUID.randomUUID().toString()) : PagingUiModel()
}