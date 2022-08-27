package me.hamsah.musiccompose.ui.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import me.hamsah.musiccompose.ui.navigations.BottomNavigationScreens
import me.hamsah.musiccompose.ui.screens.ArtistsScreen
import me.hamsah.musiccompose.ui.screens.BrowserScreen
import me.hamsah.musiccompose.ui.screens.GenresScreen
import me.hamsah.musiccompose.ui.screens.home.HomeScreen
import me.hamsah.musiccompose.ui.screens.MyMusicScreen

object MainDestinations {

    const val RESET_PASSWORD_ROOT = "Reset Password"
    const val REGISTER_ROOT = "Register"
    const val LOGIN_ROOT = "Login"
    const val BROWSER_ROOT = "Browser"
    const val ARTISTS_ROOT = "Artists"
    const val HOME_ROOT = "Home"
    const val GENRES_ROOT = "Genres"
    const val MY_MUSIC_ROOT = "MyMusic"
}

@Composable
internal fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController,
        startDestination = BottomNavigationScreens.Browser.route
    ) {
        composable(BottomNavigationScreens.Browser.route) {
            BrowserScreen()
        }
        composable(BottomNavigationScreens.Artists.route) {
            ArtistsScreen()
        }
        composable(BottomNavigationScreens.Home.route) {
            HomeScreen()
        }
        composable(BottomNavigationScreens.Genres.route) {
            GenresScreen()
        }
        composable(BottomNavigationScreens.MyMusic.route) {
            MyMusicScreen()
        }
    }
}