package com.imsosoft.kotlinmovieapp.presentation.states

import com.imsosoft.kotlinmovieapp.domain.model.MovieDetail

data class MovieDetailStates(
    val isLoading: Boolean = false,
    val movie: MovieDetail? = null,
    val error: String = ""
)