package me.hamsah.musiccompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import me.hamsah.musiccompose.R
import me.hamsah.musiccompose.network.ApiConstants.BASE_URL

@Composable
fun ItemMusic(
    number: String,
    imageUrl: String,
    nameSong: String,
    nameSinger: String
) {
    Row(
        modifier = Modifier
            .clickable {
                // Todo
            }
    ) {

        Text(
            text = number,
            fontFamily = FontFamily(Font(R.font.roboto_regular)),
            fontSize = 14.sp,
            color = Color.White
        )

        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data(data = imageUrl)
                    .apply(block = fun ImageRequest.Builder.() {
                        placeholder(R.drawable.ahllam)
                        scale(Scale.FILL)
                    }).build()
            ),
            contentDescription = nameSong,
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column {
            Text(
                text = nameSong,
                textAlign = TextAlign.Start,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = nameSinger,
                textAlign = TextAlign.Start,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                fontSize = 12.sp,
                color = Color.Gray
            )
        }

    }
}

@Preview
@Composable
fun ItemMusicPreview() {
    ItemMusic(
        number = "01",
        imageUrl = BASE_URL + "public/uploads/all/XIPClwyXctjLLj3graKzm8B1Zb0ZnaAVqqX2ItPs.jpg",
        nameSong = "",
        nameSinger = ""
    )
}