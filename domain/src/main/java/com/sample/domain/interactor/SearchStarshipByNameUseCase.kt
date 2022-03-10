package com.sample.domain.interactor

import com.sample.domain.interactor.base.UseCase
import com.sample.domain.model.Result
import com.sample.domain.model.Starships
import com.sample.domain.repository.StarshipsRepository
import javax.inject.Inject

class SearchStarshipByNameUseCase @Inject constructor(
    private val repo: StarshipsRepository
) : UseCase<Result<Starships>, SearchStarshipByNameUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<Starships> {
        params!!
        return repo.searchStarShipsByName(params.name)
    }

    data class Params(
        val name: String
    )
}