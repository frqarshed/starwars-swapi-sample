package com.sample.data.core.dao

import com.sample.data.core.network.api.CharactersApi
import com.sample.data.core.network.toDomain
import com.sample.domain.model.Character
import com.sample.domain.model.Characters
import com.sample.domain.model.Result
import com.sample.domain.repository.CharactersRepository
import com.sdk.starwars.presentation.core.model.AllPeople
import com.sdk.starwars.presentation.core.model.People
import com.sdk.starwars.presentation.core.model.Response
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharactersDao @Inject constructor(
    private val api: CharactersApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : CharactersRepository {

    override suspend fun getAllCharacters(pageNumber: Int): Result<Characters> =
        withContext(ioDispatcher) {
            try {
                when (val result = api.getAllCharacters(pageNumber)) {
                    is Response.Success<AllPeople> -> {
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

    override suspend fun getCharacter(peopleId: Int): Result<Character> {
        return withContext(ioDispatcher) {
            try {
                when (val result = api.getCharacterById(peopleId)) {
                    is Response.Success<People> -> {
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

    override suspend fun searchCharacter(name: String): Result<Characters> {
        return withContext(ioDispatcher) {
            try {
                when (val result = api.searchCharacter(name)) {
                    is Response.Success<AllPeople> -> {
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
