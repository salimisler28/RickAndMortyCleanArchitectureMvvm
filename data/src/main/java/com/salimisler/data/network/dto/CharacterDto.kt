package com.salimisler.data.network.dto

data class CharacterDto(
    val id: Int? = null,
    val name: String? = null,
    val status: String? = null,
    val species: String? = null,
    val gender: String? = null,
    val origin: OriginDto? = null,
    val location: LocationDto? = null,
    val image: String? = null,
    val episode: List<String>? = null,
    val url: String? = null,
    val created: String? = null
)
