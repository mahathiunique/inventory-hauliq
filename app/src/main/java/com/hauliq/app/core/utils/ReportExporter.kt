package com.hauliq.app.core.utils

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Color as AndroidColor
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.content.FileProvider
import com.hauliq.app.domain.model.Product
import com.hauliq.app.domain.model.Transaction
import com.hauliq.app.presentation.analytics.AnalyticsUiState
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object ReportExporter {

    fun exportAndShareCsv(
        context: Context,
        state: AnalyticsUiState,
        products: List<Product>,
        transactions: List<Transaction>
    ) {
        try {
            val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
            val filename = "HaulIQ_Inventory_Report_$timestamp.csv"
            val csvContent = buildCsvContent(state, products, transactions)

            val fileUri = saveFileToDownloadsOrStorage(
                context = context,
                filename = filename,
                mimeType = "text/csv",
                contentBytes = csvContent.toByteArray(Charsets.UTF_8)
            )

            if (fileUri != null) {
                shareFile(context, fileUri, "text/csv", "HaulIQ CSV Report ($filename)")
                Toast.makeText(context, "CSV downloaded: $filename", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, "Failed to save CSV file", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(context, "Error exporting CSV: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
        }
    }

    fun exportAndSharePdf(
        context: Context,
        state: AnalyticsUiState,
        products: List<Product>,
        transactions: List<Transaction>
    ) {
        try {
            val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
            val filename = "HaulIQ_Analytics_Report_$timestamp.pdf"
            val pdfBytes = generatePdfDocument(state, products, transactions)

            val fileUri = saveFileToDownloadsOrStorage(
                context = context,
                filename = filename,
                mimeType = "application/pdf",
                contentBytes = pdfBytes
            )

            if (fileUri != null) {
                shareFile(context, fileUri, "application/pdf", "HaulIQ PDF Report ($filename)")
                Toast.makeText(context, "PDF downloaded: $filename", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, "Failed to save PDF file", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(context, "Error exporting PDF: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
        }
    }

    private fun buildCsvContent(
        state: AnalyticsUiState,
        products: List<Product>,
        transactions: List<Transaction>
    ): String {
        val sb = StringBuilder()
        val dateStr = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())

        sb.append("HAULIQ INVENTORY & ANALYTICS REPORT\n")
        sb.append("Generated on,$dateStr\n")
        sb.append("Total Inventory Items,${state.totalInventoryCount}\n")
        sb.append("Total Valuation,$${String.format(Locale.getDefault(), "%.2f", state.totalInventoryValue)}\n")
        sb.append("Low Stock Items,${state.lowStockCount}\n")
        sb.append("Out of Stock Items,${state.outOfStockCount}\n")
        sb.append("Total Revenue,$${String.format(Locale.getDefault(), "%.2f", state.totalRevenue)}\n")
        sb.append("\n")

        sb.append("--- INVENTORY PRODUCTS ---\n")
        sb.append("ID,Name,SKU,Category,Quantity,Unit,Price,Cost,Total Value,Min Stock,Supplier\n")
        products.forEach { p ->
            val totalVal = p.price * p.quantity
            sb.append("\"${escapeCsv(p.id)}\",\"${escapeCsv(p.name)}\",\"${escapeCsv(p.sku)}\",\"${escapeCsv(p.category)}\",${p.quantity},\"${escapeCsv(p.unit)}\",${p.price},${p.cost},$totalVal,${p.lowStockThreshold},\"${escapeCsv(p.supplierName)}\"\n")
        }
        sb.append("\n")

        sb.append("--- RECENT TRANSACTIONS ---\n")
        sb.append("Transaction ID,Date,Type,Product Name,Quantity,Performed By\n")
        transactions.forEach { t ->
            val dt = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(Date(t.timestamp))
            sb.append("\"${escapeCsv(t.id)}\",\"$dt\",\"${t.type.name}\",\"${escapeCsv(t.productName)}\",${t.quantity},\"${escapeCsv(t.performedBy)}\"\n")
        }

        return sb.toString()
    }

    private fun escapeCsv(str: String): String {
        return str.replace("\"", "\"\"")
    }

    private fun generatePdfDocument(
        state: AnalyticsUiState,
        products: List<Product>,
        transactions: List<Transaction>
    ): ByteArray {
        val document = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(595, 842, 1).create() // A4
        val page = document.startPage(pageInfo)
        val canvas = page.canvas

        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = AndroidColor.DKGRAY
            textSize = 10f
        }
        val boldPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = AndroidColor.BLACK
            textSize = 11f
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        }

        // Header Background Banner
        paint.color = AndroidColor.parseColor("#0F172A")
        canvas.drawRect(0f, 0f, 595f, 75f, paint)

        // Header Text
        boldPaint.color = AndroidColor.WHITE
        boldPaint.textSize = 18f
        canvas.drawText("HAULIQ INVENTORY & ANALYTICS REPORT", 24f, 38f, boldPaint)

        textPaint.color = AndroidColor.parseColor("#94A3B8")
        textPaint.textSize = 9f
        val dateStr = SimpleDateFormat("MMM dd, yyyy HH:mm:ss", Locale.getDefault()).format(Date())
        canvas.drawText("Enterprise Inventory Management • Generated on $dateStr", 24f, 56f, textPaint)

        // KPI Summary Box
        paint.color = AndroidColor.parseColor("#F1F5F9")
        canvas.drawRoundRect(24f, 90f, 571f, 150f, 8f, 8f, paint)

        val kpiTitles = listOf("Total Items", "Total Value", "Low Stock", "Total Revenue")
        val kpiValues = listOf(
            "${state.totalInventoryCount} units",
            "$${String.format(Locale.getDefault(), "%.0f", state.totalInventoryValue)}",
            "${state.lowStockCount} items",
            "$${String.format(Locale.getDefault(), "%.2f", state.totalRevenue)}"
        )

        boldPaint.color = AndroidColor.parseColor("#0F172A")
        boldPaint.textSize = 13f
        textPaint.color = AndroidColor.parseColor("#64748B")
        textPaint.textSize = 8.5f

        val colWidth = (571f - 24f) / 4f
        for (i in 0..3) {
            val startX = 24f + (i * colWidth) + 12f
            canvas.drawText(kpiTitles[i], startX, 112f, textPaint)
            canvas.drawText(kpiValues[i], startX, 134f, boldPaint)
        }

        // Section Title: Inventory Items
        boldPaint.color = AndroidColor.parseColor("#0F172A")
        boldPaint.textSize = 12f
        canvas.drawText("Current Inventory Products (${products.size} records)", 24f, 175f, boldPaint)

        // Table Header
        paint.color = AndroidColor.parseColor("#E2E8F0")
        canvas.drawRect(24f, 185f, 571f, 205f, paint)

        boldPaint.textSize = 8.5f
        boldPaint.color = AndroidColor.parseColor("#334155")
        canvas.drawText("SKU", 30f, 198f, boldPaint)
        canvas.drawText("Product Name", 100f, 198f, boldPaint)
        canvas.drawText("Category", 260f, 198f, boldPaint)
        canvas.drawText("Stock", 370f, 198f, boldPaint)
        canvas.drawText("Price", 430f, 198f, boldPaint)
        canvas.drawText("Status", 500f, 198f, boldPaint)

        // Table Rows
        var currentY = 222f
        textPaint.color = AndroidColor.parseColor("#1E293B")
        textPaint.textSize = 8.5f

        val itemsToShow = products.take(15)
        itemsToShow.forEachIndexed { idx, p ->
            if (idx % 2 == 1) {
                paint.color = AndroidColor.parseColor("#F8FAFC")
                canvas.drawRect(24f, currentY - 14f, 571f, currentY + 6f, paint)
            }

            canvas.drawText(p.sku.take(12), 30f, currentY, textPaint)
            canvas.drawText(p.name.take(28), 100f, currentY, textPaint)
            canvas.drawText(p.category.take(18), 260f, currentY, textPaint)
            canvas.drawText("${p.quantity} ${p.unit}", 370f, currentY, textPaint)
            canvas.drawText("$${String.format(Locale.getDefault(), "%.2f", p.price)}", 430f, currentY, textPaint)

            val statusText = if (p.quantity == 0) "OUT OF STOCK" else if (p.quantity <= p.lowStockThreshold) "LOW STOCK" else "IN STOCK"
            val statusColor = if (p.quantity == 0) AndroidColor.RED else if (p.quantity <= p.lowStockThreshold) AndroidColor.parseColor("#D97706") else AndroidColor.parseColor("#16A34A")
            boldPaint.color = statusColor
            boldPaint.textSize = 7.5f
            canvas.drawText(statusText, 500f, currentY, boldPaint)

            currentY += 18f
        }

        // Section Title: Recent Transactions
        currentY += 15f
        boldPaint.color = AndroidColor.parseColor("#0F172A")
        boldPaint.textSize = 12f
        canvas.drawText("Recent Activity Log", 24f, currentY, boldPaint)

        currentY += 12f
        paint.color = AndroidColor.parseColor("#E2E8F0")
        canvas.drawRect(24f, currentY, 571f, currentY + 20f, paint)

        boldPaint.textSize = 8.5f
        boldPaint.color = AndroidColor.parseColor("#334155")
        canvas.drawText("Date", 30f, currentY + 13f, boldPaint)
        canvas.drawText("Type", 120f, currentY + 13f, boldPaint)
        canvas.drawText("Product", 200f, currentY + 13f, boldPaint)
        canvas.drawText("Quantity", 400f, currentY + 13f, boldPaint)
        canvas.drawText("User", 490f, currentY + 13f, boldPaint)

        currentY += 32f
        transactions.take(8).forEachIndexed { idx, t ->
            if (idx % 2 == 1) {
                paint.color = AndroidColor.parseColor("#F8FAFC")
                canvas.drawRect(24f, currentY - 14f, 571f, currentY + 6f, paint)
            }
            val dt = SimpleDateFormat("MMM dd, HH:mm", Locale.getDefault()).format(Date(t.timestamp))
            canvas.drawText(dt, 30f, currentY, textPaint)
            canvas.drawText(t.type.name, 120f, currentY, textPaint)
            canvas.drawText(t.productName.take(28), 200f, currentY, textPaint)
            canvas.drawText("${t.quantity} units", 400f, currentY, textPaint)
            canvas.drawText(t.performedBy.take(12), 490f, currentY, textPaint)

            currentY += 18f
        }

        // Footer
        paint.color = AndroidColor.parseColor("#CBD5E1")
        canvas.drawLine(24f, 800f, 571f, 800f, paint)

        textPaint.color = AndroidColor.parseColor("#94A3B8")
        textPaint.textSize = 8f
        canvas.drawText("HaulIQ Enterprise Inventory System • Confidential • Page 1 of 1", 24f, 816f, textPaint)
        canvas.drawText("https://hauliq.com", 490f, 816f, textPaint)

        document.finishPage(page)

        val outputStream = java.io.ByteArrayOutputStream()
        document.writeTo(outputStream)
        document.close()

        return outputStream.toByteArray()
    }

    private fun saveFileToDownloadsOrStorage(
        context: Context,
        filename: String,
        mimeType: String,
        contentBytes: ByteArray
    ): Uri? {
        // Save to public Downloads via MediaStore (Android 10+ / Q+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            try {
                val resolver = context.contentResolver
                val contentValues = ContentValues().apply {
                    put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
                    put(MediaStore.MediaColumns.MIME_TYPE, mimeType)
                    put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS + "/HaulIQ")
                }
                val uri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues)
                if (uri != null) {
                    resolver.openOutputStream(uri)?.use { os ->
                        os.write(contentBytes)
                        os.flush()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        // Also save to cache/reports so FileProvider can share it
        return try {
            val cacheDir = File(context.cacheDir, "reports").apply { if (!exists()) mkdirs() }
            val file = File(cacheDir, filename)
            FileOutputStream(file).use { fos ->
                fos.write(contentBytes)
                fos.flush()
            }
            FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", file)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private fun shareFile(context: Context, uri: Uri, mimeType: String, title: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = mimeType
            putExtra(Intent.EXTRA_STREAM, uri)
            putExtra(Intent.EXTRA_SUBJECT, title)
            putExtra(Intent.EXTRA_TEXT, "Here is the exported $title from HaulIQ.")
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        val chooser = Intent.createChooser(intent, "Download / Share $title").apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(chooser)
    }
}
