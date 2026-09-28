package com.hauliq.app.data.repository

import com.hauliq.app.data.local.dao.InventoryDao
import com.hauliq.app.data.local.dao.OrderDao
import com.hauliq.app.data.mapper.toProduct
import com.hauliq.app.domain.model.*
import com.hauliq.app.domain.repository.AiAssistantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AiAssistantRepositoryImpl @Inject constructor(
    private val inventoryDao: InventoryDao,
    private val orderDao: OrderDao
) : AiAssistantRepository {

    override fun getAiInsights(): Flow<List<AiInsight>> {
        return combine(
            inventoryDao.getAllItems(),
            orderDao.getAllOrders()
        ) { inventory, orders ->
            val insights = mutableListOf<AiInsight>()
            val products = inventory.map { it.toProduct() }

            // 1. Low stock insights
            products.filter { it.quantity <= it.lowStockThreshold }.forEach { product ->
                insights.add(
                    AiInsight(
                        id = "insight_low_${product.id}",
                        title = "Low Stock Alert",
                        description = "Stock for ${product.name} is critically low (${product.quantity} ${product.unit}). Consider restocking.",
                        type = InsightType.RESTOCK,
                        priority = InsightPriority.HIGH
                    )
                )
            }

            // 2. Overstock insights (Simple logic: > 10x threshold)
            products.filter { it.quantity > it.lowStockThreshold * 10 }.forEach { product ->
                insights.add(
                    AiInsight(
                        id = "insight_over_${product.id}",
                        title = "Overstock Warning",
                        description = "${product.name} has high inventory levels. Consider a promotion.",
                        type = InsightType.OVERSTOCK,
                        priority = InsightPriority.LOW
                    )
                )
            }

            // 3. Demand Prediction (Simplified)
            if (orders.isNotEmpty()) {
                val mostOrdered = products.maxByOrNull { p -> 
                    orders.flatMap { o -> o.items }.filter { it.productId == p.id }.sumOf { it.quantity }
                }
                mostOrdered?.let {
                    insights.add(
                        AiInsight(
                            id = "insight_demand_${it.id}",
                            title = "High Demand Predicted",
                            description = "Based on recent trends, ${it.name} is expected to have high demand this week.",
                            type = InsightType.DEMAND_PREDICTION,
                            priority = InsightPriority.MEDIUM
                        )
                    )
                }

                // Business Insights
                val fastMoving = products.maxByOrNull { p -> 
                    orders.flatMap { o -> o.items }.filter { it.productId == p.id }.sumOf { it.quantity }
                }
                fastMoving?.let {
                    insights.add(
                        AiInsight(
                            id = "insight_fast_moving",
                            title = "Fastest Moving Product",
                            description = "${it.name} is your top performer this month.",
                            type = InsightType.PERFORMANCE,
                            priority = InsightPriority.LOW
                        )
                    )
                }

                val highRevenueCategory = products.groupBy { it.category }
                    .maxByOrNull { entry -> 
                        val catProductIds = entry.value.map { it.id }
                        orders.flatMap { o -> o.items }
                            .filter { it.productId in catProductIds }
                            .sumOf { it.quantity * it.pricePerUnit }
                    }?.key
                
                highRevenueCategory?.let {
                    insights.add(
                        AiInsight(
                            id = "insight_revenue_cat",
                            title = "Highest Revenue Category",
                            description = "$it category contributed the most to your revenue recently.",
                            type = InsightType.PERFORMANCE,
                            priority = InsightPriority.LOW
                        )
                    )
                }
            }

            insights.sortedBy { it.priority }
        }
    }

    override fun getReorderSuggestions(): Flow<List<ReorderSuggestion>> {
        return inventoryDao.getLowStockItems().map { entities ->
            entities.map { entity ->
                ReorderSuggestion(
                    productId = entity.id,
                    productName = entity.itemName,
                    currentStock = entity.quantity,
                    suggestedQuantity = entity.minimumStock * 2,
                    reason = "Low stock alert based on minimum threshold of ${entity.minimumStock}."
                )
            }
        }
    }

    override suspend fun getChatResponse(message: String): String {
        val lowerMessage = message.lowercase()
        val products = inventoryDao.getAllItems().first()
        val orders = orderDao.getAllOrders().first()

        return when {
            lowerMessage.contains("hello") || lowerMessage.contains("hi") -> 
                "Hello! I am your HaulIQ AI Assistant. How can I help you manage your inventory today?"
            
            lowerMessage.contains("restock") || lowerMessage.contains("low stock") -> {
                val lowStock = products.filter { it.quantity <= it.minimumStock }
                if (lowStock.isEmpty()) {
                    "All your stock levels are currently healthy! No immediate restocks needed."
                } else {
                    "You have ${lowStock.size} items low on stock. I recommend restocking '${lowStock.first().itemName}' first."
                }
            }
            
            lowerMessage.contains("status") || lowerMessage.contains("orders") -> {
                val pending = orders.count { it.order.status == "PENDING" || it.order.status == "PROCESSING" }
                "You currently have $pending active orders being processed."
            }
            
            lowerMessage.contains("revenue") || lowerMessage.contains("money") -> {
                val total = orders.sumOf { it.order.totalPrice }
                "Your total lifetime revenue recorded in the system is $${String.format(Locale.getDefault(), "%.2f", total)}."
            }
            
            lowerMessage.contains("inventory") || lowerMessage.contains("total items") -> {
                val totalQty = products.sumOf { it.quantity }
                "You have a total of $totalQty units across ${products.size} different products in your warehouse."
            }
            
            else -> "I'm sorry, I don't have information on that specifically. You can ask me about stock levels, reordering, revenue, or order status."
        }
    }
}
