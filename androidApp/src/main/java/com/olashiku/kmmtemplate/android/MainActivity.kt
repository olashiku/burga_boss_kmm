package com.olashiku.kmmtemplate.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.olashiku.kmmtemplate.android.resource.Strings
import com.olashiku.kmmtemplate.android.screens.dashboard.DashboardScreen
import com.olashiku.kmmtemplate.android.screens.intro.IntroScreen
import com.olashiku.kmmtemplate.android.screens.login.LoginScreen
import com.olashiku.kmmtemplate.android.screens.otp.OtpScreen
import com.olashiku.kmmtemplate.android.screens.signup.SignupScreen
import com.olashiku.kmmtemplate.android.screens.splash.SplashScreen
import com.olashiku.kmmtemplate.android.screens.success.SuccessScreen

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()
                val bottomNavController = rememberNavController();

                //  DashboardScreen(navController = navController,bottomNavController = bottomNavController)

                NavHost(navController = navController, startDestination = Strings.splashScreen) {
                    composable(Strings.splashScreen) {
                        SplashScreen(navController = navController)
                    }
                    composable(Strings.introScreen) {
                        IntroScreen(navController = navController)
                    }
                    composable(Strings.loginScreen) {
                        LoginScreen(navController = navController)
                    }
                    composable(Strings.registrationScreen) {
                        SignupScreen(navController = navController)
                    }
                    composable(Strings.dashboardScreen) {
                        DashboardScreen(
                            navController = navController,
                            bottomNavController = bottomNavController
                        )
                    }
                    composable(Strings.otpScreen) {
                        OtpScreen(navController = navController)
                    }
                    composable(Strings.successScreen) {
                        SuccessScreen(navController = navController)
                    }

                }

            }
        }
    }
}




