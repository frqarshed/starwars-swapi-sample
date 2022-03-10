package com.sample.domain.interactor

import com.sample.domain.interactor.base.UseCase
import com.sample.domain.model.Character
import com.sample.domain.model.Result
import com.sample.domain.repository.CharactersRepository
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repo: CharactersRepository
) : UseCase<Result<Character>, GetCharacterUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<Character> {
        params!!
        return repo.getCharacter(peopleId = params.peopleId)
    }

    data class Params(
        val peopleId: Int
    )
}