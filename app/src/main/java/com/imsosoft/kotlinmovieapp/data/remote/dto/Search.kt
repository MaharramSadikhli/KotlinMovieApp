package com.imsosoft.kotlinmovieapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Search(
    @SerializedName(value = "Poster")
    val poster: String,

    @SerializedName(value = "Title")
    val title: String,

    @SerializedName(value = "Type")
    val type: String,

    @SerializedName(value = "Year")
    val year: String,

    val imdbID: String
)