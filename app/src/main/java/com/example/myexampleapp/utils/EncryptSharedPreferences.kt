package com.example.myexampleapp.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class EncryptSharedPreferences @Inject constructor(
    @ApplicationContext val cnx: Context
) {
    val encryptSharedPreferences = getEncryptedSharedPreferences()

    private fun getEncryptedSharedPreferences(): SharedPreferences{
        val masterKey = MasterKey.Builder(cnx)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        return EncryptedSharedPreferences.create(
            cnx,
            "${cnx.packageName}_${this.javaClass.simpleName}",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }
    // TODO obtener valor de "encryptSharedPreferences" el valor
    inline fun <reified T: Any> getSharedPreferencesValue(code: String, value: T){
        return when (T::class){
            Boolean::class ->{}
            String::class ->{}
            Float::class ->{}
            Int::class ->{}
            else -> {
                throw Error("Error ${T::class.java.simpleName}, use other object")
            }
        }
    }
    // TODO put-Class- en cada case
    inline fun <reified T: Any> setEncryptedValue(code: String, value: T){
        with(encryptSharedPreferences.edit()){
            when(T::class){
                Boolean::class -> {}
                String::class ->{}
                Float::class ->{}
                Int::class ->{}
                else -> {
                    if (value is Set<*>){
                        putStringSet(code, value as Set<String>)
                    }
                    else{
                        val json = Gson().toJson(value)
                        putString(code, json)
                    }
                }
            }
        }
    }
    fun clean(){
        encryptSharedPreferences.edit {
            this.clear()
        }
    }
}