package com.imsosoft.kotlinmovieapp.presentation.views.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.imsosoft.kotlinmovieapp.presentation.viewmodels.MovieDetailViewModel
import com.imsosoft.kotlinmovieapp.presentation.views.components.DetailText
import com.imsosoft.kotlinmovieapp.presentation.views.components.TitleText
import com.imsosoft.kotlinmovieapp.presentation.views.components.YearText

@Composable
fun MovieDetailScreen(
    viewModel: MovieDetailViewModel = hiltViewModel()
)  {

    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        state.movie?.let {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = rememberAsyncImagePainter(model = it.poster),
                    contentDescription = it.title,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(300.dp, 300.dp)
                        .clip(RectangleShape)
                        .align(Alignment.CenterHorizontally)
                    )

                TitleText(text = it.title)
                DetailText(text = "Actors: ${it.actors}")
                DetailText(text = "Director: ${it.director}")
                DetailText(text = it.country)
                DetailText(text = it.year)
                YearText(text = it.imdbRating)

            }
        }
    }

}