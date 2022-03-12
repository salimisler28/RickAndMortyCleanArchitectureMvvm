package com.salimisler.rickandmortycleanmvvm.base

import androidx.lifecycle.ViewModel
import com.salimisler.data.base.BaseException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel constructor(
) : ViewModel() {
    private val _baseLoadingMSF = MutableStateFlow<Boolean?>(null)
    val baseLoadingSF: StateFlow<Boolean?> = _baseLoadingMSF

    private val _baseErrorMSF = MutableStateFlow<BaseException?>(null)
    val baseErrorSF: StateFlow<BaseException?> = _baseErrorMSF

    protected fun showLoading() {
        _baseLoadingMSF.value = true
    }

    protected fun hideLoading() {
        _baseLoadingMSF.value = false
    }

    protected fun showError(error: BaseException) {
        _baseErrorMSF.value = error
    }
}