package com.makeshop.podbbang.shared.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class EpisodeEntity(
    @SerializedName("id")           // 에피소드 고유 번호
    var id: String,
    @SerializedName("channel")      // 해당 에피소드의 방송 정보
    var channel: EpisodeCast?,
    @SerializedName("title")
    var title: String,                      // 제목
    @SerializedName("description")
    var description: String?,                // 설명 // 오디오북일때, description이 비어있으면, 책소개 정보를 가져온다
    @SerializedName("image")
    var image: String?,                      // 썸네일 url
    @SerializedName("media")
    var media: EpisodeMedia?,                // 미디어 정보
    @SerializedName("likeCount")
    var likeCount: Int,                     // 좋아요 수
    @SerializedName("isAdultOnly")
    var isAdultOnly: Boolean,               // 성인 에피소드 여부
    @SerializedName("isFree")
    var isFree: Boolean,                    // 무료 콘텐츠 여부
    @SerializedName("isPaid")
    var isPaid: Boolean,                    // 해당 사용자의 구매 여부
    //@SerializedName("canPlay")
    //var canPlay: Boolean,                   // 해당 사용자의 에피소드 재생 가능 여부
    @SerializedName("canDownload")
    var canDownload: Boolean,               // 해당 사용자의 다운로드 가능 여부
    @SerializedName("canDownloadMessage")
    var canDownloadMessage: String,          // 다운로드 불가 이유
    @SerializedName("pay")
    var pay: EpisodePay?,                   // 유료 컨텐츠 정보
    @SerializedName("sellEndAt")
    var sellEndAt: String?,                 // 무료로 전환되는 날(내일 무료, 00일 후 무료 - 30일 이하 남은 경우만 노출) TODO 확인
    @SerializedName("publishedAt")
    var publishedAt: String,                // 에피소드 등록 일시 (예: 2020-07-08 18:00:00)
    @SerializedName("commentCount")
    var commentCount: Int,                  // 댓글 수
    @SerializedName("paging")
    var paging: EpisodePrevNext?,            // 현재 에피소드의 이전,다음 에피소드 id
    @SerializedName("playlist")
    val playlist: Playlist?,                 // 매거진 에피소드인 경우 매거진 이슈 id
    @SerializedName("subtitle")
    val subtitle: String?,                   // 매거진 에피소드인 경우 매거진 이슈의 서브타이틀
    @SerializedName("defaultImage")
    val defaultImage: String?               // 에피소드 목록에서 image 값이 없을 때 보여줄 기본이미지
) : Parcelable {

    @Parcelize
    data class EpisodeCast(
        @SerializedName("id")            // 해당 에피소드의 캐스트 고유 번호
        var id: String,
        @SerializedName("type")
        var type: String?,
        @SerializedName("title")
        var title: String?,                     // 방송 제목 (신규 에피소드 목록에 포함)
        @SerializedName("image")
        var image: String?,                     // 썸네일 이미지 (신규 에피소드 목록에 포함)
        @SerializedName("useEpisodeSupport")
        var useEpisodeSupport: Boolean?,          // 에피소드 후원 여부
        @SerializedName("isSubscribed")
        var isSubscribed: Boolean?,             // 구독여부
        @SerializedName("subscribeCount")
        var subscribeCount: Int,                // 구독자 수
        @SerializedName("useComment")
        var useComment: Boolean?,                 // 댓글 사용 여부
        @SerializedName("useReport")
        val useReport: Boolean                  // 신고하기 사용여부
    ) : Parcelable {
    }

    @Parcelize
    data class EpisodeMedia(
        @SerializedName("url")
        var url: String,                        // 에피소드 미디어 URL
        @SerializedName("type")
        var type: String,                       // 에피소드 미디어 종류 (audio|video|etc)
        @SerializedName("duration")
        var duration: String,                   // 미디어 재생 시간 (예: 00:56:37)
        @SerializedName("length")
        var length: Long,                       // 미디어 용량
        @SerializedName("playSeconds")
        var playSeconds: Int,          // 사용자의 최근 재생 시간 (초)
        @SerializedName("lastPlayedAt")
        var lastPlayedAt: String

    ) : Parcelable {

    }

    @Parcelize
    data class EpisodePay(                      // 단건 유료 컨텐츠 정보
        @SerializedName("method")
        var method: String?,                     // 유료 컨텐츠 종류 (cash: 기간 제한 유료 에피소드, ticket: 채널 이용권 또는 대여권 방송에 속한 유료 컨텐츠)
        @SerializedName("cash")
        var cash: Long,                         // 에피소드 가격
        @SerializedName("remainsForFree")
        var remainsForFree: String?,            // 기간 제한 유료 에피소드의 만료 날짜 (예: 2020-09-24 00:00:00) (신규 에피소드 목록에 포함)
        @SerializedName("dayForFree")
        var dayForFree: String?                 // 무료 전환 남은 날짜 메시지 (신규 에피소드 목록에 포함) (예: "3일 후 무료")
    ) : Parcelable

    @Parcelize
    data class EpisodePrevNext(
        @SerializedName("prev")
        var prev: String?,
        @SerializedName("next")
        var next: String?
    ) : Parcelable

    @Parcelize
    data class Playlist(
        @SerializedName("id")
        val id: String
    ) : Parcelable
}

