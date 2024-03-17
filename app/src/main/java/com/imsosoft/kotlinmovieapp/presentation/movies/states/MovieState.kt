package com.imsosoft.kotlinmovieapp.presentation.movies.states

import com.imsosoft.kotlinmovieapp.domain.model.Movie


data class MovieState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = "",
    val search: String = "joker"
)
