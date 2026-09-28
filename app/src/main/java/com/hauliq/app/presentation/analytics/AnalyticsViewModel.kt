package com.hauliq.app.presentation.analytics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hauliq.app.domain.model.*
import com.hauliq.app.domain.repository.AnalyticsRepository
import com.hauliq.app.domain.repository.InventoryRepository
import com.hauliq.app.domain.repository.OrderRepository
import com.hauliq.app.domain.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AnalyticsUiState(
// ... (omitted for brevity in replacement, but I'll make sure it's correct)
    val summary: AnalyticsSummary? = null,
    val totalInventoryCount: Int = 0,
    val totalInventoryValue: Double = 0.0,
    val lowStockCount: Int = 0,
    val outOfStockCount: Int = 0,
    val activeOrdersCount: Int = 0,
    val completedOrdersCount: Int = 0,
    val todayShipments: Int = 0,
    val totalRevenue: Double = 0.0,
    val weeklyRevenue: Double = 0.0,
    val avgOrderValue: Double = 0.0,
    val lowStockProducts: List<Product> = emptyList(),
    val recentActivities: List<Transaction> = emptyList(),
    val categoryDistribution: Map<String, Int> = emptyMap(),
    val orderStatusDistribution: Map<String, Int> = emptyMap(),
    val isLoading: Boolean = false,
    val selectedTimeFilter: TimeFilter = TimeFilter.THIS_MONTH
)

enum class TimeFilter {
    TODAY, THIS_WEEK, THIS_MONTH, CUSTOM
}

@HiltViewModel
class AnalyticsViewModel @Inject constructor(
    private val analyticsRepository: AnalyticsRepository,
    private val inventoryRepository: InventoryRepository,
    private val orderRepository: OrderRepository,
    private val transactionRepository: TransactionRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AnalyticsUiState())
    val uiState: StateFlow<AnalyticsUiState> = _uiState.asStateFlow()

    init {
        loadAnalytics()
    }

    private fun loadAnalytics() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            
            combine(
                analyticsRepository.getAnalyticsSummary(),
                analyticsRepository.getLowStockProducts(),
                analyticsRepository.getInventoryByCategory(),
                analyticsRepository.getOrderStatusDistribution(),
                inventoryRepository.getProducts(),
                transactionRepository.getAllTransactions()
            ) { args: Array<Any> ->
                val summary = args[0] as AnalyticsSummary
                val lowStock = args[1] as List<Product>
                val categoryDist = args[2] as Map<String, Int>
                val statusDist = args[3] as Map<String, Int>
                val products = args[4] as List<Product>
                val transactions = args[5] as List<Transaction>

                val totalValue = products.sumOf { it.price * it.quantity }
                val outOfStock = products.count { it.quantity == 0 }
                val totalRevenue = summary.monthlyRevenue
                
                AnalyticsUiState(
                    summary = summary,
                    totalInventoryCount = products.size,
                    totalInventoryValue = totalValue,
                    lowStockCount = lowStock.size,
                    outOfStockCount = outOfStock,
                    lowStockProducts = lowStock,
                    recentActivities = transactions.take(10),
                    categoryDistribution = categoryDist,
                    orderStatusDistribution = statusDist.mapKeys { it.key.toString() },
                    totalRevenue = totalRevenue,
                    isLoading = false
                )
            }.collect { newState ->
                _uiState.value = newState
            }
        }
    }

    fun onFilterSelected(filter: TimeFilter) {
        _uiState.update { it.copy(selectedTimeFilter = filter) }
    }
}
