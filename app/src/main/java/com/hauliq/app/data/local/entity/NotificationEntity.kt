package com.hauliq.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notifications")
data class NotificationEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val message: String,
    val timestamp: Long,
    val priority: String, // NotificationPriority.name
    val isRead: Boolean
)
