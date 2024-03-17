package com.imsosoft.kotlinmovieapp.domain.model

import com.google.gson.annotations.SerializedName
import com.imsosoft.kotlinmovieapp.data.remote.dto.Rating

data class MovieDetail(
    @SerializedName(value = "Actors")
    val actors: String,

    @SerializedName(value = "Awards")
    val awards: String,

    @SerializedName(value = "Country")
    val country: String,

    @SerializedName(value = "Director")
    val director: String,

    @SerializedName(value = "Genre")
    val genre: String,

    @SerializedName(value = "Language")
    val language: String,

    @SerializedName(value = "Poster")
    val poster: String,

    @SerializedName(value = "Rated")
    val rated: String,

    @SerializedName(value = "Released")
    val released: String,

    @SerializedName(value = "Title")
    val title: String,

    @SerializedName(value = "Type")
    val type: String,

    @SerializedName(value = "Year")
    val year: String,

    val imdbRating: String
)