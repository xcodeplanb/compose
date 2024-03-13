package com.makeshop.podbbang.repository

import android.util.Log
import com.makeshop.podbbang.api.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

suspend fun <T> safeApiCall(apiCall: suspend () -> T ): Resource<T> {
    return withContext(Dispatchers.IO)  {
        try {
            Resource.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is HttpException -> {
                    Resource.Failure(throwable.code(), throwable.response()?.errorBody())
                }
                else -> {
                    Resource.Failure(null, null)
                }
            }
        }
    }
}