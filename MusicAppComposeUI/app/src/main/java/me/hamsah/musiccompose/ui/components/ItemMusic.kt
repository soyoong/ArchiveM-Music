package me.hamsah.musiccompose.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.hamsah.musiccompose.R
import me.hamsah.musiccompose.network.ApiConstants.BASE_URL
import me.hamsah.musiccompose.ui.theme.Silver

@Composable
fun ItemMusic(
    number: String = "01",
    imageUrl: String = "",
    nameSong: String = "Nice for what",
    nameSinger: String = "Avinci John",
    moreAction: () -> Unit
) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = number,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    fontSize = 14.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.width(20.dp))

                AsyncImage(
                    imageUrl = imageUrl,
                    modifier = Modifier.size(32.dp)
                )

                Spacer(modifier = Modifier.width(20.dp))

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

            Icon(
                painter = painterResource(id = R.drawable.ic_more),
                contentDescription = "more icon",
                modifier = Modifier
                    .size(14.dp)
                    .clickable { moreAction },
                tint = Silver
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
        nameSong = "Nice for what",
        nameSinger = "Avinci John"
    ) {
        // Todo
    }
}