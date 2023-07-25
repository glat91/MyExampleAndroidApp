package com.example.myexampleapp.models.menu

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MenuOpcModel(
    @SerializedName("list_menu_opcion") var listMenuOpc: ArrayList<MenuModel> = arrayListOf(),
): Serializable

