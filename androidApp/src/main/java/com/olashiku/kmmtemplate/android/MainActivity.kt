package com.olashiku.kmmtemplate.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.olashiku.kmmtemplate.android.resource.Strings
import com.olashiku.kmmtemplate.android.screens.internal.dashboard.DashboardScreen
import com.olashiku.kmmtemplate.android.screens.external.intro.IntroScreen
import com.olashiku.kmmtemplate.android.screens.external.login.LoginScreen
import com.olashiku.kmmtemplate.android.screens.external.otp.OtpScreen
import com.olashiku.kmmtemplate.android.screens.external.signup.SignupScreen
import com.olashiku.kmmtemplate.android.screens.external.splash.SplashScreen
import com.olashiku.kmmtemplate.android.screens.external.success.SuccessScreen

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Strings.outsideRoot
                ) {
                    this.outsideNavGraph(navController = navController)
                    this.insideNavGraph()
                }

            }
        }
    }

    fun NavGraphBuilder.outsideNavGraph(
        navController: NavHostController
    ) {
        navigation(
            startDestination = Strings.splashScreen,
            route = Strings.outsideRoot
        ) {
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
            composable(Strings.otpScreen) {
                OtpScreen(navController = navController)
            }
            composable(Strings.successScreen) {
                SuccessScreen(navController = navController)
            }
        }

    }

    fun NavGraphBuilder.insideNavGraph() {
        navigation(
            startDestination = Strings.dashboardScreen,
            route = Strings.insideRoot
        ) {
            composable(route = Strings.dashboardScreen) {
                DashboardScreen()
            }
        }
    }
}




