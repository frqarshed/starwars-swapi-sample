package com.sample.domain.interactor

import com.sample.domain.interactor.base.UseCase
import com.sample.domain.model.Characters
import com.sample.domain.model.Result
import com.sample.domain.repository.CharactersRepository
import javax.inject.Inject

class SearchCharacterUseCase @Inject constructor(
    private val repo: CharactersRepository
) : UseCase<Result<Characters>, SearchCharacterUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<Characters> {
        params!!
        return repo.searchCharacter(name = params.name)
    }

    data class Params(
        val name: String
    )
}