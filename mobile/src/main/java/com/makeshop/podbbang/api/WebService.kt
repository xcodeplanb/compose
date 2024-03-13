package com.makeshop.podbbang.api

import com.makeshop.podbbang.data.AppUpdateResponse
import com.makeshop.podbbang.data.RankingPaging
import io.reactivex.Single
import okhttp3.MultipartBody
import okhttp3.RequestBody
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
    ) : RankingPaging

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