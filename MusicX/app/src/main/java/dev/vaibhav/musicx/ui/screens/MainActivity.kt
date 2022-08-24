package dev.vaibhav.musicx.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.vaibhav.musicx.data.viewmodel.MainViewModel
import dev.vaibhav.musicx.ui.screens.authScreen.ForgotPasswordScreen
import dev.vaibhav.musicx.ui.screens.authScreen.LoginScreen
import dev.vaibhav.musicx.ui.screens.authScreen.SignUpScreen
import dev.vaibhav.musicx.ui.screens.homeScreen2.HomeScreen3
import dev.vaibhav.musicx.ui.screens.navigations.Screens
import dev.vaibhav.musicx.ui.theme.MusicXTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicXTheme {
                Surface(color = MaterialTheme.colors.background) {
                    RootNavigation(mainViewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RootNavigation(mainViewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.Login.route) {
        composable(Screens.Login.route) {
            LoginScreen(navController)
        }

        composable(Screens.ForgotPassword.route) {
            ForgotPasswordScreen(navController)
        }

        composable(Screens.SignUp.route) {
            SignUpScreen(navController)
        }

        composable(Screens.MainScreen.route) {
            BottomNavigationController(mainViewModel, navController)
        }

    }
}
