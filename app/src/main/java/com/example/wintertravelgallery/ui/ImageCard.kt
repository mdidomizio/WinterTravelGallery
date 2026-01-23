package com.example.wintertravelgallery.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.wintertravelgallery.R

@Composable
fun ImageCard(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(horizontal = 4.dp, vertical = 4.dp)
            .height(220.dp)
    ) {
        SubcomposeAsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .memoryCacheKey(imageUrl)
                .diskCacheKey(imageUrl)
                .diskCachePolicy(CachePolicy.ENABLED)
                .memoryCachePolicy(CachePolicy.ENABLED)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            loading = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    colorResource(id = R.color.light_blue_background_gradient),
                                    colorResource(id = R.color.image_card_loading_gradient_end)
                                )
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(40.dp),
                        color = Color(0xFF5799FC)
                    )
                }
            },
            error = {
                val color = colorResource(id = R.color.image_card_error_icon_color)
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    colorResource(id = R.color.image_card_error_gradient_start),
                                    colorResource(id = R.color.image_card_error_gradient_end)
                                )
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Warning,
                        modifier = Modifier.size(40.dp),
                        contentDescription = stringResource(id = R.string.image_card_failed_to_load),
                        tint = color
                    )
                }
            }
        )
    }
}
