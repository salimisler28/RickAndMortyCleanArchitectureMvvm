package com.salimisler.rickandmortycleanmvvm.screen.home.adapter

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging3.PagingDataEpoxyController
import com.salimisler.domain.model.CharacterUiModel
import com.salimisler.rickandmortycleanmvvm.R
import com.salimisler.rickandmortycleanmvvm.base.ViewBindingKotlinModel
import com.salimisler.rickandmortycleanmvvm.databinding.ItemCharacterBinding
import com.salimisler.rickandmortycleanmvvm.util.extention.loadImage
import kotlinx.coroutines.ObsoleteCoroutinesApi

@OptIn(ObsoleteCoroutinesApi::class)
class HomeController : PagingDataEpoxyController<CharacterUiModel>() {
    override fun buildItemModel(currentPosition: Int, item: CharacterUiModel?): EpoxyModel<*> {
        return CharacterItemModel(
            characterUiModel = item
        ).id("char_${item?.id}")
    }

    data class CharacterItemModel(
        var characterUiModel: CharacterUiModel?
    ) : ViewBindingKotlinModel<ItemCharacterBinding>(R.layout.item_character) {
        override fun ItemCharacterBinding.bind() {
            txCharName.text = characterUiModel?.name
            ivCharAvatar.loadImage(characterUiModel?.image)
        }
    }
}