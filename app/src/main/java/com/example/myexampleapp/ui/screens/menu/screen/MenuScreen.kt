package com.example.myexampleapp.ui.screens.menu.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.myexampleapp.navigation.Destination
import com.example.myexampleapp.ui.screens.menu.view.MenuView
import com.example.myexampleapp.ui.screens.menu.viewmodel.MenuViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun MenuScreen(
    navHostController: NavHostController
) {
    val viewModel: MenuViewModel = hiltViewModel()
    //val activity = LocalContext.current as FragmentActivity

    MenuView(
        menuOpc = viewModel.menu,
        searchText = viewModel.serchText,
        onClickInfo = { /*TODO*/ },
        onClickMenu = {
            navHostController.navigate(route = Destination.Home.route)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MenuScreenPreview(){
    //MenuScreen()
}