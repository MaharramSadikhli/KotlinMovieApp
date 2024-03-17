package com.imsosoft.kotlinmovieapp.data.remote.mapper

import com.imsosoft.kotlinmovieapp.data.remote.dto.MovieDetailDTO
import com.imsosoft.kotlinmovieapp.domain.model.MovieDetail


fun MovieDetailDTO.toMovieDetail(): MovieDetail {
    return MovieDetail(
        actors, awards, country, director, genre, language, poster, rated, released, title, type, year, imdbRating
    )
}