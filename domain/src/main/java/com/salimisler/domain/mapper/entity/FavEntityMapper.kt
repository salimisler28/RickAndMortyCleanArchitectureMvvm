package com.salimisler.domain.mapper.entity

import com.salimisler.data.database.entity.FavEntity
import com.salimisler.domain.base.BaseMapper
import com.salimisler.domain.model.CharacterUiModel
import javax.inject.Inject

class FavEntityMapper @Inject constructor(
) : BaseMapper<FavEntityMapper.Params, CharacterUiModel>(){
    override fun map(params: Params): CharacterUiModel {
        val favEntity = params.favEntity

        return CharacterUiModel(
            id = favEntity.charId,
            name = favEntity.name ?: "",
            image = favEntity.image ?: "",
            isFav = true,
        )
    }

    data class Params(
        val favEntity: FavEntity
    )
}