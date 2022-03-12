package com.salimisler.rickandmortycleanmvvm.screen.home

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.salimisler.common.Resource
import com.salimisler.domain.model.CharacterUiModel
import com.salimisler.domain.usecase.GetAllCharactersPerPageUseCase
import com.salimisler.domain.usecase.InsertFavUseCase
import com.salimisler.rickandmortycleanmvvm.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllCharactersPerPageUseCase: GetAllCharactersPerPageUseCase,
    private val insertFavUseCase: InsertFavUseCase
) : BaseViewModel() {
    val charactersSF = MutableStateFlow<PagingData<CharacterUiModel>?>(null)

    init {
        getAllCharactersPerPage()
    }

    private fun getAllCharactersPerPage() = viewModelScope.launch {
        val params = GetAllCharactersPerPageUseCase.Params(scope = this)

        getAllCharactersPerPageUseCase.invoke(params).collect {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    charactersSF.value = it.data
                }
                Resource.Status.LOADING -> {
                }
                Resource.Status.ERROR -> {
                }
            }
        }
    }

    fun insertFav(charId: Int) = viewModelScope.launch {
        insertFavUseCase.invoke(InsertFavUseCase.Params(charId = charId))
            .collect()
    }
}