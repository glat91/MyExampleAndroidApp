package com.example.myexampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.myexampleapp.models.menu.MenuModel
import com.example.myexampleapp.models.menu.MenuOpcModel
import com.example.myexampleapp.ui.screens.menu.view.MenuView
import com.example.myexampleapp.ui.theme.MyExampleAppTheme
import com.example.myexampleapp.utils.customEnums

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyExampleAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
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
                }
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