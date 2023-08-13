package com.olashiku.kmmtemplate.android.screens.internal.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.olashiku.kmmtemplate.android.resource.Colors

@Composable
fun FavoriteScreen(modifier: Modifier = Modifier){
    Column(modifier = modifier
        .fillMaxSize()
        .background(Color(Colors.grayTextColor)),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Fsvorite",modifier, fontSize = 50.sp)
    }
}