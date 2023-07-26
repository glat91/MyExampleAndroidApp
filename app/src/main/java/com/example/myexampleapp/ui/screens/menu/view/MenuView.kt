package com.example.myexampleapp.ui.screens.menu.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myexampleapp.R
import com.example.myexampleapp.models.menu.MenuModel
import com.example.myexampleapp.models.menu.MenuOpcModel
import com.example.myexampleapp.ui.screens.components.PrincipalScreenCmp
import com.example.myexampleapp.ui.screens.components.TopBarCmp
import com.example.myexampleapp.ui.screens.menu.component.MenuCardCmp
import com.example.myexampleapp.ui.theme.PADDING_16
import com.example.myexampleapp.ui.theme.PADDING_8
import com.example.myexampleapp.ui.theme.TopBar
import com.example.myexampleapp.utils.customEnums
import com.example.myexampleapp.utils.customEnums.MenuChoosenEnum.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuView(
    menuOpc: MutableState<MenuOpcModel>,
    searchText: MutableState<TextFieldValue>,
    onClickInfo: () -> Unit,
    onClickMenu: (customEnums.MenuChoosenEnum) -> Unit
) {

    val scrollState = rememberScrollState()
    val menu = menuOpc.value

    val brush = Brush.verticalGradient(
        listOf(
            TopBar,
            Color.White)
    )
    Canvas(
        modifier = Modifier.size(200.dp),
        onDraw = {
            drawCircle(brush)
        }
    )
    Scaffold(
        modifier = Modifier.background(brush),
        topBar = {
                 TopBarCmp(
                     onClickBack = { onClickInfo() },
                     textSearch = searchText
                 )
        },
        content = {
            PrincipalScreenCmp(
                modifier = Modifier.padding(top = it.calculateTopPadding()),
                paddingBottom = it.calculateBottomPadding(),
                content = {
                    Column() {
                        Modifier
                            .verticalScroll(scrollState)
                            .padding(PADDING_8)
                    }
                    LazyVerticalGrid(
                        contentPadding = PaddingValues(16.dp, 16.dp, 16.dp),
                        verticalArrangement = Arrangement.spacedBy(PADDING_16),
                        horizontalArrangement = Arrangement.spacedBy(PADDING_16),
                        columns = GridCells.Fixed(2),
                        content = {
                            items(menu.listMenuOpc.size){item->
                                MenuCardCmp(
                                    text = menu.listMenuOpc[item].opcion,
                                    image = menu.listMenuOpc[item].image,
                                    onClick = {
                                        onClickMenu(menu.listMenuOpc[item].menuChoice)
                                        /**
                                        when(menu.listMenuOpc[item].menuChoice){
                                            Biometrics -> { Log.i("menu___", menu.listMenuOpc[item].menuChoice.name) }
                                            Camara -> { Log.i("menu___", menu.listMenuOpc[item].menuChoice.name) }
                                            List -> { Log.i("menu___", menu.listMenuOpc[item].menuChoice.name) }
                                            Maps -> { Log.i("menu___", menu.listMenuOpc[item].menuChoice.name) }
                                            BT -> { Log.i("menu___", menu.listMenuOpc[item].menuChoice.name) }
                                            Notification -> { Log.i("menu___", menu.listMenuOpc[item].menuChoice.name) }
                                        }
                                        */
                                    }
                                )
                            }
                    })

                }
            )
        },
        bottomBar = {
            //BottomBarCmp()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MenuViewPreview(){
    val menu = MenuOpcModel()
    menu.listMenuOpc.add(MenuModel("Biometricos", R.drawable.biometrics, Biometrics))
    menu.listMenuOpc.add(MenuModel("Camara", R.drawable.camera, Camara))
    menu.listMenuOpc.add(MenuModel("Lista", R.drawable.list, List))
    menu.listMenuOpc.add(MenuModel("Mapas", R.drawable.gmaps, Maps))
    menu.listMenuOpc.add(MenuModel("Bluetooth", R.drawable.bluetooth, BT))
    menu.listMenuOpc.add(MenuModel("Notificacion", R.drawable.notification, Notification))

    val text = remember { mutableStateOf(TextFieldValue("")) }
    MenuView(
        menuOpc = remember { mutableStateOf(menu) },
        searchText = text,
        onClickInfo = {},
        onClickMenu = {}
    )
}