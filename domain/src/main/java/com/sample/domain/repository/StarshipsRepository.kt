package com.sample.domain.repository

import com.sample.domain.model.Starship
import com.sample.domain.model.Starships
import com.sample.domain.model.Result

interface StarshipsRepository {
    suspend fun getAllStarShips(pageNumber: Int = 1): Result<Starships>

    suspend fun getStarShip(starShipsId: Int): Result<Starship>

    suspend fun searchStarShipsByName(name: String): Result<Starships>

    suspend fun searchStarShipsByModel(model: String): Result<Starships>
}