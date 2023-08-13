package com.olashiku.kmmtemplate.android.screens.internal.menu

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olashiku.kmmtemplate.android.R
import com.olashiku.kmmtemplate.android.resource.Colors
import com.olashiku.kmmtemplate.android.resource.Fonts
import com.olashiku.kmmtemplate.android.screens.external.reusable.TransparentButtonWithIcon
import com.olashiku.kmmtemplate.model.ProductDetails
import com.olashiku.kmmtemplate.viewModel.UserViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun MenuScreen(modifier: Modifier = Modifier, viewModel: UserViewModel = koinViewModel()) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(Colors.backgroundColor))
    ) {

        Column(modifier.padding(start = 16.dp, end = 16.dp)) {
            Spacer(modifier = modifier.height(10.dp))
            TitleBar()
            AdvertSection()
            Spacer(modifier = modifier.height(39.dp))
            TabSection()
            DataSection(viewModel.getProducts())
        }
    }

}

@Composable
fun TitleBar(modifier: Modifier = Modifier) {

    Column {
        Row {
            Text(
                modifier = modifier
                    .padding(top = 8.dp, end = 30.dp)
                    .weight(1F),
                text = stringResource(id = R.string.greeting_text, "Ada"),
                fontSize = 25.sp,
                style = Fonts.Typography.h1,
            )
            TransparentButtonWithIcon(R.drawable.alert_icon, {
            })

            TransparentButtonWithIcon(R.drawable.chart_icon, {
            })
        }
        Text(
            text = stringResource(id = R.string.what_your_order, "Oluwayemisi"),
            fontSize = 16.sp,
            fontWeight = FontWeight.Light,
            color = Color(Colors.menuTopTextColor),
            style = Fonts.Typography.body1,
        )
    }
}

@Composable
fun AdvertSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Spacer(modifier = modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.advert_image),
            contentDescription = "advertImage",
            modifier
                .height(135.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
        )
    }
}

@Composable
fun TabSection() {
    var selectedIndex by remember { mutableStateOf(0) }

    val list = listOf("Burger", "Fries", "Drinks")

    TabRow(selectedTabIndex = selectedIndex,
        backgroundColor = Color(Colors.tabBackgroundColor),
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(15)),
        indicator = { tabPositions: List<TabPosition> ->
            Box {}
        }
    ) {
        list.forEachIndexed { index, text ->
            val selected = selectedIndex == index
            Tab(
                modifier = if (selected) Modifier
                    .clip(RoundedCornerShape(10))
                    .background(
                        Color.White
                    )
                else Modifier
                    .clip(RoundedCornerShape(10))
                    .background(
                        Color(
                            Colors.tabBackgroundColor
                        )
                    ),
                selected = selected,
                onClick = { selectedIndex = index },
                text = {
                    Text(
                        text = text,
                        style = Fonts.Typography.body1,
                        fontSize = 16.sp,
                        color = if (selected) Color(Colors.brownColor) else Color(Colors.blackTextColor)
                    )
                }
            )
        }
    }
}


@Composable
fun DataSection(products: List<ProductDetails>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = modifier.padding(top = 20.dp)) {
        items(products.size) { index ->
            ProductTile(products[index])
        }
    }
}


@Composable
fun ProductTile(
    product: ProductDetails = ProductDetails()
) {
    val modifier: Modifier = Modifier
    Card(modifier = modifier
        .padding(10.dp)
        .height(200.dp)
        .width(150.dp)
        .clickable { },
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color(Colors.lineColor)),
        backgroundColor = Color.White
    ) {

        Column {
            Image(
                painter = painterResource(id = R.drawable.burger_image),
                contentDescription = "product image",
                modifier = modifier
                    .padding(start = 7.dp, end = 7.dp)
                    .width(156.dp)
                    .height(146.dp)
                    .clip(RoundedCornerShape(10.dp))
            )

            Row(modifier = modifier.padding(start = 7.dp, end = 7.dp, top = 14.dp)) {
                Column {
                    Text(
                        text = product.productName,
                        fontSize = 10.sp,
                        style = Fonts.Typography.body1,
                        color = Color(Colors.blackTextColor)
                    )

                    Text(
                        text = product.amount,
                        fontSize = 10.sp,
                        style = Fonts.Typography.body1,
                        color = Color(Colors.blackTextColor)
                    )
                }
                Spacer(modifier = modifier.weight(1f))
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.tiny_fab),
                        contentDescription = "tiny floatable action button"
                    )
                }
            }
        }
    }


}

@Preview()
@Composable
fun Preview() {
    ProductTile()
}





