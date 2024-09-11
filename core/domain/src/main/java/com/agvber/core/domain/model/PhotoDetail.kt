package com.agvber.core.domain.model

data class PhotoDetail(
    val id: String,
    val title: String,
    val description: String,
    val tag: List<String>,
    val userName: String,
    val url: Url,
    val link: Link,
    val size: Size,
    val isBookmarked: Boolean
) {

    data class Url(
        val raw: String,
        val full: String,
        val regular: String,
        val small: String,
        val thumb: String
    )

    data class Size(
        val width: Int,
        val height: Int
    )

    data class Link(
        val self: String,
        val html: String,
        val download: String,
        val downloadLocation: String
    )
}