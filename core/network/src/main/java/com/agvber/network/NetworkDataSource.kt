package com.agvber.network

import com.agvber.network.model.NetworkOrderBy
import com.agvber.network.model.PhotosResponse

interface NetworkDataSource {

    suspend fun getPhotos(
        page: Int = 1,
        pageSize: Int = 10,
        orderBy: NetworkOrderBy = NetworkOrderBy.LATEST
    ): List<PhotosResponse>
}