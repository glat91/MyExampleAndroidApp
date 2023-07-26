package com.example.myexampleapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import com.example.myexampleapp.models.menu.MenuModel
import com.example.myexampleapp.models.menu.MenuOpcModel
import com.example.myexampleapp.navigation.NavigationGraph
import com.example.myexampleapp.ui.screens.menu.view.MenuView
import com.example.myexampleapp.ui.theme.MyExampleAppTheme
import com.example.myexampleapp.utils.customEnums
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //val a = LocalContext.current as FragmentActivity
            MyExampleAppTheme {
                val navHostController = rememberAnimatedNavController()
                NavigationGraph(navHostController)
                /*
                val menu = MenuOpcModel()
                menu.listMenuOpc.add(MenuModel("Biometricos", R.drawable.fingerprint, customEnums.MenuChoosenEnum.Biometrics))
                menu.listMenuOpc.add(MenuModel("Camara", R.drawable.camera, customEnums.MenuChoosenEnum.Camara))
                menu.listMenuOpc.add(MenuModel("Lista", R.drawable.list, customEnums.MenuChoosenEnum.List))
                menu.listMenuOpc.add(MenuModel("Mapas", R.drawable.gmaps, customEnums.MenuChoosenEnum.Maps))
                menu.listMenuOpc.add(MenuModel("Bluetooth", R.drawable.bluetooth, customEnums.MenuChoosenEnum.BT))
                menu.listMenuOpc.add(MenuModel("Notificacion", R.drawable.notification, customEnums.MenuChoosenEnum.Notification))
                val text = remember { mutableStateOf(TextFieldValue("")) }
                MenuView(
                    menuOpc = remember { mutableStateOf(menu) },
                    searchText = text,
                    onClickInfo = {},
                    onClickMenu = {

                    }
                )
                 */

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