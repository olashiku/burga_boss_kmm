package com.olashiku.kmmtemplate.android.screens.otp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.olashiku.kmmtemplate.android.R
import com.olashiku.kmmtemplate.android.resource.Colors
import com.olashiku.kmmtemplate.android.resource.Fonts
import com.olashiku.kmmtemplate.android.resource.Strings
import com.olashiku.kmmtemplate.android.screens.reusable.Otp
import com.olashiku.kmmtemplate.android.screens.reusable.SolidButton
import com.olashiku.kmmtemplate.android.screens.reusable.TransparentButtonWithIcon


@Composable
fun OtpScreen(navController: NavController, modifier: Modifier = Modifier) {

    val otpState = remember{
        mutableStateOf("")
    }
    Column (modifier.background(Color(Colors.whiteColor))){
        TopSection(navController)
        MiddleSection(modifier,otpState)
        Spacer(modifier = modifier.weight(1F))
        BottomSection(navController)
    }

}

@Composable
fun TopSection(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxWidth()
    ) {

        TransparentButtonWithIcon(R.drawable.back_image, {
            navController.popBackStack()
        }, modifier = modifier.padding(top = 10.dp))

        Spacer(
            modifier = modifier
                .fillMaxWidth()
                .height(30.dp)
        )

        Text(
            modifier = modifier.fillMaxWidth(),
            text = Strings.verificationTitle,
            style = Fonts.Typography.h1,
            fontSize = 24.sp,
            color = Color(Colors.blackTextColor),
            textAlign = TextAlign.Center
        )

        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, start = 85.dp, end = 85.dp, top = 10.dp),
            text = Strings.verificationBody,
            style = Fonts.Typography.body1,
            fontSize = 16.sp,
            color = Color(Colors.verificationTextColor),
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun MiddleSection(modifier: Modifier, otpState: MutableState<String>) {
    Column(modifier = modifier.padding(top = 32.dp)){
        Otp(modifier,otpState)
    }
}

@Preview
 @Composable
fun MiddleSectionPreview(modifier: Modifier = Modifier){

    val otpState = remember{ mutableStateOf("") }

    Column(modifier = modifier.padding(top = 32.dp)){
        Otp(modifier,otpState)
    }

}


@Composable
fun BottomSection(
    navController: NavController,
    modifier: Modifier = Modifier) {
    Column(
        modifier
            .padding(start = 10.dp,end = 10.dp, bottom = 80.dp)
            .fillMaxSize()
            .background(color = Color(Colors.whiteColor)),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SolidButton(text = Strings.proceed, action = {
            navController.navigate(Strings.successScreen)
        })


    }
}

