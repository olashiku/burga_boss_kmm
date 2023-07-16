package com.olashiku.kmmtemplate.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.olashiku.kmmtemplate.android.views.IntroScreen.IntroScreen
import com.olashiku.kmmtemplate.android.resource.Strings
import com.olashiku.kmmtemplate.android.views.DashboardScreen.DashboardScreen
import com.olashiku.kmmtemplate.android.views.LoginScreen.LoginScreen
import com.olashiku.kmmtemplate.android.views.SignupScreen
import com.olashiku.kmmtemplate.android.views.SplashScreen.SplashScreen
import com.olashiku.kmmtemplate.model.request.profile.GetUserProfileRequest
import com.olashiku.kmmtemplate.model.request.register.RegisterRequest
import com.olashiku.kmmtemplate.viewModel.AuthenticationViewModel
import com.olashiku.kmmtemplate.viewModel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "SplashScreen") {
                    composable(Strings.splashScreen){
                        SplashScreen(navController = navController)
                    }
                    composable(Strings.introScreen){
                        IntroScreen(navController = navController)
                    }
                    composable(Strings.loginScreen){
                        LoginScreen(navController = navController)
                    }
                    composable(Strings.registrationScreen){
                        SignupScreen(navController = navController)
                    }
                    composable(Strings.dashboardScreen){
                        DashboardScreen(navController = navController)
                    }

                }

            }
        }
    }
}




