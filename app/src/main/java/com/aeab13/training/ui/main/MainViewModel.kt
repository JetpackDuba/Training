package com.aeab13.training.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.aeab13.training.repositories.FruitsRepository

// Tip: Use sealed classes to represent data's state
class MainViewModel : ViewModel() {
    private val fruitsRepository = FruitsRepository()

    fun loadData() = viewModelScope.launch {
        // TODO Loading the fruits list can take a while
        val fruitsList = fruitsRepository.getFruits()
        // TODO Do something with the fruitsList
        // TODO: Handle errors if the call crashes
    }
}