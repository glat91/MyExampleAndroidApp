package com.example.myexampleapp.ui.screens.maps.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import com.example.myexampleapp.ui.screens.components.PrincipalScreenCmp
import com.example.myexampleapp.ui.screens.components.TopBarCmp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun GMapsView() {
    Scaffold(
        topBar = {
            TopBarCmp(
                textSearch = null,
                flagBack = mutableStateOf(true),
                flagSearch = mutableStateOf(false),
                onClickBack = {  })
        },
        content = {
            PrincipalScreenCmp(
                paddingBottom = it.calculateBottomPadding(),
                content = {
                    val singapore = LatLng(1.35, 103.87)
                    val cameraPositionState = rememberCameraPositionState {
                        position = CameraPosition.fromLatLngZoom(singapore, 10f)
                    }
                    GoogleMap(
                        modifier = Modifier.fillMaxSize(),
                        cameraPositionState = cameraPositionState
                    ) {
                        Marker(
                            state = MarkerState(position = singapore),
                            title = "Singapore",
                            snippet = "Marker in Singapore"
                        )
                    }
                }
            )
        }
    )
    /*


     */
}