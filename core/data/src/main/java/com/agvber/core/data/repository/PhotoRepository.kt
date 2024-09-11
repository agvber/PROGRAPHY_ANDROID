package com.agvber.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.agvber.core.data.paging.PhotoPagingSource
import com.agvber.core.database.dao.BookmarkDao
import com.agvber.core.network.NetworkDataSource
import com.agvber.core.network.model.PhotoDetailResponse
import com.agvber.core.network.model.PhotosResponse
import com.agvber.core.network.model.RandomPhotosResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val bookmarkDao: BookmarkDao
) {
    fun getPhotos(): Flow<PagingData<PhotosResponse>> {
        return Pager(
            config = PagingConfig(10),
            initialKey = 1
        ) {
            PhotoPagingSource { params ->
                networkDataSource.getPhotos(params.key ?: 0, params.loadSize)
            }
        }
            .flow
    }

    fun getRandomPhotos(): Flow<PagingData<RandomPhotosResponse>> {
        return Pager(
            config = PagingConfig(4),
            initialKey = 1
        ) {
            PhotoPagingSource { params ->
                networkDataSource.getRandomPhotos()
                    .filter { !bookmarkDao.hasQuery(it.id) }
            }
        }
            .flow
    }

    suspend fun getPhotoDetail(id: String): PhotoDetailResponse {
        return networkDataSource.getPhotoDetail(id)
    }

    suspend fun checkBookmarkItem(id: String): Boolean {
        return bookmarkDao.hasQuery(id)
    }
}
