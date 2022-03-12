package com.salimisler.rickandmortycleanmvvm.screen.fav

import androidx.lifecycle.viewModelScope
import com.salimisler.common.Resource
import com.salimisler.data.base.BaseException
import com.salimisler.domain.model.CharacterUiModel
import com.salimisler.domain.usecase.ListenFavsUseCase
import com.salimisler.rickandmortycleanmvvm.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavViewModel @Inject constructor(
    private val listenFavsUseCase: ListenFavsUseCase
) : BaseViewModel() {
    private val _dataSF = MutableStateFlow<List<CharacterUiModel>>(emptyList())
    val dataSF: StateFlow<List<CharacterUiModel>> = _dataSF

    init {
        initFavs()
    }

    private fun initFavs() = viewModelScope.launch {
        listenFavsUseCase.invoke(ListenFavsUseCase.Params(Unit))
            .collectLatest {
                when (it.status) {
                    Resource.Status.SUCCESS -> {
                        _dataSF.value = it.data.orEmpty()
                        hideLoading()
                    }
                    Resource.Status.LOADING -> showLoading()
                    Resource.Status.ERROR -> {
                        showError(it.message as BaseException)
                        hideLoading()
                    }
                }
            }
    }
}