package com.hauliq.app.data.local.dao

import androidx.room.*
import com.hauliq.app.data.local.entity.InventoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface InventoryDao {

    @Query("SELECT * FROM inventory ORDER BY updatedAt DESC")
    fun getAllItems(): Flow<List<InventoryEntity>>

    @Query("SELECT * FROM inventory WHERE id = :id")
    fun getItemById(id: String): Flow<InventoryEntity?>

    @Query("DELETE FROM inventory WHERE id = :id")
    suspend fun deleteItemById(id: String)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertItem(item: InventoryEntity)

    @Update
    suspend fun updateItem(item: InventoryEntity)

    @Delete
    suspend fun deleteItem(item: InventoryEntity)

    @Query("SELECT * FROM inventory WHERE itemName LIKE '%' || :query || '%' OR sku LIKE '%' || :query || '%'")
    fun searchItems(query: String): Flow<List<InventoryEntity>>

    @Query("SELECT * FROM inventory WHERE category = :category ORDER BY itemName ASC")
    fun filterByCategory(category: String): Flow<List<InventoryEntity>>

    @Query("SELECT * FROM inventory WHERE quantity <= minimumStock ORDER BY (CAST(quantity AS FLOAT) / CAST(minimumStock AS FLOAT)) ASC")
    fun getLowStockItems(): Flow<List<InventoryEntity>>
    
    @Query("SELECT * FROM inventory WHERE sku = :sku LIMIT 1")
    suspend fun getItemBySku(sku: String): InventoryEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items: List<InventoryEntity>)
}
