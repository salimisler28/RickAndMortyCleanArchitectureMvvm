package com.salimisler.rickandmortycleanmvvm.screen.home.adapter

import androidx.fragment.app.Fragment
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
    var fragment: Fragment? = null
    var onFavClickListener: ((CharacterUiModel?) -> Unit)? = null

    override fun buildItemModel(currentPosition: Int, item: CharacterUiModel?): EpoxyModel<*> {
        return CharacterItemModel(
            characterUiModel = item,
            fragment = fragment,
            onFavClickListener = onFavClickListener,
            isFav = item?.isFav
        ).id("char_${item?.id}")
    }

    data class CharacterItemModel(
        var characterUiModel: CharacterUiModel?,
        var fragment: Fragment?,
        var onFavClickListener: ((CharacterUiModel?) -> Unit)?,
        val isFav: Boolean?
    ) : ViewBindingKotlinModel<ItemCharacterBinding>(R.layout.item_character) {
        override fun ItemCharacterBinding.bind() {
            val favIcon =
                if (isFav == true) R.drawable.ic_fav_filled else R.drawable.ic_fav
            txCharName.text = characterUiModel?.name
            ivCharAvatar.loadImage(fragment, characterUiModel?.image)
            ivCharFav.setOnClickListener { onFavClickListener?.invoke(characterUiModel) }
            ivCharFav.setImageResource(favIcon)
        }
    }
}