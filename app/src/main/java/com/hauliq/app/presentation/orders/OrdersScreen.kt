package com.hauliq.app.presentation.orders

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hauliq.app.core.components.DashboardCard
import com.hauliq.app.core.components.EmptyState
import com.hauliq.app.core.theme.ErrorRed
import com.hauliq.app.core.theme.WarningAmber
import com.hauliq.app.domain.model.Order
import com.hauliq.app.domain.model.OrderPriority
import com.hauliq.app.domain.model.OrderStatus
import com.hauliq.app.presentation.components.SearchBar
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrdersScreen(
    viewModel: OrderViewModel,
    onNavigateToOrderDetails: (String) -> Unit,
    onNavigateToCreateOrder: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    var searchQuery by remember { mutableStateOf("") }
    var selectedFilter by remember { mutableStateOf("All") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Orders & Shipments", fontWeight = FontWeight.Bold) },
                actions = {
                    IconButton(onClick = { /* Filter */ }) {
                        Icon(Icons.Default.FilterList, contentDescription = "Filter")
                    }
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onNavigateToCreateOrder,
                icon = { Icon(Icons.Default.Add, contentDescription = null) },
                text = { Text("New Order") },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // 1. Stats Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                SmallStatCard(
                    title = "Pending",
                    value = uiState.pendingCount.toString(),
                    color = WarningAmber,
                    modifier = Modifier.weight(1f)
                )
                SmallStatCard(
                    title = "Revenue",
                    value = "$${String.format("%.2f", uiState.totalRevenue)}",
                    color = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.weight(1f)
                )
            }

            // 2. Search and Filter
            SearchBar(
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                placeholder = "Search orders by ID or customer...",
                modifier = Modifier.padding(16.dp)
            )

            val filters = listOf("All", "Pending", "Processing", "Packed", "Shipped", "Delivered", "Cancelled")
            ScrollableTabRow(
                selectedTabIndex = filters.indexOf(selectedFilter),
                edgePadding = 16.dp,
                divider = {},
                containerColor = Color.Transparent,
                indicator = {}
            ) {
                filters.forEach { filter ->
                    FilterChip(
                        selected = selectedFilter == filter,
                        onClick = { selectedFilter = filter },
                        label = { Text(filter) },
                        modifier = Modifier.padding(horizontal = 4.dp)
                    )
                }
            }

            // 3. Orders List
            val filteredOrders = uiState.orders.filter {
                (it.customerName.contains(searchQuery, ignoreCase = true) || it.id.contains(searchQuery, ignoreCase = true)) &&
                (selectedFilter == "All" || it.status.name.equals(selectedFilter, ignoreCase = true))
            }

            if (filteredOrders.isEmpty()) {
                EmptyState(
                    title = "No Orders Found",
                    description = "We couldn't find any orders matching your criteria.",
                    icon = Icons.Default.ShoppingCart,
                    modifier = Modifier.weight(1f)
                )
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(filteredOrders) { order ->
                        OrderCard(order = order, onClick = { onNavigateToOrderDetails(order.id) })
                    }
                }
            }
        }
    }
}

@Composable
fun OrderCard(order: Order, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        onClick = onClick
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                ) {
                    Text(
                        text = order.id,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        fontWeight = FontWeight.Black,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                StatusChip(status = order.status)
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            Text(
                text = order.customerName,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Black
            )
            
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Event,
                            contentDescription = null,
                            modifier = Modifier.size(14.dp),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(Date(order.orderDate)),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    val priorityColor = when(order.priority) {
                        OrderPriority.HIGH -> ErrorRed
                        OrderPriority.MEDIUM -> WarningAmber
                        OrderPriority.LOW -> MaterialTheme.colorScheme.primary
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(modifier = Modifier.size(6.dp).background(priorityColor, CircleShape))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "${order.priority.name} Priority",
                            style = MaterialTheme.typography.labelSmall,
                            color = priorityColor,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Text(
                    text = "$${String.format(Locale.getDefault(), "%.2f", order.totalPrice)}",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Black,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Composable
fun StatusChip(status: OrderStatus) {
    val color = when(status) {
        OrderStatus.PENDING -> WarningAmber
        OrderStatus.PROCESSING -> MaterialTheme.colorScheme.primary
        OrderStatus.PACKED -> Color(0xFF9C27B0)
        OrderStatus.SHIPPED -> Color(0xFF2196F3)
        OrderStatus.DELIVERED -> MaterialTheme.colorScheme.tertiary
        OrderStatus.CANCELLED -> ErrorRed
    }
    
    Surface(
        shape = CircleShape,
        color = color.copy(alpha = 0.1f)
    ) {
        Text(
            text = status.name,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
            style = MaterialTheme.typography.labelSmall,
            color = color,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun SmallStatCard(title: String, value: String, color: Color, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.1f))
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = title, style = MaterialTheme.typography.labelSmall, color = color)
            Text(text = value, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = color)
        }
    }
}
