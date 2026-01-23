package com.example.wintertravelgallery.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.wintertravelgallery.data.Destination
import com.example.wintertravelgallery.ui.theme.PlusJakartaSans
import com.example.wintertravelgallery.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GalleryScreen(
    destinationName: String,
    onNavigationBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val destination = remember(destinationName) {
        Destination.fromTitle(destinationName)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = destination.title,
                            fontFamily = PlusJakartaSans,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.offset(x = (-24).dp)
                        )
                    }
                },
                navigationIcon = {
                    Button(
                        onClick = {
                            onNavigationBack()
                        },
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .width(40.dp)
                            .height(40.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = colorResource(id = R.color.button_content_color)
                        ),
                        border = BorderStroke(
                            width = 1.dp,
                            color = colorResource(id = R.color.button_border_color)
                        ),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.go_back_button_content_description),
                            tint = colorResource(id = R.color.button_content_color),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = modifier.padding(innerPadding),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(
                items = destination.imageUrls,
                key = { it }
            ) { imageUrl ->
                ImageCard(
                    imageUrl = imageUrl
                )
            }
        }
    }
}
