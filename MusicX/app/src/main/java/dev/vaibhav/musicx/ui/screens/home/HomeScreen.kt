package dev.vaibhav.musicx.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.vaibhav.musicx.R
import dev.vaibhav.musicx.ui.theme.MusicXTheme

@Composable
fun HomeScreen() {
    Box(modifier = Modifier) {
        Scaffold {
            Column {
                Header()

                // Banner Slider
            }
        }
    }
}

@Composable
private fun Header() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Rling",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    // Todo
                }
        )
    }
}


@Preview
@Composable
private fun HomeScreenPreview() {
    MusicXTheme {
        HomeScreen()
    }
}