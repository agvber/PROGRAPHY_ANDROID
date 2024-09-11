package com.agvber.core.domain.usecase

import androidx.paging.PagingData
import com.agvber.core.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface GetPhotosUseCase {

    operator fun invoke(): Flow<PagingData<Photo>>
}