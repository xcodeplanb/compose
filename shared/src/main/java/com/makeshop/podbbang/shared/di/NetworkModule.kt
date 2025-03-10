package com.makeshop.podbbang.shared.di

import android.content.ComponentName
import android.content.Context
import android.os.Build
import com.google.android.datatransport.BuildConfig
import com.makeshop.podbbang.shared.api.HeaderInterceptor
import com.makeshop.podbbang.shared.api.WebService
import com.makeshop.podbbang.shared.common.MusicServiceConnection
import com.makeshop.podbbang.shared.media.MusicService
import com.makeshop.podbbang.shared.repository.EpisodeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val CONNECT_TIMEOUT = 15L
    private const val WRITE_TIMEOUT = 15L
    private const val READ_TIMEOUT = 15L
    private const val URL = "https://app-api6.podbbang.com"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val userAgent = "${BuildConfig.VERSION_NAME}; " +
                "${Build.MODEL}; Android ${Build.VERSION.RELEASE}"
        return OkHttpClient.Builder().apply {
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            addInterceptor(HeaderInterceptor(userAgent))
            addNetworkInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideWebService(retrofit: Retrofit): WebService {
        return retrofit.create(WebService::class.java)
    }

    @Provides
    @Singleton
    fun provideMusicServiceConnection(@ApplicationContext appContext: Context): MusicServiceConnection {
        return MusicServiceConnection.getInstance(
            appContext,
            ComponentName(appContext, MusicService::class.java)
        )
    }

    @Provides
    @Singleton
    fun provideEpisodeRepository(webService: WebService): EpisodeRepository {
        return EpisodeRepository(webService)
    }
}