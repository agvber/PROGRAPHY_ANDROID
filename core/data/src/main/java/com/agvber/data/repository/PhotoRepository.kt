package com.agvber.data.repository

import com.agvber.database.dao.BookmarkDao
import com.agvber.model.Photo
import com.agvber.model.PhotoDetail
import com.agvber.network.NetworkDataSource
import com.agvber.network.model.PhotoDetailResponse
import com.agvber.network.model.PhotosResponse
import com.agvber.network.model.RandomPhotosResponse
import javax.inject.Inject

interface PhotoRepository {

    suspend fun getPhotos(page: Int, size: Int): List<Photo>

    suspend fun getRandomPhotos(pageSize: Int): List<Photo>

    suspend fun getPhotoDetail(id: String): PhotoDetail
}


internal class PhotoRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val bookmarkDao: BookmarkDao
) : PhotoRepository {
    override suspend fun getPhotos(page: Int, size: Int): List<Photo> {
        return networkDataSource.getPhotos(page, size).map { it.asExternalModel() }
    }

    override suspend fun getRandomPhotos(pageSize: Int): List<Photo> {
        return networkDataSource.getRandomPhotos()
            .filter { !bookmarkDao.hasQuery(it.id) }
            .map { it.asExternalModel() }
    }

    override suspend fun getPhotoDetail(id: String): PhotoDetail {
        val isBookmarked = bookmarkDao.hasQuery(id)
        return networkDataSource.getPhotoDetail(id).asExternalModel(isBookmarked)
    }
}

private fun PhotosResponse.asExternalModel() =
    Photo(
        id = id,
        title = altDescription ?: "",
        description = description ?: "",
        url = Photo.Url(
            raw = urls.raw,
            full = urls.full,
            regular = urls.regular,
            small = urls.small,
            thumb = urls.thumb
        ),
        size = Photo.Size(
            width = width, height = height
        )
    )

private fun RandomPhotosResponse.asExternalModel() =
    Photo(
        id = id,
        title = altDescription ?: "",
        description = description ?: "",
        url = Photo.Url(
            raw = urls.raw,
            full = urls.full,
            regular = urls.regular,
            small = urls.small,
            thumb = urls.thumb
        ),
        size = Photo.Size(
            width = width, height = height
        )
    )

private fun PhotoDetailResponse.asExternalModel(isBookmarked: Boolean) =
    PhotoDetail(
        id = id,
        title = altDescription ?: "",
        description = description ?: "",
        tag = tags.map { it.title },
        userName = user.username,
        url = PhotoDetail.Url(
            raw = urls.raw,
            full = urls.full,
            regular = urls.regular,
            small = urls.small,
            thumb = urls.thumb
        ),
        link = PhotoDetail.Link(
            self = links.self,
            html = links.html,
            download = links.download,
            downloadLocation = links.downloadLocation
        ),
        size = PhotoDetail.Size(width, height),
        isBookmarked = isBookmarked
    )
