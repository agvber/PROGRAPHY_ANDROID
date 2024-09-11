package com.agvber.photodetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agvber.core.common.Result
import com.agvber.core.common.asResult
import com.agvber.core.domain.model.PhotoDetail
import com.agvber.core.domain.usecase.BookmarkPhotoDetailUseCase
import com.agvber.core.domain.usecase.GetBookmarkPhotoDetailUseCase
import com.agvber.core.domain.usecase.GetPhotoDetailUseCase
import com.agvber.core.domain.usecase.UnBookmarkPhotoDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getBookmarkPhotoDetailUseCase: GetBookmarkPhotoDetailUseCase,
    private val getPhotoDetailUseCase: GetPhotoDetailUseCase,
    private val bookmarkPhotoDetailUseCase: BookmarkPhotoDetailUseCase,
    private val unBookmarkPhotoDetailUseCase: UnBookmarkPhotoDetailUseCase
) : ViewModel() {

    companion object {
        private const val CONTENT_ID = "content_id"
        private const val REQUEST_MODE = "request_mode"
        private const val NETWORK = "network"
        private const val BOOKMARK = "bookmark"
    }

    private val id = savedStateHandle.getStateFlow<String?>(CONTENT_ID, null)
    private val requestMode = savedStateHandle.getStateFlow(REQUEST_MODE, NETWORK)

    @OptIn(ExperimentalCoroutinesApi::class)
    val photoDetail = id.mapLatest { id ->
        if (id == null) {
            return@mapLatest null
        }

        if (requestMode.value == BOOKMARK) {
            return@mapLatest getBookmarkPhotoDetailUseCase(id)
        }

        getPhotoDetailUseCase(id)
    }
        .asResult()
        .map {
            when (it) {
                is Result.Error -> PhotoDetailUiState.LoadFail(it.exception)
                is Result.Loading -> PhotoDetailUiState.Loading
                is Result.Success -> {
                    it.data?.let { data -> PhotoDetailUiState.Success(data) }
                        ?: return@map PhotoDetailUiState.Loading
                }
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = PhotoDetailUiState.Loading
        )

    fun addBookmark() {
        viewModelScope.launch {
            try {
                val photoDetail = (photoDetail.value as PhotoDetailUiState.Success).data
                bookmarkPhotoDetailUseCase(photoDetail)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun deleteBookmark() {
        viewModelScope.launch {
            try {
                val photoDetail = (photoDetail.value as PhotoDetailUiState.Success).data
                unBookmarkPhotoDetailUseCase(photoDetail.id)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

sealed interface PhotoDetailUiState {
    data class Success(val data: PhotoDetail) : PhotoDetailUiState
    data class LoadFail(val t: Throwable?) : PhotoDetailUiState
    data object Loading : PhotoDetailUiState
}