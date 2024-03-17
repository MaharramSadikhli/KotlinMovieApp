package com.imsosoft.kotlinmovieapp.domain.repository

import com.imsosoft.kotlinmovieapp.data.remote.dto.MovieDetailDTO
import com.imsosoft.kotlinmovieapp.data.remote.dto.MoviesDTO

interface IMovieRepo {

    suspend fun getMovies(search: String): MoviesDTO

    suspend fun getMovieDetail(imdbId: String): MovieDetailDTO

}