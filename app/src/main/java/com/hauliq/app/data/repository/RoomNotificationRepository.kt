package com.hauliq.app.data.repository

import com.hauliq.app.data.local.dao.NotificationDao
import com.hauliq.app.data.mapper.toEntity
import com.hauliq.app.data.mapper.toNotification
import com.hauliq.app.domain.model.NotificationItem
import com.hauliq.app.domain.repository.NotificationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomNotificationRepository @Inject constructor(
    private val notificationDao: NotificationDao
) : NotificationRepository {
    override fun getAllNotifications(): Flow<List<NotificationItem>> {
        return notificationDao.getAllNotifications().map { entities ->
            entities.map { it.toNotification() }
        }
    }

    override suspend fun markAsRead(id: String) {
        notificationDao.markAsRead(id)
    }

    override suspend fun markAllAsRead() {
        notificationDao.markAllAsRead()
    }

    override suspend fun deleteNotification(id: String) {
        notificationDao.deleteById(id)
    }

    override fun getUnreadCount(): Flow<Int> {
        return notificationDao.getUnreadCount()
    }

    override suspend fun addNotification(notification: NotificationItem) {
        notificationDao.insertNotification(notification.toEntity())
    }
}
