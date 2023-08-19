package com.olashiku.kmmtemplate.android.screens.external.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.olashiku.kmmtemplate.android.R
import com.olashiku.kmmtemplate.utils.Utils
import com.olashiku.kmmtemplate.viewModel.ProductsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(navController: NavController,  viewModel: ProductsViewModel = koinViewModel()) {
    ShowLogo()
    Utils.WaitFor(3000) {
        navController.navigate("IntroScreen")
    }
}

 @Composable
 fun ShowLogo(){
     Box(modifier = Modifier
         .paint(
             painterResource(id = R.drawable.splash_background),
             contentScale = ContentScale.FillBounds
         )
         .fillMaxSize(),
         contentAlignment = Alignment.Center
     )
     {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
     }
 }

 @Preview
@Composable
fun PreviewDesign(){
     ShowLogo()
}