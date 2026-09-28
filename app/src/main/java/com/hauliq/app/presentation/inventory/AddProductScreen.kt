package com.hauliq.app.presentation.inventory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.hauliq.app.core.components.LoadingScreen
import com.hauliq.app.core.components.PrimaryButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreen(
    productId: String?,
    viewModel: InventoryViewModel,
    onNavigateBack: () -> Unit
) {
    val formState by viewModel.formState.collectAsState()
    val scrollState = rememberScrollState()

    LaunchedEffect(productId) {
        if (productId != null) {
            // Load existing product
            // Handled by viewmodel load logic called from nav graph usually, 
            // but let's ensure it's reset if adding new
        } else {
            viewModel.onFormEvent(InventoryFormEvent.ResetForm)
        }
    }

    LaunchedEffect(formState.saveSuccess) {
        if (formState.saveSuccess) {
            onNavigateBack()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (productId == null) "Add Product" else "Edit Product") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Image Picker Placeholder
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Default.AddPhotoAlternate, contentDescription = null, modifier = Modifier.size(48.dp))
                        Text("Add Product Image", style = MaterialTheme.typography.labelMedium)
                    }
                }

                // Form Fields
                InventoryTextField(
                    value = formState.name,
                    onValueChange = { viewModel.onFormEvent(InventoryFormEvent.NameChanged(it)) },
                    label = "Item Name*",
                    error = formState.nameError,
                    leadingIcon = Icons.Default.Inventory
                )

                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    InventoryTextField(
                        value = formState.sku,
                        onValueChange = { viewModel.onFormEvent(InventoryFormEvent.SkuChanged(it)) },
                        label = "SKU*",
                        error = formState.skuError,
                        modifier = Modifier.weight(1f)
                    )
                    InventoryTextField(
                        value = formState.barcode,
                        onValueChange = { viewModel.onFormEvent(InventoryFormEvent.BarcodeChanged(it)) },
                        label = "Barcode",
                        modifier = Modifier.weight(1f)
                    )
                }

                InventoryTextField(
                    value = formState.category,
                    onValueChange = { viewModel.onFormEvent(InventoryFormEvent.CategoryChanged(it)) },
                    label = "Category*",
                    leadingIcon = Icons.Default.Category
                )

                InventoryTextField(
                    value = formState.supplierName,
                    onValueChange = { viewModel.onFormEvent(InventoryFormEvent.SupplierChanged(it)) },
                    label = "Supplier",
                    leadingIcon = Icons.Default.Business
                )

                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    InventoryTextField(
                        value = formState.price,
                        onValueChange = { viewModel.onFormEvent(InventoryFormEvent.PriceChanged(it)) },
                        label = "Selling Price*",
                        error = formState.priceError,
                        keyboardType = KeyboardType.Decimal,
                        modifier = Modifier.weight(1f)
                    )
                    InventoryTextField(
                        value = formState.cost,
                        onValueChange = { viewModel.onFormEvent(InventoryFormEvent.CostChanged(it)) },
                        label = "Cost Price",
                        keyboardType = KeyboardType.Decimal,
                        modifier = Modifier.weight(1f)
                    )
                }

                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    InventoryTextField(
                        value = formState.quantity,
                        onValueChange = { viewModel.onFormEvent(InventoryFormEvent.QuantityChanged(it)) },
                        label = "Quantity*",
                        error = formState.quantityError,
                        keyboardType = KeyboardType.Number,
                        modifier = Modifier.weight(1f)
                    )
                    InventoryTextField(
                        value = formState.minStock,
                        onValueChange = { viewModel.onFormEvent(InventoryFormEvent.MinStockChanged(it)) },
                        label = "Min. Stock",
                        keyboardType = KeyboardType.Number,
                        modifier = Modifier.weight(1f)
                    )
                }

                InventoryTextField(
                    value = formState.description,
                    onValueChange = { viewModel.onFormEvent(InventoryFormEvent.DescriptionChanged(it)) },
                    label = "Description",
                    singleLine = false,
                    modifier = Modifier.height(100.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                PrimaryButton(
                    text = if (productId == null) "Save Product" else "Update Product",
                    onClick = { viewModel.onFormEvent(InventoryFormEvent.Save(productId)) },
                    enabled = !formState.isSaving
                )
                
                TextButton(
                    onClick = onNavigateBack,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Cancel")
                }
            }

            if (formState.isSaving) {
                LoadingScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventoryTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    error: String? = null,
    leadingIcon: ImageVector? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    singleLine: Boolean = true
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            modifier = Modifier.fillMaxWidth(),
            isError = error != null,
            leadingIcon = if (leadingIcon != null) {
                { Icon(imageVector = leadingIcon, contentDescription = null) }
            } else null,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            singleLine = singleLine,
            shape = RoundedCornerShape(12.dp)
        )
        if (error != null) {
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }
    }
}
