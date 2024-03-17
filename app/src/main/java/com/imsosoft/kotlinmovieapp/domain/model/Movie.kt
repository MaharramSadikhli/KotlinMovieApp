package com.imsosoft.kotlinmovieapp.domain.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName(value = "Poster")
    val poster: String,

    @SerializedName(value = "Title")
    val title: String,

    @SerializedName(value = "Year")
    val year: String,

    val imdbID: String
)