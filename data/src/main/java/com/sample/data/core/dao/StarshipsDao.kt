package com.sample.data.core.dao

import com.sample.data.core.network.api.StarshipsApi
import com.sample.data.core.network.toDomain
import com.sample.domain.model.Result
import com.sample.domain.model.Starship
import com.sample.domain.model.Starships
import com.sample.domain.repository.StarshipsRepository
import com.sdk.starwars.presentation.core.model.AllStarships
import com.sdk.starwars.presentation.core.model.Response
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StarshipsDao @Inject constructor(
    private val api: StarshipsApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : StarshipsRepository {
    override suspend fun getAllStarShips(pageNumber: Int): Result<Starships> {
        return withContext(ioDispatcher) {
            try {
                when (val result = api.getAllStarships(pageNumber)) {
                    is Response.Success<AllStarships> -> {
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

    override suspend fun getStarShip(starShipsId: Int): Result<Starship> {
        return withContext(ioDispatcher) {
            try {
                when (val result = api.getStarshipById(starShipsId)) {
                    is Response.Success<com.sdk.starwars.presentation.core.model.Starship> -> {
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

    override suspend fun searchStarShipsByName(name: String): Result<Starships> {
        return withContext(ioDispatcher) {
            try {
                when (val result = api.searchStarship(name)) {
                    is Response.Success<AllStarships> -> {
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

    override suspend fun searchStarShipsByModel(model: String): Result<Starships> {
        return withContext(ioDispatcher) {
            try {
                when (val result = api.searchStarship(model)) {
                    is Response.Success<AllStarships> -> {
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
