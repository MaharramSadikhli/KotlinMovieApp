package com.imsosoft.kotlinmovieapp.data.remote

import com.imsosoft.kotlinmovieapp.data.remote.dto.MovieDetailDTO
import com.imsosoft.kotlinmovieapp.data.remote.dto.MoviesDTO
import com.imsosoft.kotlinmovieapp.util.Constants.API_KEY
import com.imsosoft.kotlinmovieapp.util.Constants.ID
import com.imsosoft.kotlinmovieapp.util.Constants.KEY
import com.imsosoft.kotlinmovieapp.util.Constants.POINT
import com.imsosoft.kotlinmovieapp.util.Constants.SEARCH
import retrofit2.http.GET
import retrofit2.http.Query

interface IMovieService {

    @GET(POINT)
    suspend fun getMovies(
        @Query(SEARCH) searchString: String,
        @Query(KEY) apiKey: String = API_KEY
    ): MoviesDTO

    @GET(POINT)
    suspend fun getMovieDetail(
        @Query(ID) imdbId: String,
        @Query(KEY) apiKey: String = API_KEY
    ): MovieDetailDTO


}