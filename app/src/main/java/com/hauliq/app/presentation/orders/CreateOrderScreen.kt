package com.hauliq.app.presentation.orders

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.hauliq.app.domain.model.*
import com.hauliq.app.presentation.components.PrimaryButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateOrderScreen(
    viewModel: OrderViewModel,
    onNavigateBack: () -> Unit
) {
    val state by viewModel.createOrderState.collectAsState()
    val inventory by viewModel.getInventory().collectAsState(initial = emptyList())
    
    var showProductPicker by remember { mutableStateOf(false) }

    LaunchedEffect(state.saveSuccess) {
        if (state.saveSuccess) {
            onNavigateBack()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Create New Order") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 1. Customer Details
            SectionTitle(title = "Customer Details")
            OutlinedTextField(
                value = state.customerName,
                onValueChange = { viewModel.onCreateOrderEvent(CreateOrderEvent.CustomerNameChanged(it)) },
                label = { Text("Customer Name*") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )
            OutlinedTextField(
                value = state.customerPhone,
                onValueChange = { viewModel.onCreateOrderEvent(CreateOrderEvent.CustomerPhoneChanged(it)) },
                label = { Text("Phone Number") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                shape = RoundedCornerShape(12.dp)
            )
            OutlinedTextField(
                value = state.shippingAddress,
                onValueChange = { viewModel.onCreateOrderEvent(CreateOrderEvent.ShippingAddressChanged(it)) },
                label = { Text("Shipping Address*") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 2,
                shape = RoundedCornerShape(12.dp)
            )

            // 2. Select Items
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SectionTitle(title = "Order Items")
                TextButton(onClick = { showProductPicker = true }) {
                    Icon(Icons.Default.Add, contentDescription = null)
                    Text("Add Product")
                }
            }

            if (state.selectedItems.isEmpty()) {
                Text("No items added yet", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
            } else {
                state.selectedItems.forEach { item ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = item.productName, fontWeight = FontWeight.Bold)
                                Text(text = "$${item.pricePerUnit} per unit", style = MaterialTheme.typography.bodySmall)
                                
                                // Show remaining inventory if we have it
                                inventory.find { it.id == item.productId }?.let { prod ->
                                    Text(
                                        text = "Remaining after order: ${prod.quantity - item.quantity}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = if (prod.quantity - item.quantity < 5) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                            Text(text = "Qty: ${item.quantity}", fontWeight = FontWeight.SemiBold)
                            IconButton(onClick = { viewModel.onCreateOrderEvent(CreateOrderEvent.RemoveItem(item.productId)) }) {
                                Icon(Icons.Default.Delete, contentDescription = "Remove", tint = MaterialTheme.colorScheme.error)
                            }
                        }
                    }
                }
            }

            // 3. Priority
            SectionTitle(title = "Delivery Priority")
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OrderPriority.values().forEach { priority ->
                    FilterChip(
                        selected = state.priority == priority,
                        onClick = { viewModel.onCreateOrderEvent(CreateOrderEvent.PriorityChanged(priority)) },
                        label = { Text(priority.name) },
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            // 4. Notes
            SectionTitle(title = "Additional Notes")
            OutlinedTextField(
                value = state.notes,
                onValueChange = { viewModel.onCreateOrderEvent(CreateOrderEvent.NotesChanged(it)) },
                label = { Text("Order Notes (Optional)") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 3,
                shape = RoundedCornerShape(12.dp)
            )

            // 5. Summary
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Total Amount", fontWeight = FontWeight.Bold)
                Text(
                    text = "$${String.format("%.2f", state.selectedItems.sumOf { it.quantity * it.pricePerUnit })}",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            PrimaryButton(
                text = "Place Order",
                onClick = { viewModel.onCreateOrderEvent(CreateOrderEvent.SubmitOrder) },
                enabled = !state.isSaving
            )
            
            if (state.error != null) {
                Text(text = state.error!!, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
            }
        }
    }

    if (showProductPicker) {
        ProductPickerDialog(
            inventory = inventory,
            onProductSelected = { product, qty ->
                viewModel.onCreateOrderEvent(CreateOrderEvent.AddItem(product, qty))
                showProductPicker = false
            },
            onDismiss = { showProductPicker = false }
        )
    }
}

@Composable
fun ProductPickerDialog(
    inventory: List<Product>,
    onProductSelected: (Product, Int) -> Unit,
    onDismiss: () -> Unit
) {
    var selectedProduct by remember { mutableStateOf<Product?>(null) }
    var quantity by remember { mutableStateOf("1") }
    var error by remember { mutableStateOf<String?>(null) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(if (selectedProduct == null) "Select Product" else "Enter Quantity") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                if (selectedProduct == null) {
                    LazyColumn(modifier = Modifier.heightIn(max = 400.dp)) {
                        items(inventory) { product ->
                            ListItem(
                                headlineContent = { Text(product.name) },
                                supportingContent = { 
                                    Text(
                                        text = "Stock: ${product.quantity} | $${product.price}",
                                        color = if (product.quantity <= 0) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant
                                    ) 
                                },
                                modifier = Modifier.clickable(enabled = product.quantity > 0) { 
                                    selectedProduct = product 
                                },
                                colors = ListItemDefaults.colors(
                                    containerColor = if (product.quantity <= 0) MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f) else Color.Transparent
                                )
                            )
                        }
                    }
                } else {
                    val product = selectedProduct!!
                    Text("Selected: ${product.name}", fontWeight = FontWeight.Bold)
                    Text("Available Stock: ${product.quantity}", style = MaterialTheme.typography.bodySmall)
                    
                    OutlinedTextField(
                        value = quantity,
                        onValueChange = { 
                            quantity = it
                            val q = it.toIntOrNull()
                            error = when {
                                q == null -> "Invalid quantity"
                                q <= 0 -> "Quantity must be greater than 0"
                                q > product.quantity -> "Only ${product.quantity} units available"
                                else -> null
                            }
                        },
                        label = { Text("Quantity") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        isError = error != null,
                        modifier = Modifier.fillMaxWidth(),
                        supportingText = {
                            if (error != null) {
                                Text(error!!, color = MaterialTheme.colorScheme.error)
                            }
                        }
                    )
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    selectedProduct?.let { 
                        val q = quantity.toIntOrNull() ?: 1
                        if (q > 0 && q <= it.quantity) {
                            onProductSelected(it, q)
                        }
                    }
                },
                enabled = selectedProduct != null && error == null && quantity.isNotBlank()
            ) {
                Text("Add to Order")
            }
        },
        dismissButton = {
            TextButton(onClick = { if (selectedProduct != null) { selectedProduct = null; error = null } else onDismiss() }) {
                Text(if (selectedProduct != null) "Back" else "Cancel")
            }
        }
    )
}
