package com.sample.data.core.dao

import com.sample.data.core.network.api.SpeciesApi
import com.sample.data.core.network.toDomain
import com.sample.domain.model.Result
import com.sample.domain.model.Specie
import com.sample.domain.model.Species
import com.sample.domain.repository.SpeciesRepository
import com.sdk.starwars.presentation.core.model.AllSpecies
import com.sdk.starwars.presentation.core.model.Response
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SpeciesDao @Inject constructor(
    private val api: SpeciesApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : SpeciesRepository {
    override suspend fun getAllSpecies(pageNumber: Int): Result<Species> {
        return withContext(ioDispatcher) {
            try {
                when (val result = api.getAllSpecies(pageNumber)) {
                    is Response.Success<AllSpecies> -> {
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

    override suspend fun getSpecie(specieId: Int): Result<Specie> {
        return withContext(ioDispatcher) {
            try {
                when (val result = api.getSpecieById(specieId)) {
                    is Response.Success<com.sdk.starwars.presentation.core.model.Species> -> {
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

    override suspend fun searchSpecies(name: String): Result<Species> {
        return withContext(ioDispatcher) {
            try {
                when (val result = api.searchSpecie(name)) {
                    is Response.Success<AllSpecies> -> {
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
