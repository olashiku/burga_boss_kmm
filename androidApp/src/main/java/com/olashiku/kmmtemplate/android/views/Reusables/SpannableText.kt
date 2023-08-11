package com.olashiku.kmmtemplate.android.views.Reusables

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.olashiku.kmmtemplate.android.resource.Colors

@Composable
fun spannableString(textOne:String,textTwo:String): AnnotatedString {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(Color(Colors.grayTextColor),
            fontWeight = FontWeight.Light)) {
            append(textOne)
        }
        withStyle(style = SpanStyle(Color(Colors.brownColor),
            fontWeight = FontWeight.SemiBold)) {
            append(textTwo)
        }
    }
    return annotatedString
}