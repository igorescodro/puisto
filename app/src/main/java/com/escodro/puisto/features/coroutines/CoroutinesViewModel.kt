package com.escodro.puisto.features.coroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinesViewModel : ViewModel() {

    private val _snackbar = MutableLiveData<String>()

    val snackbar: LiveData<String>
        get() = _snackbar

    fun simpleCoroutinesClicked() {
        viewModelScope.launch {
            delay(2_000)
            _snackbar.value = "I'm a simple coroutine"
        }
    }
}