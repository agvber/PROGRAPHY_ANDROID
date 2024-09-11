package com.agvber.core.data.mapper

import com.agvber.core.database.model.BookmarkEntity
import com.agvber.core.domain.model.Photo
import com.agvber.core.network.model.PhotosResponse
import com.agvber.core.network.model.RandomPhotosResponse

internal fun BookmarkEntity.toPhotoModel(): Photo =
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

internal fun PhotosResponse.asExternalModel(): Photo =
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

internal fun RandomPhotosResponse.asExternalModel(): Photo =
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