package com.sample.domain.repository

import com.sample.domain.model.Specie
import com.sample.domain.model.Species
import com.sample.domain.model.Result

interface SpeciesRepository {
    suspend fun getAllSpecies(pageNumber: Int = 1): Result<Species>

    suspend fun getSpecie(specieId: Int): Result<Specie>

    suspend fun searchSpecies(name: String): Result<Species>
}