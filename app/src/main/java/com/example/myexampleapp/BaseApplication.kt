package com.example.myexampleapp

import android.app.Application
import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication: Application() {

    init {
        instance = this
    }

    companion object{
        private var instance: BaseApplication? = null
        fun applicationContext(): Context{
            return instance!!.applicationContext
        }
    }


}