package com.agvber.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.agvber.core.common.Result
import com.agvber.core.common.asResult
import com.agvber.core.domain.model.Photo
import com.agvber.core.domain.usecase.GetBookmarkPhotosUseCase
import com.agvber.core.domain.usecase.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase,
    getBookmarkPhotosUseCase: GetBookmarkPhotosUseCase
) : ViewModel() {

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

    val photos: Flow<PagingData<Photo>>? = kotlin.runCatching { getPhotosUseCase() }
        .onFailure { it.printStackTrace() }
        .getOrNull()
        ?.cachedIn(viewModelScope)
}

sealed interface BookmarkUiState {
    data class Success(val data: List<Photo>) : BookmarkUiState
    data class LoadFail(val t: Throwable?) : BookmarkUiState
    data object Loading : BookmarkUiState
}