package com.agvber.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.agvber.designsystem.component.PrographyNavigationItem

const val homeRoute = "home_route"

fun NavController.navigateToHomeScreen(
    navOptions: NavOptions? = null,
) {
    navigate(homeRoute, navOptions = navOptions)
}

fun NavGraphBuilder.addHomeScreen(
    navigationItemOnChange: (PrographyNavigationItem) -> Unit,
    itemClick: (String, String) -> Unit,
) {

    composable(homeRoute) {
        HomeRoute(
            navigationItemOnChange = navigationItemOnChange,
            itemClick = itemClick
        )
    }
}