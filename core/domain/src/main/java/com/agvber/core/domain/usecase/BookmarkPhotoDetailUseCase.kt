package com.agvber.core.domain.usecase

import com.agvber.core.domain.model.PhotoDetail

interface BookmarkPhotoDetailUseCase {

    suspend operator fun invoke(photoDetail: PhotoDetail)
}