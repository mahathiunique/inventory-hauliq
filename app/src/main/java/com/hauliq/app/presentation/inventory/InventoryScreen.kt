package com.hauliq.app.presentation.inventory

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Sort
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hauliq.app.core.components.*
import com.hauliq.app.core.theme.ErrorRed
import com.hauliq.app.core.theme.WarningAmber
import com.hauliq.app.domain.model.Product
import com.hauliq.app.presentation.components.SearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventoryScreen(
    viewModel: InventoryViewModel,
    onNavigateToDetails: (String) -> Unit,
    onNavigateToAddProduct: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val selectedCategory by viewModel.selectedCategory.collectAsState()
    
    var productToDelete by remember { mutableStateOf<Product?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Inventory Catalog", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Black) },
                actions = {
                    IconButton(onClick = { /* Sort logic */ }) {
                        Icon(Icons.AutoMirrored.Filled.Sort, contentDescription = "Sort")
                    }
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onNavigateToAddProduct,
                icon = { Icon(Icons.Default.Add, contentDescription = null) },
                text = { Text("Create Product") },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(16.dp)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // 1. Search Bar
            SearchBar(
                query = searchQuery,
                onQueryChange = { viewModel.onSearchQueryChange(it) },
                placeholder = "Search items, SKU, or tags...",
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
            )

            // 2. Category Chips
            val categories = listOf("All", "Electronics", "Furniture", "Office Supplies", "Machinery", "Consumables")
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categories) { category ->
                    FilterChip(
                        selected = selectedCategory == category,
                        onClick = { viewModel.onCategorySelect(category) },
                        label = { Text(category, fontWeight = if (selectedCategory == category) FontWeight.Bold else FontWeight.Normal) },
                        shape = RoundedCornerShape(12.dp)
                    )
                }
            }

            // 3. Inventory List with Animated Content Transition
            Box(modifier = Modifier.fillMaxSize()) {
                AnimatedContent(
                    targetState = uiState,
                    transitionSpec = {
                        fadeIn(animationSpec = tween(300)) togetherWith fadeOut(animationSpec = tween(300))
                    },
                    label = "inventory_content"
                ) { state ->
                    when (state) {
                        is InventoryUiState.Loading -> {
                            Column(modifier = Modifier.padding(16.dp)) {
                                repeat(6) {
                                    ShimmerEffect(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(110.dp)
                                            .padding(vertical = 8.dp)
                                    )
                                }
                            }
                        }
                        is InventoryUiState.Success -> {
                            val products = state.products
                            if (products.isEmpty()) {
                                EmptyState(
                                    title = "No Inventory Match",
                                    description = "Your search query did not return any results. Try adjusting the category or search keywords.",
                                    icon = Icons.Default.Inventory2,
                                    modifier = Modifier.fillMaxSize()
                                )
                            } else {
                                LazyColumn(
                                    modifier = Modifier.fillMaxSize(),
                                    contentPadding = PaddingValues(16.dp),
                                    verticalArrangement = Arrangement.spacedBy(16.dp)
                                ) {
                                    items(products, key = { it.id }) { product ->
                                        InventoryItemCard(
                                            product = product,
                                            onClick = { onNavigateToDetails(product.id) },
                                            onEdit = { /* Edit logic */ },
                                            onDelete = { productToDelete = product }
                                        )
                                    }
                                }
                            }
                        }
                        is InventoryUiState.Error -> {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                Text(text = state.message, color = MaterialTheme.colorScheme.error)
                            }
                        }
                    }
                }
            }
        }
    }

    // Confirmation Dialog
    productToDelete?.let { product ->
        ConfirmationDialog(
            showDialog = true,
            title = "Delete Product",
            message = "Are you sure you want to delete '${product.name}'? This action cannot be undone.",
            confirmText = "Delete",
            onConfirm = {
                viewModel.deleteProduct(product.id)
                productToDelete = null
            },
            onDismiss = { productToDelete = null }
        )
    }
}

@Composable
fun InventoryItemCard(
    product: Product,
    onClick: () -> Unit,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    val statusColor = when {
        product.quantity == 0 -> ErrorRed
        product.quantity <= product.lowStockThreshold -> WarningAmber
        else -> Color(0xFF10B981)
    }
    
    val statusText = when {
        product.quantity == 0 -> "OUT OF STOCK"
        product.quantity <= product.lowStockThreshold -> "LOW STOCK"
        else -> "IN STOCK"
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(70.dp),
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.Inventory2,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = product.name,
                    fontWeight = FontWeight.Black,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "${product.sku} • ${product.category}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    letterSpacing = 1.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = statusColor.copy(alpha = 0.1f)
                    ) {
                        Text(
                            text = statusText,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                            style = MaterialTheme.typography.labelSmall,
                            color = statusColor,
                            fontWeight = FontWeight.Black,
                            fontSize = 9.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "${product.quantity} ${product.unit}",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
            
            Column(horizontalAlignment = Alignment.End) {
                IconButton(onClick = onEdit) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit", tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(20.dp))
                }
                IconButton(onClick = onDelete) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete", tint = ErrorRed, modifier = Modifier.size(20.dp))
                }
            }
        }
    }
}
