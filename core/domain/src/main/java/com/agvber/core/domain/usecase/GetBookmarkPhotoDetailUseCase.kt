package com.agvber.core.domain.usecase

import com.agvber.core.domain.model.PhotoDetail

interface GetBookmarkPhotoDetailUseCase {

    suspend operator fun invoke(id: String): PhotoDetail
}