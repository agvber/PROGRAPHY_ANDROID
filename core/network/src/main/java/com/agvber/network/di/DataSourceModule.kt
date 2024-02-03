package com.agvber.network.di

import com.agvber.network.NetworkDataSource
import com.agvber.network.retrofit.RetrofitService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindsNetworkDataSource(
        retrofitService: RetrofitService
    ): NetworkDataSource
}