package com.agvber.core.data.usecase

import com.agvber.core.data.mapper.toPhotoModel
import com.agvber.core.data.repository.BookmarkRepository
import com.agvber.core.domain.model.Photo
import com.agvber.core.domain.usecase.GetBookmarkPhotosUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetBookmarkPhotosUseCaseImpl @Inject constructor(
    private val bookmarkRepository: BookmarkRepository
) : GetBookmarkPhotosUseCase {

    override fun invoke(reverse: Boolean, limit: Int): Flow<List<Photo>> {
        return bookmarkRepository.getBookmarkPhotos(reverse = reverse, limit = limit)
            .map {
                it.map { bookmark ->
                    bookmark.toPhotoModel()
                }
            }
    }
}