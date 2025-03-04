package com.makeshop.podbbang.shared.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * 메인 플레이어 내 에피소드 목록에서 사용
 */
@Parcelize
data class EpisodePaging(
    @SerializedName("data") val data: List<EpisodeEntity> = listOf(),
    @SerializedName("summary") val summary: Summary?,
    @SerializedName("paging") val paging: Paging?,
    @SerializedName("next") val next: String,      // 다음 목록의 키값
) : Parcelable {

    @Parcelize
    data class Summary(
        @SerializedName("totalCount") val totalCount: Int
    ) : Parcelable

    @Parcelize
    data class Paging(
        @SerializedName("prev") val prev: String?,              // 위로 스크롤 시 해당 값을 이전 에피소드 목록 호출에서 사용
        @SerializedName("next") val next: String?               // 아래로 스크롤 시 해당 값을 다음 에피소드 목록 호출에서 사용
    ) : Parcelable
}
