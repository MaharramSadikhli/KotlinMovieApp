package com.imsosoft.kotlinmovieapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDetailDTO(
    @SerializedName(value = "Actors")
    val actors: String,

    @SerializedName(value = "Awards")
    val awards: String,

    @SerializedName(value = "BoxOffice")
    val boxOffice: String,

    @SerializedName(value = "Country")
    val country: String,

    @SerializedName(value = "DVD")
    val dvd: String,

    @SerializedName(value = "Director")
    val director: String,

    @SerializedName(value = "Genre")
    val genre: String,

    @SerializedName(value = "Language")
    val language: String,

    @SerializedName(value = "Metascore")
    val metascore: String,

    @SerializedName(value = "Plot")
    val plot: String,

    @SerializedName(value = "Poster")
    val poster: String,

    @SerializedName(value = "Production")
    val production: String,

    @SerializedName(value = "Rated")
    val rated: String,

    @SerializedName(value = "Ratings")
    val ratings: List<Rating>,

    @SerializedName(value = "Released")
    val released: String,

    @SerializedName(value = "Response")
    val response: String,

    @SerializedName(value = "Runtime")
    val runtime: String,

    @SerializedName(value = "Title")
    val title: String,

    @SerializedName(value = "Type")
    val type: String,

    @SerializedName(value = "Website")
    val website: String,

    @SerializedName(value = "Writer")
    val writer: String,

    @SerializedName(value = "Year")
    val year: String,

    val imdbID: String,
    val imdbRating: String,
    val imdbVotes: String
)