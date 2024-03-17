package com.imsosoft.kotlinmovieapp.presentation.states

import com.imsosoft.kotlinmovieapp.domain.model.Movie


data class MovieStates(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = "",
    val search: String = "joker"
)
