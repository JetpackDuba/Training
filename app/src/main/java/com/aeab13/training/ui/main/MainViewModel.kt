package com.aeab13.training.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.aeab13.training.repositories.FruitsRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fruitsRepository: FruitsRepository
) : ViewModel() {

    private val _mainViewState = MutableStateFlow<MainViewState>(MainViewState.Loading)
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