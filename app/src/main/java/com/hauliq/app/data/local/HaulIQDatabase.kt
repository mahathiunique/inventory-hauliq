package com.hauliq.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hauliq.app.data.local.dao.InventoryDao
import com.hauliq.app.data.local.dao.NotificationDao
import com.hauliq.app.data.local.dao.OrderDao
import com.hauliq.app.data.local.dao.SupplierDao
import com.hauliq.app.data.local.dao.TransactionDao
import com.hauliq.app.data.local.entity.*

@Database(
    entities = [
        InventoryEntity::class, 
        OrderEntity::class, 
        OrderItemEntity::class,
        SupplierEntity::class,
        TransactionEntity::class,
        NotificationEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class HaulIQDatabase : RoomDatabase() {
    abstract fun inventoryDao(): InventoryDao
    abstract fun orderDao(): OrderDao
    abstract fun supplierDao(): SupplierDao
    abstract fun transactionDao(): TransactionDao
    abstract fun notificationDao(): NotificationDao
}
