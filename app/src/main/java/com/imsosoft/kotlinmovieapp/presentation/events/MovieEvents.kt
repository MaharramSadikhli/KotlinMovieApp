package com.imsosoft.kotlinmovieapp.presentation.events

sealed class MovieEvents {

    data class Search(val searchString: String): MovieEvents()

}