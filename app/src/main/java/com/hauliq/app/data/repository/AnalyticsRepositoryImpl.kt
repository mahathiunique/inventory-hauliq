package com.hauliq.app.data.repository

import com.hauliq.app.data.local.dao.InventoryDao
import com.hauliq.app.data.local.dao.OrderDao
import com.hauliq.app.data.mapper.toDomain
import com.hauliq.app.data.mapper.toProduct
import com.hauliq.app.domain.model.*
import com.hauliq.app.domain.repository.AnalyticsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnalyticsRepositoryImpl @Inject constructor(
    private val inventoryDao: InventoryDao,
    private val orderDao: OrderDao
) : AnalyticsRepository {

    override fun getAnalyticsSummary(): Flow<AnalyticsSummary> {
        return combine(
            inventoryDao.getAllItems(),
            orderDao.getAllOrders()
        ) { inventory, orders ->
            val products = inventory.map { it.toProduct() }
            val domainOrders = orders.map { it.toDomain() }

            val now = System.currentTimeMillis()
            val thirtyDaysAgo = now - 30L * 24 * 60 * 60 * 1000
            
            val monthlyRevenue = domainOrders.filter { 
                it.orderDate > thirtyDaysAgo 
            }.sumOf { it.totalPrice }
            
            val fastMoving = products.sortedByDescending { it.quantity }.take(5).map { it.name to it.quantity }
            val deadStock = products.sortedBy { it.quantity }.take(5).map { it.name to it.quantity }

            // Calculate Sales Trend (Last 6 months)
            val sdf = SimpleDateFormat("MMM", Locale.getDefault())
            val salesTrend = domainOrders.groupBy { 
                val cal = Calendar.getInstance().apply { timeInMillis = it.orderDate }
                sdf.format(cal.time)
            }.map { entry -> 
                ChartPoint(entry.key, entry.value.sumOf { it.totalPrice }.toFloat())
            }.takeLast(6)

            // Inventory value trend
            val totalValue = products.sumOf { it.price * it.quantity }

            AnalyticsSummary(
                salesTrend = salesTrend, 
                inventoryTrend = listOf(ChartPoint("Total", totalValue.toFloat())), 
                fastMovingProducts = fastMoving,
                deadStockProducts = deadStock,
                turnRate = if (products.isNotEmpty()) monthlyRevenue / totalValue else 0.0,
                monthlyRevenue = monthlyRevenue
            )
        }
    }

    override fun getLowStockProducts(): Flow<List<Product>> {
        return inventoryDao.getLowStockItems().map { entities ->
            entities.map { it.toProduct() }
        }
    }

    override fun getInventoryByCategory(): Flow<Map<String, Int>> {
        return inventoryDao.getAllItems().map { entities ->
            entities.groupBy { it.category }.mapValues { it.value.size }
        }
    }

    override fun getOrderStatusDistribution(): Flow<Map<String, Int>> {
        return orderDao.getAllOrders().map { orders ->
            orders.groupBy { it.order.status }.mapValues { it.value.size }
        }
    }
}
