package com.example.myexampleapp.ui.screens.camera.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.myexampleapp.navigation.Destination
import com.example.myexampleapp.ui.screens.camera.view.CameraView

@Composable
fun CameraScreen(
    navHostController: NavHostController
) {
    CameraView(
        onClickBack = { navHostController.navigate(route = Destination.Home.route) }
    )
}