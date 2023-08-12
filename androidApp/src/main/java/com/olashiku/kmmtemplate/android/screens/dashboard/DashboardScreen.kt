package com.olashiku.kmmtemplate.android.screens.dashboard

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.olashiku.kmmtemplate.android.resource.Colors
import com.olashiku.kmmtemplate.android.resource.Fonts
import com.olashiku.kmmtemplate.android.resource.Strings
import com.olashiku.kmmtemplate.android.screens.menu.FavoriteScreen
import com.olashiku.kmmtemplate.android.screens.menu.MenuScreen
import com.olashiku.kmmtemplate.android.screens.menu.OrderScreen
import com.olashiku.kmmtemplate.android.screens.menu.ProfileScreen
import com.olashiku.kmmtemplate.android.screens.navigation.BottomNavigationScreens

@Composable
fun DashboardScreen(navController: NavHostController, bottomNavController: NavHostController) {

    val bottomNavigationItems = listOf(
        BottomNavigationScreens.menu,
        BottomNavigationScreens.myorder,
        BottomNavigationScreens.myFavorite,
        BottomNavigationScreens.myProfile
    )

    Scaffold(
        bottomBar = {
            SpookyAppBottomNavigation(navController, bottomNavigationItems)
        },
    ) {
        MainScreenNavigationConfigurations(navController, modifier = Modifier.padding(it))
    }
}


@Composable
private fun SpookyAppBottomNavigation(
    navController: NavHostController,
    items: List<BottomNavigationScreens>
) {
    BottomNavigation(  backgroundColor = Color(Colors.whiteColor),
    ){

        val currentRoute = currentRoute(navController)
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { screen ->

            val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

            val drawableResource = if (
                selected) screen.selectedIcon
            else screen.unselectedIcon

            BottomNavigationItem(
                icon = {
                    Icon(
                        modifier=Modifier.padding(3.dp),
                        painter = painterResource(id = drawableResource),
                        contentDescription = "",
                        tint = if (selected) Color(Colors.brownColor)  else Color(Colors.rememberMeTextColor)
                    )
                },
                label = {
                    Text(
                    text = screen.title,
                    style = Fonts.Typography.h1,
                    fontSize = 10.sp,
                    fontWeight = if(selected) FontWeight.SemiBold else FontWeight.Normal,
                    color = if(selected) Color(Colors.brownColor) else Color(Colors.rememberMeTextColor)
                    ) },
                selected = selected,
                alwaysShowLabel = true,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString("KEY_ROUTE")
}


@Composable
private fun MainScreenNavigationConfigurations(
    navController: NavHostController, modifier: Modifier = Modifier
) {
    NavHost(navController, startDestination = Strings.menuScreen) {
        composable(Strings.menuScreen) {
            MenuScreen()
        }
        composable(Strings.myOrderScreen) {
            OrderScreen()
        }
        composable(Strings.myFavoriteScreen) {
            FavoriteScreen()
        }
        composable(Strings.myProfileScreen) {
            ProfileScreen()
        }
    }
}