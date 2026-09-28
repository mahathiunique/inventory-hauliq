package com.hauliq.app.domain.repository

import com.hauliq.app.domain.model.Supplier
import kotlinx.coroutines.flow.Flow

interface SupplierRepository {
    fun getAllSuppliers(): Flow<List<Supplier>>
    fun searchSuppliers(query: String): Flow<List<Supplier>>
    suspend fun addSupplier(supplier: Supplier)
    suspend fun deleteSupplier(supplier: Supplier)
}
