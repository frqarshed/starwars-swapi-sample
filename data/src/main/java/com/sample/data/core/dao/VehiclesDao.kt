package com.sample.data.core.dao

import com.sample.data.core.network.api.VehiclesApi
import com.sample.data.core.network.toDomain
import com.sample.domain.model.Result
import com.sample.domain.model.Vehicle
import com.sample.domain.model.Vehicles
import com.sample.domain.repository.VehiclesRepository
import com.sdk.starwars.presentation.core.model.AllVehicles
import com.sdk.starwars.presentation.core.model.Response
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class VehiclesDao @Inject constructor(
    private val api: VehiclesApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : VehiclesRepository {
    override suspend fun getAllVehicles(pageNumber: Int): Result<Vehicles> {
        return withContext(ioDispatcher) {
            try {
                when (val result = api.getAllVehicles(pageNumber)) {
                    is Response.Success<AllVehicles> -> {
                        Result.Success(result.data.toDomain())
                    }
                    is Response.Error -> {
                        Result.Error(result.getException())
                    }
                }
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
    }

    override suspend fun getVehicles(vehiclesId: Int): Result<Vehicle> {
        return withContext(ioDispatcher) {
            try {
                when (val result = api.getVehicleById(vehiclesId)) {
                    is Response.Success<com.sdk.starwars.presentation.core.model.Vehicle> -> {
                        Result.Success(result.data.toDomain())
                    }
                    is Response.Error -> {
                        Result.Error(result.getException())
                    }
                }
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
    }

    override suspend fun searchVehiclesByName(name: String): Result<Vehicles> {
        return withContext(ioDispatcher) {
            try {
                when (val result = api.searchVehicle(name)) {
                    is Response.Success<AllVehicles> -> {
                        Result.Success(result.data.toDomain())
                    }
                    is Response.Error -> {
                        Result.Error(result.getException())
                    }
                }
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
    }

    override suspend fun searchVehiclesByModel(model: String): Result<Vehicles> {
        return withContext(ioDispatcher) {
            try {
                when (val result = api.searchVehicle(model)) {
                    is Response.Success<AllVehicles> -> {
                        Result.Success(result.data.toDomain())
                    }
                    is Response.Error -> {
                        Result.Error(result.getException())
                    }
                }
            } catch (e: Exception) {
                Result.Error(e)
            }
        }

    }
}
