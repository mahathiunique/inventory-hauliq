package com.hauliq.app.data.local.dao

import androidx.room.*
import com.hauliq.app.data.local.entity.SupplierEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SupplierDao {
    @Query("SELECT * FROM suppliers ORDER BY name ASC")
    fun getAllSuppliers(): Flow<List<SupplierEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSupplier(supplier: SupplierEntity)

    @Delete
    suspend fun deleteSupplier(supplier: SupplierEntity)

    @Query("SELECT * FROM suppliers WHERE name LIKE '%' || :query || '%'")
    fun searchSuppliers(query: String): Flow<List<SupplierEntity>>
}
