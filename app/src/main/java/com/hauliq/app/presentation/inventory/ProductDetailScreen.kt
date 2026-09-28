package com.hauliq.app.presentation.inventory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hauliq.app.core.theme.ErrorRed
import com.hauliq.app.core.theme.WarningAmber
import com.hauliq.app.domain.model.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    productId: String,
    viewModel: InventoryViewModel,
    onNavigateBack: () -> Unit,
    onNavigateToEdit: (String) -> Unit
) {
    val product by viewModel.getProduct(productId).collectAsState(initial = null)
    var showDeleteDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Product Details") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { onNavigateToEdit(productId) }) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit")
                    }
                    IconButton(onClick = { showDeleteDialog = true }) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete", tint = ErrorRed)
                    }
                }
            )
        }
    ) { paddingValues ->
        product?.let { p ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                // Image and Status Header
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Inventory2,
                        contentDescription = null,
                        modifier = Modifier.size(80.dp),
                        tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = p.name,
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "SKU: ${p.sku}",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    StockStatusChip(quantity = p.quantity, threshold = p.lowStockThreshold)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Details Card
                DetailSection(
                    title = "Inventory Information",
                    items = listOf(
                        DetailItem("Category", p.category, Icons.Default.Category),
                        DetailItem("Quantity", "${p.quantity} ${p.unit}", Icons.Default.Inventory),
                        DetailItem("Min. Stock", "${p.lowStockThreshold} ${p.unit}", Icons.Default.Warning),
                        DetailItem("Barcode", p.barcode, Icons.Default.QrCode)
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                DetailSection(
                    title = "Financial Details",
                    items = listOf(
                        DetailItem("Selling Price", "$${p.price}", Icons.Default.AttachMoney),
                        DetailItem("Cost Price", "$${p.cost}", Icons.Default.MoneyOff),
                        DetailItem("Supplier", p.supplierName, Icons.Default.Business)
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                DetailSection(
                    title = "Description",
                    items = listOf(
                        DetailItem("", p.description, Icons.Default.Description)
                    )
                )
            }
        }
    }

    if (showDeleteDialog) {
        AlertDialog(
            onDismissRequest = { showDeleteDialog = false },
            title = { Text("Delete Product") },
            text = { Text("Are you sure you want to delete this product? This action cannot be undone.") },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.deleteProduct(productId)
                        showDeleteDialog = false
                        onNavigateBack()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = ErrorRed)
                ) {
                    Text("Delete")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDeleteDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
fun DetailSection(title: String, items: List<DetailItem>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            if (title.isNotEmpty()) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            items.forEachIndexed { index, item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Surface(
                        modifier = Modifier.size(32.dp),
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        if (item.label.isNotEmpty()) {
                            Text(
                                text = item.label,
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Text(
                            text = item.value,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
                if (index < items.size - 1) {
                    HorizontalDivider(
                        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 48.dp),
                        color = MaterialTheme.colorScheme.outline.copy(alpha = 0.05f)
                    )
                }
            }
        }
    }
}

data class DetailItem(val label: String, val value: String, val icon: ImageVector)

@Composable
fun StockStatusChip(quantity: Int, threshold: Int) {
    val statusColor = when {
        quantity == 0 -> ErrorRed
        quantity <= threshold -> WarningAmber
        else -> MaterialTheme.colorScheme.tertiary
    }
    val statusText = when {
        quantity == 0 -> "Out of Stock"
        quantity <= threshold -> "Low Stock"
        else -> "In Stock"
    }

    Surface(
        shape = CircleShape,
        color = statusColor.copy(alpha = 0.1f)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.size(8.dp).background(statusColor, CircleShape))
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = statusText,
                style = MaterialTheme.typography.labelMedium,
                color = statusColor,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
