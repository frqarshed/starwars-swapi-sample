package com.sample.domain.interactor

import com.sample.domain.interactor.base.UseCase
import com.sample.domain.model.Result
import com.sample.domain.model.Starship
import com.sample.domain.repository.StarshipsRepository
import javax.inject.Inject

class GetStarshipUseCase @Inject constructor(
    private val repo: StarshipsRepository
) : UseCase<Result<Starship>, GetStarshipUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<Starship> {
        params!!
        return repo.getStarShip(params.starshipId)
    }

    data class Params(
        val starshipId: Int
    )
}