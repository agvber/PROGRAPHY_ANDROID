package com.agvber.core.network

import androidx.annotation.IntRange
import com.agvber.core.network.model.NetworkContentFilter
import com.agvber.core.network.model.NetworkOrderBy
import com.agvber.core.network.model.NetworkOrientation
import com.agvber.core.network.model.PhotoDetailResponse
import com.agvber.core.network.model.PhotosResponse
import com.agvber.core.network.model.RandomPhotosResponse

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

    suspend fun getPhotoDetail(id: String): PhotoDetailResponse
}