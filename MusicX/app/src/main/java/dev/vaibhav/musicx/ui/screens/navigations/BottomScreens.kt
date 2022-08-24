package dev.vaibhav.musicx.ui.screens.navigations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import dev.vaibhav.musicx.utils.BottomConstants


sealed class BottomScreens(val route: String, val label: String, val icon: ImageVector) {

    object Home : BottomScreens(BottomConstants.ROUTE_HOME, "Home", Icons.Default.Home)
    object Notification : BottomScreens(BottomConstants.ROUTE_NOTIFICATION, "Notification", Icons.Default.Notifications)

    object Favorite : BottomScreens(BottomConstants.ROUTE_FAVORITE, "Favorite", Icons.Default.Favorite)
    object Setting : BottomScreens(BottomConstants.ROUTE_SETTING, "Setting", Icons.Default.Settings)

    object Items {
        val items = listOf(
            Home, Notification, Favorite, Setting
        )
    }
}