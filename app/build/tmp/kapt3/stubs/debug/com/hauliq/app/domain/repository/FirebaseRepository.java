package com.hauliq.app.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH&J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\fH&J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0\fH&J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000f0\fH&J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000f0\fH&J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u000f0\fH&J\u0016\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0019"}, d2 = {"Lcom/hauliq/app/domain/repository/FirebaseRepository;", "", "addProduct", "", "product", "Lcom/hauliq/app/data/remote/model/FirebaseProduct;", "(Lcom/hauliq/app/data/remote/model/FirebaseProduct;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteProduct", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDashboardStats", "Lkotlinx/coroutines/flow/Flow;", "Lcom/hauliq/app/data/remote/model/FirebaseDashboard;", "getInventoryTransactions", "", "Lcom/hauliq/app/data/remote/model/FirebaseInventoryTransaction;", "getProducts", "getSales", "Lcom/hauliq/app/data/remote/model/FirebaseSale;", "getSuppliers", "Lcom/hauliq/app/data/remote/model/FirebaseSupplier;", "getWarehouses", "Lcom/hauliq/app/data/remote/model/FirebaseWarehouse;", "updateProduct", "app_debug"})
public abstract interface FirebaseRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.data.remote.model.FirebaseProduct>> getProducts();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.data.remote.model.FirebaseSupplier>> getSuppliers();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.data.remote.model.FirebaseWarehouse>> getWarehouses();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.data.remote.model.FirebaseSale>> getSales();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.data.remote.model.FirebaseInventoryTransaction>> getInventoryTransactions();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.hauliq.app.data.remote.model.FirebaseDashboard> getDashboardStats();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addProduct(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.remote.model.FirebaseProduct product, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateProduct(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.remote.model.FirebaseProduct product, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteProduct(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}