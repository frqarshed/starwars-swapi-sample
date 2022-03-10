package com.sample.domain.interactor

import com.sample.domain.interactor.base.UseCase
import com.sample.domain.model.Planets
import com.sample.domain.model.Result
import com.sample.domain.repository.PlanetRepository
import javax.inject.Inject

class GetAllPlanetsUseCase @Inject constructor(
    private val repo: PlanetRepository
) : UseCase<Result<Planets>, GetAllPlanetsUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<Planets> {
        params!!
        return repo.getAllPlanet(pageNumber = params.pageNumber)
    }

    data class Params(
        val pageNumber: Int = 1
    )
}