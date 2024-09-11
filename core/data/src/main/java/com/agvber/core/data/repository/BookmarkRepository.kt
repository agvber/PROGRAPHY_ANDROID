package com.agvber.core.data.repository

import com.agvber.core.database.dao.BookmarkDao
import com.agvber.core.database.model.BookmarkEntity
import com.agvber.core.domain.model.PhotoDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class BookmarkRepository @Inject constructor(
    private val bookmarkDao: BookmarkDao
) {

    fun getBookmarkPhotos(
        reverse: Boolean,
        limit: Int
    ): Flow<List<BookmarkEntity>> {
        return bookmarkDao.getBookmarkEntity(reverse, limit)
    }

    suspend fun getBookmarkPhotoDetail(id: String): BookmarkEntity {
        return bookmarkDao.getBookmarkEntity()
            .first()
            .first { it.id == id }
    }

    suspend fun addBookmark(photoDetail: PhotoDetail) {
        bookmarkDao.insertBookmark(
            listOf(
                BookmarkEntity(
                    id = photoDetail.id,
                    title = photoDetail.title,
                    description = photoDetail.description,
                    userName = photoDetail.userName,
                    tags = photoDetail.tag,
                    url = BookmarkEntity.Url(
                        raw = photoDetail.url.raw,
                        full = photoDetail.url.full,
                        regular = photoDetail.url.regular,
                        small = photoDetail.url.small,
                        thumb = photoDetail.url.thumb,
                        smallS3 = "null",
                    )
                )
            )
        )
    }

    suspend fun deleteBookmark(id: String) {
        bookmarkDao.deleteBookmark(id)
    }
}