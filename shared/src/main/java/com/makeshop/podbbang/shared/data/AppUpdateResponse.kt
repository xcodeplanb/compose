package com.makeshop.podbbang.shared.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AppUpdateResponse(
    @SerializedName("isForceUpdate")
    val isForceUpdate: Boolean,
    @SerializedName("isUpdate")
    val isUpdate: Boolean
): Parcelable