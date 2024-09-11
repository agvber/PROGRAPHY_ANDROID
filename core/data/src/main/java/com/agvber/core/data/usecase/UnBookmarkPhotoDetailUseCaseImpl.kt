package com.agvber.core.data.usecase

import com.agvber.core.data.repository.BookmarkRepository
import com.agvber.core.domain.usecase.UnBookmarkPhotoDetailUseCase
import javax.inject.Inject

class UnBookmarkPhotoDetailUseCaseImpl @Inject constructor(
    private val bookmarkRepository: BookmarkRepository
) : UnBookmarkPhotoDetailUseCase {

    override suspend fun invoke(id: String) {
        bookmarkRepository.deleteBookmark(id)
    }
}