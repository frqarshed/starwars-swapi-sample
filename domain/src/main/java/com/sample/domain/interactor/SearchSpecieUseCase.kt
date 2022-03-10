package com.sample.domain.interactor

import com.sample.domain.interactor.base.UseCase
import com.sample.domain.model.Result
import com.sample.domain.model.Species
import com.sample.domain.repository.SpeciesRepository
import javax.inject.Inject

class SearchSpecieUseCase @Inject constructor(
    private val repo: SpeciesRepository
) : UseCase<Result<Species>, SearchSpecieUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<Species> {
        params!!
        return repo.searchSpecies(params.name)
    }

    data class Params(
        val name: String
    )
}