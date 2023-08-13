package com.olashiku.kmmtemplate.android.screens.external.reusable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olashiku.kmmtemplate.android.resource.Colors
import com.olashiku.kmmtemplate.android.resource.Fonts

@Composable
fun CheckBoxView(modifier: Modifier = Modifier,checkStatus:(Boolean)->Unit, checkboxText:String) {

    val checked = remember { mutableStateOf(true) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Spacer(modifier = modifier.height(60.dp))
        Checkbox(
            checked = checked.value,
            onCheckedChange = { checked_ ->
                checked.value = checked_
                checkStatus.invoke( checked.value)
            }
        )
        Text(
            modifier = Modifier.padding(start = 2.dp),
            text = checkboxText,
            style = Fonts.Typography.body1,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light,
            color = Color(Colors.rememberMeTextColor))
    }
}