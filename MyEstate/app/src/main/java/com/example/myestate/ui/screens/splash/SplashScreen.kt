package com.example.myestate.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myestate.R
import com.example.myestate.ui.components.ButtonComponents
import com.example.myestate.ui.components.TextComponents
import com.example.myestate.utils.getStringRes

@Composable
fun SplashScreen(
    navigateToHome: () -> Unit
) {
    val viewModel:SplashViewModelInterface = SplashViewModel()
    val state = viewModel.state.value
    Box {

        Image(
            painterResource(R.drawable.testbackimage),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize(),
          )

        Column(
            modifier = Modifier.fillMaxSize().padding(vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
            ) {
            Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                TextComponents.HeadlineTitle(getStringRes(state.appTitle))
                TextComponents.SubTitle(getStringRes(state.subTitle))
            }

            Column(modifier = Modifier.padding(bottom = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                // Email Button
                ButtonComponents.AccountButton(
                    getStringRes(state.emailButtonType.text),
                    backColor = Color(state.emailButtonType.backColor),
                    textColor = Color(state.emailButtonType.textColor)
                    )
                // Google Button
                ButtonComponents.AccountButton(
                    getStringRes(state.googleButtonType.text),
                    backColor = Color(state.googleButtonType.backColor),
                    textColor = Color(state.googleButtonType.textColor))

                //NormalClickableText
                TextComponents.NormalClickableText(
                    getStringRes(state.clickableTextTitle),
                    Color.White,
                    Modifier.clickable {
                        navigateToHome()
                    }
                )
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(navigateToHome = {})
}