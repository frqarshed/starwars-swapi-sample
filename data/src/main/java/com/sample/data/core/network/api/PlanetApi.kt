package com.sample.data.core.network.api

import com.sdk.starwars.presentation.core.model.AllPlanet
import com.sdk.starwars.presentation.core.model.Planet
import com.sdk.starwars.presentation.core.model.Response

interface PlanetApi {
    suspend fun getAllPlanets(pageNumber: Int): Response<AllPlanet>

    suspend fun getPlanetById(planetId: Int): Response<Planet>

    suspend fun searchPlanet(name: String): Response<AllPlanet>
}
