package com.escodro.puisto.features.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MovieRepository {

    suspend fun loadRandomMovie(): String =
        "Watch ${fetchMovie()} on ${fetchCinema()}"

    private suspend fun fetchMovie(): String =
        // Just simulating an IO operation
        withContext(Dispatchers.IO) {
            println("fetchMovie : I'm working in thread ${Thread.currentThread().name}")
            delay(300)
            movieList.random()
        }

    private suspend fun fetchCinema(): String =
        // Just simulating an IO operation
        withContext(Dispatchers.IO) {
            println("fetchCinema : I'm working in thread ${Thread.currentThread().name}")
            delay(400)
            cinemasList.random()
        }

    private val movieList = listOf("Star Wars", "Harry Potter", "Avengers", "007", "Sherlock Homes")

    private val cinemasList = listOf("Kinoplex", "Cinépolis", "Cinemark")
}