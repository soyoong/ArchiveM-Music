package me.hamsah.musiccompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import me.hamsah.musiccompose.R

@Composable
fun AsyncImage(
    imageUrl: String,
    width: Dp? = 0.dp,
    height: Dp? = 0.dp,
    cornerSize: Dp? = 0.dp,
    modifier: Modifier? = Modifier
) {

    if (imageUrl.isEmpty()) {
        Image(
            painter = painterResource(id = R.drawable.ahllam),
            contentDescription = "AsyncImage",
            modifier = modifier ?: Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(size = cornerSize ?: 3.dp))
                .height(height ?: 32.dp)
                .width(width ?: 32.dp),
            contentScale = ContentScale.Crop
        )
    } else {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data(data = imageUrl)
                    .apply(block = fun ImageRequest.Builder.() {
                        placeholder(R.drawable.ahllam)
                        scale(Scale.FILL)
                    }).build()
            ),
            contentDescription = "AsyncImage",
            modifier = modifier ?: Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(size = cornerSize ?: 3.dp))
                .height(height ?: 32.dp)
                .width(height ?: 32.dp),
            contentScale = ContentScale.Crop
        )
    }

}

@Preview
@Composable
private fun AsyncImagePreview() {
    AsyncImage(imageUrl = "", cornerSize = 30.dp)
}