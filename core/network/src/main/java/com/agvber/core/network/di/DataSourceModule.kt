package com.agvber.core.network.di

import com.agvber.core.network.NetworkDataSource
import com.agvber.core.network.retrofit.RetrofitService
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