package com.olashiku.kmmtemplate.android.screens.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.olashiku.kmmtemplate.android.resource.Colors


@Composable
fun MenuScreen(modifier:Modifier = Modifier){
    Column(modifier = modifier
        .fillMaxSize()
        .background(Color(Colors.grayTextColor)),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Menu",modifier, fontSize = 50.sp)
    }
}

@Composable
fun OrderScreen(modifier:Modifier = Modifier){
    Column(modifier = modifier
        .fillMaxSize()
        .background(Color(Colors.grayTextColor)),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Order",modifier, fontSize = 50.sp)
    }
}

@Composable
fun FavoriteScreen(modifier:Modifier = Modifier){
    Column(modifier = modifier
        .fillMaxSize()
        .background(Color(Colors.grayTextColor)),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Fsvorite",modifier, fontSize = 50.sp)

    }
}

@Composable
fun ProfileScreen(modifier:Modifier = Modifier){
    Column(modifier = modifier
        .fillMaxSize()
        .background(Color(Colors.grayTextColor)),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Profile",modifier, fontSize = 50.sp)

    }
}