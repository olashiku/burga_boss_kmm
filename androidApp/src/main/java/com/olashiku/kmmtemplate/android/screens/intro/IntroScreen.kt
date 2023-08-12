package com.olashiku.kmmtemplate.android.screens.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.olashiku.kmmtemplate.android.R
import com.olashiku.kmmtemplate.android.resource.Colors
import com.olashiku.kmmtemplate.android.resource.Fonts
import com.olashiku.kmmtemplate.android.resource.Strings
import com.olashiku.kmmtemplate.android.screens.reusable.LightButton
import com.olashiku.kmmtemplate.android.screens.reusable.SolidButton
import com.olashiku.kmmtemplate.android.screens.reusable.TransparentButton
import com.olashiku.kmmtemplate.viewModel.UserViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun IntroScreen(navController: NavController ) {
    Surface(modifier = Modifier.fillMaxSize().verticalScroll(ScrollState(0))) {
        Column {
            CreateTopSection()
            Spacer(modifier = Modifier.weight(1f))
            BottomSection(navController)
        }
    }
}

@Composable
fun CreateTopSection(modifier: Modifier = Modifier) {
    Column(
        modifier =
        modifier
            .fillMaxWidth()
            .background(color = Color(0x29F1A13E)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.burga_image),
            contentDescription = "intro image drawable",

            modifier
                .padding( vertical = 5.dp)
                .size(306.dp)
        )

        Text(
            text = Strings.introText,
            style = Fonts.Typography.h1,
            fontSize = 16.sp,
            color = Color(Colors.grayTextColor),
            textAlign = TextAlign.Center,
            modifier = modifier.padding(top = 20.dp,bottom = 20.dp, start = 10.dp, end = 10.dp)
        )
    }
}

@Composable
fun BottomSection(navController: NavController, modifier: Modifier = Modifier,userViewModel: UserViewModel = koinViewModel()) {

    Column(modifier.padding(20.dp, 30.dp, 20.dp, 0.dp)) {
        SolidButton(text = Strings.loginText, action = {
            navController.navigate(Strings.loginScreen)
        })

        LightButton(text = Strings.signupText, action = {
            navController.navigate(Strings.registrationScreen)
        }, modifier.padding(0.dp, 16.dp, 0.dp, 0.dp))

        Box(
            modifier
                .fillMaxWidth()
                .padding(0.dp, 24.dp, 0.dp, 0.dp), contentAlignment = Alignment.Center
        ) {
            Divider(
                color = Color(Colors.grayLineColor),
                startIndent = 1.dp,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 0.dp),
            )
            Text(
                text = Strings.orText,
                color = Color(Colors.brownColor),
                fontSize = 16.sp,
                style = Fonts.Typography.body1,

                modifier = modifier
                    .background(Color.White)
                    .padding(10.dp)
            )
        }


        TransparentButton(
            text = Strings.exploreText, action = {
                navController.navigate(Strings.dashboardScreen){
                    popUpTo(Strings.introScreen) {
                        inclusive = true
                    }
                }
            }, modifier = modifier
                .padding(0.dp, 24.dp, 0.dp, 24.dp)
                .fillMaxWidth()

        )
    }
}

