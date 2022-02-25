package com.salimisler.data.network.response

import com.salimisler.data.network.dto.CharacterDto
import com.salimisler.data.network.dto.InfoDto

data class GetFilteredCharactersResponse(
    val info: InfoDto? = null,
    val result: List<CharacterDto>? = null
)
