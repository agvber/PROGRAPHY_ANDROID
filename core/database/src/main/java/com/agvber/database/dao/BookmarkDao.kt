package com.agvber.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.agvber.database.model.BookmarkEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkDao {

    @Query(
        value = "SELECT * FROM bookmark " +
            "ORDER BY " +
            "CASE WHEN :reverse = 0 THEN queried_date END ASC," +
            "CASE WHEN :reverse = 1 THEN queried_date END DESC " +
            "LIMIT :limit"
    )
    fun getBookmarkEntity(
        reverse: Boolean = false,
        limit: Int = -1
    ): Flow<List<BookmarkEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBookmark(
        bookmarkEntities: List<BookmarkEntity>
    ): List<Long>

    @Query("DELETE FROM bookmark WHERE id = :id")
    suspend fun deleteBookmark(id: String)
}