package dev.vaibhav.musicx.ui.screens.authScreen

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
import dev.vaibhav.musicx.R
import dev.vaibhav.musicx.ui.components.AuthButton
import dev.vaibhav.musicx.ui.components.AuthTextFiled
import dev.vaibhav.musicx.ui.screens.navigations.Screens
import dev.vaibhav.musicx.utils.Define

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
                    type = Define.TextFieldType.Email,
                    placeholder = "Email",
                    painter = painterResource(id = R.drawable.ic_email),
                    modifier = Modifier,
                    onValueChange = { email = it }
                )

                Spacer(modifier = Modifier.height(20.dp))

                AuthTextFiled(
                    text = password,
                    type = Define.TextFieldType.Password,
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
                    AuthButton(label = "Sign in", onClicked = {
                        // Todo
                        navHostController.navigate(Screens.MainScreen.route)
                    })

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Sing up".uppercase(),
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier
                            .clickable {
                                // Todo
                                navHostController.navigate(Screens.SignUp.route)
                            }
                    )
                }

            }
        }

    }
}
