package com.hauliq.app.presentation.suppliers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hauliq.app.domain.model.Supplier
import com.hauliq.app.domain.repository.SupplierRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class SupplierViewModel @Inject constructor(
    private val supplierRepository: SupplierRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    val filteredSuppliers: StateFlow<List<Supplier>> = _searchQuery
        .flatMapLatest { query ->
            if (query.isBlank()) {
                supplierRepository.getAllSuppliers()
            } else {
                supplierRepository.searchSuppliers(query)
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun addSupplier(
        name: String,
        contact: String,
        email: String,
        phone: String,
        address: String,
        categories: List<String>
    ) {
        viewModelScope.launch {
            val newSupplier = Supplier(
                id = "S" + UUID.randomUUID().toString().take(3).uppercase(),
                name = name,
                contactPerson = contact,
                email = email,
                phone = phone,
                address = address,
                categoriesSupplied = categories,
                totalProducts = 0
            )
            supplierRepository.addSupplier(newSupplier)
        }
    }
}
