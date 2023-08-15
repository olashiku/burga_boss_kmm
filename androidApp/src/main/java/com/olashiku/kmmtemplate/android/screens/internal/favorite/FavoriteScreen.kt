package com.olashiku.kmmtemplate.android.screens.internal.favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olashiku.kmmtemplate.android.R
import com.olashiku.kmmtemplate.android.resource.Colors
import com.olashiku.kmmtemplate.android.resource.Fonts
import com.olashiku.kmmtemplate.android.resource.Strings

@Composable
fun FavoriteScreen(modifier: Modifier = Modifier){
    Column(modifier = modifier.fillMaxSize().background(color = Color(Colors.whiteColor))) {
        Spacer(modifier = modifier.height(10.dp))
        TitleBar()
        Spacer(modifier = modifier.height(64.dp))
        EmptyStateOrder()
    }
}


@Composable
fun EmptyStateOrder(modifier: Modifier = Modifier) {
    Column (modifier =modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Image(
            painter = painterResource(id = R.drawable.empty_favorite_icon),
            contentDescription = "empty image "
        )
        Spacer(modifier = modifier.height(16.dp))
        Text(
            text = Strings.noFavorite,
            fontSize = 16.sp,
            style = Fonts.Typography.body1,
            color = Color(Colors.noorderColor)
        )
    }


}

@Composable
fun TitleBar(modifier: Modifier = Modifier) {
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Row {
            Text(
                modifier = modifier
                    .weight(1F),
                text = Strings.favorite,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                style = Fonts.Typography.h1,
            )
        }
    }
}