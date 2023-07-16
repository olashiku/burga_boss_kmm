package com.olashiku.kmmtemplate.android.views.Reusables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olashiku.kmmtemplate.android.resource.Colors
import com.olashiku.kmmtemplate.android.resource.Fonts


@Composable
fun SolidButton(text: String, action: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = { action.invoke() },
        modifier
            .height(60.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(Colors.brownColor)
        ),
        shape = RoundedCornerShape(20),
        elevation = ButtonDefaults.elevation(0.dp),


        ) {

        Text(
            text = text,
            color = Color(Colors.whiteColor), fontSize = 16.sp,
            style = Fonts.Typography.body1,

        )
    }
}

@Composable
fun LightButton(text: String, action: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = { action.invoke() },
        modifier
            .height(60.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(Colors.lightBrownColor),
            contentColor = Color(Colors.lightBrownColor)
        ),
        shape = RoundedCornerShape(20),
        elevation = ButtonDefaults.elevation(0.dp),



        ) {
        Text(
            text = text, color = Color(Colors.brownColor),
            fontSize = 16.sp,
            style = Fonts.Typography.body1,
            )
    }
}

@Composable
fun TransparentButton(text: String, action: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = { action.invoke() },
        modifier
            .height(60.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.Black
        ),
        shape = RoundedCornerShape(20),
        elevation = ButtonDefaults.elevation(0.dp),


        ) {
        Text(
            text = text, color = Color(Colors.brownColor),
            fontSize = 16.sp,
            style = Fonts.Typography.body1,
            )
    }
}

@Preview
@Composable
fun RunComposable() {
    LightButton("hello_world", {})
}