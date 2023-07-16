package com.olashiku.kmmtemplate.android.resource

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.olashiku.kmmtemplate.android.R
import com.olashiku.kmmtemplate.android.resource.Fonts.Typography

object Fonts {
    val Rene = FontFamily(
        Font(R.font.rene_bieder),
        Font(R.font.rene_bieder_light),
        Font(R.font.rene_bieder_medium),
        Font(R.font.rene_galano),
        Font(R.font.rene_galano_light),
        Font(R.font.rene_galano_medium)
    )

     val Typography = Typography(
         h1 = TextStyle(
             fontFamily = Rene,
             fontWeight = FontWeight.Bold,
             fontSize = 24.sp
         ),
         body1 = TextStyle(
             fontFamily = Rene,
             fontWeight = FontWeight.Normal,
             fontSize = 16.sp
         )
     )
}