package com.hauliq.app.presentation.analytics

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingDown
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hauliq.app.core.theme.ErrorRed
import com.hauliq.app.core.theme.WarningAmber
import com.hauliq.app.core.components.ShimmerEffect
import com.hauliq.app.domain.model.Product
import com.hauliq.app.domain.model.Transaction
import com.hauliq.app.domain.model.TransactionType
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnalyticsScreen(
    viewModel: AnalyticsViewModel,
    modifier: Modifier = Modifier,
) {
    val uiState by viewModel.uiState.collectAsState()
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Analytics Center", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Black) },
                actions = {
                    IconButton(onClick = { viewModel.exportPdf(context) }) {
                        Icon(Icons.Default.IosShare, contentDescription = "Export")
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize()) {
            if (uiState.isLoading) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    ShimmerEffect(modifier = Modifier.fillMaxWidth().height(150.dp))
                    ShimmerEffect(modifier = Modifier.fillMaxWidth().height(200.dp))
                    ShimmerEffect(modifier = Modifier.fillMaxWidth().height(150.dp))
                }
            } else {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .verticalScroll(scrollState)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    // 1. Time Filter
                    TimeFilterSection(
                        selectedFilter = uiState.selectedTimeFilter,
                        onFilterSelected = viewModel::onFilterSelected
                    )

                    // 2. Summary Statistics
                    SummarySection(uiState)

                    // 3. Charts Section
                    ChartsSection(uiState)

                    // 4. Low Stock Section
                    LowStockSection(uiState.lowStockProducts)

                    // 5. Revenue Insights
                    RevenueSection(uiState)

                    // 6. Inventory Insights
                    InventoryInsightsSection(uiState)

                    // 7. Recent Activity Timeline
                    ActivityTimelineSection(uiState.recentActivities)

                    // 8. Export Options
                    ExportSection(
                        onExportPdf = { viewModel.exportPdf(context) },
                        onExportCsv = { viewModel.exportCsv(context) }
                    )

                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }
    }
}

@Composable
fun TimeFilterSection(
    selectedFilter: TimeFilter,
    onFilterSelected: (TimeFilter) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TimeFilter.entries.forEach { filter ->
            FilterChip(
                selected = selectedFilter == filter,
                onClick = { onFilterSelected(filter) },
                label = { Text(filter.name.lowercase().replaceFirstChar { it.uppercase() }) },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun SummarySection(state: AnalyticsUiState) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Key Performance Indicators", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            StatCard(
                title = "Inventory Items",
                value = state.totalInventoryCount.toString(),
                icon = Icons.Default.Inventory2,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.weight(1f)
            )
            StatCard(
                title = "Total Value",
                value = "$${String.format(Locale.getDefault(), "%.0f", state.totalInventoryValue)}",
                icon = Icons.Default.AccountBalanceWallet,
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.weight(1f)
            )
        }
        
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            StatCard(
                title = "Low Stock",
                value = state.lowStockCount.toString(),
                icon = Icons.Default.Warning,
                color = WarningAmber,
                modifier = Modifier.weight(1f)
            )
            StatCard(
                title = "Out of Stock",
                value = state.outOfStockCount.toString(),
                icon = Icons.Default.ErrorOutline,
                color = ErrorRed,
                modifier = Modifier.weight(1f)
            )
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            StatCard(
                title = "Active Orders",
                value = state.activeOrdersCount.toString(),
                icon = Icons.Default.ShoppingCart,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.weight(1f)
            )
            StatCard(
                title = "Completed",
                value = state.completedOrdersCount.toString(),
                icon = Icons.Default.TaskAlt,
                color = Color(0xFF4CAF50),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun StatCard(title: String, value: String, icon: ImageVector, color: Color, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(icon, contentDescription = null, tint = color, modifier = Modifier.size(20.dp))
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = value, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.ExtraBold)
            Text(text = title, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Composable
fun ChartsSection(state: AnalyticsUiState) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Data Visualization", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text("Inventory by Category", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(20.dp))
                PieChart(data = state.categoryDistribution)
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text("Monthly Sales Revenue ($)", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(20.dp))
                val salesData = state.summary?.salesTrend?.map { it.value.toInt() } ?: emptyList()
                if (salesData.isNotEmpty()) {
                    BarChart(data = salesData)
                } else {
                    Text("No sales data recorded yet.", style = MaterialTheme.typography.bodySmall)
                }
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text("Stock Value Performance", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(20.dp))
                val trendData = state.summary?.inventoryTrend?.map { it.value } ?: emptyList()
                if (trendData.isNotEmpty()) {
                    LineChart(data = trendData)
                } else {
                    Text("Inventory tracking in progress...", style = MaterialTheme.typography.bodySmall)
                }
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text("Order Status Distribution", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(20.dp))
                DonutChart(data = state.orderStatusDistribution)
            }
        }
    }
}

@Composable
fun BarChart(data: List<Int>) {
    val max = data.maxOrNull()?.toFloat() ?: 1f
    val color = MaterialTheme.colorScheme.primary

    Canvas(modifier = Modifier.fillMaxWidth().height(150.dp)) {
        val width = size.width
        val height = size.height
        val barWidth = width / (data.size * 2f)
        
        data.forEachIndexed { index, value ->
            val barHeight = (value / max) * height
            drawRect(
                color = color,
                topLeft = androidx.compose.ui.geometry.Offset(
                    x = ((index * 2f) + 0.5f) * barWidth,
                    y = height - barHeight
                ),
                size = androidx.compose.ui.geometry.Size(barWidth, barHeight)
            )
        }
    }
}

@Composable
fun LineChart(data: List<Float>) {
    val max = data.maxOrNull() ?: 1f
    val color = MaterialTheme.colorScheme.tertiary

    Canvas(modifier = Modifier.fillMaxWidth().height(150.dp)) {
        val width = size.width
        val height = size.height
        val stepX = width / (data.size - 1)
        
        val path = Path()
        data.forEachIndexed { index, value ->
            val x = index * stepX
            val y = height - (value / max) * height
            if (index == 0) path.moveTo(x, y) else path.lineTo(x, y)
        }
        
        drawPath(
            path = path,
            color = color,
            style = Stroke(width = 4f, cap = StrokeCap.Round)
        )
        
        // Add fill below line
        val fillPath = Path().apply {
            addPath(path)
            lineTo(width, height)
            lineTo(0f, height)
            close()
        }
        drawPath(
            path = fillPath,
            brush = Brush.verticalGradient(
                colors = listOf(color.copy(alpha = 0.3f), Color.Transparent)
            )
        )
    }
}

@Composable
fun PieChart(data: Map<String, Int>) {
    if (data.isEmpty()) {
        Box(modifier = Modifier.fillMaxWidth().height(200.dp), contentAlignment = Alignment.Center) {
            Text("No data available", color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        return
    }

    val total = data.values.sum().toFloat()
    val colors = listOf(
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.secondary,
        MaterialTheme.colorScheme.tertiary,
        MaterialTheme.colorScheme.error,
        WarningAmber,
        Color(0xFF9C27B0),
        Color(0xFF00BCD4)
    )

    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Canvas(modifier = Modifier.size(150.dp).weight(1f)) {
            var startAngle = 0f
            data.values.forEachIndexed { index, value ->
                val sweepAngle = (value / total) * 360f
                drawArc(
                    color = colors[index % colors.size],
                    startAngle = startAngle,
                    sweepAngle = sweepAngle,
                    useCenter = true
                )
                startAngle += sweepAngle
            }
        }
        
        Column(modifier = Modifier.weight(1f).padding(start = 16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            data.entries.forEachIndexed { index, entry ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(12.dp).background(colors[index % colors.size], CircleShape))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "${entry.key}: ${entry.value}", style = MaterialTheme.typography.labelSmall)
                }
            }
        }
    }
}

@Composable
fun DonutChart(data: Map<String, Int>) {
    if (data.isEmpty()) {
        Box(modifier = Modifier.fillMaxWidth().height(200.dp), contentAlignment = Alignment.Center) {
            Text("No data available", color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        return
    }

    val total = data.values.sum().toFloat()
    val colors = listOf(
        Color(0xFF2196F3),
        Color(0xFFFFC107),
        Color(0xFF4CAF50),
        Color(0xFFF44336),
        Color(0xFF9C27B0)
    )

    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Canvas(modifier = Modifier.size(150.dp).weight(1f)) {
            var startAngle = 0f
            data.values.forEachIndexed { index, value ->
                val sweepAngle = (value / total) * 360f
                drawArc(
                    color = colors[index % colors.size],
                    startAngle = startAngle,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = Stroke(width = 30f, cap = StrokeCap.Round)
                )
                startAngle += sweepAngle
            }
        }
        
        Column(modifier = Modifier.weight(1f).padding(start = 16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            data.entries.forEachIndexed { index, entry ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(12.dp).background(colors[index % colors.size], CircleShape))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "${entry.key}: ${entry.value}", style = MaterialTheme.typography.labelSmall)
                }
            }
        }
    }
}

@Composable
fun LowStockSection(products: List<Product>) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text("Critical Low Stock", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            TextButton(onClick = { /* View All */ }) { Text("View All") }
        }

        if (products.isEmpty()) {
            Text("All inventory levels are healthy.", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        } else {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(products) { product ->
                    LowStockCard(product)
                }
            }
        }
    }
}

@Composable
fun LowStockCard(product: Product) {
    Card(
        modifier = Modifier.width(160.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = product.name, fontWeight = FontWeight.Bold, maxLines = 1, modifier = Modifier.weight(1f))
                Surface(
                    shape = CircleShape,
                    color = ErrorRed.copy(alpha = 0.1f)
                ) {
                    Icon(Icons.Default.PriorityHigh, contentDescription = null, tint = ErrorRed, modifier = Modifier.size(12.dp).padding(2.dp))
                }
            }
            Text(text = product.sku, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.Bottom) {
                Text(text = product.quantity.toString(), style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Black, color = ErrorRed)
                Text(text = " / ${product.lowStockThreshold}", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = { /* Restock */ },
                modifier = Modifier.fillMaxWidth().height(32.dp),
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Restock", fontSize = 10.sp)
            }
        }
    }
}

@Composable
fun RevenueSection(state: AnalyticsUiState) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Revenue Dashboard", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Text("Total Revenue", color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f))
                Text(
                    text = "$${String.format(Locale.getDefault(), "%.2f", state.totalRevenue)}",
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Black,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    RevenueStat("Weekly", "$${String.format(Locale.getDefault(), "%.0f", state.weeklyRevenue)}")
                    RevenueStat("Average Order", "$${String.format(Locale.getDefault(), "%.0f", state.avgOrderValue)}")
                    RevenueStat("Shipments Today", state.todayShipments.toString())
                }
            }
        }
    }
}

@Composable
fun RevenueStat(label: String, value: String) {
    Column {
        Text(text = label, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f))
        Text(text = value, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onPrimary)
    }
}

@Composable
fun InventoryInsightsSection(state: AnalyticsUiState) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Inventory Insights", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        
        val mostStocked = state.categoryDistribution.maxByOrNull { it.value }?.key ?: "N/A"
        val leastStocked = state.categoryDistribution.minByOrNull { it.value }?.key ?: "N/A"

        InsightCard("Most Stocked Category", mostStocked, Icons.Default.Category, MaterialTheme.colorScheme.primary)
        InsightCard("Least Stocked Category", leastStocked, Icons.Default.Inventory, ErrorRed)

        state.summary?.let { summary ->
            InsightCard("Fast Moving Items", summary.fastMovingProducts.joinToString { it.first }, Icons.AutoMirrored.Filled.TrendingUp, Color(0xFF4CAF50))
            InsightCard("Slow Moving Items", summary.deadStockProducts.joinToString { it.first }, Icons.AutoMirrored.Filled.TrendingDown, ErrorRed)
        }
    }
}

@Composable
fun InsightCard(title: String, details: String, icon: ImageVector, color: Color) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = null, tint = color)
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = title, fontWeight = FontWeight.Bold)
                Text(text = details, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}

@Composable
fun ActivityTimelineSection(activities: List<Transaction>) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Recent Activity Timeline", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                if (activities.isEmpty()) {
                    Text("No recent activity found.", style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(8.dp))
                } else {
                    val primaryColor = MaterialTheme.colorScheme.primary
                    activities.forEach { activity ->
                        val icon = when (activity.type) {
                            TransactionType.PURCHASE -> Icons.Default.AddCircle
                            TransactionType.SALES -> Icons.Default.ShoppingCart
                            TransactionType.ADJUSTMENT -> Icons.Default.Tune
                        }
                        val color = when (activity.type) {
                            TransactionType.PURCHASE -> Color(0xFF4CAF50)
                            TransactionType.SALES -> primaryColor
                            TransactionType.ADJUSTMENT -> WarningAmber
                        }
                        
                        ActivityItem(
                            title = activity.type.name.lowercase().replaceFirstChar { it.uppercase() },
                            desc = "${activity.quantity} units of '${activity.productName}'",
                            time = com.hauliq.app.core.utils.Formatters.formatDateTime(activity.timestamp),
                            icon = icon,
                            color = color
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ActivityItem(title: String, desc: String, time: String, icon: ImageVector, color: Color) {
    Row(verticalAlignment = Alignment.Top) {
        Icon(icon, contentDescription = null, tint = color, modifier = Modifier.size(20.dp))
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = title, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyMedium)
            Text(text = desc, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        Text(text = time, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

@Composable
fun ExportSection(
    onExportPdf: () -> Unit,
    onExportCsv: () -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Reports & Export", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            ExportButton("Export PDF", Icons.Default.PictureAsPdf, Modifier.weight(1f), onClick = onExportPdf)
            ExportButton("Export CSV", Icons.Default.TableChart, Modifier.weight(1f), onClick = onExportCsv)
        }
    }
}

@Composable
fun ExportButton(
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.height(48.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Icon(icon, contentDescription = null, modifier = Modifier.size(18.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text, fontSize = 12.sp)
    }
}
