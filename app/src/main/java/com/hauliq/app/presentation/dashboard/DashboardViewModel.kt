package com.hauliq.app.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hauliq.app.domain.model.ActivityLog
import com.hauliq.app.domain.model.AiInsight
import com.hauliq.app.domain.model.DashboardStats
import com.hauliq.app.domain.model.SampleData
import com.hauliq.app.domain.repository.InventoryRepository
import com.hauliq.app.domain.repository.OrderRepository
import com.hauliq.app.domain.repository.AiAssistantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val inventoryRepository: InventoryRepository,
    private val orderRepository: OrderRepository,
    private val aiAssistantRepository: AiAssistantRepository
) : ViewModel() {

    private val _stats = MutableStateFlow<DashboardStats?>(null)
    val stats: StateFlow<DashboardStats?> = _stats.asStateFlow()

    private val _activities = MutableStateFlow<List<ActivityLog>>(emptyList())
    val activities: StateFlow<List<ActivityLog>> = _activities.asStateFlow()

    private val _aiInsights = MutableStateFlow<List<AiInsight>>(emptyList())
    val aiInsights: StateFlow<List<AiInsight>> = _aiInsights.asStateFlow()

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing.asStateFlow()

    init {
        loadDashboardData()
    }

    private fun loadDashboardData() {
        viewModelScope.launch {
            combine(
                inventoryRepository.getProducts(),
                orderRepository.getAllOrders(),
                orderRepository.getPendingOrdersCount(),
                orderRepository.getTotalRevenue()
            ) { products, orders, pendingCount, totalRevenue ->
                val lowStockCount = products.count { it.quantity <= it.lowStockThreshold }
                val totalInventoryValue = products.sumOf { it.price * it.quantity }
                
                // Simplified "today sales" - in a real app, filter orders by date
                val todayMillis = System.currentTimeMillis() - 24 * 60 * 60 * 1000 // Last 24h for mock
                val todaySales = orders.filter { it.orderDate > todayMillis }.sumOf { it.totalPrice }

                DashboardStats(
                    totalProducts = products.size,
                    lowStockCount = lowStockCount,
                    todaySales = todaySales,
                    pendingOrders = pendingCount,
                    totalInventoryValue = totalInventoryValue,
                    totalRevenue = totalRevenue
                )
            }.collect {
                _stats.value = it
            }
        }
        
        viewModelScope.launch {
            _activities.value = SampleData.activityLogs
        }

        viewModelScope.launch {
            aiAssistantRepository.getAiInsights().collect {
                _aiInsights.value = it.take(3) // Show top 3 on dashboard
            }
        }
    }

    fun refreshDashboard() {
        viewModelScope.launch {
            _isRefreshing.value = true
            // Mock refreshing delays
            kotlinx.coroutines.delay(500)
            loadDashboardData()
            _isRefreshing.value = false
        }
    }
}
