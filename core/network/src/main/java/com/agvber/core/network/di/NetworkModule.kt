package com.agvber.core.network.di

import com.agvber.core.network.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesOkhttpCallFactory(): Call.Factory = OkHttpClient.Builder().run {
        addInterceptor(
            HttpLoggingInterceptor()
                .apply {
                    if (BuildConfig.DEBUG) {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    }
                }
        )
        addNetworkInterceptor {
            with(it) {
                val request = this.request().newBuilder().run {
                    addHeader(
                        "Authorization",
                        "Bearer Client-ID SJtd_ZxhIEPE21PcLbJxodoTbDEYTujFy0ftznhLXlA"
                    )
                    build()
                }

                proceed(request)
            }
        }
        build()
    }
}