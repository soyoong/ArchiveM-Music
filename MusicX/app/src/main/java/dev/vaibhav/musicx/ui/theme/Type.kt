package dev.vaibhav.musicx.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.vaibhav.musicx.R

// Replace with your font locations
val Gilroy = FontFamily(
    Font(R.font.gilroy_regular, FontWeight.W400),
    Font(R.font.gilroy_medium, FontWeight.Medium),
    Font(R.font.gilroy_semi_bold, FontWeight.SemiBold),
    Font(R.font.gilroy_bld, FontWeight.Bold),
)

val OpenSans = FontFamily(
    Font(R.font.opensans_regular, FontWeight.W400),
    Font(R.font.opensans_medium, FontWeight.Medium),
    Font(R.font.opensans_bold, FontWeight.Bold),
)

val Typography = androidx.compose.material.Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

//val Roboto = FontFamily(
//    Font(R.font.roboto_regular),
//    Font(R.font.roboto_black),
//    Font(R.font.roboto_black_italic),
//    Font(R.font.roboto_bold),
//    Font(R.font.roboto_bold_italic),
//    Font(R.font.roboto_medium),
//    Font(R.font.roboto_medium_italic),
//    Font(R.font.roboto_thin),
//    Font(R.font.roboto_thin_italic),
//    Font(R.font.roboto_italic),
//    Font(R.font.roboto_light),
//    Font(R.font.roboto_light_italic)
//)

