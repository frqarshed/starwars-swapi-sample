package com.sample.domain.interactor

import com.sample.domain.interactor.base.UseCase
import com.sample.domain.model.Movies
import com.sample.domain.model.Result
import com.sample.domain.repository.MoviesRepository
import javax.inject.Inject

class GetAllMoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
) : UseCase<Result<Movies>, GetAllMoviesUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<Movies> {
        params!!
        return moviesRepository.getAllMovies(pageNumber = params.pageNumber)
    }

    data class Params(
        val pageNumber: Int = 1
    )

}