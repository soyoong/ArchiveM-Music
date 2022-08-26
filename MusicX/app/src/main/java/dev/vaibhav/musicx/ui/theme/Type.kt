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

val AppTypography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

//val Roboto = FontFamily(
//    Font(R.font.roboto_regular, FontWeight.Normal),
//    Font(R.font.roboto_black, FontWeight.Normal),
//    Font(R.font.roboto_black_italic, FontWeight.Normal),
//    Font(R.font.roboto_bold, FontWeight.Normal),
//    Font(R.font.roboto_bold_italic, FontWeight.Normal),
//    Font(R.font.roboto_medium, FontWeight.Normal),
//    Font(R.font.roboto_medium_italic, FontWeight.Normal),
//    Font(R.font.roboto_thin, FontWeight.Normal),
//    Font(R.font.roboto_thin_italic, FontWeight.Normal),
//    Font(R.font.roboto_italic, FontWeight.Normal),
//    Font(R.font.roboto_light, FontWeight.Normal),
//    Font(R.font.roboto_light_italic, FontWeight.Normal)
//)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Silver
    ),
    body2 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Silver
    ),
    h1 = TextStyle(
        color = Silver,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    h2 = TextStyle(
        color = Silver,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    subtitle1 = TextStyle(
        color = LightPurple,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle2 = TextStyle(
        color = TextGrey,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        letterSpacing = 0.15.sp
    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)