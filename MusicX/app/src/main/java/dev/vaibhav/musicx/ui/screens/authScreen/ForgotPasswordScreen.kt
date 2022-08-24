package dev.vaibhav.musicx.ui.screens.authScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.vaibhav.musicx.R
import dev.vaibhav.musicx.ui.components.AuthButton
import dev.vaibhav.musicx.ui.components.AuthTextFiled
import dev.vaibhav.musicx.ui.components.BackButton
import dev.vaibhav.musicx.ui.screens.navigations.Screens
import dev.vaibhav.musicx.utils.Define

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ForgotPasswordScreen(navHostController: NavHostController) {
    var email by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.music_background),
            contentDescription = "Background image",
            modifier = Modifier,
            contentScale = ContentScale.FillBounds
        )

        Scaffold(
            backgroundColor = Color.Transparent,   // Make the background transparent
            topBar = {
                Column(modifier = Modifier.padding(vertical = 60.dp)) {
                    BackButton(onClicked = {
                        // Todo
                        navHostController.popBackStack()
                    })
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Reset password".toUpperCase(Locale.current),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                    )
                }
            },
            modifier = Modifier

        ) {
            // Scaffold content

            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            ) {

                AuthTextFiled(
                    text = email,
                    type = Define.TextFieldType.Email,
                    placeholder = "Email",
                    painter = painterResource(id = R.drawable.ic_email),
                    modifier = Modifier,
                    onValueChange = { email = it }
                )

                Spacer(modifier = Modifier.height(40.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AuthButton(label = "Send", onClicked = {
                        // Todo
                        navHostController.navigate(Screens.Login.route)
                    })
                }

            }
        }

    }
}
