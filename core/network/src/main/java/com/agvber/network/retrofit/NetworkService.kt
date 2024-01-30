package com.agvber.network.retrofit

import com.agvber.network.model.PhotosResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface NetworkService {

    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page: Int = 1, // Page number to retrieve. (Optional; default: 1)
        @Query("per_page") pageSize: Int, // Number of items per page. (Optional; default: 10)
        @Query("order_by") orderBy: String = "latest" // How to sort the photos. Optional. (Valid values: latest, oldest, popular; default: latest)
    ): List<PhotosResponse>
}