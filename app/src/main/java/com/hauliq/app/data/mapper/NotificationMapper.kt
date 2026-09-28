package com.hauliq.app.data.mapper

import com.hauliq.app.data.local.entity.NotificationEntity
import com.hauliq.app.domain.model.NotificationItem
import com.hauliq.app.domain.model.NotificationPriority

fun NotificationEntity.toNotification(): NotificationItem {
    return NotificationItem(
        id = id,
        title = title,
        message = message,
        timestamp = timestamp,
        priority = NotificationPriority.valueOf(priority),
        isRead = isRead
    )
}

fun NotificationItem.toEntity(): NotificationEntity {
    return NotificationEntity(
        id = id,
        title = title,
        message = message,
        timestamp = timestamp,
        priority = priority.name,
        isRead = isRead
    )
}
