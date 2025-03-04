package com.makeshop.podbbang.shared.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryList(
    @SerializedName("data")
    val data: List<Category> = listOf()
): Parcelable {
    @Parcelize
    data class Category (
        @SerializedName("no")
        var id: String,
        @SerializedName("title")
        var title: String?,
        @SerializedName("image")
        var image: String?,
        @SerializedName("isSelected")
        var isSelected: Boolean? = false
    ): Parcelable
}