package com.example.myexampleapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.example.myexampleapp.ui.screens.menu.screen.MenuScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.pager.ExperimentalPagerApi


@OptIn(ExperimentalAnimationApi::class, ExperimentalPagerApi::class)
@Composable
fun NavigationGraph(navHostController: NavHostController) {
    AnimatedNavHost(
        navController = navHostController,
        startDestination = Destination.Home.route
    ){
        homeScreen(navHostController = navHostController)
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
