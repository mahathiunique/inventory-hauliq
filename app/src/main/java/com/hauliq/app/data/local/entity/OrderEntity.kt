package com.hauliq.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class OrderEntity(
    @PrimaryKey val id: String,
    val customerName: String,
    val customerPhone: String,
    val shippingAddress: String,
    val orderDate: Long,
    val status: String, // Pending, Processing, Packed, Shipped, Delivered, Cancelled
    val priority: String, // Low, Medium, High
    val totalPrice: Double,
    val paymentStatus: String,
    val trackingNumber: String?,
    val notes: String?
)

@Entity(tableName = "order_items")
data class OrderItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val orderId: String,
    val productId: String,
    val productName: String,
    val quantity: Int,
    val pricePerUnit: Double
)
