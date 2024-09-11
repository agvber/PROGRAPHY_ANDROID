package com.agvber.core.data.usecase

import androidx.paging.PagingData
import androidx.paging.map
import com.agvber.core.data.mapper.asExternalModel
import com.agvber.core.data.repository.PhotoRepository
import com.agvber.core.domain.model.Photo
import com.agvber.core.domain.usecase.GetPhotosUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPhotosUseCaseImpl @Inject constructor(
    private val photoRepository: PhotoRepository
) : GetPhotosUseCase {

    override fun invoke(): Flow<PagingData<Photo>> {
        return photoRepository.getPhotos().map { pagingData ->
            pagingData.map {
                it.asExternalModel()
            }
        }
    }
}