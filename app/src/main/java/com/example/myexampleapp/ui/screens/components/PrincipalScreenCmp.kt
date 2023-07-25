package com.example.myexampleapp.ui.screens.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.myexampleapp.ui.theme.PADDING_16
import com.example.myexampleapp.ui.theme.TopBar

@Composable
fun PrincipalScreenCmp(
    modifier: Modifier = Modifier,
    paddingBottom: Dp,
    contentPadding: Dp = PADDING_16,
    content: @Composable () -> Unit
) {

    val brush = Brush.verticalGradient(
        listOf(
            TopBar,
            Color.White)
    )
    Canvas(
        modifier = Modifier.size(200.dp),
        onDraw = {
            drawCircle(brush)
        }
    )

    Surface(
        modifier = modifier
            .background(brush)
            .border(width = 2.dp, color = TopBar, shape = RoundedCornerShape(
                topStartPercent = 4,
                topEndPercent = 4,
            )),
        shape = RoundedCornerShape(
            topStartPercent = 4,
            topEndPercent = 4,
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                //.padding(top = contentPadding, start = contentPadding, end = contentPadding)
                .background(brush)
        ) {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrincipalScreenCmpPreview(){

}