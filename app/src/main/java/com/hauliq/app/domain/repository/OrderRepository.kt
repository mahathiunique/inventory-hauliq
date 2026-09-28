package com.hauliq.app.domain.repository

import com.hauliq.app.domain.model.Order
import com.hauliq.app.domain.model.OrderStatus
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    fun getAllOrders(): Flow<List<Order>>
    fun getOrderById(id: String): Flow<Order?>
    suspend fun createOrder(order: Order)
    suspend fun updateOrderStatus(orderId: String, status: OrderStatus)
    fun getPendingOrdersCount(): Flow<Int>
    fun getTotalRevenue(): Flow<Double>
}
