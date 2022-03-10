package com.sample.data.core.dao

import com.sample.data.core.network.api.MoviesApi
import com.sample.data.core.network.toDomain
import com.sample.domain.model.Movies
import com.sample.domain.model.Result
import com.sample.domain.repository.MoviesRepository
import com.sdk.starwars.presentation.core.model.AllFilms
import com.sdk.starwars.presentation.core.model.Film
import com.sdk.starwars.presentation.core.model.Response
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton
import com.sample.domain.model.Movie as LocalFilm

@Singleton
class MoviesDao @Inject constructor(
    private val api: MoviesApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : MoviesRepository {

    override suspend fun getAllMovies(pageNumber: Int): Result<Movies> =
        withContext(ioDispatcher) {
            try {
                when (val result = api.getAllMovies(pageNumber)) {
                    is Response.Success<AllFilms> -> {
                        Result.Success(result.data.toDomain())
                    }
                    is Response.Error -> {
                        Result.Error(result.getException())
                    }
                }
            } catch (e: Exception) {
                Result.Error(e)
            }
        }

    override suspend fun getMoviesById(movieId: Int): Result<LocalFilm> =
        withContext(ioDispatcher) {
            try {
                when (val result = api.getMoviesById(movieId)) {
                    is Response.Success<Film> -> {
                        Result.Success(result.data.toDomain())
                    }
                    is Response.Error -> {
                        Result.Error(result.getException())
                    }
                }
            } catch (e: Exception) {
                Result.Error(e)
            }
        }

    override suspend fun searchMovie(title: String): Result<Movies> =
        withContext(ioDispatcher) {
            try {
                when (val result = api.searchMovie(title)) {
                    is Response.Success<AllFilms> -> {
                        Result.Success(result.data.toDomain())
                    }
                    is Response.Error -> {
                        Result.Error(result.getException())
                    }
                }
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
}
