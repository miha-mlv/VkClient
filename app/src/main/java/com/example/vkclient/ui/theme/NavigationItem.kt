package com.example.vkclient.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.vkclient.navigation.Screen

sealed class NavigationItem (
    val screen: Screen,
    val titleResId: String,
    val icon: ImageVector
){
    object Home: NavigationItem(
        screen = Screen.NewsFeed,
        titleResId = "Главная",
        icon = Icons.Outlined.Home
    )

    object Favourite: NavigationItem(
        screen = Screen.Favourite,
        titleResId = "Избранное",
        icon = Icons.Outlined.Favorite
    )

    object Profile: NavigationItem(
        screen = Screen.Profile,
        titleResId = "Профиль",
        icon = Icons.Outlined.Person
    )
}