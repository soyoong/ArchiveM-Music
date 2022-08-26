package dev.vaibhav.musicx.ui.screens.navigations

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector
import dev.vaibhav.musicx.R
import dev.vaibhav.musicx.ui.screens.navigations.MainDestinations.ARTISTS_ROOT
import dev.vaibhav.musicx.ui.screens.navigations.MainDestinations.BROWSER_ROOT
import dev.vaibhav.musicx.ui.screens.navigations.MainDestinations.GENRES_ROOT
import dev.vaibhav.musicx.ui.screens.navigations.MainDestinations.HOME_ROOT
import dev.vaibhav.musicx.ui.screens.navigations.MainDestinations.MY_MUSIC_ROOT

sealed class BottomNavigationScreens(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector,
) {

    object Browser :
        BottomNavigationScreens(BROWSER_ROOT, R.string.browser_screen_route, Icons.Rounded.ArtTrack)

    object Artists :
        BottomNavigationScreens(ARTISTS_ROOT, R.string.artists_screen_route, Icons.Rounded.Person)

    object Home :
        BottomNavigationScreens(HOME_ROOT, R.string.home_screen_route, Icons.Rounded.Home)

    object Genres :
        BottomNavigationScreens(GENRES_ROOT, R.string.genres_bag_screen_route, Icons.Rounded.Audiotrack)

    object MyMusic :
        BottomNavigationScreens(MY_MUSIC_ROOT, R.string.my_music_screen_route, Icons.Rounded.Headset)
}