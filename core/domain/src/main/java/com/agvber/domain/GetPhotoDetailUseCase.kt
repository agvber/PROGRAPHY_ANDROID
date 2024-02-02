package com.agvber.domain

import com.agvber.data.repository.BookmarkRepository
import com.agvber.data.repository.PhotoRepository
import com.agvber.model.PhotoDetail
import javax.inject.Inject

class GetPhotoDetailUseCase @Inject constructor(
    private val photoRepository: PhotoRepository,
    private val bookmarkRepository: BookmarkRepository
) {

    suspend operator fun invoke(
        id: String,
        photoDetailRequest: PhotoDetailRequest
    ): PhotoDetail {
        return when (photoDetailRequest) {
            PhotoDetailRequest.NETWORK -> photoRepository.getPhotoDetail(id)
            PhotoDetailRequest.BOOKMARK -> bookmarkRepository.getBookmarkPhotoDetail(id)
        }
    }
}

enum class PhotoDetailRequest {
    NETWORK, BOOKMARK
}