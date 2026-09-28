package com.hauliq.app.presentation.dashboard

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hauliq.app.R
import com.hauliq.app.core.components.DashboardCard
import com.hauliq.app.core.theme.ErrorRed
import com.hauliq.app.core.theme.WarningAmber
import com.hauliq.app.domain.model.ActivityLog
import com.hauliq.app.domain.model.AiInsight
import com.hauliq.app.domain.model.InsightPriority
import com.hauliq.app.domain.model.LogType
import com.hauliq.app.presentation.components.SearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel,
    onNavigateToInventory: () -> Unit,
    onNavigateToScanner: () -> Unit,
    onNavigateToReports: () -> Unit,
    onNavigateToAnalytics: () -> Unit,
    onNavigateToNotifications: () -> Unit,
    onNavigateToOrders: () -> Unit,
    onNavigateToAiAssistant: () -> Unit,
    modifier: Modifier = Modifier
) {
    val stats by viewModel.stats.collectAsState()
    val activities by viewModel.activities.collectAsState()
    val aiInsights by viewModel.aiInsights.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // 1. Dashboard Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_hauliq_logo),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = "Good Morning,",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "Alex Mercer",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Black,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = onNavigateToNotifications,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notifications",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Surface(
                    modifier = Modifier.size(40.dp),
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Profile",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
        ) {
            // 2. Search Section
            SearchBar(
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                placeholder = "Search inventory/products...",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 3. AI Smart Insights
            if (aiInsights.isNotEmpty()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Smart AI Insights",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    TextButton(onClick = onNavigateToAiAssistant) {
                        Text("View Assistant")
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                aiInsights.forEach { insight ->
                    AiInsightDashboardCard(insight, onNavigateToAiAssistant)
                    Spacer(modifier = Modifier.height(8.dp))
                }
                Spacer(modifier = Modifier.height(24.dp))
            }

            // 4. Summary Cards
            Text(
                text = "Summary",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(12.dp))
            
            stats?.let { s ->
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    AnimatedDashboardCard(
                        title = "Total Inventory",
                        targetValue = s.totalProducts.toFloat(),
                        subtitle = "Items in stock",
                        icon = Icons.Default.Inventory,
                        iconColor = MaterialTheme.colorScheme.primary,
                        onClick = onNavigateToInventory,
                        modifier = Modifier.weight(1f)
                    )
                    AnimatedDashboardCard(
                        title = "Low Stock",
                        targetValue = s.lowStockCount.toFloat(),
                        subtitle = "Urgent attention",
                        icon = Icons.Default.Warning,
                        iconColor = WarningAmber,
                        onClick = onNavigateToInventory,
                        modifier = Modifier.weight(1f)
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    AnimatedDashboardCard(
                        title = "Pending Orders",
                        targetValue = s.pendingOrders.toFloat(),
                        subtitle = "To be processed",
                        icon = Icons.Default.ShoppingCart,
                        iconColor = MaterialTheme.colorScheme.secondary,
                        onClick = onNavigateToOrders,
                        modifier = Modifier.weight(1f)
                    )
                    AnimatedDashboardCard(
                        title = "Total Revenue",
                        targetValue = s.totalRevenue.toFloat(),
                        subtitle = "Overall sales",
                        icon = Icons.Default.Payments,
                        iconColor = MaterialTheme.colorScheme.tertiary,
                        onClick = onNavigateToAnalytics,
                        modifier = Modifier.weight(1f),
                        isCurrency = true
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // 4. Quick Actions
            Text(
                text = "Quick Actions",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                QuickActionButton(
                    title = "Add Item",
                    icon = Icons.Default.Add,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    onClick = onNavigateToInventory
                )
                QuickActionButton(
                    title = "Scan SKU",
                    icon = Icons.Default.QrCodeScanner,
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    onClick = onNavigateToScanner
                )
                QuickActionButton(
                    title = "Analytics",
                    icon = Icons.Default.BarChart,
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    onClick = onNavigateToAnalytics
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // 5. Recent Activity
            Text(
                text = "Recent Activity",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(12.dp))
            
            activities.take(5).forEach { activity ->
                ActivityItem(activity = activity)
                Spacer(modifier = Modifier.height(8.dp))
            }
            
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun AiInsightDashboardCard(insight: AiInsight, onClick: () -> Unit) {
    val color = when (insight.priority) {
        InsightPriority.HIGH -> MaterialTheme.colorScheme.error
        InsightPriority.MEDIUM -> WarningAmber
        InsightPriority.LOW -> MaterialTheme.colorScheme.primary
    }

    Card(
        modifier = Modifier.fillMaxWidth().clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.05f)),
        border = androidx.compose.foundation.BorderStroke(1.dp, color.copy(alpha = 0.2f))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.AutoAwesome,
                contentDescription = null,
                tint = color,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(text = insight.title, fontWeight = FontWeight.Bold, color = color, style = MaterialTheme.typography.bodyMedium)
                Text(text = insight.description, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}

@Composable
fun AnimatedDashboardCard(
    title: String,
    targetValue: Float,
    subtitle: String,
    icon: ImageVector,
    iconColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isCurrency: Boolean = false
) {
    val animatedValue by animateFloatAsState(
        targetValue = targetValue,
        animationSpec = tween(durationMillis = 1500, easing = FastOutSlowInEasing),
        label = "counter"
    )

    val displayValue = if (isCurrency) {
        "$${String.format(java.util.Locale.getDefault(), "%.0f", animatedValue)}"
    } else {
        animatedValue.toInt().toString()
    }

    DashboardCard(
        title = title,
        value = displayValue,
        subtitle = subtitle,
        icon = icon,
        iconColor = iconColor,
        onClick = onClick,
        modifier = modifier
    )
}

@Composable
fun QuickActionButton(
    title: String,
    icon: ImageVector,
    color: Color,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Surface(
            modifier = Modifier.size(64.dp),
            shape = RoundedCornerShape(20.dp),
            color = color
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = title, style = MaterialTheme.typography.labelMedium)
    }
}

@Composable
fun ActivityItem(activity: ActivityLog) {
    val icon = when (activity.type) {
        LogType.STOCK_IN -> Icons.Default.Add
        LogType.STOCK_OUT -> Icons.Default.Remove
        LogType.ALERT -> Icons.Default.PriorityHigh
        LogType.SYSTEM -> Icons.Default.Info
    }
    
    val color = when (activity.type) {
        LogType.STOCK_IN -> MaterialTheme.colorScheme.tertiary
        LogType.STOCK_OUT -> MaterialTheme.colorScheme.primary
        LogType.ALERT -> ErrorRed
        LogType.SYSTEM -> MaterialTheme.colorScheme.secondary
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(40.dp),
                shape = CircleShape,
                color = color.copy(alpha = 0.1f)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(imageVector = icon, contentDescription = null, tint = color, modifier = Modifier.size(20.dp))
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = activity.action, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyMedium)
                Text(text = activity.details, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            Text(
                text = "2h ago", // Simplified for placeholder
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
