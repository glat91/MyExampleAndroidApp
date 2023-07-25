package com.example.myexampleapp.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myexampleapp.R
import com.example.myexampleapp.ui.screens.menu.component.SearchBarCmp
import com.example.myexampleapp.ui.theme.TopBar

@Composable
fun TopBarCmp(
    textSearch: MutableState<TextFieldValue>,
    flagSearch: MutableState<Boolean> = mutableStateOf(false),
    flagBack: MutableState<Boolean> = mutableStateOf(false),
    onClick: () -> Unit,
    content: @Composable () -> Unit = {  }
) {

    ConstraintLayout(
        modifier = Modifier
            //.height(height)
            .fillMaxWidth()
            .background(TopBar)
    ) {
        val (ivPhoto, ivBack, searchBar) = createRefs()
        Image(
            modifier = Modifier
                .size(50.dp)
                .constrainAs(ivPhoto) {
                    top.linkTo(parent.top, margin = 8.dp)
                    end.linkTo(parent.end, margin = 4.dp)
                    //bottom.linkTo(txtTitle.bottom, goneMargin = 10.dp)
                }
                .clickable { onClick() },
            painter = painterResource(id = R.drawable.info),
            contentDescription = "menu icon"
        )

        if (!flagBack.value){
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .constrainAs(ivBack) {
                        top.linkTo(parent.top, margin = 8.dp)
                        start.linkTo(parent.start, margin = 4.dp)
                        //bottom.linkTo(txtTitle.bottom, goneMargin = 10.dp)
                    }
                    .clickable { onClick() },
                painter = painterResource(id = R.drawable.arrow_back),
                contentDescription = "arrow back image"
            )
        }
        if (!flagSearch.value){
            Column(
                modifier = Modifier.constrainAs(searchBar) {
                    top.linkTo(ivPhoto.bottom, margin = 8.dp)
                    //start.linkTo(ivPhoto.start, margin = 4.dp)
                    //bottom.linkTo(txtTitle.bottom, goneMargin = 10.dp)
                }
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SearchBarCmp(
                    state = textSearch)
            }

        }

    }
}


@Preview(showBackground = true)
@Composable
fun TopBarCmpPreview(){
    val text = remember { mutableStateOf(TextFieldValue("")) }
    TopBarCmp(
        onClick = {},
        textSearch = text
    )
}


