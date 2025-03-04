package com.makeshop.podbbang.shared.data


import com.google.gson.annotations.SerializedName

class RecommendCastList : ArrayList<RecommendCastList.RecommendCastListItem>() {
    data class RecommendCastListItem(
        @SerializedName("channel_title") val channelTitle: String?,
        @SerializedName("count_like") val countLike: String?,
        @SerializedName("created") val created: String?,
        @SerializedName("episode_title") val episodeTitle: String?,
        @SerializedName("episode_uid") val episodeUid: String?,
        @SerializedName("image") val image: String?,
        @SerializedName("it_duration") val itDuration: String?,
        @SerializedName("playurl") val playurl: String?,
        @SerializedName("podbbang_uid") val podbbangUid: String?
    )
}