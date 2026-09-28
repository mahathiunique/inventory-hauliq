package com.hauliq.app.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "inventory",
    indices = [Index(value = ["sku"], unique = true)]
)
data class InventoryEntity(
    @PrimaryKey val id: String,
    val itemName: String,
    val sku: String,
    val barcode: String,
    val category: String,
    val supplier: String,
    val purchasePrice: Double,
    val sellingPrice: Double,
    val quantity: Int,
    val minimumStock: Int,
    val warehouseLocation: String,
    val description: String,
    val imageUri: String?,
    val createdAt: Long,
    val updatedAt: Long
)
