package com.makeshop.podbbang.mobile

import android.text.TextUtils
import android.webkit.JavascriptInterface
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import com.makeshop.podbbang.shared.util.LineLog

class PodbbangWebBridge {
    var isDisableSkeleton: Boolean = false // 스켈레톤 사용 여부


    // 웹뷰로 데이터 전달 시 사용할 리스너
    interface HandlerListener {
        fun getPaymentInapp(product_id: String?)
        fun getPaymentInappList(type: String?)
        fun setPaymentInapp(type: String?, ProductId: String?)
        fun restorePurchase(cash: String?)
        fun changeMagazineSubscriptionState(magazineId: String?, state: String?)
        fun sendAlert(data: String?)
        fun enableSkeleton(enable: Boolean?)
        fun emailLogin(email: String?, password: String?)
        fun backPress()
        fun showFreeCashScreen()
        fun closeFreeCashScreen()
        fun showCardPointScreen()
        fun closeCardPointScreen()
        fun refreshToken()
        fun enableBackPressCallback(enable: Boolean?)
//        val livePlayerState: Unit

        fun useChangeLivePlayerState(use: Boolean)
//        fun onAddPlayerTrackList(liveTrack: ArrayList<Media>?)
        fun onClearPlayerTackList()
        fun onGetPlayerTrackList()
        fun onPlayPlayerTrackList()
        fun onPlayPlayer()
        fun onPausePlayer()
        fun onStopPlayer()
        fun onShowCertifyDialog(title: String?, message: String?)
        fun setAudioMute(mute: Boolean?)

        //        void loginSns(UserSns userSns);
        fun showConfirmDialog(message: String?)
    }

    private var handlerListener: HandlerListener? = null
    fun setHandlerListener(handlerListener: HandlerListener?) {
        this.handlerListener = handlerListener
    }

    @get:JavascriptInterface
    val version: String
        get() {
//            val auth: DeviceInfo = DeviceInfo(PbApplication.context)
//            val version: String = auth.getVersion()
            return version
        }

    @get:JavascriptInterface
    val isOs: String
        get() = "android"

    // 단일상품 리스트 불러오기
    @JavascriptInterface
    fun getInAppProduct(product_id: String) {
        LineLog.d("단일상품 가져오기 : querySkuInApp($product_id)")

        // 웹뷰로 전달
        handlerListener!!.getPaymentInapp(product_id)
    }


    // 결제모듈 리스트 불러오기
    @JavascriptInterface
    fun getInAppProducts(type: String) {
        //billingManager.querySkuInAppLists();

        LineLog.d("데이터 가져오기 : querySkuInAppLists($type)")

        // 웹뷰로 전달
        handlerListener!!.getPaymentInappList(type)
    }

    // 구매복원
    @JavascriptInterface
    fun restorePurchase(cash: String?) {
        //billingManager.querySkuInAppLists();

        LineLog.d(" 구매복원 : restorePurchase()")

        // 웹뷰로 전달
        handlerListener!!.restorePurchase(cash)
    }

    // 구매복원
    @JavascriptInterface
    fun changeMagazineSubscriptionState(magazineId: String?, state: String?) {
        //billingManager.querySkuInAppLists();

        LineLog.d(" 구매복원 : restorePurchase()")


        // 웹뷰로 전달
        handlerListener!!.changeMagazineSubscriptionState(magazineId, state)
    }


    // 결제 시도
    @JavascriptInterface
    fun purchaseInAppProduct(type: String?, ProductId: String?, OnlyOne: String?) {
//        if (UniqueDataDAO.`in`().checkLogin()) {
//            //Toast.makeText(PbApplication.context, "ProductId : " + ProductId + " / OnlyOne : " + OnlyOne, Toast.LENGTH_SHORT).show();
//            handlerListener!!.setPaymentInapp(type, ProductId)
//        }
    }

    @JavascriptInterface
    fun whatPlay(): String {
        var curEpisodeNum: String? = null
        var isPlaying = "true"

//        try {
//            curEpisodeNum =
//                if (TextUtils.isEmpty(PlayerServiceViewModel.INSTANCE.getEpisodeId())) "null"
//                else PlayerServiceViewModel.INSTANCE.getEpisodeId()
//
//            isPlaying = (if (PlayerServiceViewModel.INSTANCE.isPlaying()) "true" else "false")
//        } catch (throwable: Throwable) {
//        }

        return "$curEpisodeNum,$isPlaying"
    }

    @get:JavascriptInterface
    val userId: String
        get() {
            var userID = "false"
//            if (UniqueDataDAO.`in`().checkLogin()) {
//                userID = UniqueDataDAO.`in`().getValue(DeviceInfo.KEY_MEMBERUNIQUE_NUM)
//                if (TextUtils.isEmpty(userID)) userID = "false"
//            }
            return userID
        }

    @JavascriptInterface
    fun login() {
//        LineLog.d("login()")
//        if (PbApplication.`in`().getCurrentActivity() != null
//            && (PbApplication.`in`().getCurrentActivity() is MainActivity)
//        ) {
//            PbApplication.`in`().getCurrentActivity().runOnUiThread(Runnable {
//                (PbApplication.`in`()
//                    .getCurrentActivity() as MainActivity).openLogin()
//            })
//        }
    }

    @JavascriptInterface
    fun backPress() {
        LineLog.d("onBackPressed() backPress()")
        //PbApplication.in().getCurrentActivity().onBackPressed();
        handlerListener!!.backPress()
    }

    @JavascriptInterface
    fun setCustomBackEvent() {
        handlerListener!!.enableBackPressCallback(true)
    }

    @JavascriptInterface
    fun unSetCustomBackEvent() {
        handlerListener!!.enableBackPressCallback(false)
    }

    @JavascriptInterface
    fun alert(data: String) {
        LineLog.d("alert() data: $data")

        // 웹뷰로 전달
        handlerListener!!.sendAlert(data)
    }

    @JavascriptInterface
    fun viewDidLoad() {
        isDisableSkeleton = true

        // 웹뷰로 전달
        handlerListener!!.enableSkeleton(false)
    }

    // 무료캐시충전소 호출
    @JavascriptInterface
    fun showFreeCashScreen() {
        handlerListener!!.showFreeCashScreen()
    }

    // 무료캐시충전소 닫기
    @JavascriptInterface
    fun closeFreeCashScreen() {
        handlerListener!!.closeFreeCashScreen()
    }

    // 카드포인트충전창 호출
    @JavascriptInterface
    fun showCardPointScreen() {
        handlerListener!!.showCardPointScreen()
    }

    // 카드포인트충전창 닫기
    @JavascriptInterface
    fun closeCardPointScreen() {
        handlerListener!!.closeCardPointScreen()
    }


    @JavascriptInterface
    fun emailLogin(id: String, password: String?) {
        LineLog.d("emailLogin() id: $id")

        if (!TextUtils.isEmpty(id) && !TextUtils.isEmpty(password)) {
            handlerListener!!.emailLogin(id, password)
        }
    }

    @JavascriptInterface
    fun logout() {
//        UniqueDataDAO.`in`().logout()
    }

    @JavascriptInterface
    fun refreshToken() {
        handlerListener!!.refreshToken()
    }

//    @get:JavascriptInterface
//    val livePlayerState: Unit
//        /**
//         * 라이브 플레이어 상태 전달
//         */
//        get() {
//            LineLog.d("[MUSICPOD] getLivePlayerState()")
//            handlerListener!!.livePlayerState
//        }

    /**
     * 현재 웹뷰에서 라이브 플레이어 상태를 전달할지 여부 설정
     */
    @JavascriptInterface
    fun useChangeLivePlayerState(use: Boolean) {
        LineLog.d("[MUSICPOD] useChangeLivePlayerState()")
        handlerListener!!.useChangeLivePlayerState(use)
    }

    /**
     * 라이브 플레이어에서 재생할 미디어(트랙) 데이터 추가
     * @param mediaList
     */
    @JavascriptInterface
    fun addPlayerTrackList(mediaList: String) {
        LineLog.d("[MUSICPOD] mediaList: $mediaList")

//        if (TextUtils.isEmpty(mediaList)) return
//
//        val type = object : TypeToken<ArrayList<Media?>?>() {}.type
//        val liveTrack: ArrayList<Media> =
//            RetrofitManager.INSTANCE.getGson().fromJson(mediaList, type)
//        if (liveTrack != null && !liveTrack.isEmpty()) {
//            for (live in liveTrack) {
//                live.setTitle(live.getTitle().trim())
//            }
//            handlerListener!!.onAddPlayerTrackList(liveTrack)
//        }
    }

    /**
     * 라이브 트랙 목록 삭제
     */
    @JavascriptInterface
    fun clearPlayerTrackList() {
        LineLog.d("[MUSICPOD] clear live track")

        handlerListener!!.onClearPlayerTackList()
    }

    @get:JavascriptInterface
    val playerTrackList: Unit
        /**
         * 라이브 트랙 목록 전달
         */
        get() {
            LineLog.d("[MUSICPOD] received Get live track")

            handlerListener!!.onGetPlayerTrackList()
        }

    /**
     * 라이브 트랙 재생
     */
    @JavascriptInterface
    fun playPlayerTrackList() {
        LineLog.d("[MUSICPOD] play live")

        handlerListener!!.onPlayPlayerTrackList()
    }

    /**
     * 플레이어 재생
     */
    @JavascriptInterface
    fun playPlayer() {
        LineLog.d("[MUSICPOD] play")

        handlerListener!!.onPlayPlayer()
    }

    /**
     * 플레이어 일시중지
     */
    @JavascriptInterface
    fun pausePlayer() {
        LineLog.d("[MUSICPOD] pause")

        handlerListener!!.onPausePlayer()
    }

    /**
     * 플레이어 중지
     */
    @JavascriptInterface
    fun stopPlayer() {
        LineLog.d("[MUSICPOD] stop")

        handlerListener!!.onStopPlayer()
    }

    /**
     * 본인인증 다이얼로그 출력
     */
    @JavascriptInterface
    fun certifyConfirmDialog(data: String) {
        LineLog.d("[MUSICPOD] data: $data")

//        if (TextUtils.isEmpty(data)) {
//            // 기본 다이얼로그 출력
//            handlerListener!!.onShowCertifyDialog(null, null)
//        } else {
//            val jsonObject = JsonParser.parseString(data).asJsonObject
//
//            if (!jsonObject.isJsonObject) return
//
//            val title: String = GsonUtils.INSTANCE.getString(jsonObject, "title", "")
//            val message: String = GsonUtils.INSTANCE.getString(jsonObject, "message", "")
//
//            handlerListener!!.onShowCertifyDialog(title, message)
//        }
    }

    /**
     * 오디오 볼륨 음소거
     */
    @JavascriptInterface
    fun setAudioMute(mute: Boolean?) {
        handlerListener!!.setAudioMute(mute)
    }

    /**
     * 이메일 회원 가입 후 이메일 로그인 화면 출력
     */
    @JavascriptInterface
    fun joinEmailSuccess(data: String) {
        LineLog.d("[Login] data: $data")

//        if (!TextUtils.isEmpty(data)) {
//            try {
//                val jsonObject = JsonParser.parseString(data).asJsonObject
//
//                if (!jsonObject.isJsonObject) return
//
//                val email: String = GsonUtils.INSTANCE.getString(jsonObject, "email", "")
//
//                if (PbApplication.`in`().getCurrentActivity() != null
//                    && (PbApplication.`in`().getCurrentActivity() is MainActivity)
//                ) {
//                    PbApplication.`in`().getCurrentActivity().runOnUiThread(Runnable {
//                        (PbApplication.`in`()
//                            .getCurrentActivity() as MainActivity).openEmailLogin(email)
//                    })
//                }
//            } catch (ex: Exception) {
//                ex.printStackTrace()
//            }
//        }
    }

    /**
     * SNS 회원가입 완료 후 로그인 처리
     */
    @JavascriptInterface
    fun joinSnsSuccess(data: String) {
        LineLog.d("[Login] data: $data")

//        if (!TextUtils.isEmpty(data)) {
//            try {
//                val jsonObject = JsonParser.parseString(data).asJsonObject
//
//                if (!jsonObject.isJsonObject) return
//
//                val authId: String = GsonUtils.INSTANCE.getString(jsonObject, "authId", "")
//                val snsType: String = GsonUtils.INSTANCE.getString(jsonObject, "snsType", "")
//
//                if (!authId.isEmpty() && !snsType.isEmpty()) {
//                    handlerListener.loginSns(UserSns(snsType, authId, null))
//                }
//            } catch (ex: Exception) {
//                ex.printStackTrace()
//            }
//        }
    }

    /**
     * 로그인 전 본인인증 완료 후 결과
     * @param data
     */
    @JavascriptInterface
    fun certifyResult(data: String) {
        LineLog.d("data: $data")

        //        if(BuildConfig.DEBUG) {
//            data = "{\"name\":\"김이박\",\"birthday\":\"2020-04-01\"," +
//                    "\"gender\":\"F\",\"phone\":\"010-0000-1111\",\"isChild\":true,\"certify\":\"CA\"," +
//                    "\"ci\":\"abcd1234!@#$\"}";
//        }
//        if (!TextUtils.isEmpty(data)) {
//            val certify: Certify =
//                RetrofitManager.INSTANCE.getGson().fromJson(data, Certify::class.java)
//
//            if (certify.getError() != null) {
//                if (!TextUtils.isEmpty(certify.getError().getType())
//                    && !TextUtils.isEmpty(certify.getError().getMessage())
//                ) {
//                    // 에러 다이얼로그 출력
//                    handlerListener!!.showConfirmDialog(certify.getError().getMessage())
//                }
//            } else {
//                // 본인인증 이전 화면에서 결과 옵저버
//                CertifyEventBus.INSTANCE.post(certify)
//            }
//        }
    }

    companion object {
        var STATE_LOAD: String = "load"
        var STATE_APPEAR: String = "appear"
        var STATE_DISAPPEAR: String = "disappear"


        var PLAY_STATE_PLAY: String = "PLAY"
        var PLAY_STATE_PLAYING: String = "PLAYING"
        var PLAY_STATE_PAUSE: String = "PAUSE"
    }
}

