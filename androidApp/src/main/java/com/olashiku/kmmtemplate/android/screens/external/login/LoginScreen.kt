package com.olashiku.kmmtemplate.android.screens.external.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.olashiku.kmmtemplate.android.R
import com.olashiku.kmmtemplate.android.resource.Colors
import com.olashiku.kmmtemplate.android.resource.Fonts
import com.olashiku.kmmtemplate.android.resource.Strings
import com.olashiku.kmmtemplate.android.screens.external.reusable.CheckBoxView
import com.olashiku.kmmtemplate.android.screens.external.reusable.EditText
import com.olashiku.kmmtemplate.android.screens.external.reusable.EditTextPassword
import com.olashiku.kmmtemplate.android.screens.external.reusable.SolidButton
import com.olashiku.kmmtemplate.android.screens.external.reusable.TransparentButtonSmallSize
import com.olashiku.kmmtemplate.android.screens.external.reusable.TransparentButtonWithAnnotation
import com.olashiku.kmmtemplate.android.screens.external.reusable.spannableString

@Composable
fun LoginScreen(navController: NavController) {

    val usernameState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(Colors.whiteColor)).verticalScroll(ScrollState(0))
                .height(IntrinsicSize.Max)
        ) {
            TopSection()
            MiddleSection(usernameState = usernameState, passwordState = passwordState)
            Spacer(modifier = Modifier.weight(1f))
            BottomSection(navController)
        }

}

@Composable
fun TopSection(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .height(130.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = Strings.login,
            style = Fonts.Typography.h1,
            fontSize = 24.sp,
            color = Color(Colors.blackTextColor),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun MiddleSection(modifier: Modifier = Modifier,usernameState: MutableState<String>, passwordState: MutableState<String>) {

    Column(modifier = Modifier.padding(16.dp)) {
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 17.dp)
                .clickable { }
            ,
            shape = RectangleShape,
            color = Color(Colors.googleBlue),

        ) {
            Row {
                Image(
                    painter =
                    painterResource(id = R.drawable.google_logo),
                    contentDescription = ""
                )
                Text(
                    text = Strings.signInWithGoogle,
                    textAlign = TextAlign.Center,
                    style = Fonts.Typography.body1,
                    fontSize = 16.sp,
                    color = Color(Colors.whiteColor),
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(10.dp, 10.dp, 38.dp, 10.dp)
                )
            }
        }


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

        Spacer(
            modifier = modifier
                .fillMaxWidth()
                .height(20.dp)
        )
        EditText(
            modifier.fillMaxWidth(), usernameState,Strings.emailOrPhoneText,
            isEnabled = true, isSingleLine = true)
        Spacer(
            modifier = modifier
                .fillMaxWidth()
                .height(16.dp)
        )
        EditTextPassword(
            modifier.fillMaxWidth(),
            passwordState,Strings.emailOrPhoneText,
            isEnabled = true, isSingleLine = true,
            imeAction = ImeAction.Done)


        Row(modifier = modifier.padding(0.dp, 15.dp, 0.dp, 0.dp)) {
            CheckBoxView(modifier = modifier.padding(0.dp, 0.dp, 0.dp, 5.dp), { status ->

            }, Strings.rememberMeText)

            Spacer(Modifier.weight(1f))

            TransparentButtonSmallSize(
                text = Strings.forgotPassword, action = {
                }, modifier = modifier
                    .fillMaxWidth(), textAlign = TextAlign.Right
            )
        }
    }
}

@Composable
fun BottomSection(
  navController: NavController,
    modifier: Modifier = Modifier) {
    Column(
        modifier
            .padding(10.dp)
            .fillMaxSize()
            .background(color = Color(Colors.whiteColor))
    ) {

        SolidButton(text = Strings.loginText, action = {
           navController.navigate(Strings.insideRoot)
        }, modifier = modifier.padding(top = 60.dp))

        TransparentButtonWithAnnotation(
            text = spannableString(Strings.noAccountTextOne, Strings.noAccountTextTwo),
            action = {
               navController.navigate(Strings.registrationScreen)
            }, modifier = modifier
                .padding(0.dp, 24.dp, 0.dp, 0.dp)
                .fillMaxWidth()

        )


    }

}
