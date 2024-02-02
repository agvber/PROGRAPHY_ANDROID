package com.agvber.data.di

import com.agvber.data.repository.BookmarkRepository
import com.agvber.data.repository.BookmarkRepositoryImpl
import com.agvber.data.repository.PhotoRepository
import com.agvber.data.repository.PhotoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Binds
    fun bindsPhotoRepository(
        photoRepositoryImpl: PhotoRepositoryImpl
    ): PhotoRepository

    @Binds
    fun bindsBookmarkRepository(
        bookmarkRepositoryImpl: BookmarkRepositoryImpl
    ): BookmarkRepository
}