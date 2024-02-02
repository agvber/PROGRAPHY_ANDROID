package com.agvber.network.retrofit

import com.agvber.network.NetworkDataSource
import com.agvber.network.model.NetworkContentFilter
import com.agvber.network.model.NetworkOrderBy
import com.agvber.network.model.NetworkOrientation
import com.agvber.network.model.PhotoDetailResponse
import com.agvber.network.model.PhotosResponse
import com.agvber.network.model.RandomPhotosResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
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

    private val moshi = Moshi.Builder().run {
        add(KotlinJsonAdapterFactory())
        build()
    }

    private val retrofit = Retrofit.Builder().run {
        baseUrl("https://api.unsplash.com")
        callFactory(okhttpCallFactory)
        addConverterFactory(MoshiConverterFactory.create(moshi))
        build()
    }

    private val networkService = retrofit.create<NetworkService>()
    override suspend fun getPhotos(page: Int, pageSize: Int, orderBy: NetworkOrderBy): List<PhotosResponse> {
        return networkService.getPhotos(page = page, pageSize = pageSize, orderBy = orderBy.params)
    }

    override suspend fun getRandomPhotos(
        collections: List<String>?,
        topics: List<String>?,
        username: String?,
        query: String?,
        orientation: NetworkOrientation?,
        contentFilter: NetworkContentFilter,
        count: Int,
    ): List<RandomPhotosResponse> {
        return networkService.getRandomPhotos(
            collections = collections?.joinToString(", "),
            topics = topics?.joinToString(", "),
            username = username,
            query = query,
            orientation = orientation?.params,
            contentFilter = contentFilter.params,
            count = count
        )
    }

    override suspend fun getPhotoDetail(id: String): PhotoDetailResponse {
        return networkService.getPhotoDetail(id = id)
    }
}