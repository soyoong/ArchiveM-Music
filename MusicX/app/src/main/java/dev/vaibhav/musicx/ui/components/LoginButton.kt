package dev.vaibhav.musicx.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.vaibhav.musicx.R

@Composable
fun AuthButton(label: String, onClicked: () -> Unit) {
    Button(
        onClick = onClicked,
        // Uses ButtonDefaults.ContentPadding by default
        contentPadding = PaddingValues(
            start = 20.dp,
            top = 12.dp,
            end = 20.dp,
            bottom = 12.dp
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .width(295.dp)
            .height(58.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.pink))
    ) {
        Text(
            label.uppercase(),
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.roboto_bold)),
            color = Color.White
        )
    }
}

@Preview
@Composable
private fun AuthButtonPreview() {
    AuthButton("Sign in", {})
}