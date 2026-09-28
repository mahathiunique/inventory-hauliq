package com.hauliq.app.presentation.orders

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Notes
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hauliq.app.domain.model.Order
import com.hauliq.app.domain.model.OrderStatus
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderDetailsScreen(
    orderId: String,
    viewModel: OrderViewModel,
    onNavigateBack: () -> Unit
) {
    val order by viewModel.getOrder(orderId).collectAsState(initial = null)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Order Details") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        order?.let { o ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // 1. Order Status & Header
                Card(
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "Order ID: ${o.id}", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
                            StatusChip(status = o.status)
                        }
                        if (o.trackingNumber != null) {
                            Text(text = "Tracking: ${o.trackingNumber}", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "Total Amount", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Text(text = "$${String.format("%.2f", o.totalPrice)}", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.ExtraBold)
                    }
                }

                // 2. Shipment Timeline
                TimelineSection(currentStatus = o.status, onStatusUpdate = { viewModel.updateOrderStatus(o.id, it) })

                // 3. Customer Info
                SectionTitle(title = "Customer Information")
                DetailInfoCard(
                    items = listOf(
                        DetailRow("Name", o.customerName, Icons.Default.Person),
                        DetailRow("Phone", o.customerPhone, Icons.Default.Phone),
                        DetailRow("Shipping Address", o.shippingAddress, Icons.Default.LocalShipping),
                        DetailRow("Notes", o.notes ?: "No special instructions", Icons.AutoMirrored.Filled.Notes)
                    )
                )

                // 4. Order Items
                SectionTitle(title = "Ordered Items")
                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        o.items.forEach { item ->
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(text = item.productName, fontWeight = FontWeight.SemiBold)
                                    Text(text = "${item.quantity} x $${item.pricePerUnit}", style = MaterialTheme.typography.bodySmall)
                                }
                                Text(text = "$${String.format("%.2f", item.quantity * item.pricePerUnit)}", fontWeight = FontWeight.Bold)
                            }
                            if (o.items.last() != item) HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp), color = MaterialTheme.colorScheme.outline.copy(alpha = 0.1f))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TimelineSection(currentStatus: OrderStatus, onStatusUpdate: (OrderStatus) -> Unit) {
    val statuses = OrderStatus.values().filter { it != OrderStatus.CANCELLED }
    
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Tracking Status", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleSmall)
            Spacer(modifier = Modifier.height(16.dp))
            
            statuses.forEachIndexed { index, status ->
                val isCompleted = status.ordinal <= currentStatus.ordinal
                val isCurrent = status == currentStatus
                
                Row(verticalAlignment = Alignment.Top) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(if (isCompleted) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            if (isCompleted) Icon(Icons.Default.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
                        }
                        if (index < statuses.size - 1) {
                            Box(
                                modifier = Modifier
                                    .width(2.dp)
                                    .height(30.dp)
                                    .background(if (isCompleted && index < currentStatus.ordinal) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = status.name.replace("_", " ").lowercase().capitalize(Locale.ROOT),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Normal,
                            color = if (isCompleted) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        if (isCurrent) {
                            TextButton(onClick = { 
                                val nextIndex = index + 1
                                if (nextIndex < statuses.size) onStatusUpdate(statuses[nextIndex])
                            }) {
                                Text("Update to Next Stage")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(text = title, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
}

@Composable
fun DetailInfoCard(items: List<DetailRow>) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            items.forEach { item ->
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 8.dp)) {
                    Surface(
                        modifier = Modifier.size(36.dp),
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(imageVector = item.icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(18.dp))
                        }
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(text = item.label, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Text(text = item.value, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }
    }
}

data class DetailRow(val label: String, val value: String, val icon: ImageVector)
