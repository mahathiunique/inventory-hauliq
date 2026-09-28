package com.hauliq.app.presentation.transactions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hauliq.app.R
import com.hauliq.app.core.components.EmptyState
import com.hauliq.app.core.theme.ErrorRed
import com.hauliq.app.core.theme.LightPrimary
import com.hauliq.app.core.theme.WarningAmber
import com.hauliq.app.core.utils.Formatters
import com.hauliq.app.domain.model.Transaction
import com.hauliq.app.domain.model.TransactionType

@Composable
fun TransactionsScreen(
    viewModel: TransactionsViewModel,
    modifier: Modifier = Modifier
) {
    val transactions by viewModel.filteredTransactions.collectAsState()
    val activeFilter by viewModel.selectedFilter.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Header info
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
                    text = "History",
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Black,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Text(
                text = "Intake logs, dispatches, and warehouse audits",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            Spacer(modifier = Modifier.height(16.dp))

            // Filters selector
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FilterTabButton(
                    text = "All Logs",
                    isSelected = activeFilter == null,
                    onClick = { viewModel.setFilter(null) },
                    modifier = Modifier.weight(1f)
                )
                FilterTabButton(
                    text = "Purchases",
                    isSelected = activeFilter == TransactionType.PURCHASE,
                    onClick = { viewModel.setFilter(TransactionType.PURCHASE) },
                    modifier = Modifier.weight(1f)
                )
                FilterTabButton(
                    text = "Sales",
                    isSelected = activeFilter == TransactionType.SALES,
                    onClick = { viewModel.setFilter(TransactionType.SALES) },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // Timeline Feed
        if (transactions.isEmpty()) {
            EmptyState(
                title = "No transactions found",
                description = "There are no matching logged records for this filter.",
                icon = Icons.Default.ReceiptLong,
                modifier = Modifier.weight(1f)
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(transactions) { tx ->
                    TransactionTimelineRow(transaction = tx)
                }
            }
        }
    }
}

@Composable
fun FilterTabButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
            contentColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant
        ),
        modifier = modifier.height(44.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
    }
}

@Composable
fun TransactionTimelineRow(
    transaction: Transaction,
    modifier: Modifier = Modifier
) {
    val (icon, tint, bg) = when (transaction.type) {
        TransactionType.PURCHASE -> Triple(
            Icons.Default.ArrowDownward,
            MaterialTheme.colorScheme.tertiary,
            MaterialTheme.colorScheme.tertiary.copy(alpha = 0.1f)
        )
        TransactionType.SALES -> Triple(
            Icons.Default.ArrowUpward,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
        )
        TransactionType.ADJUSTMENT -> Triple(
            Icons.Default.Tune,
            WarningAmber,
            WarningAmber.copy(alpha = 0.1f)
        )
    }

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = bg,
                modifier = Modifier.size(44.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(imageVector = icon, contentDescription = null, tint = tint)
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = transaction.productName,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Authorized by: ${transaction.performedBy}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Text(
                    text = Formatters.formatDateTime(transaction.timestamp),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Quantity indicator
            val prefix = if (transaction.quantity > 0) "+" else ""
            Text(
                text = "$prefix${transaction.quantity} units",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold,
                color = tint
            )
        }
    }
}
