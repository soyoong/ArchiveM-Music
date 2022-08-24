package dev.vaibhav.musicx.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.vaibhav.musicx.utils.BottomConstants.ROUTE_HOME
import dev.vaibhav.musicx.utils.BottomConstants.ROUTE_NOTIFICATION
import dev.vaibhav.musicx.utils.BottomConstants.ROUTE_SETTING

@Composable
fun Notification() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Notification",
            fontSize = 20.sp
        )
    }
}

@Composable
fun Favorite() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Favorite",
            fontSize = 20.sp
        )
    }
}

@Composable
fun Settings() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Settings",
            fontSize = 20.sp
        )
    }
}