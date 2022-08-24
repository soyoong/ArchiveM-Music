package dev.vaibhav.musicx.ui.screens.homeScreen2.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import dev.vaibhav.musicx.R
import dev.vaibhav.musicx.data.models.Movie
import dev.vaibhav.musicx.data.viewmodel.MainViewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun BannerSlider(mainViewModel: MainViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

        val state = rememberPagerState()
        Column {
            HorizontalPager(
                state = state,
                count = mainViewModel.listCharacter.value.size, modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            ) { page ->
                imageUrl.value = viewModel.movieListResponse[page].imageUrl

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(contentAlignment = Alignment.BottomCenter) {

                        val painter = rememberImagePainter(data = imageUrl.value, builder = {
                            placeholder(R.drawable.divide)
                            scale(coil.size.Scale.FILL)
                        })
                        Image(
                            painter = painter, contentDescription = "", Modifier
                                .padding(8.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .fillMaxSize(), contentScale = ContentScale.Crop
                        )

                        Text(
                            text = viewModel.movieListResponse[page].name,
                            Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(8.dp)
                                .background(Color.LightGray.copy(alpha = 0.60F))
                                .padding(8.dp),
                            textAlign = TextAlign.Start,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.padding(4.dp))
            DotsIndicator(
                totalDots = mainViewModel.movieListResponse.size,
                selectedIndex = state.currentPage
            )

            LazyColumn() {
                items(mainViewModel.movieListResponse) { item ->
                    MovieCard(movie = item)
                }
            }
        }
        LaunchedEffect(key1 = state.currentPage) {
            delay(3000)
            var newPosition = state.currentPage + 1
            if (newPosition > mainViewModel.movieListResponse.size - 1) newPosition = 0
            // scrolling to the new position.
            state.animateScrollToPage(newPosition)
        }
    }
}

@Composable
fun MovieCard(movie: Movie) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
    ) {
        Text(
            text = movie.name,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SliderView(state: PagerState, viewModel: MainViewModel) {

    val imageUrl =
        remember { mutableStateOf("") }
    HorizontalPager(
        state = state,
        count = viewModel.movieListResponse.size, modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
    ) { page ->
        imageUrl.value = viewModel.movieListResponse[page].imageUrl

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(contentAlignment = Alignment.BottomCenter) {

                val painter = rememberImagePainter(data = imageUrl.value, builder = {
                    placeholder(R.drawable.divide)
                    scale(coil.size.Scale.FILL)
                })
                Image(
                    painter = painter, contentDescription = "", Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxSize(), contentScale = ContentScale.Crop
                )

                Text(
                    text = viewModel.movieListResponse[page].name,
                    Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(8.dp)
                        .background(Color.LightGray.copy(alpha = 0.60F))
                        .padding(8.dp),
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }


        }


    }
}

@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int
) {

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(), horizontalArrangement = Arrangement.Center
    ) {

        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(color = Color.DarkGray)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(color = Color.LightGray)
                )
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(showSystemUi = false, showBackground = false)
@Composable
fun SliderPreview() {
    Column {
        SliderView(state = rememberPagerState(), MainViewModel())
        DotsIndicator(
            totalDots = 5,
            selectedIndex = 1
        )
    }

}

