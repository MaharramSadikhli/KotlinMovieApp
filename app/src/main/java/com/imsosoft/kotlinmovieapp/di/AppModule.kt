package com.imsosoft.kotlinmovieapp.di

import com.imsosoft.kotlinmovieapp.data.remote.IMovieService
import com.imsosoft.kotlinmovieapp.data.repository.MovieRepo
import com.imsosoft.kotlinmovieapp.domain.repository.IMovieRepo
import com.imsosoft.kotlinmovieapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApi(): IMovieService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IMovieService::class.java)
    }



    @Provides
    @Singleton
    fun provideMovieRepo(api: IMovieService): IMovieRepo = MovieRepo(api = api)


}