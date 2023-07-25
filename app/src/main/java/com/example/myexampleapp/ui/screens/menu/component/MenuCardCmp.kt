package com.example.myexampleapp.ui.screens.menu.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myexampleapp.R
import com.example.myexampleapp.ui.theme.MenuOpcionBorderColor

@Composable
fun MenuCardCmp(
    modifier: Modifier = Modifier,
    text: String,
    image: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(shape = RectangleShape)
            .border(width = 2.dp, color = MenuOpcionBorderColor, shape = RoundedCornerShape(
                topStartPercent = 10,
                topEndPercent = 10,
                bottomEndPercent = 10,
                bottomStartPercent = 10
            ))
            .size(100.dp)
            .background(Color.Transparent)
            .padding(10.dp)
            .clickable {
                       onClick()
            },
        contentAlignment = Alignment.Center,

    ){
        Column(
            modifier
                    ,//.paint(painterResource(id = R.drawable.circle), contentScale = ContentScale.Crop),
                    horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(50.dp),
                painter = painterResource(id = image),
                contentDescription = "menu icon"
            )
            Text(text = text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuCardCmpPreview(){
    MenuCardCmp(
        text = "Camara",
        image = R.drawable.camera,
        onClick = {

        }
    )
}