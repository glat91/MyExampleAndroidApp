package com.example.myexampleapp.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myexampleapp.R
import com.example.myexampleapp.ui.theme.DialogInfoBorderColor

@Composable
fun DialogInfoCmp() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 2.dp, color = DialogInfoBorderColor, shape = RoundedCornerShape(
            topStartPercent = 10,
            topEndPercent = 10,
            bottomEndPercent = 10,
            bottomStartPercent = 10
        )
        ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()){

            Column(
                modifier = Modifier
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .width(65.dp)
                        .height(65.dp),
                    painter = painterResource(id = R.drawable.jetpackcompose),
                    contentDescription = "Jetpack Compose logo"
                )
                TextCmp(
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    textValue = "Esta aplicacion fue realizada en JetPack Compose")
                TextCmp(
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    textValue = "Es solo un ejemplo y no recolecta datos de ningun tipo")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DialogInfoCmpPreview(){
    DialogInfoCmp()
}