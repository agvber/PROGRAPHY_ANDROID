package com.agvber.network.retrofit

import androidx.annotation.IntRange
import com.agvber.network.model.PhotoDetailResponse
import com.agvber.network.model.PhotosResponse
import com.agvber.network.model.RandomPhotosResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface NetworkService {

    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page: Int = 1, // Page number to retrieve. (Optional; default: 1)
        @Query("per_page") pageSize: Int, // Number of items per page. (Optional; default: 10)
        @Query("order_by") orderBy: String = "latest" // How to sort the photos. Optional. (Valid values: latest, oldest, popular; default: latest)
    ): List<PhotosResponse>

    @GET("/photos/random")
    suspend fun getRandomPhotos(
        @Query("collections") collections: String? = null, // 	Public collection ID(‘s) to filter selection. If multiple, comma-separated
        @Query("topics") topics: String? = null, // Public topic ID(‘s) to filter selection. If multiple, comma-separated
        @Query("username") username: String? = null, // 	Limit selection to a single user.
        @Query("query") query: String? = null, // Limit selection to photos matching a search term.
        @Query("orientation") orientation: String? = null, // Filter by photo orientation. (Valid values: landscape, portrait, squarish)
        @Query("content_filter") contentFilter: String = "low", // Limit results by content safety. Default: low. Valid values are low and high.
        @Query("count") @IntRange(1, 30) count: Int = 1, // The number of photos to return. (Default: 1; max: 30)
    ): List<RandomPhotosResponse>

    @GET("/photos/{id}")
    suspend fun getPhotoDetail(
        @Path(value = "id") id: String
    ): PhotoDetailResponse
}