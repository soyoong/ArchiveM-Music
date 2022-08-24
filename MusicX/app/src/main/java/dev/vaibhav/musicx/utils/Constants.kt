package dev.vaibhav.musicx.utils

const val NOTIFICATION_ID = 1
const val CHANNEL_ID = "MusicXChannel"
const val CHANNEL_NAME = "MusicX"
const val MEDIA_ROOT_ID = "root_id"

const val NETWORK_ERROR = "Network error"
const val DURATION = "duration"

const val sArtworkUri = "content://media/external/audio/albumart"

enum class MusicState {
    PLAYING, PAUSED, NONE
}

object BottomConstants {
    const val ROUTE_HOME = "Home"
    const val ROUTE_NOTIFICATION = "Notification"
    const val ROUTE_FAVORITE = "Favorite"
    const val ROUTE_SETTING = "Setting"
    const val ROUTE_MAIN_SCREEN = "Main screen"
    const val ROUTE_LOGIN = "Login"
    const val ROUTE_SIGNUP = "Sign up"
    const val ROUTE_FORGOT_PASSWORD = "Forgot password"
}