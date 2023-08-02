package com.example.myexampleapp.ui.screens.camera.view

import android.annotation.SuppressLint
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.example.myexampleapp.R
import com.example.myexampleapp.ui.screens.components.TopBarCmp
import com.example.myexampleapp.ui.screens.menu.component.MenuCardCmp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlin.math.absoluteValue

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CameraView(
    onClickBack: () -> Unit = { }
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    
    Scaffold(
        topBar = {
            TopBarCmp(
                textSearch = null,
                flagBack = mutableStateOf(true),
                flagSearch = mutableStateOf(false),
                onClickBack = onClickBack)
        },
        content = {
            val padding = it.calculateBottomPadding()
            AndroidView(
                factory = { ctx ->
                    val previewView = PreviewView(ctx)
                    val executor = ContextCompat.getMainExecutor(ctx)
                    cameraProviderFuture.addListener({
                        val cameraProvider = cameraProviderFuture.get()
                        val preview = Preview.Builder().build().also {
                            it.setSurfaceProvider(previewView.surfaceProvider)
                        }

                        val cameraSelector = CameraSelector.Builder()
                            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                            .build()

                        cameraProvider.unbindAll()
                        cameraProvider.bindToLifecycle(
                            lifecycleOwner,
                            cameraSelector,
                            preview
                        )
                    }, executor)
                    previewView
                },
                modifier = Modifier.fillMaxSize(),
            )
        },

    )

    /**
    import androidx.compose.ui.util.lerp


    val pagerState = rememberPagerState(initialPage = 2)
    HorizontalPager(
        modifier = Modifier.height(200.dp),
        count = 5,
        contentPadding = PaddingValues(horizontal = 100.dp),
        itemSpacing = 5.dp,
        state = pagerState
    ) { page ->
        Card(
            modifier = Modifier.graphicsLayer {
                val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                lerp(start = .5f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f,1f)
                ).also { scale->
                    scaleX = scale
                    scaleY = scale
                }
                alpha = lerp(
                    start = .5f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f,1f)
                )
            },
        ) {
            MenuCardCmp(text = "Something", image = R.drawable.fingerprint) {

            }
        }
    }
    */
}

//@Preview(showBackground = true)
@Composable
fun CameraViewPreview(){
    //CameraView()
}