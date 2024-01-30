package com.agvber.network

import androidx.annotation.IntRange
import com.agvber.network.model.NetworkContentFilter
import com.agvber.network.model.NetworkOrderBy
import com.agvber.network.model.NetworkOrientation
import com.agvber.network.model.PhotosResponse
import com.agvber.network.model.RandomPhotosResponse

interface NetworkDataSource {

    suspend fun getPhotos(
        page: Int = 1,
        pageSize: Int = 10,
        orderBy: NetworkOrderBy = NetworkOrderBy.LATEST
    ): List<PhotosResponse>

    suspend fun getRandomPhotos(
        collections: List<String>? = null,
        topics: List<String>? = null,
        username: String? = null,
        query: String? = null,
        orientation: NetworkOrientation? = null,
        contentFilter: NetworkContentFilter = NetworkContentFilter.LOW,
        @IntRange(1, 30) count: Int = 1,
    ): List<RandomPhotosResponse>
}