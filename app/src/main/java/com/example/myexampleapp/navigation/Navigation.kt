package com.example.myexampleapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.example.myexampleapp.ui.screens.biometrics.screen.BiometricsScreen
import com.example.myexampleapp.ui.screens.camera.screen.CameraScreen
import com.example.myexampleapp.ui.screens.menu.screen.MenuScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun Navigation(navHostController: NavHostController) {
    AnimatedNavHost(
        navController = navHostController,
        startDestination = Destination.Home.route
    ){
        homeScreen(navHostController = navHostController)
        bluetoothScreen(navHostController = navHostController)
        biometricScreen(navHostController = navHostController)
        cameraScreen(navHostController = navHostController)
        listScreen(navHostController = navHostController)
        notificationScreen(navHostController = navHostController)
    }
}
@ExperimentalAnimationApi
@ExperimentalPagerApi
fun NavGraphBuilder.homeScreen(navHostController: NavHostController) {
    composable(
        route = Destination.Home.route,
        enterTransition = { Animations.customEnterAnimation },
        exitTransition = { Animations.customExitAnimation },
        popEnterTransition = { Animations.customPopEnterAnimation },
        popExitTransition = { Animations.customPopExitAnimation }
    ){
        MenuScreen(
            navHostController = navHostController
        )
    }
}
@ExperimentalAnimationApi
@ExperimentalPagerApi
fun NavGraphBuilder.bluetoothScreen(navHostController: NavHostController) {
    composable(
        route = Destination.BT.route,
        enterTransition = { Animations.customEnterAnimation },
        exitTransition = { Animations.customExitAnimation },
        popEnterTransition = { Animations.customPopEnterAnimation },
        popExitTransition = { Animations.customPopExitAnimation }
    ){
        MenuScreen(
            navHostController = navHostController
        )
    }
}
@ExperimentalAnimationApi
@ExperimentalPagerApi
fun NavGraphBuilder.biometricScreen(navHostController: NavHostController) {
    composable(
        route = Destination.Biometric.route,
        enterTransition = { Animations.customEnterAnimation },
        exitTransition = { Animations.customExitAnimation },
        popEnterTransition = { Animations.customPopEnterAnimation },
        popExitTransition = { Animations.customPopExitAnimation }
    ){
        BiometricsScreen(
            navHostController = navHostController
        )
    }
}
@ExperimentalAnimationApi
@ExperimentalPagerApi
fun NavGraphBuilder.cameraScreen(navHostController: NavHostController) {
    composable(
        route = Destination.Camera.route,
        enterTransition = { Animations.customEnterAnimation },
        exitTransition = { Animations.customExitAnimation },
        popEnterTransition = { Animations.customPopEnterAnimation },
        popExitTransition = { Animations.customPopExitAnimation }
    ){
        CameraScreen(
            navHostController = navHostController
        )
    }
}
@ExperimentalAnimationApi
@ExperimentalPagerApi
fun NavGraphBuilder.listScreen(navHostController: NavHostController) {
    composable(
        route = Destination.List.route,
        enterTransition = { Animations.customEnterAnimation },
        exitTransition = { Animations.customExitAnimation },
        popEnterTransition = { Animations.customPopEnterAnimation },
        popExitTransition = { Animations.customPopExitAnimation }
    ){
        MenuScreen(
            navHostController = navHostController
        )
    }
}
@ExperimentalAnimationApi
@ExperimentalPagerApi
fun NavGraphBuilder.notificationScreen(navHostController: NavHostController) {
    composable(
        route = Destination.Notification.route,
        enterTransition = { Animations.customEnterAnimation },
        exitTransition = { Animations.customExitAnimation },
        popEnterTransition = { Animations.customPopEnterAnimation },
        popExitTransition = { Animations.customPopExitAnimation }
    ){
        MenuScreen(
            navHostController = navHostController
        )
    }
}
