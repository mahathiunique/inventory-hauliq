package com.hauliq.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey
    val id: String,
    val productId: String,
    val productName: String,
    val type: String, // TransactionType.name
    val quantity: Int,
    val timestamp: Long,
    val performedBy: String
)
