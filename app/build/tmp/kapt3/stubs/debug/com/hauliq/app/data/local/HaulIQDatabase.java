package com.hauliq.app.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/hauliq/app/data/local/HaulIQDatabase;", "Landroidx/room/RoomDatabase;", "()V", "inventoryDao", "Lcom/hauliq/app/data/local/dao/InventoryDao;", "notificationDao", "Lcom/hauliq/app/data/local/dao/NotificationDao;", "orderDao", "Lcom/hauliq/app/data/local/dao/OrderDao;", "supplierDao", "Lcom/hauliq/app/data/local/dao/SupplierDao;", "transactionDao", "Lcom/hauliq/app/data/local/dao/TransactionDao;", "app_debug"})
@androidx.room.Database(entities = {com.hauliq.app.data.local.entity.InventoryEntity.class, com.hauliq.app.data.local.entity.OrderEntity.class, com.hauliq.app.data.local.entity.OrderItemEntity.class, com.hauliq.app.data.local.entity.SupplierEntity.class, com.hauliq.app.data.local.entity.TransactionEntity.class, com.hauliq.app.data.local.entity.NotificationEntity.class}, version = 2, exportSchema = false)
public abstract class HaulIQDatabase extends androidx.room.RoomDatabase {
    
    public HaulIQDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.hauliq.app.data.local.dao.InventoryDao inventoryDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.hauliq.app.data.local.dao.OrderDao orderDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.hauliq.app.data.local.dao.SupplierDao supplierDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.hauliq.app.data.local.dao.TransactionDao transactionDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.hauliq.app.data.local.dao.NotificationDao notificationDao();
}