package com.sample.domain.interactor

import com.sample.domain.interactor.base.UseCase
import com.sample.domain.model.Result
import com.sample.domain.model.Specie
import com.sample.domain.repository.SpeciesRepository
import javax.inject.Inject

class GetSpecieUseCase @Inject constructor(
    private val repo: SpeciesRepository
) : UseCase<Result<Specie>, GetSpecieUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<Specie> {
        params!!
        return repo.getSpecie(params.specieId)
    }

    data class Params(
        val specieId: Int
    )
}