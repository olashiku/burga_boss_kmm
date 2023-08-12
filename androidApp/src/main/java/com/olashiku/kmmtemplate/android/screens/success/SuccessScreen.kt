package com.olashiku.kmmtemplate.android.screens.success

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.olashiku.kmmtemplate.android.R
import com.olashiku.kmmtemplate.android.resource.Colors
import com.olashiku.kmmtemplate.android.resource.Fonts
import com.olashiku.kmmtemplate.android.resource.Strings
import com.olashiku.kmmtemplate.android.screens.reusable.SolidButton

@Composable
fun SuccessScreen(navController: NavController, modifier: Modifier = Modifier) {



    Column(modifier = modifier.background(Color(Colors.whiteColor))) {
        ContentSection(modifier)
        Spacer(modifier = Modifier.weight(1F))
        BottomSection(navController = navController)
    }

}


@Composable
fun ContentSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(500.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.success_icon),
            contentDescription = "success icon"
        )

        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            text = Strings.verificationTitle,
            style = Fonts.Typography.h1,
            fontSize = 20.sp,
            color = Color(Colors.blackTextColor),
            textAlign = TextAlign.Center
        )

        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, start = 17.dp, end = 17.dp, top = 8.dp),
            text = Strings.verificationBody,
            style = Fonts.Typography.body1,
            fontSize = 14.sp,
            color = Color(Colors.verificationTextColor),
            textAlign = TextAlign.Center
        )
    }

}

@Composable
fun BottomSection(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .padding(start = 10.dp, end = 10.dp, bottom = 30.dp)
            .fillMaxWidth()
            .height(150.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SolidButton(text = Strings.proceed, action = {
            navController.popBackStack(route = Strings.introScreen, inclusive = false)
        })
    }
}





@Preview
@Composable
fun itemPreview() {

}



