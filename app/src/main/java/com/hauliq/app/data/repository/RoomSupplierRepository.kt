package com.hauliq.app.data.repository

import com.hauliq.app.data.local.dao.SupplierDao
import com.hauliq.app.data.mapper.toEntity
import com.hauliq.app.data.mapper.toSupplier
import com.hauliq.app.domain.model.Supplier
import com.hauliq.app.domain.repository.SupplierRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomSupplierRepository @Inject constructor(
    private val supplierDao: SupplierDao
) : SupplierRepository {
    override fun getAllSuppliers(): Flow<List<Supplier>> {
        return supplierDao.getAllSuppliers().map { entities ->
            entities.map { it.toSupplier() }
        }
    }

    override fun searchSuppliers(query: String): Flow<List<Supplier>> {
        return supplierDao.searchSuppliers(query).map { entities ->
            entities.map { it.toSupplier() }
        }
    }

    override suspend fun addSupplier(supplier: Supplier) {
        supplierDao.insertSupplier(supplier.toEntity())
    }

    override suspend fun deleteSupplier(supplier: Supplier) {
        supplierDao.deleteSupplier(supplier.toEntity())
    }
}
