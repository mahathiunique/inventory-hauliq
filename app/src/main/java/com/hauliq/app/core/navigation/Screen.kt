package com.hauliq.app.core.navigation

sealed class Screen(val route: String) {
    // Auth Screens
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Register : Screen("register")
    object ForgotPassword : Screen("forgot_password")
    
    // Core App Screens
    object Dashboard : Screen("dashboard")
    object Inventory : Screen("inventory")
    object Orders : Screen("orders")
    
    object OrderDetails : Screen("order_details/{orderId}") {
        fun createRoute(orderId: String) = "order_details/$orderId"
    }
    
    object CreateOrder : Screen("create_order")
    
    object ProductDetails : Screen("product_details/{productId}") {
        fun createRoute(productId: String) = "product_details/$productId"
    }
    
    object AddProduct : Screen("add_product?productId={productId}&barcode={barcode}") {
        fun createRoute(productId: String? = null, barcode: String? = null) = buildString {
            append("add_product")
            val params = mutableListOf<String>()
            if (productId != null) params.add("productId=$productId")
            if (barcode != null) params.add("barcode=$barcode")
            if (params.isNotEmpty()) {
                append("?")
                append(params.joinToString("&"))
            }
        }
    }
    
    object Scanner : Screen("scanner")
    object Suppliers : Screen("suppliers")
    object Transactions : Screen("transactions")
    object Analytics : Screen("analytics")
    object Reports : Screen("reports")
    object Notifications : Screen("notifications")
    object AiAssistant : Screen("ai_assistant")
    object Profile : Screen("profile")
    object Settings : Screen("settings")
    object About : Screen("about")
}
