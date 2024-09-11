package com.agvber.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.agvber.core.database.dao.BookmarkDao
import com.agvber.core.database.model.BookmarkEntity

@Database(
    entities = [
        BookmarkEntity::class
    ],
    version = 1
)
@TypeConverters(StringListTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookmarkDao(): BookmarkDao
}