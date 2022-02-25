package com.salimisler.data.network.response

import com.salimisler.data.network.dto.CharacterDto

data class GetCharacterByIdResponse(
    var result: CharacterDto? = null
)
