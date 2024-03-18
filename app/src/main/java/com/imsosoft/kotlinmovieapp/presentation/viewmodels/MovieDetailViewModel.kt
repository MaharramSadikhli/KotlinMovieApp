package com.imsosoft.kotlinmovieapp.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imsosoft.kotlinmovieapp.domain.use_case.get_movie_detail.GetMovieDetailUseCase
import com.imsosoft.kotlinmovieapp.presentation.states.MovieDetailStates
import com.imsosoft.kotlinmovieapp.util.Constants
import com.imsosoft.kotlinmovieapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject
constructor(
    private val useCase: GetMovieDetailUseCase,
    private val savedStateHandle: SavedStateHandle
    ): ViewModel() {

    private val _state = mutableStateOf<MovieDetailStates>(MovieDetailStates())
    val state: State<MovieDetailStates> = _state


    init {
        savedStateHandle.get<String>(Constants.IMDB_ID)?.let {
            getMovieDetail(it)
        }
    }


    private fun getMovieDetail(imdbId: String) {

        viewModelScope.launch {
            useCase.executeGetMovieDetails(imdbId = imdbId)
                .collect {
                    when(it) {
                        is Resource.Success -> {
                            _state.value = MovieDetailStates(movie = it.data)
                        }
                        is Resource.Error -> {
                            _state.value = MovieDetailStates(error = it.message ?: "Error!")
                        }
                        is Resource.Loading -> {
                            _state.value = MovieDetailStates(isLoading = true)
                        }
                    }
                }
        }

    }

}