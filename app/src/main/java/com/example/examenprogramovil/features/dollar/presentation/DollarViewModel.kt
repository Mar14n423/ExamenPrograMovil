package com.example.examenprogramovil.features.dollar.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examenprogramovil.features.dollar.domain.model.DollarModel
import com.example.examenprogramovil.features.dollar.domain.usecases.FetchDollarUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DollarViewModel(
    private val fetchDollarUseCase: FetchDollarUseCase
) : ViewModel() {

    sealed class DollarUIState {
        object Loading : DollarUIState()
        data class Error(val message: String) : DollarUIState()
        data class Success(val data: DollarModel) : DollarUIState()
    }

    private val _uiState = MutableStateFlow<DollarUIState>(DollarUIState.Loading)
    val uiState: StateFlow<DollarUIState> = _uiState.asStateFlow()

    init {
        // Inserta un valor inicial en la BD al abrir la app
        saveInitialDollar()
        // Carga el último valor de la BD
        getDollar()
    }

    fun getDollar() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                fetchDollarUseCase.execute().collect { data ->
                    _uiState.value = DollarUIState.Success(data)
                }
            } catch (e: Exception) {
                _uiState.value = DollarUIState.Error(e.message ?: "Error desconocido")
            }
        }
    }

    fun saveInitialDollar() {
        viewModelScope.launch(Dispatchers.IO) {
            val dummy = DollarModel(
                dollarOficialCompra = "6.90",
                dollarOficialVenta = "6.95",
                dollarParaleloCompra = "7.00",
                dollarParaleloVenta = "7.10",
                timestamp = System.currentTimeMillis()
            )
            fetchDollarUseCase.save(dummy)
        }
    }
}