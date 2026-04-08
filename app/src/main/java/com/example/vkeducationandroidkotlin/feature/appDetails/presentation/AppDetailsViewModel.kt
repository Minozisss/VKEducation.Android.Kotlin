package com.example.vkeducationandroidkotlin.feature.appDetails.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val appDetailRepository: AppDetailRepository
): ViewModel() {
    private val _state: MutableStateFlow<AppDetailsState> = MutableStateFlow(
        AppDetailsState.Loading
    )
    val state: StateFlow<AppDetailsState> = _state.asStateFlow()

    private val id: String = checkNotNull(savedStateHandle["id"])

    init {
        loadApp()
    }

    fun loadApp() {
        viewModelScope.launch {
            _state.value = AppDetailsState.Loading
            runCatching {
                delay(1000L) // Условный сценарий загрузки. Было в лекции
                appDetailRepository.get(id)
            }.onSuccess { app ->
                _state.value = AppDetailsState.Content(app)
            }.onFailure {
                _state.value = AppDetailsState.Error
            }
        }
    }
}