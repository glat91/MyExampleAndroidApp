package com.example.myexampleapp.ui.screens.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
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

@Composable
fun DialogImageCmp(
    textTitle: String,
    textMessage: String,
    onClickAccept: () -> Unit,
    onClickCancel: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(1f),
        color = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 32.dp)
                    .fillMaxWidth()
                    .background(
                        color = Color.White
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier
                    .height(40.dp))
                TextCmp(
                    maxLines = 2,
                    modifier = Modifier
                        .fillMaxWidth()
                    ,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    textValue = textTitle
                )

                Spacer(Modifier.height(16.dp))

                TextCmp(
                    maxLines = 2,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                    ,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    textValue = textMessage
                )
                Spacer(Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column() {
                        Button(
                            onClick = {
                                      Log.i("alertBtn___", "aceptar")
                            },
                            content = {
                                TextCmp(fontSize = 20.sp, textAlign = TextAlign.Center, textValue = "Aceptar")
                            }
                        )
                    }
                    Column() {
                        Button(
                            onClick = {
                                Log.i("alertBtn___", "cancelar")
                            },
                            content = {
                                TextCmp(fontSize = 20.sp, textAlign = TextAlign.Center, textValue = "Cancelar")
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(height = 16.dp * 2))
            }
            Image(
                modifier = Modifier
                    .align(alignment = Alignment.TopCenter)
                    .width(65.dp)
                    .height(65.dp),
                painter = painterResource(id = R.drawable.jetpackcompose),
                contentDescription = "Alert in blue"
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DialogImageCmpPreview(){
    DialogImageCmp(
        textTitle = "App V0.0.1",
        textMessage = "Esta app fue realizada con JetPack Compose, es solo una muestra para CV no recopila datos de ningun tipo",
        onClickAccept = { /*TODO*/ }
    ) {

    }
}