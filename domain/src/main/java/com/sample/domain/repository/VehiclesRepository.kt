package com.sample.domain.repository

import com.sample.domain.model.Vehicle
import com.sample.domain.model.Vehicles
import com.sample.domain.model.Result

interface VehiclesRepository {
    suspend fun getAllVehicles(pageNumber: Int = 1): Result<Vehicles>

    suspend fun getVehicles(vehiclesId: Int): Result<Vehicle>

    suspend fun searchVehiclesByName(name: String): Result<Vehicles>

    suspend fun searchVehiclesByModel(model: String): Result<Vehicles>
}