package com.hauliq.app.data.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u000e\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u000e\u001a\u00020\tH\'J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\f2\u0006\u0010\b\u001a\u00020\tH\'J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0016\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0015\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u00a7@\u00a2\u0006\u0002\u0010\u0017J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0019\u001a\u00020\tH\'J\u0016\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u001b"}, d2 = {"Lcom/hauliq/app/data/local/dao/InventoryDao;", "", "deleteItem", "", "item", "Lcom/hauliq/app/data/local/entity/InventoryEntity;", "(Lcom/hauliq/app/data/local/entity/InventoryEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteItemById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterByCategory", "Lkotlinx/coroutines/flow/Flow;", "", "category", "getAllItems", "getItemById", "getItemBySku", "sku", "getLowStockItems", "insertItem", "insertItems", "items", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchItems", "query", "updateItem", "app_debug"})
@androidx.room.Dao()
public abstract interface InventoryDao {
    
    @androidx.room.Query(value = "SELECT * FROM inventory ORDER BY updatedAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.data.local.entity.InventoryEntity>> getAllItems();
    
    @androidx.room.Query(value = "SELECT * FROM inventory WHERE id = :id")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.hauliq.app.data.local.entity.InventoryEntity> getItemById(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @androidx.room.Query(value = "DELETE FROM inventory WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteItemById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 3)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertItem(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.local.entity.InventoryEntity item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateItem(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.local.entity.InventoryEntity item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteItem(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.local.entity.InventoryEntity item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM inventory WHERE itemName LIKE \'%\' || :query || \'%\' OR sku LIKE \'%\' || :query || \'%\'")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.data.local.entity.InventoryEntity>> searchItems(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @androidx.room.Query(value = "SELECT * FROM inventory WHERE category = :category ORDER BY itemName ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.data.local.entity.InventoryEntity>> filterByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category);
    
    @androidx.room.Query(value = "SELECT * FROM inventory WHERE quantity <= minimumStock ORDER BY (CAST(quantity AS FLOAT) / CAST(minimumStock AS FLOAT)) ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.data.local.entity.InventoryEntity>> getLowStockItems();
    
    @androidx.room.Query(value = "SELECT * FROM inventory WHERE sku = :sku LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getItemBySku(@org.jetbrains.annotations.NotNull()
    java.lang.String sku, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.hauliq.app.data.local.entity.InventoryEntity> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertItems(@org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.data.local.entity.InventoryEntity> items, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}