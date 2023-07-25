package com.example.myexampleapp.ui.screens.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit

@Composable
fun TextCmp(
    modifier: Modifier = Modifier,
    fontSize: TextUnit,
    textAlign: TextAlign,
    maxLines: Int = Int.MAX_VALUE,
    textValue: String
) {
    Text(
        modifier = modifier,
        text = textValue,
        fontSize = fontSize,
        textAlign = textAlign,
        maxLines = maxLines
    )
}