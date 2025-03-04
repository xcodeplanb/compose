package com.makeshop.podbbang.shared.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Splash (
    @SerializedName("image")
    var image: String?,
    @SerializedName("no1")
    var no1: String?,
    @SerializedName("no2")
    var no2: String?,
    @SerializedName("badges")
    var badges: ArrayList<Badges>?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("play_history_log_time")
    var playHistoryLogTime: Int?    // 초단위
) : Parcelable {
    @Parcelize
    data class Badges (
        @SerializedName("type")
        var type: String?,
        @SerializedName("tintColor")
        var tintColor: String?,
        @SerializedName("textColor")
        var textColor: String?,
        @SerializedName("text")
        var text: String?
    ) : Parcelable
    companion object {
        fun mock() = Splash(
            image = "https://dimg.podbbang.com/splash/8f7308af-67eb-42f8-9cc8-28ce5e000cf9.jpeg",
            no1 = "",
            no2 ="",
            badges = arrayListOf(
                Badges("", "#FFD31010", "#FFFFFF", "LIVE"),
                Badges("outline", "#B50B1A", "#B50B1A", "HOT")
            ),
            description = "AM 06:50 ~ 7:50",
            null
        )
    }
}
