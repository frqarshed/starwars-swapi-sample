package com.sample.data.core.network.api

import com.sdk.starwars.presentation.core.model.AllPeople
import com.sdk.starwars.presentation.core.model.People
import com.sdk.starwars.presentation.core.model.Response

interface CharactersApi {
    suspend fun getAllCharacters(pageNumber: Int): Response<AllPeople>

    suspend fun getCharacterById(characterId: Int): Response<People>

    suspend fun searchCharacter(name: String): Response<AllPeople>
}
