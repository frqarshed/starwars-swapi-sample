package com.sample.data.core.network.api

import com.sdk.starwars.presentation.core.model.AllVehicles
import com.sdk.starwars.presentation.core.model.Response
import com.sdk.starwars.presentation.core.model.Vehicle

interface VehiclesApi {
    suspend fun getAllVehicles(pageNumber: Int): Response<AllVehicles>

    suspend fun getVehicleById(vehicleId: Int): Response<Vehicle>

    suspend fun searchVehicle(name: String): Response<AllVehicles>
}
