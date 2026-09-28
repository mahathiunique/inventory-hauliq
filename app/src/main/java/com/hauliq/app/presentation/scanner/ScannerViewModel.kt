package com.hauliq.app.presentation.scanner

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hauliq.app.domain.model.Product
import com.hauliq.app.domain.model.SampleData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScannerViewModel @Inject constructor() : ViewModel() {

    private val _scanHistory = MutableStateFlow<List<Product>>(emptyList())
    val scanHistory: StateFlow<List<Product>> = _scanHistory.asStateFlow()

    private val _isFlashOn = MutableStateFlow(false)
    val isFlashOn: StateFlow<Boolean> = _isFlashOn.asStateFlow()

    private val _isContinuousScanOn = MutableStateFlow(true)
    val isContinuousScanOn: StateFlow<Boolean> = _isContinuousScanOn.asStateFlow()

    private val _lastScannedProduct = MutableStateFlow<Product?>(null)
    val lastScannedProduct: StateFlow<Product?> = _lastScannedProduct.asStateFlow()

    fun toggleFlash() {
        _isFlashOn.value = !_isFlashOn.value
    }

    fun toggleContinuousScan() {
        _isContinuousScanOn.value = !_isContinuousScanOn.value
    }

    fun simulateScan(barcode: String) {
        viewModelScope.launch {
            val matchingProduct = SampleData.products.firstOrNull { it.barcode == barcode } 
                ?: SampleData.products.random() // Fallback to random if no exact match

            _lastScannedProduct.value = matchingProduct
            
            val currentList = _scanHistory.value.toMutableList()
            if (!currentList.contains(matchingProduct)) {
                currentList.add(0, matchingProduct)
            }
            _scanHistory.value = currentList
        }
    }

    fun clearHistory() {
        _scanHistory.value = emptyList()
        _lastScannedProduct.value = null
    }
}
