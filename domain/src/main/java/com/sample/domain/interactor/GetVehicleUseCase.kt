package com.sample.domain.interactor

import com.sample.domain.interactor.base.UseCase
import com.sample.domain.model.Result
import com.sample.domain.model.Vehicle
import com.sample.domain.repository.VehiclesRepository
import javax.inject.Inject

class GetVehicleUseCase @Inject constructor(
    private val repo: VehiclesRepository
) : UseCase<Result<Vehicle>, GetVehicleUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<Vehicle> {
        params!!
        return repo.getVehicles(params.vehicleId)
    }

    data class Params(
        val vehicleId: Int
    )
}