package com.example.myexampleapp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myexampleapp.models.menu.MenuModel
import com.example.myexampleapp.models.menu.MenuOpcModel
import com.example.myexampleapp.navigation.NavigationGraph
import com.example.myexampleapp.ui.screens.biometrics.view.BiometricsView
import com.example.myexampleapp.ui.screens.menu.view.MenuView
import com.example.myexampleapp.ui.theme.MyExampleAppTheme
import com.example.myexampleapp.utils.customEnums
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            //val a = LocalContext.current as FragmentActivity
            MyExampleAppTheme {
                val navHostController = rememberAnimatedNavController()
                NavigationGraph(navHostController)


            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyExampleAppTheme {
        Greeting("Android")
    }
}