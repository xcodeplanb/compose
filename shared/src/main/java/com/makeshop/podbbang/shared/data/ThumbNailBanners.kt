package com.makeshop.podbbang.shared.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
data class ThumbNailBanners (
    @SerializedName("banners")
    val banners: List<ThumbNailBanner> = listOf()
): Parcelable {

    @Parcelize
    data class ThumbNailBanner(
        @SerializedName("no")
        val no: String,
        @SerializedName("image")
        val image: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("link")
        val link: String
    ): Parcelable
}
