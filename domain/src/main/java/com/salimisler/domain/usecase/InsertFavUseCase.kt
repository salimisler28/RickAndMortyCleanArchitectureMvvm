package com.salimisler.domain.usecase

import com.salimisler.common.Resource
import com.salimisler.data.database.entity.FavEntity
import com.salimisler.data.repository.CharacterRepository
import com.salimisler.domain.base.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InsertFavUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
): BaseUseCase<InsertFavUseCase.Params, Unit>() {

    override fun invoke(params: Params): Flow<Resource<Unit>> {
        val charId = params.charId
        val time = System.currentTimeMillis().toString()
        val entity = FavEntity(id = null, charId = charId, createdAt = time)
        return characterRepository.insertFav(entity)
    }

    data class Params(
        val charId: Int
    )
}