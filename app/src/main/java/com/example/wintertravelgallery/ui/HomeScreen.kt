package com.example.wintertravelgallery.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.wintertravelgallery.R
import com.example.wintertravelgallery.data.Destination
import com.example.wintertravelgallery.ui.theme.PlusJakartaSans

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onDestinationClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = colorResource(id = R.color.light_blue_background_gradient)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(
                    text = stringResource(id = R.string.home_screen_title),
                    fontFamily = PlusJakartaSans,
                    fontWeight = FontWeight.SemiBold
                ) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = backgroundColor,
                    titleContentColor = Color.Black,
                )
            )
        },
        containerColor = backgroundColor,
        modifier = modifier
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(
                items = Destination.entries,
                key = { it.name }
                ) { destination ->
                DestinationCard(
                    destination = destination,
                    onCardClick = {  onDestinationClicked(destination.title)}
                )
            }
        }
    }
}
