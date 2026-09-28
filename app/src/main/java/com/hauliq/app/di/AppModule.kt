package com.hauliq.app.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hauliq.app.data.local.HaulIQDatabase
import com.hauliq.app.data.local.dao.*
import com.hauliq.app.data.local.entity.InventoryEntity
import com.hauliq.app.data.mapper.*
import com.hauliq.app.data.repository.*
import com.hauliq.app.domain.model.Product
import com.hauliq.app.domain.model.SampleData
import com.hauliq.app.domain.repository.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindInventoryRepository(
        roomInventoryRepository: RoomInventoryRepository
    ): InventoryRepository

    @Binds
    @Singleton
    abstract fun bindOrderRepository(
        roomOrderRepository: RoomOrderRepository
    ): OrderRepository

    @Binds
    @Singleton
    abstract fun bindAnalyticsRepository(
        analyticsRepositoryImpl: AnalyticsRepositoryImpl
    ): AnalyticsRepository

    @Binds
    @Singleton
    abstract fun bindAiAssistantRepository(
        aiAssistantRepositoryImpl: AiAssistantRepositoryImpl
    ): AiAssistantRepository

    @Binds
    @Singleton
    abstract fun bindSupplierRepository(
        roomSupplierRepository: RoomSupplierRepository
    ): SupplierRepository

    @Binds
    @Singleton
    abstract fun bindTransactionRepository(
        roomTransactionRepository: RoomTransactionRepository
    ): TransactionRepository

    @Binds
    @Singleton
    abstract fun bindNotificationRepository(
        roomNotificationRepository: RoomNotificationRepository
    ): NotificationRepository

    companion object {
        @Provides
        @Singleton
        fun provideDatabase(
            @ApplicationContext context: Context,
            inventoryDaoProvider: Provider<InventoryDao>,
            supplierDaoProvider: Provider<SupplierDao>,
            transactionDaoProvider: Provider<TransactionDao>,
            notificationDaoProvider: Provider<NotificationDao>
        ): HaulIQDatabase {
            return Room.databaseBuilder(
                context,
                HaulIQDatabase::class.java,
                "hauliq_database"
            ).fallbackToDestructiveMigration()
             .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    CoroutineScope(Dispatchers.IO).launch {
                        // Seed Products
                        inventoryDaoProvider.get().insertItems(
                            SampleData.products.map { it.toEntity() }
                        )
                        // Seed Suppliers
                        supplierDaoProvider.get().insertSupplier(
                            SampleData.suppliers.first().toEntity()
                        )
                        // Seed Transactions
                        SampleData.transactions.forEach {
                            transactionDaoProvider.get().insertTransaction(it.toEntity())
                        }
                        // Seed Notifications
                        notificationDaoProvider.get().insertNotifications(
                            SampleData.notifications.map { it.toEntity() }
                        )
                    }
                }
            }).build()
        }

        @Provides
        fun provideInventoryDao(database: HaulIQDatabase): InventoryDao = database.inventoryDao()

        @Provides
        fun provideOrderDao(database: HaulIQDatabase): OrderDao = database.orderDao()

        @Provides
        fun provideSupplierDao(database: HaulIQDatabase): SupplierDao = database.supplierDao()

        @Provides
        fun provideTransactionDao(database: HaulIQDatabase): TransactionDao = database.transactionDao()

        @Provides
        fun provideNotificationDao(database: HaulIQDatabase): NotificationDao = database.notificationDao()
    }
}

// Helper mapper in same file or import
fun Product.toEntity(): InventoryEntity {
    return InventoryEntity(
        id = id,
        itemName = name,
        sku = sku,
        barcode = barcode,
        category = category,
        supplier = supplierName,
        purchasePrice = cost,
        sellingPrice = price,
        quantity = quantity,
        minimumStock = lowStockThreshold,
        warehouseLocation = "Main",
        description = description,
        imageUri = imageUrl,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    )
}

