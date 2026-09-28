package com.hauliq.app.data.remote.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class FirebaseProduct(
    val product_id: String = "",
    val product_name: String = "",
    val category: String = "",
    val brand: String = "",
    val supplier_id: String = "",
    val warehouse_id: String = "",
    val barcode: String = "",
    val cost_price: Double = 0.0,
    val selling_price: Double = 0.0,
    val current_stock: Int = 0,
    val reorder_level: Int = 0,
    val unit: String = "",
    val expiry_date: Long? = null,
    val image_url: String? = null
)

@IgnoreExtraProperties
data class FirebaseSupplier(
    val supplier_id: String = "",
    val supplier_name: String = "",
    val contact_person: String = "",
    val email: String = "",
    val phone: String = "",
    val address: String = "",
    val categories: List<String> = emptyList()
)

@IgnoreExtraProperties
data class FirebaseWarehouse(
    val warehouse_id: String = "",
    val warehouse_name: String = "",
    val location: String = "",
    val capacity: Int = 0
)

@IgnoreExtraProperties
data class FirebaseSale(
    val sale_id: String = "",
    val product_id: String = "",
    val quantity: Int = 0,
    val total_amount: Double = 0.0,
    val sale_date: Long = 0,
    val customer_name: String = ""
)

@IgnoreExtraProperties
data class FirebaseInventoryTransaction(
    val transaction_id: String = "",
    val product_id: String = "",
    val type: String = "", // STOCK_IN, STOCK_OUT, ADJUSTMENT
    val quantity: Int = 0,
    val timestamp: Long = 0,
    val performed_by: String = ""
)

@IgnoreExtraProperties
data class FirebaseUser(
    val user_id: String = "",
    val email: String = "",
    val name: String = "",
    val role: String = "OPERATOR"
)

@IgnoreExtraProperties
data class FirebaseDashboard(
    val total_inventory_value: Double = 0.0,
    val total_sales_today: Double = 0.0,
    val low_stock_alerts: Int = 0,
    val pending_shipments: Int = 0
)
