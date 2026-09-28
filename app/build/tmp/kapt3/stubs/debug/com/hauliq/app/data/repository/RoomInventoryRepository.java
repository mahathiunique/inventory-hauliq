package com.hauliq.app.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00110\u000fH\u0016J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00110\u000f2\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00110\u000f2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0016\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/hauliq/app/data/repository/RoomInventoryRepository;", "Lcom/hauliq/app/domain/repository/InventoryRepository;", "inventoryDao", "Lcom/hauliq/app/data/local/dao/InventoryDao;", "(Lcom/hauliq/app/data/local/dao/InventoryDao;)V", "addProduct", "", "product", "Lcom/hauliq/app/domain/model/Product;", "(Lcom/hauliq/app/domain/model/Product;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteProduct", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductById", "Lkotlinx/coroutines/flow/Flow;", "getProducts", "", "getProductsByCategory", "category", "searchProducts", "query", "updateProduct", "app_debug"})
public final class RoomInventoryRepository implements com.hauliq.app.domain.repository.InventoryRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.data.local.dao.InventoryDao inventoryDao = null;
    
    @javax.inject.Inject()
    public RoomInventoryRepository(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.local.dao.InventoryDao inventoryDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.domain.model.Product>> getProducts() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.hauliq.app.domain.model.Product> getProductById(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object addProduct(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.Product product, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateProduct(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.Product product, @org.jetbrains.annotations.NotNull()
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
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.domain.model.Product>> searchProducts(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.domain.model.Product>> getProductsByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category) {
        return null;
    }
}