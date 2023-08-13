package com.olashiku.kmmtemplate.android.screens.external.reusable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.olashiku.kmmtemplate.android.resource.Colors
import com.yogeshpaliyal.speld.PinInput

@Composable
fun Otp(modifier: Modifier, textState: MutableState<String>) {
    val focusRequester = remember { FocusRequester() }
    val text = textState

    PinInput(
        cellModifier = modifier
            .size(width = 45.dp, height = 45.dp)
            .background(Color(Colors.editTextColor),RoundedCornerShape(5.dp) )
            .clickable { }
            .focusRequester(focusRequester)
            .onFocusChanged { focusRequester.requestFocus() },
        value = text.value,
        length = 4,
        disableKeypad = false,
    ) {
        text.value = it
    }

 }