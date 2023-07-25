package com.example.myexampleapp.models.shareviewmodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SharedModel(
    @SerializedName("code") var code: String = "",
    @SerializedName("shared_entity") var sharedEntity: Any? = null
): Serializable
