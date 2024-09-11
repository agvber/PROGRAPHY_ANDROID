package com.agvber.core.data.usecase

import com.agvber.core.data.mapper.asExternalModel
import com.agvber.core.data.repository.PhotoRepository
import com.agvber.core.domain.model.PhotoDetail
import com.agvber.core.domain.usecase.GetPhotoDetailUseCase
import javax.inject.Inject

class GetPhotoDetailUseCaseImpl @Inject constructor(
    private val photoRepository: PhotoRepository
) : GetPhotoDetailUseCase {

    override suspend fun invoke(id: String): PhotoDetail {
        val isBookmark = photoRepository.checkBookmarkItem(id)
        return photoRepository.getPhotoDetail(id).asExternalModel(isBookmark)
    }
}