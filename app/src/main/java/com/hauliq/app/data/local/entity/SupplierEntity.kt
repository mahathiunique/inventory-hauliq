package com.hauliq.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "suppliers")
data class SupplierEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val contactPerson: String,
    val email: String,
    val phone: String,
    val address: String,
    val categoriesSupplied: String, // Comma separated
    val totalProducts: Int
)
