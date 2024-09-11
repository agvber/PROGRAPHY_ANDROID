package com.agvber.core.domain.usecase

import com.agvber.core.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface GetBookmarkPhotosUseCase {

    operator fun invoke(reverse: Boolean = false, limit: Int = -1): Flow<List<Photo>>
}