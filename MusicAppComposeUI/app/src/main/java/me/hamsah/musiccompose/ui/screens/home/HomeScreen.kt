package me.hamsah.musiccompose.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.hamsah.musiccompose.R
import me.hamsah.musiccompose.ui.components.ItemMusic
import me.hamsah.musiccompose.ui.theme.DarkBackground
import me.hamsah.musiccompose.ui.theme.MusicComposeTheme
import me.hamsah.musiccompose.ui.theme.Silver
import me.hamsah.musiccompose.ui.theme.Typography

@Composable
fun HomeScreen() {
//    val homeViewModel = viewModel(modelClass = MainViewModel::class.java)
//    val state by homeViewModel.recommendation.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground),
        verticalArrangement = Arrangement.Top
    ) {
        SessionHeader(
            title = "RLing",
            searchAction = {
                // Todo action
            }
        )

        // Banner slider
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, bottom = 20.dp)
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = "New Albums",
                fontSize = 22.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = "View all",
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .clickable {
                        // Todo
                    }
            )
        }

        BannerView()

        // Recently music
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = "Recently Music ",
                fontSize = 22.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        LazyColumn(content = {
            items(10) {
                ItemMusic() {
                    // Todo
                }
            }
        }, modifier = Modifier.fillMaxHeight().padding(vertical = 10.dp))

    }
}

@Composable
private fun SessionHeader(title: String, searchAction: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(
            text = title,
            style = Typography.h1,
            fontFamily = FontFamily(Font(R.font.roboto_bold)),
            fontSize = 48.sp,
            modifier = Modifier.weight(1f)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "QR Code Scanner",
            modifier = Modifier
                .padding(4.dp)
                .size(24.dp),
            tint = Silver
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    MusicComposeTheme {
        HomeScreen()
    }
}