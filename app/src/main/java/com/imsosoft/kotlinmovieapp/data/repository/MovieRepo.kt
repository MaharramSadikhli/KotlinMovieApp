package com.imsosoft.kotlinmovieapp.data.repository

import com.imsosoft.kotlinmovieapp.data.remote.IMovieService
import com.imsosoft.kotlinmovieapp.data.remote.dto.MovieDetailDTO
import com.imsosoft.kotlinmovieapp.data.remote.dto.MoviesDTO
import com.imsosoft.kotlinmovieapp.domain.repository.IMovieRepo
import javax.inject.Inject

class MovieRepo @Inject constructor(private val api: IMovieService): IMovieRepo {
    override suspend fun getMovies(search: String): MoviesDTO {
        return api.getMovies(searchString = search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDTO {
        return api.getMovieDetail(imdbId = imdbId)
    }
}