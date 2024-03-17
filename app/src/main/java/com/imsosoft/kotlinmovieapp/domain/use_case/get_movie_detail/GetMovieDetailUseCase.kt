package com.imsosoft.kotlinmovieapp.domain.use_case.get_movie_detail

import coil.network.HttpException
import com.imsosoft.kotlinmovieapp.data.remote.mapper.toMovieDetail
import com.imsosoft.kotlinmovieapp.domain.model.MovieDetail
import com.imsosoft.kotlinmovieapp.domain.repository.IMovieRepo
import com.imsosoft.kotlinmovieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repo: IMovieRepo) {

    fun executeGetMovieDetails(imdbId: String): Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repo.getMovieDetail(imdbId)
            emit(Resource.Success(movieDetail.toMovieDetail()))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "Could not reach internet"))
        }
    }

}