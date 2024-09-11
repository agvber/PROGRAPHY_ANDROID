package com.agvber.core.data.usecase

import com.agvber.core.data.repository.BookmarkRepository
import com.agvber.core.domain.model.PhotoDetail
import com.agvber.core.domain.usecase.BookmarkPhotoDetailUseCase
import javax.inject.Inject

class BookmarkPhotoDetailUseCaseImpl @Inject constructor(
    private val bookmarkRepository: BookmarkRepository
) : BookmarkPhotoDetailUseCase {

    override suspend fun invoke(photoDetail: PhotoDetail) {
        bookmarkRepository.addBookmark(photoDetail)
    }
}