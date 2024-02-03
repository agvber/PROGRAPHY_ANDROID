package com.agvber.photodetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agvber.common.Result
import com.agvber.common.asResult
import com.agvber.data.repository.BookmarkRepository
import com.agvber.domain.GetPhotoDetailUseCase
import com.agvber.domain.PhotoDetailRequest
import com.agvber.model.PhotoDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoDetailViewModel @Inject constructor(
    getPhotoDetailUseCase: GetPhotoDetailUseCase,
    savedStateHandle: SavedStateHandle,
    private val bookmarkRepository: BookmarkRepository,
) : ViewModel() {

    private val id = savedStateHandle.getStateFlow<String?>("content_id", null)
    private val requestMode = savedStateHandle.getStateFlow("request_mode", "network")

    @OptIn(ExperimentalCoroutinesApi::class)
    val photoDetail = id.flatMapLatest { id ->
        if (id == null){
            return@flatMapLatest emptyFlow()
        }
        flowOf(
            getPhotoDetailUseCase(
                id = id,
                photoDetailRequest = if (requestMode.value == "bookmark") {
                    PhotoDetailRequest.BOOKMARK
                } else {
                    PhotoDetailRequest.NETWORK
                }
            )
        )
    }
        .asResult()
        .map {
            when (it) {
                is Result.Error -> PhotoDetailUiState.LoadFail(it.exception)
                is Result.Loading -> PhotoDetailUiState.Loading
                is Result.Success -> PhotoDetailUiState.Success(it.data)
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
                bookmarkRepository.addBookmark(
                    (photoDetail.value as PhotoDetailUiState.Success).data
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun deleteBookmark() {
        viewModelScope.launch {
            bookmarkRepository.deleteBookmark(
                (photoDetail.value as PhotoDetailUiState.Success).data.id
            )
        }
    }
}

sealed interface PhotoDetailUiState {
    data class Success(val data: PhotoDetail): PhotoDetailUiState
    data class LoadFail(val t: Throwable?): PhotoDetailUiState

    object Loading: PhotoDetailUiState
}