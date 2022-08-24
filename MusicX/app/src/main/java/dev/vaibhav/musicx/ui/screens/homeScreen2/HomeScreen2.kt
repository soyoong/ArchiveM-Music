package dev.vaibhav.musicx.ui.screens.homeScreen2
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Card
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Surface
//import androidx.compose.material.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.colorResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.text.style.TextOverflow
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import coil.compose.rememberImagePainter
//import coil.size.Scale
//import coil.transform.CircleCropTransformation
//import com.google.accompanist.pager.ExperimentalPagerApi
//import com.google.accompanist.pager.HorizontalPager
//import com.google.accompanist.pager.PagerState
//import com.google.accompanist.pager.rememberPagerState
//import dev.vaibhav.musicx.R
//import dev.vaibhav.musicx.data.models.remote.movies.Movie
//import kotlinx.coroutines.delay
//
//@Composable
//fun HomeScreen2(viewModel: MainViewModel = viewModel()) {
//    viewModel.getAllMovies()
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(colorResource(id = R.color.main_color))
//    ) {
//
//        Column(
//            modifier = Modifier
//        ) {
//            HeaderHomeScreen()
//
//            BannerSlider(viewModel = viewModel)
//
//            Surface(color = MaterialTheme.colors.background) {
//                MovieList(movieList = viewModel.movieListResponse)
//            }
//        }
//    }
//}
//
//
//@Composable
//fun MovieList(movieList: List<Movie>) {
//    var selectedIndex by remember { mutableStateOf(-1) }
//    LazyColumn {
//
//        itemsIndexed(items = movieList) { index, item ->
//            MovieItem(movie = item, index, selectedIndex) { i ->
//                selectedIndex = i
//            }
//        }
//    }
//
//}
//
//@Preview(showBackground = true)
//@Composable
//fun MovieItem() {
//    val movie = Movie(
//        "Coco",
//        "https://howtodoandroid.com/images/coco.jpg",
//        "Coco is a 2017 American 3D computer-animated musical fantasy adventure film produced by Pixar",
//        "Latest"
//    )
//
//    MovieItem(movie = movie, 0, 0) { i ->
//
//    }
//}
//
//
//@Composable
//fun MovieItem(movie: Movie, index: Int, selectedIndex: Int, onClick: (Int) -> Unit) {
//
//    val backgroundColor =
//        if (index == selectedIndex) MaterialTheme.colors.primary else MaterialTheme.colors.background
//    Card(
//        modifier = Modifier
//            .padding(8.dp, 4.dp)
//            .fillMaxWidth()
//            .clickable { onClick(index) }
//            .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
//    ) {
//        Surface(color = backgroundColor) {
//
//            Row(
//                Modifier
//                    .padding(4.dp)
//                    .fillMaxSize()
//            ) {
//
//                Image(
//                    painter = rememberImagePainter(
//                        data = movie.imageUrl,
//
//                        builder = {
//                            scale(Scale.FILL)
//                            placeholder(R.drawable.divide)
//                            transformations(CircleCropTransformation())
//
//                        }
//                    ),
//                    contentDescription = movie.desc,
//                    modifier = Modifier
//                        .fillMaxHeight()
//                        .weight(0.2f)
//                )
//
//
//                Column(
//                    verticalArrangement = Arrangement.Center,
//                    modifier = Modifier
//                        .padding(4.dp)
//                        .fillMaxHeight()
//                        .weight(0.8f)
//                ) {
//                    Text(
//                        text = movie.name,
//                        style = MaterialTheme.typography.subtitle1,
//                        fontWeight = FontWeight.Bold
//                    )
//                    Text(
//                        text = movie.category,
//                        style = MaterialTheme.typography.caption,
//                        modifier = Modifier
//                            .background(
//                                Color.LightGray
//                            )
//                            .padding(4.dp)
//                    )
//                    Text(
//                        text = movie.desc,
//                        style = MaterialTheme.typography.body1,
//                        maxLines = 2,
//                        overflow = TextOverflow.Ellipsis
//                    )
//
//                }
//            }
//        }
//    }
//
//}
//
//////////////////
//
//@OptIn(ExperimentalPagerApi::class)
//@Composable
//fun BannerSlider(viewModel: MainViewModel) {
//    Surface(
//        modifier = Modifier.fillMaxSize(),
//        color = MaterialTheme.colors.background
//    ) {
//        val state = rememberPagerState()
//
//        Column {
//            SliderView(state, viewModel)
//            Spacer(modifier = Modifier.padding(4.dp))
//            DotsIndicator(
//                totalDots = viewModel.movieListResponse.size,
//                selectedIndex = state.currentPage
//            )
//
//            viewModel.getAllMovies()
//
//            LazyColumn {
//                items(viewModel.movieListResponse) { item ->
//                    MovieCard(movie = item)
//                }
//            }
//        }
//        LaunchedEffect(key1 = state.currentPage) {
//            delay(3000)
//            var newPosition = state.currentPage + 1
//            if (newPosition > viewModel.movieListResponse.size - 1) newPosition = 0
//            // scrolling to the new position.
//            state.animateScrollToPage(newPosition)
//        }
//    }
//}
//
//@OptIn(ExperimentalPagerApi::class)
//@Composable
//fun SliderView(state: PagerState, viewModel: MainViewModel) {
//
//    val imageUrl = remember { mutableStateOf("") }
//    HorizontalPager(
//        state = state,
//        count = viewModel.movieListResponse.size, modifier = Modifier
//            .height(200.dp)
//            .fillMaxWidth()
//    ) { page ->
//        imageUrl.value = viewModel.movieListResponse[page].imageUrl
//
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Top,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Box(contentAlignment = Alignment.BottomCenter) {
//
//                val painter = rememberImagePainter(data = imageUrl.value, builder = {
//                    placeholder(R.drawable.divide)
//                    scale(Scale.FILL)
//                })
//                Image(
//                    painter = painter,
//                    contentDescription = "",
//                    modifier = Modifier
//                        .padding(8.dp)
//                        .clip(RoundedCornerShape(10.dp))
//                        .fillMaxSize(), contentScale = ContentScale.Crop
//                )
//
//                Text(
//                    text = viewModel.movieListResponse[page].name,
//                    Modifier
//                        .fillMaxWidth()
//                        .height(60.dp)
//                        .padding(8.dp)
//                        .background(Color.LightGray.copy(alpha = 0.60F))
//                        .padding(8.dp),
//                    textAlign = TextAlign.Start,
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Medium
//                )
//            }
//
//
//
//        }
//
//
//    }
//}
//
//
//@Composable
//fun MovieCard(movie: Movie) {
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(100.dp)
//            .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
//    ) {
//        Text(
//            text = movie.name,
//            modifier = Modifier
//                .fillMaxWidth()
//        )
//    }
//
//}
//
//@Preview(name = "Sliding Image Preview", showSystemUi = false, showBackground = true)
//@Composable
//fun MovieCardPreview() {
//    MovieCard(movie = Movie("Poco","Latest","",""))
//}
//
//
//@Composable
//fun DotsIndicator(
//    totalDots: Int,
//    selectedIndex: Int
//) {
//
//    LazyRow(
//        modifier = Modifier
//            .fillMaxWidth()
//            .wrapContentHeight(), horizontalArrangement = Arrangement.Center
//    ) {
//
//        items(totalDots) { index ->
//            if (index == selectedIndex) {
//                Box(
//                    modifier = Modifier
//                        .size(10.dp)
//                        .clip(CircleShape)
//                        .background(color = Color.DarkGray)
//                )
//            } else {
//                Box(
//                    modifier = Modifier
//                        .size(10.dp)
//                        .clip(CircleShape)
//                        .background(color = Color.LightGray)
//                )
//            }
//
//            if (index != totalDots - 1) {
//                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
//            }
//        }
//    }
//}
//
//@OptIn(ExperimentalPagerApi::class)
//@Preview(showSystemUi = false, showBackground = false)
//@Composable
//fun SliderPreview() {
//    Column {
//        SliderView(state = rememberPagerState(), MainViewModel())
//        DotsIndicator(
//            totalDots = 5,
//            selectedIndex = 1
//        )
//    }
//
//}
//
