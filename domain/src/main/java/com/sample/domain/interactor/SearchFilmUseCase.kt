package com.sample.domain.interactor

import com.sample.domain.interactor.base.UseCase
import com.sample.domain.model.Movies
import com.sample.domain.model.Result
import com.sample.domain.repository.MoviesRepository
import javax.inject.Inject

class SearchFilmUseCase @Inject constructor(
    private val repo: MoviesRepository
) : UseCase<Result<Movies>, SearchFilmUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<Movies> {
        params!!
        return repo.searchMovie(title = params.title)
    }

    data class Params(
        val title: String
    )
}