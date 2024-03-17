package com.imsosoft.kotlinmovieapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MoviesDTO(
    @SerializedName(value = "Response")
    val response: String,

    @SerializedName(value = "Search")
    val search: List<Search>,

    val totalResults: String
)