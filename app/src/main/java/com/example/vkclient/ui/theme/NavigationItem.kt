package com.example.vkclient.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem (
    val titleResId: String,
    val icon: ImageVector
){
    object Home: NavigationItem(
        titleResId = "Главная",
        icon = Icons.Outlined.Home
    )

    object Favourite: NavigationItem(
        titleResId = "Избранное",
        icon = Icons.Outlined.Favorite
    )

    object Profile: NavigationItem(
        titleResId = "Профиль",
        icon = Icons.Outlined.Person
    )
}