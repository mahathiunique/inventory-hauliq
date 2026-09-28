package com.hauliq.app.domain.model

data class Product(
    val id: String,
    val name: String,
    val description: String,
    val barcode: String,
    val sku: String,
    val category: String,
    val price: Double,
    val cost: Double,
    val quantity: Int,
    val unit: String,
    val supplierName: String,
    val batchNumber: String,
    val expiryDate: Long?, // Timestamp
    val lowStockThreshold: Int = 15,
    val imageUrl: String? = null
)

data class Supplier(
    val id: String,
    val name: String,
    val contactPerson: String,
    val email: String,
    val phone: String,
    val address: String,
    val categoriesSupplied: List<String>,
    val totalProducts: Int
)

enum class TransactionType {
    PURCHASE,
    SALES,
    ADJUSTMENT
}

data class Transaction(
    val id: String,
    val productId: String,
    val productName: String,
    val type: TransactionType,
    val quantity: Int,
    val timestamp: Long,
    val performedBy: String
)

data class ActivityLog(
    val id: String,
    val action: String,
    val timestamp: Long,
    val details: String,
    val type: LogType
)

enum class LogType {
    STOCK_IN,
    STOCK_OUT,
    ALERT,
    SYSTEM
}

enum class NotificationPriority {
    HIGH,
    WARNING,
    INFO
}

data class NotificationItem(
    val id: String,
    val title: String,
    val message: String,
    val timestamp: Long,
    val priority: NotificationPriority,
    val isRead: Boolean = false
)

data class DashboardStats(
    val totalProducts: Int,
    val lowStockCount: Int,
    val todaySales: Double,
    val pendingOrders: Int,
    val totalInventoryValue: Double,
    val totalRevenue: Double = 0.0
)

data class ChartPoint(
    val label: String,
    val value: Float
)

data class AnalyticsSummary(
    val salesTrend: List<ChartPoint>,
    val inventoryTrend: List<ChartPoint>,
    val fastMovingProducts: List<Pair<String, Int>>,
    val deadStockProducts: List<Pair<String, Int>>,
    val turnRate: Double,
    val monthlyRevenue: Double
)

enum class ReportType {
    INVENTORY,
    SALES,
    PURCHASE
}

data class ReportItem(
    val id: String,
    val type: ReportType,
    val title: String,
    val dateGenerated: Long,
    val fileFormat: String, // PDF / Excel
    val fileSize: String
)

// AI Assistant Models
data class AiInsight(
    val id: String,
    val title: String,
    val description: String,
    val type: InsightType,
    val priority: InsightPriority
)

enum class InsightType {
    RESTOCK, DEMAND_PREDICTION, OVERSTOCK, PERFORMANCE
}

enum class InsightPriority {
    HIGH, MEDIUM, LOW
}

data class ReorderSuggestion(
    val productId: String,
    val productName: String,
    val currentStock: Int,
    val suggestedQuantity: Int,
    val reason: String
)

data class ChatMessage(
    val id: String,
    val text: String,
    val isFromAi: Boolean,
    val timestamp: Long = System.currentTimeMillis()
)

data class Order(
    val id: String,
    val customerName: String,
    val customerPhone: String,
    val shippingAddress: String,
    val orderDate: Long,
    val status: OrderStatus,
    val priority: OrderPriority,
    val items: List<OrderItem>,
    val totalPrice: Double,
    val paymentStatus: String,
    val trackingNumber: String?,
    val notes: String?
)

data class OrderItem(
    val productId: String,
    val productName: String,
    val quantity: Int,
    val pricePerUnit: Double
)

enum class OrderStatus {
    PENDING, PROCESSING, PACKED, SHIPPED, DELIVERED, CANCELLED
}

enum class OrderPriority {
    LOW, MEDIUM, HIGH
}
