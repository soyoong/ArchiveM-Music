package me.hamsah.musiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import me.hamsah.musiccompose.ui.navigations.MainScreen
import me.hamsah.musiccompose.ui.theme.MusicComposeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicComposeTheme {
                MainScreen()
            }
        }
    }
}