package com.agvber.photodetail

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val photoDetailRoute = "photo_detail_route"

fun NavController.navigateToPhotoDetailScreen(
    id: String,
    requestMode: String, // network, bookmark
    navOptions: NavOptions? = null
) {
    navigate("${photoDetailRoute}/$id/$requestMode", navOptions)
}

fun NavGraphBuilder.addPhotoDetailScreen(
    onBackRequest: () -> Unit
) {
    composable(
        route = "${photoDetailRoute}/{content_id}/{request_mode}"
    ) {
        PhotoDetailRoute(
            onBackRequest = onBackRequest
        )
    }
}