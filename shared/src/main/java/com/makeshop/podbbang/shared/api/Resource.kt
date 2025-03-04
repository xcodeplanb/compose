package com.makeshop.podbbang.shared.api

import com.makeshop.podbbang.shared.data.ErrorResponse
import okhttp3.ResponseBody

sealed class Resource<out T> {
    data object Loading : Resource<Nothing>()
    data class Success<out T>(val value: T) : Resource<T>()
    data class Error(
        val errorCode: String?, val errorBody: ErrorResponse?
    ) : Resource<Nothing>()
    data class Failure(
        val errorCode: Int?, val errorBody: ResponseBody?
    ) : Resource<Nothing>()
}
