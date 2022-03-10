package com.sample.data.core.network.api

import com.sdk.starwars.presentation.core.model.AllStarships
import com.sdk.starwars.presentation.core.model.Response
import com.sdk.starwars.presentation.core.model.Starship

interface StarshipsApi {
    suspend fun getAllStarships(pageNumber: Int): Response<AllStarships>

    suspend fun getStarshipById(starshipId: Int): Response<Starship>

    suspend fun searchStarship(name: String): Response<AllStarships>
}
