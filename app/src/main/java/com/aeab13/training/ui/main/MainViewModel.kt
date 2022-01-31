package com.aeab13.training.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.aeab13.training.repositories.FruitsRepository

class MainViewModel : ViewModel() {
    private val _mainViewState = MutableStateFlow<MainViewState>(MainViewState.Loading)
    private val fruitsRepository = FruitsRepository()
    val mainViewState: StateFlow<MainViewState> = _mainViewState

    fun loadData() = viewModelScope.launch {
        try {
            _mainViewState.value = MainViewState.Loading

            val fruitsList = fruitsRepository.getFruits()
            _mainViewState.value = MainViewState.Complete(fruitsList)
        } catch (ex: Exception) {
            _mainViewState.value = MainViewState.Error(ex)
        }
    }
}

sealed class MainViewState {
    object Loading: MainViewState()
    data class Complete(val fruitsList: List<String>): MainViewState()
    data class Error(val exception: Exception): MainViewState()
}