package com.hauliq.app.domain.repository

import com.hauliq.app.domain.model.NotificationItem
import kotlinx.coroutines.flow.Flow

interface NotificationRepository {
    fun getAllNotifications(): Flow<List<NotificationItem>>
    suspend fun markAsRead(id: String)
    suspend fun markAllAsRead()
    suspend fun deleteNotification(id: String)
    fun getUnreadCount(): Flow<Int>
    suspend fun addNotification(notification: NotificationItem)
}
