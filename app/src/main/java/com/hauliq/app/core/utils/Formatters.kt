package com.hauliq.app.core.utils

import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Formatters {
    fun formatCurrency(amount: Double): String {
        val format = NumberFormat.getCurrencyInstance(Locale.US)
        return format.format(amount)
    }

    fun formatDate(timestamp: Long): String {
        val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }

    fun formatDateTime(timestamp: Long): String {
        val sdf = SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }

    fun formatPercentage(value: Double): String {
        return String.format(Locale.getDefault(), "%.1f%%", value)
    }
}
