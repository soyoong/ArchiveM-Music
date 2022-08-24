package dev.vaibhav.musicx.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.vaibhav.musicx.R

@Composable
fun BackButton(onClicked: () -> Unit) {
    Button(
        onClick = onClicked,
        colors = ButtonDefaults
            .buttonColors(backgroundColor = Color.Transparent),
        modifier = Modifier,
    ) {
        Image(
            imageVector = ImageVector
                .vectorResource(id = R.drawable.ic_arrow_left),
            contentDescription = "Back icon",
            colorFilter = ColorFilter
                .tint(color = Color.White),
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
        )
    }
}


@Preview
@Composable
private fun BackButtonPreview() {
    BackButton(onClicked = {})
}