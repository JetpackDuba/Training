package com.aeab13.training.ui.states_example

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

private const val TAG = "StatesViewModel"

class StatesViewModel : ViewModel() {
    private val _updateStateFlow = MutableStateFlow<UpdateStatus>(UpdateStatus.NoUpdates)
    val updateStatusFlow: StateFlow<UpdateStatus> = _updateStateFlow

    fun checkForUpdates() {
        viewModelScope.launch {
            _updateStateFlow.value = UpdateStatus.CheckingUpdates
            delay(4000)
            _updateStateFlow.value = UpdateStatus.UpdateAvailable("1.0.1")
        }
    }

    fun resetState() {
        viewModelScope.launch {
            _updateStateFlow.value = UpdateStatus.NoUpdates
        }
    }
}

/**
 * No updates
 * Checking updates
 * Update Available
 */
sealed interface UpdateStatus {
    object NoUpdates : UpdateStatus
    object CheckingUpdates : UpdateStatus
    data class UpdateAvailable(val versionName: String) : UpdateStatus
}