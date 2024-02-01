package com.agvber.database.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "bookmark"
)
data class BookmarkEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "user_name") val userName: String,
    @ColumnInfo(name = "tags") val tags: List<String>,
    @Embedded val url: Url,
    @ColumnInfo(name = "queried_date") val queriedDate: Long = System.currentTimeMillis()
) {
    data class Url(
        @ColumnInfo(name = "raw") val raw: String,
        @ColumnInfo(name = "full") val full: String,
        @ColumnInfo(name = "regular") val regular: String,
        @ColumnInfo(name = "small") val small: String,
        @ColumnInfo(name = "thumb") val thumb: String,
        @ColumnInfo(name = "small_s3") val smallS3: String,
    )
}