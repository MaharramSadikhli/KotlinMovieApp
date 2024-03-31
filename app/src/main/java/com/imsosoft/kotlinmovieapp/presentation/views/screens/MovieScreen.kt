package com.imsosoft.kotlinmovieapp.presentation.views.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.imsosoft.kotlinmovieapp.presentation.Screen
import com.imsosoft.kotlinmovieapp.presentation.events.MovieEvents
import com.imsosoft.kotlinmovieapp.presentation.viewmodels.MoviesViewModel
import com.imsosoft.kotlinmovieapp.presentation.views.components.ErrorText
import com.imsosoft.kotlinmovieapp.presentation.views.components.MovieListRow
import com.imsosoft.kotlinmovieapp.presentation.views.components.MovieSearchBar

@Composable
fun MovieScreen(navController: NavController, viewModel: MoviesViewModel = hiltViewModel()) {

    val state = viewModel.state.value

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        Column() {
            MovieSearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, top= 80.dp),
                hint = "Joker",
                onSearch = {
                    viewModel.onEvent(MovieEvents.Search(it))
                }
            )

            LazyColumn(modifier = Modifier
                .fillMaxSize()) {
                items(state.movies) { movie ->
                    MovieListRow(movie = movie) {
                        navController.navigate(Screen.MovieDetailScreen.route+"/${movie.imdbID}")
                    }
                }
            }

        }

        if (state.error.isNotBlank()) {
            ErrorText(text = state.error)
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}