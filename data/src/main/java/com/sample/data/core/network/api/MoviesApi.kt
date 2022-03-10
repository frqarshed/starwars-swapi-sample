package com.sample.data.core.network.api

import com.sdk.starwars.presentation.core.model.AllFilms
import com.sdk.starwars.presentation.core.model.Film
import com.sdk.starwars.presentation.core.model.Response

interface MoviesApi {
    suspend fun getAllMovies(pageNumber: Int): Response<AllFilms>

    suspend fun getMoviesById(movieId: Int): Response<Film>

    suspend fun searchMovie(title: String): Response<AllFilms>
}
