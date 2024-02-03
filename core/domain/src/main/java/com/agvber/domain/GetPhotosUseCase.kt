package com.agvber.domain

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.agvber.data.repository.PhotoRepository
import com.agvber.model.Photo
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(
    private val photoRepository: PhotoRepository
) {

    operator fun invoke(
        photoRequest: PhotoRequest
    ): Pager<Int, Photo> {
        return Pager(
            config = PagingConfig(10),
            initialKey = 1
        ) {
            PhotoPagingSource(photoRequest)
        }
    }

    inner class PhotoPagingSource(
        private val photoRequest: PhotoRequest
    ): PagingSource<Int, Photo>() {
        override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
            return state.anchorPosition?.let { anchorPosition ->
                state.closestPageToPosition(anchorPosition)?.prevKey
            }
        }

        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
            val page = params.key ?: 1
            return try {
                LoadResult.Page(
                    data = when (photoRequest) {
                        PhotoRequest.PHOTO -> photoRepository.getPhotos(page, 10)
                        PhotoRequest.RANDOM -> photoRepository.getRandomPhotos(3)
                    },
                    prevKey = if (page == 1) null else page -1,
                    nextKey = page + 1
                )
            } catch (exception: Exception) {
                LoadResult.Error(exception)
            }
        }
    }
}

enum class PhotoRequest {
    PHOTO, RANDOM
}