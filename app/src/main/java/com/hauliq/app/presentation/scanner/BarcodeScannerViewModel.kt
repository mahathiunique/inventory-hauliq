package com.hauliq.app.presentation.scanner

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hauliq.app.domain.repository.InventoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class ScannerUiState {
    object Idle : ScannerUiState()
    object Loading : ScannerUiState()
    data class Success(val barcode: String, val productExists: Boolean, val productId: String? = null) : ScannerUiState()
    data class Error(val message: String) : ScannerUiState()
}

@HiltViewModel
class BarcodeScannerViewModel @Inject constructor(
    private val repository: InventoryRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<ScannerUiState>(ScannerUiState.Idle)
    val uiState = _uiState.asStateFlow()

    private val _isFlashEnabled = MutableStateFlow(false)
    val isFlashEnabled = _isFlashEnabled.asStateFlow()

    private var lastScannedBarcode: String? = null

    fun onBarcodeDetected(barcode: String) {
        if (barcode == lastScannedBarcode || _uiState.value is ScannerUiState.Success) return
        
        lastScannedBarcode = barcode
        _uiState.value = ScannerUiState.Loading
        
        viewModelScope.launch {
            repository.getProducts().firstOrNull()?.let { products ->
                val product = products.find { it.barcode == barcode }
                if (product != null) {
                    _uiState.value = ScannerUiState.Success(barcode, true, product.id)
                } else {
                    _uiState.value = ScannerUiState.Success(barcode, false)
                }
            } ?: run {
                _uiState.value = ScannerUiState.Success(barcode, false)
            }
        }
    }

    fun toggleFlash() {
        _isFlashEnabled.value = !_isFlashEnabled.value
    }

    fun resetScanner() {
        lastScannedBarcode = null
        _uiState.value = ScannerUiState.Idle
    }

    fun onManualBarcodeSubmit(barcode: String) {
        onBarcodeDetected(barcode)
    }
}
