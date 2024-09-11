package com.agvber.core.data.mapper

import com.agvber.core.database.model.BookmarkEntity
import com.agvber.core.domain.model.PhotoDetail
import com.agvber.core.network.model.PhotoDetailResponse

internal fun BookmarkEntity.toPhotoDetailModel(isBookmarked: Boolean): PhotoDetail =
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

internal fun PhotoDetailResponse.asExternalModel(isBookmarked: Boolean): PhotoDetail =
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