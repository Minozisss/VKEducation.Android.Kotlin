package com.example.vkeducationandroidkotlin.feature.store.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkeducationandroidkotlin.feature.store.domain.App
import com.example.vkeducationandroidkotlin.feature.store.domain.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

@HiltViewModel
class StoreViewModel @Inject constructor(
    private val appRepository: AppRepository
) : ViewModel() {
    private val _state: MutableStateFlow<StoreState> = MutableStateFlow(
        StoreState.Loading
    )
    val state: StateFlow<StoreState> = _state.asStateFlow()

    private val _events: Channel<StoreEvents> = Channel(
        Channel.BUFFERED
    )
    val events = _events.receiveAsFlow()

    init {
        loadApps()
    }

    fun loadApps() {
        viewModelScope.launch {
            runCatching {
                _state.value = StoreState.Loading

                delay(1000L) // Условный сценарий загрузки. Было в лекции

                val apps: List<App> = appRepository.get()

                _state.value = StoreState.Content(apps)
            }.onFailure {
                _state.value = StoreState.Error
            }
        }
    }

    fun showSnackbar() {
        viewModelScope.launch {
            _events.send(
                StoreEvents.ShowSnackbar(
                    message = "Это RuStore"
                )
            )
        }
    }
}