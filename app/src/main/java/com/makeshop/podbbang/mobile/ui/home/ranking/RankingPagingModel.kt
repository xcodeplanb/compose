package com.makeshop.podbbang.mobile.ui.home.ranking

import com.makeshop.podbbang.shared.data.RankingPaging
import java.util.UUID

sealed class PagingUiModel() {
    data class Item(var item: RankingPaging.RankEntity) : PagingUiModel()
    //    data class Advertise(var banner: ThumbNailBanners.ThumbNailBanner?): DataModel(DataType.ADVERTISE)
    data class SeparatorItem(val id : String = UUID.randomUUID().toString()) : PagingUiModel()
    data class Footer(val id : String = UUID.randomUUID().toString()) : PagingUiModel()
}