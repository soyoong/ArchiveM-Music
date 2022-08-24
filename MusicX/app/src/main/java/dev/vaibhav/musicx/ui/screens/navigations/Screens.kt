package dev.vaibhav.musicx.ui.screens.navigations

import dev.vaibhav.musicx.utils.BottomConstants.ROUTE_FORGOT_PASSWORD
import dev.vaibhav.musicx.utils.BottomConstants.ROUTE_LOGIN
import dev.vaibhav.musicx.utils.BottomConstants.ROUTE_MAIN_SCREEN
import dev.vaibhav.musicx.utils.BottomConstants.ROUTE_SIGNUP


sealed class Screens(val route: String) {

    object Login : Screens(ROUTE_LOGIN)
    object SignUp : Screens(ROUTE_SIGNUP)
    object ForgotPassword : Screens(ROUTE_FORGOT_PASSWORD)
    object MainScreen : Screens(ROUTE_MAIN_SCREEN)

}
