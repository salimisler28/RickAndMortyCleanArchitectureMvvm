package com.salimisler.rickandmortycleanmvvm.screen.fav.adapter

import com.airbnb.epoxy.EpoxyController
import com.salimisler.domain.model.CharacterUiModel

class FavController constructor(
) : EpoxyController() {
    var data: List<CharacterUiModel>? = null

    override fun buildModels() {
        data?.forEach {
            val favItem = FavItemModel()
            favItem.id(it.id)
            favItem.item = it
            favItem.addTo(this)
        }
    }
}