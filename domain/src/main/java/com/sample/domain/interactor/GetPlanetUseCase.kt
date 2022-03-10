package com.sample.domain.interactor

import com.sample.domain.interactor.base.UseCase
import com.sample.domain.model.Planet
import com.sample.domain.model.Result
import com.sample.domain.repository.PlanetRepository
import javax.inject.Inject

class GetPlanetUseCase @Inject constructor(
    private val repo: PlanetRepository
) : UseCase<Result<Planet>, GetPlanetUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<Planet> {
        params!!
        return repo.getPlanet(params.planetId)
    }

    data class Params(
        val planetId: Int
    )
}