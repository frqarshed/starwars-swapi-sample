package com.sample.domain.interactor

import com.sample.domain.interactor.base.UseCase
import com.sample.domain.model.Planets
import com.sample.domain.model.Result
import com.sample.domain.repository.PlanetRepository
import javax.inject.Inject

class SearchPlanetUseCase @Inject constructor(
    private val repo: PlanetRepository
) : UseCase<Result<Planets>, SearchPlanetUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<Planets> {
        params!!
        return repo.searchPlanet(params.name)
    }

    data class Params(
        val name: String
    )
}