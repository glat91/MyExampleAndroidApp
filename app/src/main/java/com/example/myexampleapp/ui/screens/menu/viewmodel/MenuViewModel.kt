package com.example.myexampleapp.ui.screens.menu.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import com.example.myexampleapp.R
import com.example.myexampleapp.models.menu.MenuModel
import com.example.myexampleapp.models.menu.MenuOpcModel
import com.example.myexampleapp.utils.customEnums
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(

): ViewModel() {
    val menu: MutableState<MenuOpcModel> = mutableStateOf(MenuOpcModel())
    val serchText: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue(""))
    val flagSerch: MutableState<Boolean> = mutableStateOf(true)


    init {
        menu.value.listMenuOpc.add(MenuModel("Biometricos", R.drawable.biometrics, customEnums.MenuChoosenEnum.Biometrics))
        menu.value.listMenuOpc.add(MenuModel("Camara", R.drawable.camera, customEnums.MenuChoosenEnum.Camara))
        menu.value.listMenuOpc.add(MenuModel("Lista", R.drawable.list, customEnums.MenuChoosenEnum.List))
        menu.value.listMenuOpc.add(MenuModel("Mapas", R.drawable.gmaps, customEnums.MenuChoosenEnum.Maps))
        menu.value.listMenuOpc.add(MenuModel("Bluetooth", R.drawable.bluetooth, customEnums.MenuChoosenEnum.BT))
        menu.value.listMenuOpc.add(MenuModel("Notificacion", R.drawable.notification, customEnums.MenuChoosenEnum.Notification))
    }
}