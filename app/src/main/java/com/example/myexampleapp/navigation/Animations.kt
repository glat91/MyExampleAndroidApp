package com.example.myexampleapp.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.ui.Alignment

class Animations {

    companion object{
        val customEnterAnimation: EnterTransition = slideInHorizontally(initialOffsetX = { 1000 })
        val customExitAnimation: ExitTransition = slideOutHorizontally(targetOffsetX = { -1000 })

        val customPopEnterAnimation: EnterTransition = slideInHorizontally(initialOffsetX = { 1000 })
        val customPopExitAnimation: ExitTransition = slideOutHorizontally(targetOffsetX = { -1000 })

        val customExpandVerticalAnimation: EnterTransition = expandVertically(expandFrom = Alignment.Bottom)
        val customShrinkVerticalAnimation: ExitTransition = shrinkVertically(shrinkTowards = Alignment.Bottom)
    }
}