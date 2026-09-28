package com.hauliq.app.presentation.suppliers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Business
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hauliq.app.R
import com.hauliq.app.core.components.CustomSearchBar
import com.hauliq.app.core.components.EmptyState
import com.hauliq.app.core.components.PrimaryButton
import com.hauliq.app.core.components.SupplierCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SupplierScreen(
    viewModel: SupplierViewModel,
    modifier: Modifier = Modifier
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val suppliers by viewModel.filteredSuppliers.collectAsState()
    
    var showAddSupplierSheet by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddSupplierSheet = true },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(16.dp)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Supplier")
            }
        },
        modifier = modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValues)
        ) {
            // Header
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_hauliq_logo),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Suppliers",
                        style = MaterialTheme.typography.displaySmall,
                        fontWeight = FontWeight.Black,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                Text(
                    text = "Logistics partners & providers registry",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(24.dp))
                CustomSearchBar(
                    query = searchQuery,
                    onQueryChange = { viewModel.setSearchQuery(it) },
                    onFilterClick = {},
                    placeholder = "Search supplier name, categories..."
                )
            }

            // List of Suppliers
            if (suppliers.isEmpty()) {
                EmptyState(
                    title = "No suppliers found",
                    description = "Try verifying your search query spelling.",
                    icon = Icons.Default.Business,
                    modifier = Modifier.weight(1f)
                )
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize().weight(1f),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(suppliers, key = { it.id }) { supplier ->
                        SupplierCard(
                            supplier = supplier,
                            onClick = {}
                        )
                    }
                }
            }
        }

        // Add Supplier Bottom Sheet
        if (showAddSupplierSheet) {
            ModalBottomSheet(
                onDismissRequest = { showAddSupplierSheet = false },
                shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
                containerColor = MaterialTheme.colorScheme.surface
            ) {
                AddSupplierForm(
                    onSave = { name, contact, email, phone, address, categories ->
                        viewModel.addSupplier(name, contact, email, phone, address, categories)
                        showAddSupplierSheet = false
                    },
                    onCancel = { showAddSupplierSheet = false }
                )
            }
        }
    }
}

@Composable
fun AddSupplierForm(
    onSave: (String, String, String, String, String, List<String>) -> Unit,
    onCancel: () -> Unit,
    modifier: Modifier = Modifier
) {
    var name by remember { mutableStateOf("") }
    var contact by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var categoriesStr by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Register New Supplier",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Supplier Name *") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = contact,
            onValueChange = { contact = it },
            label = { Text("Contact Person *") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email Address *") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Phone Number *") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Warehouse Address") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = categoriesStr,
            onValueChange = { categoriesStr = it },
            label = { Text("Categories supplied (comma separated)") },
            placeholder = { Text("Electronics, Office Supplies") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedButton(
                onClick = onCancel,
                modifier = Modifier.weight(1f)
            ) {
                Text("Cancel")
            }
            Button(
                onClick = {
                    val cats = categoriesStr.split(",").map { it.trim() }.filter { it.isNotEmpty() }
                    onSave(name, contact, email, phone, address, cats)
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Save")
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
    }
}
