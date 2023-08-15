package com.olashiku.kmmtemplate.android.screens.internal.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olashiku.kmmtemplate.android.R
import com.olashiku.kmmtemplate.android.model.ProfileModel
import com.olashiku.kmmtemplate.android.resource.Colors
import com.olashiku.kmmtemplate.android.resource.Fonts
import com.olashiku.kmmtemplate.android.resource.Strings

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.background(Color(Colors.whiteColor))) {
        TitleSection()
        MiddleSection()
        BottomSection()
    }
}


@Composable
fun TitleSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color(Colors.creamColor))
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = Strings.profile,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            style = Fonts.Typography.h1,
            modifier = modifier.padding(top = 30.dp)
        )
    }
}

@Composable
fun MiddleSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(230.dp)
            .background(
                color = Color(Colors.creamColor),
                shape = RoundedCornerShape(0.dp, 0.dp, 100.dp, 0.dp)
            )
            .wrapContentSize(Alignment.Center),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.height(28.dp))
        Image(
            modifier = modifier
                .width(100.dp)
                .height(100.dp),
            painter = painterResource(id = R.drawable.image_avater),
            contentDescription = null
        )
        Spacer(modifier = modifier.height(16.dp))
        Text(
            text = "Oguntayo Oluwayemisi",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            style = Fonts.Typography.h1,
        )
        Text(
            text = "olashiku@gmail.com",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            style = Fonts.Typography.body1,
        )
    }
}

@Composable
fun BottomSection(modifier: Modifier = Modifier) {
    val profileItem = ProfileModel().getProfileModel(Strings.registeredCustomerType)
    LazyColumn(modifier = modifier.padding(top = 25.dp), content = {
        items(profileItem.size) { index ->
            ShowMenuList(modifier, profileItem[index])
        }
    })
}

@Composable
fun ShowMenuList(modifier: Modifier = Modifier, profileModel: ProfileModel = ProfileModel()) {
    Column(modifier = modifier.clickable { }) {
        Row(
            modifier = modifier
                .background(color = Color(Colors.whiteColor))
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 16.dp)
        ) {
            Image(
                painter = painterResource(id = profileModel.image),
                contentDescription = "image",
                modifier = modifier
                    .padding(start = 32.dp, end = 8.dp, top = 2.dp)
            )
            Text(
                text = profileModel.title,
                fontSize = 16.sp,
                style = Fonts.Typography.body1,
                color = if(profileModel.title.equals(Strings.logout)) Color(Colors.logoutColor) else Color(Colors.noorderColor)
            )
            Spacer(modifier = modifier.weight(1F))
            Image(
                painter = painterResource(id = R.drawable.menu_arrow),
                contentDescription = "image",
                modifier = modifier.padding(end = 32.dp)
            )
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(16.dp)
                .background(Color(Colors.lightCreamColor))
        )
    }


}

@Preview(showSystemUi = true)
@Composable
fun Preview() {
    ProfileScreen()
}