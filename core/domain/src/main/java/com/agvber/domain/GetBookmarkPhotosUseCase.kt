package com.agvber.domain

import com.agvber.data.repository.BookmarkRepository
import com.agvber.model.Photo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBookmarkPhotosUseCase @Inject constructor(
    private val bookmarkRepository: BookmarkRepository
) {
    operator fun invoke(
        reverse: Boolean = false,
        limit: Int = -1
    ): Flow<List<Photo>> {
        return bookmarkRepository.getBookmarkPhotos(reverse, limit)
    }
}