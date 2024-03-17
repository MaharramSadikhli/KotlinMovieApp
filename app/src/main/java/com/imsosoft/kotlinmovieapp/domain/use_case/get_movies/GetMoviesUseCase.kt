package com.imsosoft.kotlinmovieapp.domain.use_case.get_movies

import coil.network.HttpException
import com.imsosoft.kotlinmovieapp.data.remote.mapper.toMovieList
import com.imsosoft.kotlinmovieapp.domain.model.Movie
import com.imsosoft.kotlinmovieapp.domain.repository.IMovieRepo
import com.imsosoft.kotlinmovieapp.util.Resource
import kotlinx.coroutines.flow.*
import java.io.IOError
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val repo: IMovieRepo) {

    fun executeGetMovies(search: String): Flow<Resource<List<Movie>>> = flow {
        try {

            emit(Resource.Loading())

            val movieList = repo.getMovies(search)

            if (movieList.response == "True") {
                emit(Resource.Success(movieList.toMovieList()))
            } else {
                emit(Resource.Error(message = "No movies found"))
            }

        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "Could not reach internet"))
        }
    }

}