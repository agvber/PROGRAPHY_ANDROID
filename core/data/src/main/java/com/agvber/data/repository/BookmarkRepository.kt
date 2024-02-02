package com.agvber.data.repository

import com.agvber.database.dao.BookmarkDao
import com.agvber.database.model.BookmarkEntity
import com.agvber.model.Photo
import com.agvber.model.PhotoDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface BookmarkRepository {

    suspend fun getBookmarkPhotos(
        reverse: Boolean = false,
        limit: Int = -1
    ): Flow<List<Photo>>

    suspend fun getBookmarkPhotoDetail(id: String): PhotoDetail

    suspend fun addBookmark(photoDetail: PhotoDetail)

    suspend fun deleteBookmark(id: String)
}

internal class BookmarkRepositoryImpl @Inject constructor(
    private val bookmarkDao: BookmarkDao
): BookmarkRepository {
    override suspend fun getBookmarkPhotos(
        reverse: Boolean,
        limit: Int
    ): Flow<List<Photo>> {
        return bookmarkDao.getBookmarkEntity(reverse, limit)
            .map {
                it.map { it.toPhotoModel() }
            }
    }

    override suspend fun getBookmarkPhotoDetail(id: String): PhotoDetail {
        return bookmarkDao.getBookmarkEntity()
            .first()
            .first { it.id == id }
            .toPhotoDetailModel(true)
    }

    override suspend fun addBookmark(photoDetail: PhotoDetail) {
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

    override suspend fun deleteBookmark(id: String) {
        bookmarkDao.deleteBookmark(id)
    }
}

private fun BookmarkEntity.toPhotoModel() =
    Photo(
        id = id,
        title = title,
        description = description,
        url = Photo.Url(
            raw = url.raw,
            full = url.full,
            regular = url.regular,
            small = url.small,
            thumb = url.thumb
        ),
        size = Photo.Size(
            width = 0, height = 0
        )
    )

private fun BookmarkEntity.toPhotoDetailModel(isBookmarked: Boolean) =
    PhotoDetail(
        id = id,
        title = title,
        description = description,
        tag = tags,
        userName = userName,
        url = PhotoDetail.Url(
            raw = url.raw,
            full = url.full,
            regular = url.regular,
            small = url.small,
            thumb = url.thumb
        ),
        link = PhotoDetail.Link(
            self = "",
            html = "",
            download = "",
            downloadLocation = ""
        ),
        size = PhotoDetail.Size(0, 0),
        isBookmarked = isBookmarked
    )