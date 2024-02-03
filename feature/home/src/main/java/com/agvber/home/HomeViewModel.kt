package com.agvber.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.agvber.common.Result
import com.agvber.common.asResult
import com.agvber.domain.GetBookmarkPhotosUseCase
import com.agvber.domain.GetPhotosUseCase
import com.agvber.domain.PhotoRequest
import com.agvber.model.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getPhotosUseCase: GetPhotosUseCase,
    getBookmarkPhotosUseCase: GetBookmarkPhotosUseCase
): ViewModel() {

    val bookmarkPhoto = getBookmarkPhotosUseCase(true)
        .asResult()
        .map {
            when (it) {
                is Result.Error -> BookmarkUiState.LoadFail(it.exception)
                is Result.Loading -> BookmarkUiState.Loading
                is Result.Success -> BookmarkUiState.Success(it.data)
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = BookmarkUiState.Loading
        )

    val photos = getPhotosUseCase(PhotoRequest.PHOTO)
        .flow
        .cachedIn(viewModelScope)
}

sealed interface BookmarkUiState {
    data class Success(val data: List<Photo>): BookmarkUiState

    data class LoadFail(val t: Throwable?): BookmarkUiState

    object Loading: BookmarkUiState
}