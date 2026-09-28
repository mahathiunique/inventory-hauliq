package com.hauliq.app.presentation.reports

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
import com.hauliq.app.core.components.LoadingScreen
import com.hauliq.app.core.theme.LightPrimary
import com.hauliq.app.core.utils.Formatters
import com.hauliq.app.domain.model.ReportItem
import com.hauliq.app.domain.model.ReportType

@Composable
fun ReportsScreen(
    viewModel: ReportsViewModel,
    modifier: Modifier = Modifier
) {
    val reports by viewModel.reports.collectAsState()
    val isExporting by viewModel.isExporting.collectAsState()
    val statusMessage by viewModel.exportStatusMessage.collectAsState()

    var selectedReportType by remember { mutableStateOf(ReportType.INVENTORY) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Header
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_hauliq_logo),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Reports Center",
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Black,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Text(
                text = "Audit, reconcile, and export inventory data sheets",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 1. Report Selector & Export actions
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Compile Audit Report",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    // Report Type tab selector
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        ReportTab(
                            text = "Inventory",
                            isSelected = selectedReportType == ReportType.INVENTORY,
                            onClick = { selectedReportType = ReportType.INVENTORY },
                            modifier = Modifier.weight(1f)
                        )
                        ReportTab(
                            text = "Sales",
                            isSelected = selectedReportType == ReportType.SALES,
                            onClick = { selectedReportType = ReportType.SALES },
                            modifier = Modifier.weight(1f)
                        )
                        ReportTab(
                            text = "Purchases",
                            isSelected = selectedReportType == ReportType.PURCHASE,
                            onClick = { selectedReportType = ReportType.PURCHASE },
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Download Actions
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Button(
                            onClick = { viewModel.exportReport(selectedReportType, "PDF") },
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary
                            )
                        ) {
                            Icon(imageVector = Icons.Default.PictureAsPdf, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Export PDF", fontWeight = FontWeight.Bold)
                        }

                        Button(
                            onClick = { viewModel.exportReport(selectedReportType, "Excel") },
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.tertiary
                            )
                        ) {
                            Icon(imageVector = Icons.Default.Description, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Export Excel", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 2. Previously Generated Lists
            Text(
                text = "Recently Generated Documents",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(12.dp))

            if (reports.isEmpty()) {
                EmptyState(
                    title = "No Reports Generated",
                    description = "Use the options above to compile and export your first audit report.",
                    icon = Icons.Default.Description,
                    modifier = Modifier.weight(1f)
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(reports) { report ->
                        ReportRow(report = report)
                    }
                }
            }
        }

        // Export overlay
        if (isExporting || statusMessage != null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f)),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    modifier = Modifier.width(280.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator(
                            color = MaterialTheme.colorScheme.primary,
                            strokeWidth = 4.dp
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = statusMessage ?: "Processing...",
                            fontWeight = FontWeight.Medium,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ReportTab(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
            contentColor = if (isSelected) MaterialTheme.colorScheme.onSecondary else MaterialTheme.colorScheme.onSurfaceVariant
        ),
        modifier = modifier.height(38.dp)
    ) {
        Text(text = text, style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold, maxLines = 1)
    }
}

@Composable
fun ReportRow(
    report: ReportItem,
    modifier: Modifier = Modifier
) {
    val icon = if (report.fileFormat == "PDF") Icons.Default.PictureAsPdf else Icons.Default.Description
    val color = if (report.fileFormat == "PDF") MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.tertiary

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = color.copy(alpha = 0.1f),
                modifier = Modifier.size(44.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(imageVector = icon, contentDescription = null, tint = color)
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = report.title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Generated: ${Formatters.formatDate(report.dateGenerated)} • ${report.fileSize}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Download, contentDescription = "Download Report", tint = MaterialTheme.colorScheme.primary)
            }
        }
    }
}
