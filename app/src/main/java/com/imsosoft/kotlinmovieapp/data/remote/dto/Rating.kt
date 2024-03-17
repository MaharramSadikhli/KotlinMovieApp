package com.imsosoft.kotlinmovieapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Rating(

    @SerializedName(value = "Source")
    val source: String,

    @SerializedName(value = "Value")
    val value: String
)