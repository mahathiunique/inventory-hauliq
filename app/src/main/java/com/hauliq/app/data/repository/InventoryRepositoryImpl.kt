package com.hauliq.app.data.repository

import com.hauliq.app.domain.model.Product
import com.hauliq.app.domain.model.SampleData
import com.hauliq.app.domain.repository.InventoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InventoryRepositoryImpl @Inject constructor() : InventoryRepository {

    private val products = MutableStateFlow<List<Product>>(SampleData.products)

    override fun getProducts(): Flow<List<Product>> = products

    override fun getProductById(id: String): Flow<Product?> = products.map { list ->
        list.find { it.id == id }
    }

    override fun searchProducts(query: String): Flow<List<Product>> = products.map { list ->
        if (query.isBlank()) list
        else list.filter { 
            it.name.contains(query, ignoreCase = true) || 
            it.sku.contains(query, ignoreCase = true) ||
            it.barcode.contains(query, ignoreCase = true)
        }
    }

    override fun getProductsByCategory(category: String): Flow<List<Product>> = products.map { list ->
        if (category.equals("All", ignoreCase = true)) list
        else list.filter { it.category == category }
    }

    override suspend fun addProduct(product: Product) {
        products.value = products.value + product
    }

    override suspend fun updateProduct(product: Product) {
        products.value = products.value.map {
            if (it.id == product.id) product else it
        }
    }

    override suspend fun deleteProduct(id: String) {
        products.value = products.value.filter { it.id != id }
    }
}
