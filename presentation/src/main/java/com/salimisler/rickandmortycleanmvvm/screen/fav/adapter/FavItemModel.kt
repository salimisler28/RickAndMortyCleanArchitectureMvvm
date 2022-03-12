package com.salimisler.rickandmortycleanmvvm.screen.fav.adapter

import com.salimisler.domain.model.CharacterUiModel
import com.salimisler.rickandmortycleanmvvm.R
import com.salimisler.rickandmortycleanmvvm.base.ViewBindingKotlinModel
import com.salimisler.rickandmortycleanmvvm.databinding.ItemFavBinding

class FavItemModel : ViewBindingKotlinModel<ItemFavBinding>(R.layout.item_fav) {
    var item: CharacterUiModel? = null

    override fun ItemFavBinding.bind() {
        tvName.text = "item?.name"
    }
}