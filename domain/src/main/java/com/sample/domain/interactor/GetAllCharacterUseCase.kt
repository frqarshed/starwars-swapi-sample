package com.sample.domain.interactor

import com.sample.domain.interactor.base.UseCase
import com.sample.domain.model.Characters
import com.sample.domain.model.Result
import com.sample.domain.repository.CharactersRepository
import javax.inject.Inject

class GetAllCharacterUseCase @Inject constructor(
    private val repo: CharactersRepository
) : UseCase<Result<Characters>, GetAllCharacterUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<Characters> {
        params!!
        return repo.getAllCharacters(pageNumber = params.pageNumber)
    }

    data class Params(
        val pageNumber: Int = 1
    )
}