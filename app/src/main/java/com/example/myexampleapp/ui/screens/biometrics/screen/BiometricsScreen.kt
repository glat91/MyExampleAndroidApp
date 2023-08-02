package com.example.myexampleapp.ui.screens.biometrics.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.myexampleapp.ui.screens.biometrics.view.BiometricsView
import com.example.myexampleapp.ui.screens.biometrics.viewmodel.BiometricsViewModel

@Composable
fun BiometricsScreen(
    navHostController: NavHostController
) {
    val viewModel: BiometricsViewModel = hiltViewModel()
    val screen = LocalContext.current as FragmentActivity
    BiometricsView(
        flagBack = viewModel.getFlagBack(),
        isBiometricActivate = viewModel.getBiometricFlag(),
        onClickBiometric = { viewModel.checkBiometrics(screen) }
    )
}
