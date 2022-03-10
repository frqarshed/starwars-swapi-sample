package com.sample.domain.repository

import com.sample.domain.model.Movie
import com.sample.domain.model.Movies
import com.sample.domain.model.Result

interface MoviesRepository {
    suspend fun getAllMovies(pageNumber: Int): Result<Movies>

    suspend fun getMoviesById(movieId: Int): Result<Movie>

    suspend fun searchMovie(title: String): Result<Movies>
}