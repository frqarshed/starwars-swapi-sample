package com.sample.domain.repository

import com.sample.domain.model.Planet
import com.sample.domain.model.Planets
import com.sample.domain.model.Result

interface PlanetRepository {
    suspend fun getAllPlanet(pageNumber: Int = 1): Result<Planets>

    suspend fun getPlanet(planetId: Int): Result<Planet>

    suspend fun searchPlanet(name: String): Result<Planets>
}