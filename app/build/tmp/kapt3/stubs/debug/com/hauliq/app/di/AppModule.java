package com.hauliq.app.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\'J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\'J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\'J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\'\u00a8\u0006 "}, d2 = {"Lcom/hauliq/app/di/AppModule;", "", "()V", "bindAiAssistantRepository", "Lcom/hauliq/app/domain/repository/AiAssistantRepository;", "aiAssistantRepositoryImpl", "Lcom/hauliq/app/data/repository/AiAssistantRepositoryImpl;", "bindAnalyticsRepository", "Lcom/hauliq/app/domain/repository/AnalyticsRepository;", "analyticsRepositoryImpl", "Lcom/hauliq/app/data/repository/AnalyticsRepositoryImpl;", "bindInventoryRepository", "Lcom/hauliq/app/domain/repository/InventoryRepository;", "roomInventoryRepository", "Lcom/hauliq/app/data/repository/RoomInventoryRepository;", "bindNotificationRepository", "Lcom/hauliq/app/domain/repository/NotificationRepository;", "roomNotificationRepository", "Lcom/hauliq/app/data/repository/RoomNotificationRepository;", "bindOrderRepository", "Lcom/hauliq/app/domain/repository/OrderRepository;", "roomOrderRepository", "Lcom/hauliq/app/data/repository/RoomOrderRepository;", "bindSupplierRepository", "Lcom/hauliq/app/domain/repository/SupplierRepository;", "roomSupplierRepository", "Lcom/hauliq/app/data/repository/RoomSupplierRepository;", "bindTransactionRepository", "Lcom/hauliq/app/domain/repository/TransactionRepository;", "roomTransactionRepository", "Lcom/hauliq/app/data/repository/RoomTransactionRepository;", "Companion", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.hauliq.app.di.AppModule.Companion Companion = null;
    
    public AppModule() {
        super();
    }
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.hauliq.app.domain.repository.InventoryRepository bindInventoryRepository(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.repository.RoomInventoryRepository roomInventoryRepository);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.hauliq.app.domain.repository.OrderRepository bindOrderRepository(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.repository.RoomOrderRepository roomOrderRepository);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.hauliq.app.domain.repository.AnalyticsRepository bindAnalyticsRepository(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.repository.AnalyticsRepositoryImpl analyticsRepositoryImpl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.hauliq.app.domain.repository.AiAssistantRepository bindAiAssistantRepository(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.repository.AiAssistantRepositoryImpl aiAssistantRepositoryImpl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.hauliq.app.domain.repository.SupplierRepository bindSupplierRepository(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.repository.RoomSupplierRepository roomSupplierRepository);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.hauliq.app.domain.repository.TransactionRepository bindTransactionRepository(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.repository.RoomTransactionRepository roomTransactionRepository);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.hauliq.app.domain.repository.NotificationRepository bindNotificationRepository(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.repository.RoomNotificationRepository roomNotificationRepository);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JJ\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\u0007J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007\u00a8\u0006\u0017"}, d2 = {"Lcom/hauliq/app/di/AppModule$Companion;", "", "()V", "provideDatabase", "Lcom/hauliq/app/data/local/HaulIQDatabase;", "context", "Landroid/content/Context;", "inventoryDaoProvider", "Ljavax/inject/Provider;", "Lcom/hauliq/app/data/local/dao/InventoryDao;", "supplierDaoProvider", "Lcom/hauliq/app/data/local/dao/SupplierDao;", "transactionDaoProvider", "Lcom/hauliq/app/data/local/dao/TransactionDao;", "notificationDaoProvider", "Lcom/hauliq/app/data/local/dao/NotificationDao;", "provideInventoryDao", "database", "provideNotificationDao", "provideOrderDao", "Lcom/hauliq/app/data/local/dao/OrderDao;", "provideSupplierDao", "provideTransactionDao", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @dagger.Provides()
        @javax.inject.Singleton()
        @org.jetbrains.annotations.NotNull()
        public final com.hauliq.app.data.local.HaulIQDatabase provideDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
        @org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        javax.inject.Provider<com.hauliq.app.data.local.dao.InventoryDao> inventoryDaoProvider, @org.jetbrains.annotations.NotNull()
        javax.inject.Provider<com.hauliq.app.data.local.dao.SupplierDao> supplierDaoProvider, @org.jetbrains.annotations.NotNull()
        javax.inject.Provider<com.hauliq.app.data.local.dao.TransactionDao> transactionDaoProvider, @org.jetbrains.annotations.NotNull()
        javax.inject.Provider<com.hauliq.app.data.local.dao.NotificationDao> notificationDaoProvider) {
            return null;
        }
        
        @dagger.Provides()
        @org.jetbrains.annotations.NotNull()
        public final com.hauliq.app.data.local.dao.InventoryDao provideInventoryDao(@org.jetbrains.annotations.NotNull()
        com.hauliq.app.data.local.HaulIQDatabase database) {
            return null;
        }
        
        @dagger.Provides()
        @org.jetbrains.annotations.NotNull()
        public final com.hauliq.app.data.local.dao.OrderDao provideOrderDao(@org.jetbrains.annotations.NotNull()
        com.hauliq.app.data.local.HaulIQDatabase database) {
            return null;
        }
        
        @dagger.Provides()
        @org.jetbrains.annotations.NotNull()
        public final com.hauliq.app.data.local.dao.SupplierDao provideSupplierDao(@org.jetbrains.annotations.NotNull()
        com.hauliq.app.data.local.HaulIQDatabase database) {
            return null;
        }
        
        @dagger.Provides()
        @org.jetbrains.annotations.NotNull()
        public final com.hauliq.app.data.local.dao.TransactionDao provideTransactionDao(@org.jetbrains.annotations.NotNull()
        com.hauliq.app.data.local.HaulIQDatabase database) {
            return null;
        }
        
        @dagger.Provides()
        @org.jetbrains.annotations.NotNull()
        public final com.hauliq.app.data.local.dao.NotificationDao provideNotificationDao(@org.jetbrains.annotations.NotNull()
        com.hauliq.app.data.local.HaulIQDatabase database) {
            return null;
        }
    }
}