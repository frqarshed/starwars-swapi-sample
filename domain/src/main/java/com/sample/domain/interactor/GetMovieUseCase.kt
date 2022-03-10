package com.sample.domain.interactor

import com.sample.domain.interactor.base.UseCase
import com.sample.domain.model.Movie
import com.sample.domain.model.Result
import com.sample.domain.repository.MoviesRepository
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val repo: MoviesRepository
) : UseCase<Result<Movie>, GetMovieUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<Movie> {
        params!!
        return repo.getMoviesById(movieId = params.filmId)
    }

    data class Params(
        val filmId: Int
    )
}