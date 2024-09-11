package com.agvber.prography_android

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.agvber.core.designsystem.component.PrographyNavigationItem
import com.agvber.home.addHomeScreen
import com.agvber.home.homeRoute
import com.agvber.home.navigateToHomeScreen
import com.agvber.photodetail.addPhotoDetailScreen
import com.agvber.photodetail.navigateToPhotoDetailScreen
import com.agvber.randomphoto.addRandomPhotoScreen
import com.agvber.randomphoto.navigateToRandomPhotoScreen

@Composable
fun PrographyNavHost() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = homeRoute
    ) {

        addHomeScreen(
            navigationItemOnChange = {
                when (it) {
                    PrographyNavigationItem.HOME -> navController.navigateToHomeScreen()
                    PrographyNavigationItem.RANDOM_PHOTO -> navController.navigateToRandomPhotoScreen()
                }
            },
            itemClick = navController::navigateToPhotoDetailScreen
        )
        addRandomPhotoScreen(
            navigationItemOnChange = {
                when (it) {
                    PrographyNavigationItem.HOME -> navController.navigateToHomeScreen()
                    PrographyNavigationItem.RANDOM_PHOTO -> navController.navigateToRandomPhotoScreen()
                }
            },
            photoInfoButtonOnClick = {
                navController.navigateToPhotoDetailScreen(
                    it, "network"
                )
            }
        )
        addPhotoDetailScreen(onBackRequest = navController::popBackStack)
    }
}