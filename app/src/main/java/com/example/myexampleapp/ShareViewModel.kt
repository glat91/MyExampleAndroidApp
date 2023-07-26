package com.example.myexampleapp

import androidx.lifecycle.ViewModel
import com.example.myexampleapp.models.shareviewmodel.ListSharedModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShareViewModel @Inject constructor(): ViewModel() {
    var listSharedViewModel: ListSharedModel = ListSharedModel()

    // TODO debe de verificar si hay otro modelo con el mismo nombre
    fun addSharedModel(){}
    // TODO filtrar modelos para obtener el buscado
    fun getSharedModel(){}
    // TODO remover un modelo
    fun removeModel(){}
    fun clean(){
        listSharedViewModel = ListSharedModel()
    }
}