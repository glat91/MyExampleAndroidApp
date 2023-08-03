package com.example.myexampleapp.navigation

sealed class Destination(
    val route: String
){
    object Home: Destination("home")
    object Biometric: Destination("biometric")
    object Camera: Destination("camera")
    object List: Destination("list")
    object BT: Destination("bluetooth")
    object Notification: Destination("notification")
    object GMaps: Destination("gmaps")
}
