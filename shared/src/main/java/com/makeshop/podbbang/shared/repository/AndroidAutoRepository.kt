package com.makeshop.podbbang.shared.repository

import com.makeshop.podbbang.shared.api.Resource
import com.makeshop.podbbang.shared.api.WebService
import com.makeshop.podbbang.shared.api.safeApiCall
import com.makeshop.podbbang.shared.data.RecommendCastList
import javax.inject.Inject

class AndroidAutoRepository @Inject constructor(private val webService: WebService) {

    /**
     * 구매 에피소드 리스트
     */
    fun getBuyEpisodeList(){

    }

    /**
     * 로그인 사용자, 다운로드
     */
    fun getDownloadList(){

    }

    /**
     * 라이브 방송
     */
    fun getLiveOnList(){

    }

    /**
     * 에피소드 리스트
     */
    fun getEpisodeList() {

    }

    /**
     * 추천 캐스트 리스트
     */
    suspend fun recommendCastList(
        url: String
    ): Resource<RecommendCastList> = safeApiCall {
        webService.getRecommendCastList(url)
    }

}