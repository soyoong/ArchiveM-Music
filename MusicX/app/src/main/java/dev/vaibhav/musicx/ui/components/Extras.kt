package dev.vaibhav.musicx.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import dev.vaibhav.musicx.R
import dev.vaibhav.musicx.ui.theme.MusicXTheme

@Composable
fun CoilImage(
    url: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(0.dp)
) {
    Image(
        painter = rememberImagePainter(url),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier.clip(shape)
    )
}

@Preview
@Composable
fun CoilImagePreviewLight() {
    MusicXTheme {
        CoilImage(
            "https://raw.githubusercontent.com/Vaibhav2002/MusicX/main/media/cover-light.png",
            "",
            modifier = Modifier,
            shape = CircleShape
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CoilImagePreviewDark() {
    MusicXTheme {
        CoilImage(
            "https://raw.githubusercontent.com/Vaibhav2002/MusicX/main/media/cover-light.png",
            "",
            modifier = Modifier,
            shape = CircleShape
        )
    }
}