package com.imsosoft.kotlinmovieapp.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imsosoft.kotlinmovieapp.domain.use_case.get_movies.GetMoviesUseCase
import com.imsosoft.kotlinmovieapp.presentation.events.MovieEvents
import com.imsosoft.kotlinmovieapp.presentation.states.MovieStates
import com.imsosoft.kotlinmovieapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val useCase: GetMoviesUseCase) : ViewModel() {

    private val _state = mutableStateOf<MovieStates>(MovieStates())
    val state: State<MovieStates> = _state

    private var job: Job? = null


    init {
        getMovies(_state.value.search)
    }


    private fun getMovies(search: String) {

        job?.cancel()

        job = viewModelScope.launch {

            useCase.executeGetMovies(search = search)
                .collect {
                    when (it) {
                        is Resource.Success -> {
                            _state.value = MovieStates(movies = it.data ?: emptyList())
                        }

                        is Resource.Error -> {
                            _state.value =
                                MovieStates(error = it.message ?: "An unexpected error occurred")
                        }

                        is Resource.Loading -> {
                            _state.value = MovieStates(isLoading = true)
                        }
                    }
                }
        }

    }

    fun onEvent(events: MovieEvents) {
        when(events) {
            is MovieEvents.Search -> {
                getMovies(events.searchString)
            }
        }
    }

}





















