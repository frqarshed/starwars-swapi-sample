package com.sample.domain.repository

import com.sample.domain.model.Characters
import com.sample.domain.model.Character
import com.sample.domain.model.Result

interface CharactersRepository {
    suspend fun getAllCharacters(pageNumber: Int = 1): Result<Characters>

    suspend fun getCharacter(peopleId: Int): Result<Character>

    suspend fun searchCharacter(name: String): Result<Characters>
}