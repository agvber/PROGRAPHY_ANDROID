package com.agvber.randomphoto

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.agvber.core.domain.model.Photo
import com.agvber.core.domain.usecase.BookmarkPhotoDetailUseCase
import com.agvber.core.domain.usecase.GetPhotoDetailUseCase
import com.agvber.core.domain.usecase.GetRandomPhotosUseCase
import com.agvber.core.domain.usecase.UnBookmarkPhotoDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomPhotoViewModel @Inject constructor(
    private val getRandomPhotosUseCase: GetRandomPhotosUseCase,
    private val getPhotoDetailUseCase: GetPhotoDetailUseCase,
    private val bookmarkPhotoDetailUseCase: BookmarkPhotoDetailUseCase,
    private val unBookmarkPhotoDetailUseCase: UnBookmarkPhotoDetailUseCase
) : ViewModel() {

    val randomPhoto: Flow<PagingData<Photo>>? = runCatching { getRandomPhotosUseCase() }
        .onFailure { it.printStackTrace() }
        .getOrNull()
        ?.cachedIn(viewModelScope)

    fun addBookmark(id: String) {
        viewModelScope.launch {
            try {
                val detail = getPhotoDetailUseCase(id)
                bookmarkPhotoDetailUseCase(detail)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun deleteBookmark(id: String) {
        viewModelScope.launch {
            try {
                unBookmarkPhotoDetailUseCase(id)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}