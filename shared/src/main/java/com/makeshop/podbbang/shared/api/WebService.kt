package com.makeshop.podbbang.shared.api

import com.makeshop.podbbang.shared.data.AppUpdateResponse
import com.makeshop.podbbang.shared.data.CategoryList
import com.makeshop.podbbang.shared.data.EpisodePaging
import com.makeshop.podbbang.shared.data.RankingPaging
import com.makeshop.podbbang.shared.data.RecommendCastList
import io.reactivex.Single
import retrofit2.http.*

interface WebService {

    @GET("/configurations")
    fun getConfigurations(
        @Query("appversion") appversion: String
    ): AppUpdateResponse

    /** 랭킹 목록 **/
    @GET("/ranking")
    suspend fun getRankingList(
        @Query("type") type: String,
        @Query("limit") limit: Int,
        @Query("category_id") categoryId: String?,
        @Query("next") next: String?
    ): RankingPaging

    /**
     * 정렬을 기준으로 에피소드 목록 조회
     * ?with=image 추가 시 에피소드 썸네일이 없는 경우에도 image 수신
     */
    @GET("/podcasts/{castid}/episodes/")
    suspend fun getEpisodeList(
        @Path("castid") castId: String,
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?,
        @Query("sort") sort: String?,
        @Query("with") with: String?
    ): EpisodePaging

    @POST
    suspend fun getRecommendCastList(
        @Url url: String
    ): RecommendCastList

    /**
     * 카테고리 목록
     * isRanking : 랭킹 화면에서 호출했는지 여부
     */
    @GET("/categories")
    suspend fun getCategoryList(
        @Query("isRanking") isRanking: Boolean
    ) : CategoryList

//    @GET("/search/users")
//    suspend fun searchUser(
//        @Header("Authorization") token: String,
//        @QueryMap queryMap: HashMap<String, Any>
//    ): GithubUser
//
//    @GET("/search/repositories")
//    suspend fun searchRepository(
//        @Header("Authorization") token: String,
//        @QueryMap queryMap: HashMap<String, Any>
//    ): GithubRepository
//
//    @GET
//    suspend fun getWeather(
//        @Url url: String,
//        @Query("lat") lat: Double,
//        @Query("lon") lon: Double,
//        @Query("exclude") exclude: String,
//        @Query("appid") appid: String,
//    ): Weather
//
//    @Headers("Authorization: KakaoAK f137124b0cf4c5f01867b9c2afeb983f")
//    @GET
//    suspend fun searchDaumImage(
//        @Url url: String,
//        @QueryMap map: HashMap<String, Any>
//    ): KakaoImage
//
//    @Multipart
//    @PUT("/v2/petping/pet-profiles/{petId}")
//    suspend fun partMap(
//        @Header("Authorization") authKey: String,
//        @Path("petId") petId: Int,
//        @PartMap body: Map<String, @JvmSuppressWildcards RequestBody>,
//        @Part photoFile: MultipartBody.Part
//    ): CommonResponse<*>
//
//    @Multipart
//    @POST("")
//    suspend fun part(
//        @Header("Authorization") authKey: String,
//        @Part memberId: MultipartBody.Part,
//        @Part file: List<MultipartBody.Part>
//    ): CommonResponse<*>

}