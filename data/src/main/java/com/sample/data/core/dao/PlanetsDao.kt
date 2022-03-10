package com.sample.data.core.dao

import com.sample.data.core.network.api.PlanetApi
import com.sample.data.core.network.toDomain
import com.sample.domain.model.Planet
import com.sample.domain.model.Planets
import com.sample.domain.model.Result
import com.sample.domain.repository.PlanetRepository
import com.sdk.starwars.presentation.core.model.AllPlanet
import com.sdk.starwars.presentation.core.model.Response
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PlanetsDao @Inject constructor(
    private val api: PlanetApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : PlanetRepository {
    override suspend fun getAllPlanet(pageNumber: Int): Result<Planets> {
        return withContext(ioDispatcher) {
            try {
                when (val result = api.getAllPlanets(pageNumber)) {
                    is Response.Success<AllPlanet> -> {
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

    override suspend fun getPlanet(planetId: Int): Result<Planet> {
        return withContext(ioDispatcher) {
            try {
                when (val result = api.getPlanetById(planetId)) {
                    is Response.Success<com.sdk.starwars.presentation.core.model.Planet> -> {
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

    override suspend fun searchPlanet(name: String): Result<Planets> {
        return withContext(ioDispatcher) {
            try {
                when (val result = api.searchPlanet(name)) {
                    is Response.Success<AllPlanet> -> {
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
