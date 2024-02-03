package com.agvber.randomphoto

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.agvber.data.repository.BookmarkRepository
import com.agvber.domain.GetPhotoDetailUseCase
import com.agvber.domain.GetPhotosUseCase
import com.agvber.domain.PhotoDetailRequest
import com.agvber.domain.PhotoRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomPhotoViewModel @Inject constructor(
    getPhotosUseCase: GetPhotosUseCase,
    private val getPhotoDetailUseCase: GetPhotoDetailUseCase,
    private val bookmarkRepository: BookmarkRepository,
): ViewModel() {

    val randomPhoto = getPhotosUseCase(PhotoRequest.RANDOM)
        .flow
        .cachedIn(viewModelScope)

    fun addBookmark(id: String) {
        viewModelScope.launch {
            try {
                val detail = getPhotoDetailUseCase(id, PhotoDetailRequest.NETWORK)
                bookmarkRepository.addBookmark(detail)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun deleteBookmark(id: String) {
        viewModelScope.launch {
            bookmarkRepository.deleteBookmark(id)
        }
    }
}