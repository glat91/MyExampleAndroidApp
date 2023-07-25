package com.example.myexampleapp.models.menu

import com.example.myexampleapp.utils.customEnums
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MenuModel(
    @SerializedName("opcion") var opcion: String,
    @SerializedName("img") var image: Int,
    @SerializedName("choice") var menuChoice: customEnums.MenuChoosenEnum
): Serializable