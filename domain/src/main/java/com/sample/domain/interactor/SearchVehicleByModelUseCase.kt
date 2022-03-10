package com.sample.domain.interactor

import com.sample.domain.interactor.base.UseCase
import com.sample.domain.model.Result
import com.sample.domain.model.Vehicles
import com.sample.domain.repository.VehiclesRepository
import javax.inject.Inject

class SearchVehicleByModelUseCase @Inject constructor(
    private val repo: VehiclesRepository
) : UseCase<Result<Vehicles>, SearchVehicleByModelUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<Vehicles> {
        params!!
        return repo.searchVehiclesByModel(params.model)
    }

    data class Params(
        val model: String
    )
}