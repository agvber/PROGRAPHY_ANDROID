package com.agvber.database.di

import android.content.Context
import androidx.room.Room
import com.agvber.database.AppDatabase
import com.agvber.database.StringListTypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Singleton
    @Provides
    fun providesAppDatabase(
        @ApplicationContext appContext: Context
    ): AppDatabase {
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        return Room.databaseBuilder(
            context = appContext,
            klass = AppDatabase::class.java,
            name = "prography-db"
        )
            .addTypeConverter(StringListTypeConverter(moshi))
            .build()
    }
}