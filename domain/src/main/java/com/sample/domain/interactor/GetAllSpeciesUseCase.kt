package com.sample.domain.interactor

import com.sample.domain.interactor.base.UseCase
import com.sample.domain.model.Result
import com.sample.domain.model.Species
import com.sample.domain.repository.SpeciesRepository
import javax.inject.Inject

class GetAllSpeciesUseCase @Inject constructor(
    private val repo: SpeciesRepository
) : UseCase<Result<Species>, GetAllSpeciesUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<Species> {
        params!!
        return repo.getAllSpecies(pageNumber = params.pageNumber)
    }

    data class Params(
        val pageNumber: Int = 1
    )
}