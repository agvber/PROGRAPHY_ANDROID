package com.agvber.network.retrofit

import com.agvber.network.NetworkDataSource
import com.agvber.network.model.NetworkOrderBy
import com.agvber.network.model.PhotosResponse
import okhttp3.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitService @Inject constructor(
    okhttpCallFactory: Call.Factory
): NetworkDataSource {

    private val retrofit = Retrofit.Builder().run {
        baseUrl("https://api.unsplash.com")
        callFactory(okhttpCallFactory)
        addConverterFactory(MoshiConverterFactory.create())
        build()
    }

    private val networkService = retrofit.create<NetworkService>()
    override suspend fun getPhotos(page: Int, pageSize: Int, orderBy: NetworkOrderBy): List<PhotosResponse> {
        return networkService.getPhotos(page = page, pageSize = pageSize, orderBy = orderBy.params)
    }
}