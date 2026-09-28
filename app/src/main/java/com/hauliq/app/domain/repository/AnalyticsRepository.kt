package com.hauliq.app.domain.repository

import com.hauliq.app.domain.model.AnalyticsSummary
import com.hauliq.app.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface AnalyticsRepository {
    fun getAnalyticsSummary(): Flow<AnalyticsSummary>
    fun getLowStockProducts(): Flow<List<Product>>
    fun getInventoryByCategory(): Flow<Map<String, Int>>
    fun getOrderStatusDistribution(): Flow<Map<String, Int>>
}
