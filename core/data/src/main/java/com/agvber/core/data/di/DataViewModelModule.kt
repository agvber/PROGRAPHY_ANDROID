package com.agvber.core.data.di

import com.agvber.core.data.usecase.BookmarkPhotoDetailUseCaseImpl
import com.agvber.core.data.usecase.GetBookmarkPhotoDetailUseCaseImpl
import com.agvber.core.data.usecase.GetBookmarkPhotosUseCaseImpl
import com.agvber.core.data.usecase.GetPhotoDetailUseCaseImpl
import com.agvber.core.data.usecase.GetPhotosUseCaseImpl
import com.agvber.core.data.usecase.GetRandomPhotosUseCaseImpl
import com.agvber.core.data.usecase.UnBookmarkPhotoDetailUseCaseImpl
import com.agvber.core.domain.usecase.BookmarkPhotoDetailUseCase
import com.agvber.core.domain.usecase.GetBookmarkPhotoDetailUseCase
import com.agvber.core.domain.usecase.GetBookmarkPhotosUseCase
import com.agvber.core.domain.usecase.GetPhotoDetailUseCase
import com.agvber.core.domain.usecase.GetPhotosUseCase
import com.agvber.core.domain.usecase.GetRandomPhotosUseCase
import com.agvber.core.domain.usecase.UnBookmarkPhotoDetailUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal interface DataViewModelModule {

    @Binds
    fun bindsGetBookmarkPhotoDetailUseCase(
        getBookmarkPhotoDetailUseCaseImpl: GetBookmarkPhotoDetailUseCaseImpl
    ): GetBookmarkPhotoDetailUseCase

    @Binds
    fun bindsGetBookmarkPhotosUseCase(
        getBookmarkPhotosUseCaseImpl: GetBookmarkPhotosUseCaseImpl
    ): GetBookmarkPhotosUseCase

    @Binds
    fun bindsGetPhotoDetailUseCase(
        getPhotoDetailUseCaseImpl: GetPhotoDetailUseCaseImpl
    ): GetPhotoDetailUseCase

    @Binds
    fun bindsGetPhotosUseCase(
        getPhotosUseCaseImpl: GetPhotosUseCaseImpl
    ): GetPhotosUseCase

    @Binds
    fun bindsGetRandomPhotosUseCase(
        getRandomPhotosUseCaseImpl: GetRandomPhotosUseCaseImpl
    ): GetRandomPhotosUseCase

    @Binds
    fun bindsBookmarkPhotoDetailUseCase(
        bookmarkPhotoDetailUseCaseImpl: BookmarkPhotoDetailUseCaseImpl
    ): BookmarkPhotoDetailUseCase

    @Binds
    fun bindsUnBookmarkPhotoDetailUseCase(
        unBookmarkPhotoDetailUseCaseImpl: UnBookmarkPhotoDetailUseCaseImpl
    ): UnBookmarkPhotoDetailUseCase
}