package com.sample.data.core.network.api

import com.sdk.starwars.presentation.core.model.AllSpecies
import com.sdk.starwars.presentation.core.model.Response
import com.sdk.starwars.presentation.core.model.Species

interface SpeciesApi {
    suspend fun getAllSpecies(pageNumber: Int): Response<AllSpecies>

    suspend fun getSpecieById(specieId: Int): Response<Species>

    suspend fun searchSpecie(name: String): Response<AllSpecies>
}
