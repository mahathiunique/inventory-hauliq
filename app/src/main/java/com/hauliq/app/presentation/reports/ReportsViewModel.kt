package com.hauliq.app.presentation.reports

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hauliq.app.domain.model.ReportItem
import com.hauliq.app.domain.model.ReportType
import com.hauliq.app.domain.repository.InventoryRepository
import com.hauliq.app.domain.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class ReportsViewModel @Inject constructor(
    private val inventoryRepository: InventoryRepository,
    private val transactionRepository: TransactionRepository
) : ViewModel() {

    private val _reports = MutableStateFlow<List<ReportItem>>(emptyList())
    val reports: StateFlow<List<ReportItem>> = _reports.asStateFlow()

    private val _isExporting = MutableStateFlow(false)
    val isExporting: StateFlow<Boolean> = _isExporting.asStateFlow()

    private val _exportStatusMessage = MutableStateFlow<String?>(null)
    val exportStatusMessage: StateFlow<String?> = _exportStatusMessage.asStateFlow()

    init {
        // Load some initial history if desired, or leave empty
        _reports.value = listOf(
            ReportItem("R001", ReportType.INVENTORY, "End-of-Month Stock Valuations", System.currentTimeMillis() - 604800000, "PDF", "2.4 MB"),
            ReportItem("R002", ReportType.SALES, "Q2 Sales Performance Report", System.currentTimeMillis() - 1209600000, "Excel", "1.1 MB")
        )
    }

    fun exportReport(type: ReportType, format: String) {
        viewModelScope.launch {
            _isExporting.value = true
            
            // Actually fetch some data to "simulate" a real report compilation
            val dataCount = when (type) {
                ReportType.INVENTORY -> inventoryRepository.getProducts().first().size
                else -> transactionRepository.getAllTransactions().first().size
            }

            _exportStatusMessage.value = "Analyzing $dataCount records..."
            delay(1200)
            _exportStatusMessage.value = "Compiling tables..."
            delay(1000)
            _exportStatusMessage.value = "Generating $format file..."
            delay(800)

            val name = when (type) {
                ReportType.INVENTORY -> "Inventory Audit Sheet"
                ReportType.SALES -> "Sales Metrics Record"
                ReportType.PURCHASE -> "Purchase Order Audit Log"
            }
// ...

            val size = if (format == "PDF") "1.8 MB" else "784 KB"
            val newReport = ReportItem(
                id = "R" + UUID.randomUUID().toString().take(3).uppercase(),
                type = type,
                title = name,
                dateGenerated = System.currentTimeMillis(),
                fileFormat = format,
                fileSize = size
            )

            val currentList = _reports.value.toMutableList()
            currentList.add(0, newReport)
            _reports.value = currentList

            _isExporting.value = false
            _exportStatusMessage.value = "Report exported successfully!"
            delay(2000)
            _exportStatusMessage.value = null
        }
    }

    fun dismissStatus() {
        _exportStatusMessage.value = null
    }
}
