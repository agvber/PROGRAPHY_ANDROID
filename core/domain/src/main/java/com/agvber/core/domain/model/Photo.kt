package com.agvber.core.domain.model

data class Photo(
    val id: String,
    val title: String,
    val description: String,
    val url: Url,
    val size: Size
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
}