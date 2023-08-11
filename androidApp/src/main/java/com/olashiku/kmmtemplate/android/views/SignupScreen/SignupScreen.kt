package com.olashiku.kmmtemplate.android.views.SignupScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.olashiku.kmmtemplate.android.R
import com.olashiku.kmmtemplate.android.resource.Colors
import com.olashiku.kmmtemplate.android.resource.Fonts
import com.olashiku.kmmtemplate.android.resource.Strings
import com.olashiku.kmmtemplate.android.views.Reusables.EditText
import com.olashiku.kmmtemplate.android.views.Reusables.SolidButton
import com.olashiku.kmmtemplate.android.views.Reusables.TransparentButtonWithAnnotation
import com.olashiku.kmmtemplate.android.views.Reusables.TransparentButtonWithIcon
import com.olashiku.kmmtemplate.android.views.Reusables.spannableString

@Composable
fun SignupScreen(navController: NavController) {

    val firstNameState = remember { mutableStateOf("") }
    val lastNameState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val phoneState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val confirmPasswordState = remember { mutableStateOf("") }


    Column(Modifier.background(color = Color(Colors.whiteColor)).verticalScroll(rememberScrollState())) {
        TopSection(navController)
        MiddleSection(
            firstNameState = firstNameState,
            lastNameState = lastNameState, emailState = emailState,
            phoneState = phoneState,
            passwordState = passwordState, reEnterPasswordState = confirmPasswordState
        )
        BottomSection(navController = navController)
    }
}


@Composable
fun TopSection(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .height(130.dp)
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
            text = Strings.getStarted,
            style = Fonts.Typography.h1,
            fontSize = 24.sp,
            color = Color(Colors.blackTextColor),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun MiddleSection(
    modifier: Modifier = Modifier,
    firstNameState: MutableState<String>,
    lastNameState: MutableState<String>,
    emailState: MutableState<String>,
    phoneState: MutableState<String>,
    passwordState: MutableState<String>,
    reEnterPasswordState: MutableState<String>
) {

    Column(modifier = Modifier.padding(16.dp)) {
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .padding(0.dp, 17.dp, 0.dp, 0.dp),
            shape = RectangleShape,
            color = Color(Colors.googleBlue)
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
                .background(Color.White)
                .padding(0.dp, 33.dp, 0.dp, 0.dp), contentAlignment = Alignment.Center
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


        Row(modifier = modifier
            .padding(top = 20.dp)
            .fillMaxWidth()) {
            EditText(
                modifier = modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                textState = firstNameState,
                label = Strings.firstNameText,
                isEnabled = true,
                isSingleLine = false
            )

            EditText(
                modifier = modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                textState = lastNameState,
                label = Strings.lastNameText,
                isEnabled = true,
                isSingleLine = false
            )
        }


            EditText(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                textState = emailState,
                label = Strings.emailText,
                isEnabled = true,
                isSingleLine = false
            )

            EditText(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                textState = phoneState,
                label = Strings.phoneText,
                isEnabled = true,
                isSingleLine = false
            )

            EditText(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                textState = passwordState,
                label = Strings.passwordText,
                isEnabled = true,
                isSingleLine = false
            )

            EditText(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                textState = reEnterPasswordState,
                label = Strings.confirmPasswordText,
                isEnabled = true,
                isSingleLine = false
            )
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

        SolidButton(text = Strings.signupText, action = {
            navController.navigate(Strings.dashboardScreen)
        })

        TransparentButtonWithAnnotation(
            text = spannableString(Strings.haveAccountLogin, Strings.loginText),
            action = {
                navController.navigate(Strings.registrationScreen)
            }, modifier = modifier
                .padding(0.dp, 24.dp, 0.dp, 0.dp)
                .fillMaxWidth()

        )


    }
}



