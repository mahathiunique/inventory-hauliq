package com.hauliq.app.domain.repository

import com.hauliq.app.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface InventoryRepository {
    fun getProducts(): Flow<List<Product>>
    fun getProductById(id: String): Flow<Product?>
    suspend fun addProduct(product: Product)
    suspend fun updateProduct(product: Product)
    suspend fun deleteProduct(id: String)
    fun searchProducts(query: String): Flow<List<Product>>
    fun getProductsByCategory(category: String): Flow<List<Product>>
}
