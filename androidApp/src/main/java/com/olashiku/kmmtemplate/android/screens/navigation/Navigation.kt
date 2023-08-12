package com.olashiku.kmmtemplate.android.screens.navigation

import com.olashiku.kmmtemplate.android.R
import com.olashiku.kmmtemplate.android.resource.Strings

sealed class BottomNavigationScreens(val route: String,val title:String, val selectedIcon: Int,val unselectedIcon: Int) {
    object menu : BottomNavigationScreens(Strings.menuScreen, Strings.menu, R.drawable.menu_icon, R.drawable.menu_icon_inative)
    object myorder : BottomNavigationScreens(Strings.myOrderScreen, Strings.order, R.drawable.selected_order, R.drawable.order_icon)
    object myFavorite : BottomNavigationScreens(Strings.myFavoriteScreen,  Strings.favorite, R.drawable.selected_favorite, R.drawable.favorite_icon)
    object myProfile : BottomNavigationScreens(Strings.myProfileScreen,  Strings.profile, R.drawable.select_profile,R.drawable.profile_icon)
}