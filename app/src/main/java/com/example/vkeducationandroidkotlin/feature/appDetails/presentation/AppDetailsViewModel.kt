package com.example.vkeducationandroidkotlin.feature.appDetails.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkeducationandroidkotlin.feature.appDetails.data.AppDetailApi
import com.example.vkeducationandroidkotlin.feature.appDetails.data.AppDetailMapper
import com.example.vkeducationandroidkotlin.feature.appDetails.data.AppDetailRepositoryImplMock
import com.example.vkeducationandroidkotlin.core.data.CategoryMapper
import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetailRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppDetailsViewModel(
    private val id: String
): ViewModel() {
    private val appDetailRepository: AppDetailRepository = AppDetailRepositoryImplMock(
        api = AppDetailApi(),
        mapper = AppDetailMapper(categoryMapper = CategoryMapper())
    )

    private val _state: MutableStateFlow<AppDetailsState> = MutableStateFlow(
        AppDetailsState.Loading
    )
    val state: StateFlow<AppDetailsState> = _state.asStateFlow()

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