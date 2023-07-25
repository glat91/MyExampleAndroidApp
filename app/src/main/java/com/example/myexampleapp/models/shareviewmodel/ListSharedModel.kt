package com.example.myexampleapp.models.shareviewmodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ListSharedModel(
    @SerializedName("list_shared_model") var listSharedModel: ArrayList<ListSharedModel> = arrayListOf(),
): Serializable