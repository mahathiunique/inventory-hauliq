package com.hauliq.app.presentation.inventory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hauliq.app.domain.model.Product
import com.hauliq.app.domain.repository.InventoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class InventoryUiState {
    object Loading : InventoryUiState()
    data class Success(val products: List<Product>) : InventoryUiState()
    data class Error(val message: String) : InventoryUiState()
}

sealed class InventoryFormEvent {
    data class NameChanged(val name: String) : InventoryFormEvent()
    data class SkuChanged(val sku: String) : InventoryFormEvent()
    data class BarcodeChanged(val barcode: String) : InventoryFormEvent()
    data class CategoryChanged(val category: String) : InventoryFormEvent()
    data class SupplierChanged(val supplier: String) : InventoryFormEvent()
    data class PriceChanged(val price: String) : InventoryFormEvent()
    data class CostChanged(val cost: String) : InventoryFormEvent()
    data class QuantityChanged(val quantity: String) : InventoryFormEvent()
    data class MinStockChanged(val minStock: String) : InventoryFormEvent()
    data class UnitChanged(val unit: String) : InventoryFormEvent()
    data class DescriptionChanged(val description: String) : InventoryFormEvent()
    data class Save(val productId: String? = null) : InventoryFormEvent()
    data class LoadProduct(val product: Product) : InventoryFormEvent()
    object ResetForm : InventoryFormEvent()
}

data class InventoryFormState(
    val name: String = "",
    val sku: String = "",
    val barcode: String = "",
    val category: String = "Electronics",
    val supplierName: String = "",
    val price: String = "",
    val cost: String = "",
    val quantity: String = "",
    val minStock: String = "10",
    val unit: String = "pcs",
    val location: String = "",
    val description: String = "",
    val nameError: String? = null,
    val skuError: String? = null,
    val quantityError: String? = null,
    val priceError: String? = null,
    val isSaving: Boolean = false,
    val saveSuccess: Boolean = false
)

@HiltViewModel
class InventoryViewModel @Inject constructor(
    private val repository: InventoryRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _selectedCategory = MutableStateFlow("All")
    val selectedCategory = _selectedCategory.asStateFlow()

    private val _formState = MutableStateFlow(InventoryFormState())
    val formState = _formState.asStateFlow()

    fun getProduct(id: String): Flow<Product?> = repository.getProductById(id)

    fun onFormEvent(event: InventoryFormEvent) {
        when (event) {
            is InventoryFormEvent.NameChanged -> _formState.update { it.copy(name = event.name, nameError = null) }
            is InventoryFormEvent.SkuChanged -> _formState.update { it.copy(sku = event.sku, skuError = null) }
            is InventoryFormEvent.BarcodeChanged -> _formState.update { it.copy(barcode = event.barcode) }
            is InventoryFormEvent.CategoryChanged -> _formState.update { it.copy(category = event.category) }
            is InventoryFormEvent.SupplierChanged -> _formState.update { it.copy(supplierName = event.supplier) }
            is InventoryFormEvent.PriceChanged -> _formState.update { it.copy(price = event.price, priceError = null) }
            is InventoryFormEvent.CostChanged -> _formState.update { it.copy(cost = event.cost) }
            is InventoryFormEvent.QuantityChanged -> _formState.update { it.copy(quantity = event.quantity, quantityError = null) }
            is InventoryFormEvent.MinStockChanged -> _formState.update { it.copy(minStock = event.minStock) }
            is InventoryFormEvent.UnitChanged -> _formState.update { it.copy(unit = event.unit) }
            is InventoryFormEvent.DescriptionChanged -> _formState.update { it.copy(description = event.description) }
            is InventoryFormEvent.Save -> saveProduct(event.productId)
            is InventoryFormEvent.LoadProduct -> loadProductIntoForm(event.product)
            is InventoryFormEvent.ResetForm -> _formState.value = InventoryFormState()
        }
    }

    private fun loadProductIntoForm(product: Product) {
        _formState.value = InventoryFormState(
            name = product.name,
            sku = product.sku,
            barcode = product.barcode,
            category = product.category,
            supplierName = product.supplierName,
            price = product.price.toString(),
            cost = product.cost.toString(),
            quantity = product.quantity.toString(),
            minStock = product.lowStockThreshold.toString(),
            unit = product.unit,
            description = product.description
        )
    }

    private fun saveProduct(productId: String?) {
        val state = _formState.value
        val hasError = validateForm()
        if (hasError) return

        viewModelScope.launch {
            _formState.update { it.copy(isSaving = true) }
            try {
                val product = Product(
                    id = productId ?: "P${System.currentTimeMillis()}",
                    name = state.name,
                    description = state.description,
                    barcode = state.barcode,
                    sku = state.sku,
                    category = state.category,
                    price = state.price.toDoubleOrNull() ?: 0.0,
                    cost = state.cost.toDoubleOrNull() ?: 0.0,
                    quantity = state.quantity.toIntOrNull() ?: 0,
                    unit = state.unit,
                    supplierName = state.supplierName,
                    batchNumber = "AUTO",
                    expiryDate = null,
                    lowStockThreshold = state.minStock.toIntOrNull() ?: 10
                )

                if (productId == null) {
                    repository.addProduct(product)
                } else {
                    repository.updateProduct(product)
                }
                _formState.update { it.copy(isSaving = false, saveSuccess = true) }
            } catch (e: Exception) {
                _formState.update { 
                    it.copy(
                        isSaving = false, 
                        skuError = if (e.message?.contains("SKU") == true) e.message else null,
                        nameError = if (e.message?.contains("SKU") == false) e.message else null
                    ) 
                }
            }
        }
    }

    private fun validateForm(): Boolean {
        val state = _formState.value
        var hasError = false

        if (state.name.isBlank()) {
            _formState.update { it.copy(nameError = "Name is required") }
            hasError = true
        }
        if (state.sku.isBlank()) {
            _formState.update { it.copy(skuError = "SKU is required") }
            hasError = true
        }
        val q = state.quantity.toIntOrNull()
        if (q == null || q < 0) {
            _formState.update { it.copy(quantityError = "Valid quantity required") }
            hasError = true
        }
        val p = state.price.toDoubleOrNull()
        if (p == null || p <= 0) {
            _formState.update { it.copy(priceError = "Valid price required") }
            hasError = true
        }

        return hasError
    }

    val uiState: StateFlow<InventoryUiState> = combine(
        repository.getProducts(),
        _searchQuery,
        _selectedCategory
    ) { products, query, category ->
        val filtered = products.filter { product ->
            val matchesQuery = product.name.contains(query, ignoreCase = true) || 
                               product.sku.contains(query, ignoreCase = true)
            val matchesCategory = if (category == "All") true else product.category == category
            matchesQuery && matchesCategory
        }
        InventoryUiState.Success(filtered)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = InventoryUiState.Loading
    )

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }

    fun onCategorySelect(category: String) {
        _selectedCategory.value = category
    }

    fun deleteProduct(id: String) {
        viewModelScope.launch {
            repository.deleteProduct(id)
        }
    }
}
