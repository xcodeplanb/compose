package com.makeshop.podbbang.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RankingPaging(
    @SerializedName("createdAt")
    val createdAt: String, // ex: 2021-11-30 13:00:00
    @SerializedName("data")
    val data: List<RankEntity> = listOf(),
    @SerializedName("next")
    val next: String,      // 다음 목록의 키값
    @SerializedName("summary")
    val summary: Summary
) : Parcelable {

    @Parcelize
    data class RankEntity(
        @SerializedName("id")
        var id: String,
        @SerializedName("type")
        var type: String?,
        @SerializedName("title")
        var title: String,
        @SerializedName("image")
        var image: String,
        @SerializedName("category")
        var category: CategoryEntity?,
        @SerializedName("copyright")
        var copyright: String,
        @SerializedName("subscribeCount")
        var subscribeCount: Int,
        @SerializedName("rank")
        var rank: Int,
        @SerializedName("rankChange")             // +,- 등락, (new : 진입)
        var rankChange: String?,
        @SerializedName("onAir")
        var onAir: Boolean?,
        @SerializedName("isAdultOnly")
        var isAdultOnly: Boolean?,                       //  성인 콘텐츠 여부
        @SerializedName("updatedAt")
        var updatedAt: String?,                          // (2021-01-19 10:26:36)
    ) : Parcelable {

        @Parcelize
        data class CategoryEntity(
            @SerializedName("id")
            val id: String,                                  // 카테고리 고유 ID
            @SerializedName("name")
            val name: String                                // 카테고리명
        ) : Parcelable

        constructor() : this(
            "", null, "", "",
            null, "", 0,
            0, "", null, null, null
        )
    }

    @Parcelize
    data class Summary(
        @SerializedName("totalCount")
        val totalCount: Int
    ) : Parcelable
}

