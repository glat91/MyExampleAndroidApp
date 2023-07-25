package com.example.myexampleapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class BaseViewModel {
    private var aboutDialog: MutableState<Boolean> = mutableStateOf(false)
    fun stateDialogInfo() = aboutDialog

    private var dialogAlert: MutableState<Boolean> = mutableStateOf(false)
    private var textAlert: MutableState<String> = mutableStateOf("")
    fun stateDialogAlert() = dialogAlert
    fun setTextAlert(text: String) { textAlert.value = text }
    fun getTextAlert() = textAlert.value

}