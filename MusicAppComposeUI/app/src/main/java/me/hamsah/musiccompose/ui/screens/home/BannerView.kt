package me.hamsah.musiccompose.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import me.hamsah.musiccompose.R
import me.hamsah.musiccompose.model.Banner
import me.hamsah.musiccompose.utils.sampleBannerList

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BannerView() {
//    val mainViewModel = viewModel(modelClass = MainViewModel::class.java)
//    val list by mainViewModel.recommendation.collectAsState()
    val pagerState = rememberPagerState()
    val list = sampleBannerList

//    mainViewModel.getRecommendation()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        SliderView(pagerState, list)

        LaunchedEffect(key1 = pagerState.currentPage) {
            delay(3000)
            var newPosition = pagerState.currentPage + 1
            if (newPosition > list.size - 1) newPosition = 0
            // scrolling to the new position.
            pagerState.animateScrollToPage(newPosition)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun SliderView(state: PagerState, list: List<Banner>) {

    val imageUrl = remember { mutableStateOf("") }

    HorizontalPager(
        state = state,
        count = list.size,
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
    ) { page ->

        imageUrl.value = list[page].icon

        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .height(200.dp)
        ) {

            val painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data(data = imageUrl.value)
                    .apply(block = fun ImageRequest.Builder.() {
                        placeholder(R.drawable.ahllam)
                        scale(Scale.FILL)
                    }).build()
            )
            Image(
                painter = painter,
                contentDescription = "",
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(Color.LightGray.copy(alpha = 0.60F))
                    .padding(8.dp)
            ) {
                Text(
                    text = list[page].banner,
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = list[page].name,
                    textAlign = TextAlign.Start,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular))
                )
            }
        }
    }
}

@Preview
@Composable
fun BannerViewPreview() {
    BannerView()
}