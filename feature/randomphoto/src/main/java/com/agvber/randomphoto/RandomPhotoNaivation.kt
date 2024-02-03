package com.agvber.randomphoto

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.agvber.designsystem.component.PrographyNavigationItem

const val randomPhotoRoute = "random_photo_route"

fun NavController.navigateToRandomPhotoScreen(
    navOptions: NavOptions? = null
) {
    navigate(randomPhotoRoute, navOptions)
}

fun NavGraphBuilder.addRandomPhotoScreen(
    navigationItemOnChange: (PrographyNavigationItem) -> Unit,
    photoInfoButtonOnClick: (String) -> Unit,
) {
    composable(randomPhotoRoute) {
        RandomPhotoRoute(
            navigationItemOnChange = navigationItemOnChange,
            photoInfoButtonOnClick = photoInfoButtonOnClick
        )
    }
}