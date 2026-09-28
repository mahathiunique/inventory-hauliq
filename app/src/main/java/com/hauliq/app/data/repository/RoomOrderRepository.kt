package com.hauliq.app.data.repository

import com.hauliq.app.data.local.dao.InventoryDao
import com.hauliq.app.data.local.dao.OrderDao
import com.hauliq.app.data.local.dao.TransactionDao
import com.hauliq.app.data.local.entity.TransactionEntity
import com.hauliq.app.data.mapper.toDomain
import com.hauliq.app.data.mapper.toEntity
import com.hauliq.app.domain.model.Order
import com.hauliq.app.domain.model.OrderStatus
import com.hauliq.app.domain.model.TransactionType
import com.hauliq.app.domain.repository.OrderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomOrderRepository @Inject constructor(
    private val orderDao: OrderDao,
    private val inventoryDao: InventoryDao,
    private val transactionDao: TransactionDao
) : OrderRepository {

    override fun getAllOrders(): Flow<List<Order>> {
        return orderDao.getAllOrders().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override fun getOrderById(id: String): Flow<Order?> {
        return orderDao.getOrderById(id).map { it?.toDomain() }
    }

    override suspend fun createOrder(order: Order) {
        // 1. Insert Order
        orderDao.insertOrder(order.toEntity())
        // 2. Insert Items
        orderDao.insertOrderItems(order.items.map { it.toEntity(order.id) })
        
        // 3. Update Inventory & Log Transactions
        order.items.forEach { item ->
            val inventoryItem = inventoryDao.getItemById(item.productId).firstOrNull()
            if (inventoryItem != null) {
                val updatedQuantity = inventoryItem.quantity - item.quantity
                if (updatedQuantity < 0) {
                    throw Exception("Insufficient stock for ${item.productName}")
                }
                inventoryDao.updateItem(inventoryItem.copy(quantity = updatedQuantity))

                // Log Transaction
                transactionDao.insertTransaction(
                    TransactionEntity(
                        id = UUID.randomUUID().toString(),
                        productId = item.productId,
                        productName = item.productName,
                        type = TransactionType.SALES.name,
                        quantity = -item.quantity,
                        timestamp = System.currentTimeMillis(),
                        performedBy = "System (Order #${order.id})"
                    )
                )
            }
        }
    }

    override suspend fun updateOrderStatus(orderId: String, status: OrderStatus) {
        val orderWithItems = orderDao.getOrderById(orderId).firstOrNull()
        if (orderWithItems != null) {
            orderDao.updateOrder(orderWithItems.order.copy(status = status.name))
        }
    }

    override fun getPendingOrdersCount(): Flow<Int> {
        return orderDao.getPendingOrdersCount()
    }

    override fun getTotalRevenue(): Flow<Double> {
        return orderDao.getTotalRevenue().map { it ?: 0.0 }
    }
}
