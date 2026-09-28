package com.hauliq.app.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hauliq.app.presentation.ai.AiAssistantScreen
import com.hauliq.app.presentation.ai.AiAssistantViewModel
import com.hauliq.app.presentation.analytics.AnalyticsScreen
import com.hauliq.app.presentation.analytics.AnalyticsViewModel
import com.hauliq.app.presentation.auth.*
import com.hauliq.app.presentation.dashboard.DashboardScreen
import com.hauliq.app.presentation.dashboard.DashboardViewModel
import com.hauliq.app.presentation.inventory.*
import com.hauliq.app.presentation.orders.*
import com.hauliq.app.presentation.notifications.NotificationsScreen
import com.hauliq.app.presentation.notifications.NotificationsViewModel
import com.hauliq.app.presentation.profile.ProfileScreen
import com.hauliq.app.presentation.profile.ProfileViewModel
import com.hauliq.app.presentation.reports.ReportsScreen
import com.hauliq.app.presentation.reports.ReportsViewModel
import com.hauliq.app.presentation.scanner.ScannerScreen
import com.hauliq.app.presentation.scanner.BarcodeScannerViewModel
import com.hauliq.app.presentation.settings.AboutScreen
import com.hauliq.app.presentation.settings.SettingsScreen
import com.hauliq.app.presentation.settings.SettingsViewModel
import com.hauliq.app.presentation.suppliers.SupplierScreen
import com.hauliq.app.presentation.suppliers.SupplierViewModel
import com.hauliq.app.presentation.transactions.TransactionsScreen
import com.hauliq.app.presentation.transactions.TransactionsViewModel
import kotlinx.coroutines.flow.firstOrNull

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = Screen.Splash.route
) {
    // Sharing the InventoryViewModel for list, details, and add/edit flow consistency
    val inventoryViewModel: InventoryViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        // Splash
        composable(Screen.Splash.route) {
            SplashScreen(
                onTimeout = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }

        // Login
        composable(Screen.Login.route) {
            val authViewModel: AuthViewModel = hiltViewModel()
            LoginScreen(
                viewModel = authViewModel,
                onLoginSuccess = {
                    navController.navigate(Screen.Dashboard.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                onNavigateToRegister = {
                    navController.navigate(Screen.Register.route)
                },
                onNavigateToForgotPassword = {
                    navController.navigate(Screen.ForgotPassword.route)
                }
            )
        }

        // Register
        composable(Screen.Register.route) {
            val authViewModel: AuthViewModel = hiltViewModel()
            RegisterScreen(
                viewModel = authViewModel,
                onRegisterSuccess = {
                    navController.navigate(Screen.Dashboard.route) {
                        popUpTo(Screen.Register.route) { inclusive = true }
                    }
                },
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Register.route) { inclusive = true }
                    }
                }
            )
        }

        // Forgot Password
        composable(Screen.ForgotPassword.route) {
            val authViewModel: AuthViewModel = hiltViewModel()
            ForgotPasswordScreen(
                viewModel = authViewModel,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        // Dashboard
        composable(Screen.Dashboard.route) {
            val dashboardViewModel: DashboardViewModel = hiltViewModel()
            DashboardScreen(
                viewModel = dashboardViewModel,
                onNavigateToInventory = { navController.navigate(Screen.Inventory.route) },
                onNavigateToScanner = { navController.navigate(Screen.Scanner.route) },
                onNavigateToReports = { navController.navigate(Screen.Reports.route) },
                onNavigateToAnalytics = { navController.navigate(Screen.Analytics.route) },
                onNavigateToNotifications = { navController.navigate(Screen.Notifications.route) },
                onNavigateToOrders = { navController.navigate(Screen.Orders.route) },
                onNavigateToAiAssistant = { navController.navigate(Screen.AiAssistant.route) }
            )
        }

        // Inventory
        composable(Screen.Inventory.route) {
            InventoryScreen(
                viewModel = inventoryViewModel,
                onNavigateToDetails = { id ->
                    navController.navigate(Screen.ProductDetails.createRoute(id))
                },
                onNavigateToAddProduct = {
                    navController.navigate(Screen.AddProduct.createRoute())
                }
            )
        }

        // Orders
        composable(Screen.Orders.route) {
            val orderViewModel: OrderViewModel = hiltViewModel()
            OrdersScreen(
                viewModel = orderViewModel,
                onNavigateToOrderDetails = { id ->
                    navController.navigate(Screen.OrderDetails.createRoute(id))
                },
                onNavigateToCreateOrder = {
                    navController.navigate(Screen.CreateOrder.route)
                }
            )
        }

        // Order Details
        composable(
            route = Screen.OrderDetails.route,
            arguments = listOf(navArgument("orderId") { type = NavType.StringType })
        ) { backStackEntry ->
            val orderId = backStackEntry.arguments?.getString("orderId") ?: ""
            val orderViewModel: OrderViewModel = hiltViewModel()
            OrderDetailsScreen(
                orderId = orderId,
                viewModel = orderViewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        // Create Order
        composable(Screen.CreateOrder.route) {
            val orderViewModel: OrderViewModel = hiltViewModel()
            CreateOrderScreen(
                viewModel = orderViewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        // Product Details
        composable(
            route = Screen.ProductDetails.route,
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            ProductDetailScreen(
                productId = productId,
                viewModel = inventoryViewModel,
                onNavigateBack = { navController.popBackStack() },
                onNavigateToEdit = { id ->
                    navController.navigate(Screen.AddProduct.createRoute(id))
                }
            )
        }

        // Add / Edit Product
        composable(
            route = Screen.AddProduct.route,
            arguments = listOf(
                navArgument("productId") { 
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                },
                navArgument("barcode") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                }
            )
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")
            val barcode = backStackEntry.arguments?.getString("barcode")
            
            // Effect to load product when editing
            LaunchedEffect(productId, barcode) {
                if (productId != null) {
                    inventoryViewModel.getProduct(productId).firstOrNull()?.let {
                        inventoryViewModel.onFormEvent(InventoryFormEvent.LoadProduct(it))
                    }
                } else {
                    inventoryViewModel.onFormEvent(InventoryFormEvent.ResetForm)
                    if (barcode != null) {
                        inventoryViewModel.onFormEvent(InventoryFormEvent.BarcodeChanged(barcode))
                    }
                }
            }

            AddProductScreen(
                productId = productId,
                viewModel = inventoryViewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        // Barcode Scanner
        composable(Screen.Scanner.route) {
            val scannerViewModel: BarcodeScannerViewModel = hiltViewModel()
            ScannerScreen(
                viewModel = scannerViewModel,
                onNavigateToProductDetails = { id ->
                    navController.navigate(Screen.ProductDetails.createRoute(id)) {
                        popUpTo(Screen.Scanner.route) { inclusive = true }
                    }
                },
                onNavigateToAddProduct = { barcode ->
                    navController.navigate(Screen.AddProduct.createRoute(barcode = barcode)) {
                        popUpTo(Screen.Scanner.route) { inclusive = true }
                    }
                },
                onNavigateBack = { navController.popBackStack() }
            )
        }

        // Suppliers
        composable(Screen.Suppliers.route) {
            val supplierViewModel: SupplierViewModel = hiltViewModel()
            SupplierScreen(viewModel = supplierViewModel)
        }

        // Transactions
        composable(Screen.Transactions.route) {
            val transactionsViewModel: TransactionsViewModel = hiltViewModel()
            TransactionsScreen(viewModel = transactionsViewModel)
        }

        // Analytics
        composable(Screen.Analytics.route) {
            val analyticsViewModel: AnalyticsViewModel = hiltViewModel()
            AnalyticsScreen(viewModel = analyticsViewModel)
        }

        // AI Assistant
        composable(Screen.AiAssistant.route) {
            val aiViewModel: AiAssistantViewModel = hiltViewModel()
            AiAssistantScreen(viewModel = aiViewModel)
        }

        // Reports
        composable(Screen.Reports.route) {
            val reportsViewModel: ReportsViewModel = hiltViewModel()
            ReportsScreen(viewModel = reportsViewModel)
        }

        // Notifications
        composable(Screen.Notifications.route) {
            val notificationsViewModel: NotificationsViewModel = hiltViewModel()
            NotificationsScreen(viewModel = notificationsViewModel)
        }

        // Profile
        composable(Screen.Profile.route) {
            val profileViewModel: ProfileViewModel = hiltViewModel()
            ProfileScreen(viewModel = profileViewModel)
        }

        // Settings
        composable(Screen.Settings.route) {
            val settingsViewModel: SettingsViewModel = hiltViewModel()
            SettingsScreen(
                viewModel = settingsViewModel,
                onNavigateToAbout = { navController.navigate(Screen.About.route) }
            )
        }

        // About
        composable(Screen.About.route) {
            AboutScreen(onNavigateBack = { navController.popBackStack() })
        }
    }
}
