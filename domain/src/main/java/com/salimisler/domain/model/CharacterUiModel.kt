package com.salimisler.domain.model

data class CharacterUiModel(
    var id: Int,
    var name: String,
    var status: String,
    var species: String,
    var gender: String,
    var image: String,
    var episode: List<String>,
    var url: String,
    var created: String,
    var isFav: Boolean
)
