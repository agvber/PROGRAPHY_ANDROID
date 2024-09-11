package com.agvber.core.domain.usecase

import com.agvber.core.domain.model.PhotoDetail

interface GetPhotoDetailUseCase {

    suspend operator fun invoke(id: String): PhotoDetail
}