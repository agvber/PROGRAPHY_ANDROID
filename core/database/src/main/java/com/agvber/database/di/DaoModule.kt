package com.agvber.database.di

import com.agvber.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {

    @Provides
    fun providesBookmarkDao(appDatabase: AppDatabase) = appDatabase.bookmarkDao()
}