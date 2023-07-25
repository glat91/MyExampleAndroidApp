package com.example.myexampleapp.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myexampleapp.R
import com.example.myexampleapp.ui.screens.menu.component.MenuCardCmp
import com.example.myexampleapp.ui.theme.PADDING_16
import com.example.myexampleapp.ui.theme.PADDING_8
import com.example.myexampleapp.ui.theme.TopBar

@Composable
fun BottomBarCmp() {
    Row(modifier = Modifier
        .height(50.dp)
        .fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(.4f)
                .fillMaxHeight()
        ) {

        }
        Row(
            modifier = Modifier
                .fillMaxWidth(.3f)
                .fillMaxHeight()
                .clip(RoundedCornerShape(10.dp))
                .background(TopBar)
        ) {

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarCmpPreview(){
    BottomBarCmp()
}