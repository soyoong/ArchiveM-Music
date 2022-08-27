package me.hamsah.musiccompose.ui.screens.authScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import me.hamsah.musiccompose.R
import me.hamsah.musiccompose.ui.navigations.MainDestinations.HOME_ROOT
import me.hamsah.musiccompose.ui.navigations.MainDestinations.REGISTER_ROOT
import me.hamsah.musiccompose.ui.screens.authScreen.components.AuthTextFiled
import me.hamsah.musiccompose.ui.screens.authScreen.components.LoginButton
import me.hamsah.musiccompose.utils.enums.TextFieldType

@ExperimentalComposeUiApi
@Composable
fun LoginScreen(navHostController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
                Text(
                    text = "Sign in".toUpperCase(Locale.current),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(vertical = 60.dp)
                )
            },
            modifier = Modifier
                .padding(horizontal = 20.dp)

        ) {
            // Scaffold content

            Column {

                AuthTextFiled(
                    text = email,
                    type = TextFieldType.email,
                    placeholder = "Email",
                    painter = painterResource(id = R.drawable.ic_email),
                    modifier = Modifier,
                    onValueChange = { email = it }
                )

                Spacer(modifier = Modifier.height(20.dp))

                AuthTextFiled(
                    text = password,
                    type = TextFieldType.password,
                    placeholder = "Password",
                    painter = painterResource(id = R.drawable.ic_lock),
                    modifier = Modifier,
                    onValueChange = { password = it }
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "Forgot password?",
                        color = Color.White,
                        modifier = Modifier
                            .clickable {
                                /* todo */
                            },
                        textAlign = TextAlign.End
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LoginButton(
                        label = "Sign in",
                        onClicked = {
                            // Todo
                            navHostController.navigate(HOME_ROOT)
                        }
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Sing up".uppercase(),
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier
                            .clickable {
                                // Todo
                                navHostController.navigate(REGISTER_ROOT)
                            }
                    )
                }
            }
        }
    }
}
