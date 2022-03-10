package com.sample.domain.interactor

import com.sample.domain.interactor.base.UseCase
import com.sample.domain.model.Result
import com.sample.domain.model.Starships
import com.sample.domain.repository.StarshipsRepository
import javax.inject.Inject

class SearchStarshipByModelUseCase @Inject constructor(
    private val repo: StarshipsRepository
) : UseCase<Result<Starships>, SearchStarshipByModelUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<Starships> {
        params!!
        return repo.searchStarShipsByModel(params.model)
    }

    data class Params(
        val model: String
    )
}