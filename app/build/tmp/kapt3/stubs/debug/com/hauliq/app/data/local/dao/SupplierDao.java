package com.hauliq.app.data.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0016\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\f\u001a\u00020\rH\'\u00a8\u0006\u000e"}, d2 = {"Lcom/hauliq/app/data/local/dao/SupplierDao;", "", "deleteSupplier", "", "supplier", "Lcom/hauliq/app/data/local/entity/SupplierEntity;", "(Lcom/hauliq/app/data/local/entity/SupplierEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSuppliers", "Lkotlinx/coroutines/flow/Flow;", "", "insertSupplier", "searchSuppliers", "query", "", "app_debug"})
@androidx.room.Dao()
public abstract interface SupplierDao {
    
    @androidx.room.Query(value = "SELECT * FROM suppliers ORDER BY name ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.data.local.entity.SupplierEntity>> getAllSuppliers();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSupplier(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.local.entity.SupplierEntity supplier, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteSupplier(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.local.entity.SupplierEntity supplier, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM suppliers WHERE name LIKE \'%\' || :query || \'%\'")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.data.local.entity.SupplierEntity>> searchSuppliers(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
}