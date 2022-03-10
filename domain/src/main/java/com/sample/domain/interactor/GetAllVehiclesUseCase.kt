package com.sample.domain.interactor

import com.sample.domain.interactor.base.UseCase
import com.sample.domain.model.Result
import com.sample.domain.model.Vehicles
import com.sample.domain.repository.VehiclesRepository
import javax.inject.Inject

class GetAllVehiclesUseCase @Inject constructor(
    private val repo: VehiclesRepository
) : UseCase<Result<Vehicles>, GetAllVehiclesUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<Vehicles> {
        params!!
        return repo.getAllVehicles(params.pageNumber)
    }

    data class Params(
        val pageNumber: Int = 1
    )
}