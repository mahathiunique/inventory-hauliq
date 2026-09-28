package com.hauliq.app.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0016J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u000fH\u0016J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\u000fH\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00120\u000fH\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00120\u000fH\u0016J\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00120\u000fH\u0016J\u0016\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/hauliq/app/data/repository/FirebaseRepositoryImpl;", "Lcom/hauliq/app/domain/repository/FirebaseRepository;", "rootRef", "Lcom/google/firebase/database/DatabaseReference;", "(Lcom/google/firebase/database/DatabaseReference;)V", "addProduct", "", "product", "Lcom/hauliq/app/data/remote/model/FirebaseProduct;", "(Lcom/hauliq/app/data/remote/model/FirebaseProduct;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteProduct", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDashboardStats", "Lkotlinx/coroutines/flow/Flow;", "Lcom/hauliq/app/data/remote/model/FirebaseDashboard;", "getInventoryTransactions", "", "Lcom/hauliq/app/data/remote/model/FirebaseInventoryTransaction;", "getProducts", "getSales", "Lcom/hauliq/app/data/remote/model/FirebaseSale;", "getSuppliers", "Lcom/hauliq/app/data/remote/model/FirebaseSupplier;", "getWarehouses", "Lcom/hauliq/app/data/remote/model/FirebaseWarehouse;", "updateProduct", "app_debug"})
public final class FirebaseRepositoryImpl implements com.hauliq.app.domain.repository.FirebaseRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.database.DatabaseReference rootRef = null;
    
    @javax.inject.Inject()
    public FirebaseRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.google.firebase.database.DatabaseReference rootRef) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.data.remote.model.FirebaseProduct>> getProducts() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.data.remote.model.FirebaseSupplier>> getSuppliers() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.data.remote.model.FirebaseWarehouse>> getWarehouses() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.data.remote.model.FirebaseSale>> getSales() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.data.remote.model.FirebaseInventoryTransaction>> getInventoryTransactions() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.hauliq.app.data.remote.model.FirebaseDashboard> getDashboardStats() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object addProduct(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.remote.model.FirebaseProduct product, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateProduct(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.remote.model.FirebaseProduct product, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteProduct(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}