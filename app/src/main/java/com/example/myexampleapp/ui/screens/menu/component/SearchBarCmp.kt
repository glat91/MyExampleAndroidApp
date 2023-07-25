package com.example.myexampleapp.ui.screens.menu.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myexampleapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarCmp(
    modifier: Modifier = Modifier,
    state: MutableState<TextFieldValue>
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
    ){
        TextField(modifier = Modifier
            .fillMaxWidth(.8f),
            value = state.value,
            onValueChange = { value ->
                state.value = value
            },
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 16.sp),
            trailingIcon = {
                Icon(
                    painterResource(id = R.drawable.search),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(16.dp)
                        .size(25.dp)
                )

                /*
                if (state.value != TextFieldValue(StringUtil.EMPTY_STR)) {
                    IconButton(
                        onClick = {
                            state.value =
                                TextFieldValue(StringUtil.EMPTY_STR) // Remove text from TextField when you press the 'X' icon
                        }
                    ) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = StringUtil.EMPTY_STR,
                            modifier = Modifier
                                .padding(15.dp)
                                .size(24.dp)
                        )
                    }
                }
                 */

            },
            /*
            leadingIcon = {
                /*
                Icon(
                    Icons.Default.Search,
                    contentDescription = StringUtil.EMPTY_STR,
                    modifier = Modifier
                        .padding(15.dp)
                        .size(24.dp)
                )
                 */

            },
             */

            singleLine = true,
            shape = RoundedCornerShape(8.dp), // The TextFiled has rounded corners top left and right by default
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                cursorColor = Color.Black,
                //leadingIconColor = Color.Black,
                //trailingIconColor = Color.Black,
                //backgroundColor = DefaultBackGroundIntercam,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarCmpPreview(){
    val text = remember { mutableStateOf(TextFieldValue("")) }
    SearchBarCmp(
        state = text
    )
}