package com.escodro.puisto.features.coroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CoroutinesViewModel : ViewModel() {

    private val _snackbar = MutableLiveData<String>()

    private val movieRepository = MovieRepository()

    private val cityRepository = CityRepository()

    val snackbar: LiveData<String>
        get() = _snackbar

    fun simpleCoroutinesClicked() {
        viewModelScope.launch {
            delay(2_000)
            _snackbar.value = "I'm a simple coroutine"
        }
    }

    fun suspendFunctionsClicked() {
        viewModelScope.launch {
            _snackbar.value = movieRepository.loadRandomMovie()
        }
    }

    @ExperimentalCoroutinesApi
    @FlowPreview
    fun flowClicked() {
        viewModelScope.launch {
            cityRepository.loadRandomCity()
                .catch { _snackbar.value = "Something went wrong. Please try again." }
                .collect { _snackbar.value = it }
        }
    }
}