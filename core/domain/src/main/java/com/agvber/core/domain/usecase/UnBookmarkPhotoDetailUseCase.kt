package com.agvber.core.domain.usecase

interface UnBookmarkPhotoDetailUseCase {

    suspend operator fun invoke(id: String)
}