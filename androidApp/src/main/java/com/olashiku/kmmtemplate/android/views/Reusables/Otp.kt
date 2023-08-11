package com.olashiku.kmmtemplate.android.views.Reusables

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.olashiku.kmmtemplate.android.resource.Colors
import com.yogeshpaliyal.speld.PinInput

@Composable
fun Otp(modifier: Modifier, textState: MutableState<String>) {
    val text = textState
    PinInput(
        cellModifier = modifier
            .background(Color(Colors.grayOtpColor))
            .clip(RoundedCornerShape(3.dp)),
        value = text.value,
        obscureText = "*",
        length = 4,
        disableKeypad = false // Optional
    ) {
        text.value = it
    }
}