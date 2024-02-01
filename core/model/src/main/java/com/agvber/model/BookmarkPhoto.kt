package com.agvber.model

data class BookmarkPhoto(
    val id: String,
    val title: String,
    val description: String,
    val userName: String,
    val tags: List<String>,
    val url: Url,
    val queriedDate: Long = System.currentTimeMillis()
) {
    data class Url(
        val raw: String,
        val full: String,
        val regular: String,
        val small: String,
        val thumb: String,
        val smallS3: String,
    )
}