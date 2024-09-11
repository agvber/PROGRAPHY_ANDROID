package com.agvber.core.data.usecase

import com.agvber.core.data.mapper.toPhotoDetailModel
import com.agvber.core.data.repository.BookmarkRepository
import com.agvber.core.domain.model.PhotoDetail
import com.agvber.core.domain.usecase.GetBookmarkPhotoDetailUseCase
import javax.inject.Inject

class GetBookmarkPhotoDetailUseCaseImpl @Inject constructor(
    private val bookmarkRepository: BookmarkRepository
) : GetBookmarkPhotoDetailUseCase {

    override suspend fun invoke(id: String): PhotoDetail {
        return bookmarkRepository.getBookmarkPhotoDetail(id)
            .toPhotoDetailModel(true)
    }
}