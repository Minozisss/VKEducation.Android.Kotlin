package com.example.vkeducationandroidkotlin.feature.appDetails.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkeducationandroidkotlin.feature.appDetails.domain.GetAppDetailsUseCase
import com.example.vkeducationandroidkotlin.feature.appDetails.domain.ObserveAppDetailsUseCase
import com.example.vkeducationandroidkotlin.feature.appDetails.domain.ToggleWishListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getAppDetailsUseCase: GetAppDetailsUseCase,
    private val toggleWishListUseCase: ToggleWishListUseCase,
    private val observeAppDetailsUseCase: ObserveAppDetailsUseCase
): ViewModel() {
    private val _state: MutableStateFlow<AppDetailsState> = MutableStateFlow(
        AppDetailsState.Loading
    )
    val state: StateFlow<AppDetailsState> = _state.asStateFlow()

    private val id: String = checkNotNull(savedStateHandle["id"])

    init {
        observeAppDetails()
        viewModelScope.launch {
            loadApp()
        }
    }

    private suspend fun loadApp() {
        _state.value = AppDetailsState.Loading
        runCatching {
            getAppDetailsUseCase(id)
        }.onFailure {
            _state.value = AppDetailsState.Error
        }
    }

    private fun observeAppDetails() {
        viewModelScope.launch {
            observeAppDetailsUseCase(id)
                .catch {
                    _state.value = AppDetailsState.Error
                }
                .collect { appDetails ->
                    _state.value = AppDetailsState.Content(appDetails)
                }
        }
    }

    fun toggleWishList() {
        viewModelScope.launch {
            toggleWishListUseCase(id)
        }
    }
}
