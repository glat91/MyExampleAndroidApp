package com.example.myexampleapp.ui.screens.biometrics.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentActivity
import com.example.myexampleapp.R
import com.example.myexampleapp.ui.screens.components.PrincipalScreenCmp
import com.example.myexampleapp.ui.screens.components.TextCmp
import com.example.myexampleapp.ui.screens.components.TopBarCmp
import com.example.myexampleapp.ui.theme.MenuOpcionBorderColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BiometricsView(
    flagBack: MutableState<Boolean>,
    isBiometricActivate: MutableState<Boolean>,
    onClickBiometric: () -> Unit,
    //fragment: FragmentActivity,
) {

    Scaffold(
        topBar = {
                 TopBarCmp(
                     textSearch = null,
                     flagBack = flagBack,
                     onClickBack = {
                         onClickBiometric()
                     })
        },
        content = {
            PrincipalScreenCmp(
                paddingBottom = it.calculateBottomPadding(),
                content = {
                    Column(
                        Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(
                            modifier = Modifier
                                .height(50.dp),
                            onClick = { onClickBiometric() },
                            colors = ButtonDefaults.buttonColors(MenuOpcionBorderColor)
                        ) {
                            TextCmp(
                                modifier = Modifier
                                    .height(50.dp)
                                    .background(MenuOpcionBorderColor),
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                textValue = if (isBiometricActivate.value) "Validar Huella" else "Activar Biometricos"
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(painter = painterResource(id = R.drawable.fingerprint), contentDescription = "")
                        }
                    }
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun BiometricsViewPreview(){
    val flagBack = remember { mutableStateOf(true) }
    val flagBiometric = remember { mutableStateOf(false) }


}