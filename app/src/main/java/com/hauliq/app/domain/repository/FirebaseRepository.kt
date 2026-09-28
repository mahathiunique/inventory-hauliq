package com.hauliq.app.domain.repository

import com.hauliq.app.data.remote.model.*
import kotlinx.coroutines.flow.Flow

interface FirebaseRepository {
    fun getProducts(): Flow<List<FirebaseProduct>>
    fun getSuppliers(): Flow<List<FirebaseSupplier>>
    fun getWarehouses(): Flow<List<FirebaseWarehouse>>
    fun getSales(): Flow<List<FirebaseSale>>
    fun getInventoryTransactions(): Flow<List<FirebaseInventoryTransaction>>
    fun getDashboardStats(): Flow<FirebaseDashboard?>
    
    suspend fun addProduct(product: FirebaseProduct)
    suspend fun updateProduct(product: FirebaseProduct)
    suspend fun deleteProduct(id: String)
}
