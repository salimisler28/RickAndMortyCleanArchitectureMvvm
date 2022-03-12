package com.salimisler.domain.mapper.dto

import android.util.Log
import com.salimisler.data.database.entity.FavEntity
import com.salimisler.data.network.dto.CharacterDto
import com.salimisler.domain.base.BaseMapper
import com.salimisler.domain.model.CharacterUiModel
import javax.inject.Inject

class CharacterDtoMapper @Inject constructor(
) : BaseMapper<CharacterDtoMapper.Params, CharacterUiModel>() {
    override fun map(params: Params): CharacterUiModel {
        val dto = params.dto
        val favList = params.favList
        val isFav = favList?.any { it.id == dto?.id } ?: false

        val model = CharacterUiModel(
            id = dto?.id ?: -1,
            name = dto?.name ?: "",
            image = dto?.image ?: "",
            isFav = isFav,
        )
        Log.d("denemeke", model.toString())
        return model
    }

    data class Params(
        val dto: CharacterDto?,
        val favList: List<FavEntity>?
    )
}