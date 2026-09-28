package com.hauliq.app.presentation.notifications

import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hauliq.app.R
import com.hauliq.app.core.components.EmptyState
import com.hauliq.app.core.theme.ErrorRed
import com.hauliq.app.core.theme.WarningAmber
import com.hauliq.app.core.utils.Formatters
import com.hauliq.app.domain.model.NotificationItem
import com.hauliq.app.domain.model.NotificationPriority

@Composable
fun NotificationsScreen(
    viewModel: NotificationsViewModel,
    modifier: Modifier = Modifier
) {
    val notifications by viewModel.notifications.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_hauliq_logo),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "System Alerts",
                        style = MaterialTheme.typography.displaySmall,
                        fontWeight = FontWeight.Black,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                Text(
                    text = "Stock violations and batch updates",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            if (notifications.any { !it.isRead }) {
                TextButton(onClick = { viewModel.markAllAsRead() }) {
                    Text("Mark all read", fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        if (notifications.isEmpty()) {
            EmptyState(
                title = "All caught up!",
                description = "There are no notifications or stock alerts to display.",
                icon = Icons.Default.NotificationsActive,
                modifier = Modifier.weight(1f)
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(notifications, key = { it.id }) { item ->
                    NotificationRow(
                        item = item,
                        onClick = { viewModel.markAsRead(item.id) },
                        onDelete = { viewModel.deleteNotification(item.id) }
                    )
                }
            }
        }
    }
}

@Composable
fun NotificationRow(
    item: NotificationItem,
    onClick: () -> Unit,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    val indicatorColor = when (item.priority) {
        NotificationPriority.HIGH -> ErrorRed
        NotificationPriority.WARNING -> WarningAmber
        NotificationPriority.INFO -> MaterialTheme.colorScheme.primary
    }

    val cardBg = if (item.isRead) {
        MaterialTheme.colorScheme.surface
    } else {
        MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.25f)
    }

    Card(
        onClick = onClick,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = cardBg),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Status Circle
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(indicatorColor, shape = CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))

            // Body
            Column(modifier = Modifier.weight(1f)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = if (item.isRead) FontWeight.Bold else FontWeight.Black
                    )
                    if (!item.isRead) {
                        Spacer(modifier = Modifier.width(8.dp))
                        Surface(
                            shape = CircleShape,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(6.dp)
                        ) {}
                    }
                }
                Text(
                    text = item.message,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = Formatters.formatDateTime(item.timestamp),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Delete action
            IconButton(onClick = onDelete) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Dismiss",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                )
            }
        }
    }
}
