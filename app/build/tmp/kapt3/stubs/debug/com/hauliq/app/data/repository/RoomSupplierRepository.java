package com.hauliq.app.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\fH\u0016J\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/hauliq/app/data/repository/RoomSupplierRepository;", "Lcom/hauliq/app/domain/repository/SupplierRepository;", "supplierDao", "Lcom/hauliq/app/data/local/dao/SupplierDao;", "(Lcom/hauliq/app/data/local/dao/SupplierDao;)V", "addSupplier", "", "supplier", "Lcom/hauliq/app/domain/model/Supplier;", "(Lcom/hauliq/app/domain/model/Supplier;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSupplier", "getAllSuppliers", "Lkotlinx/coroutines/flow/Flow;", "", "searchSuppliers", "query", "", "app_debug"})
public final class RoomSupplierRepository implements com.hauliq.app.domain.repository.SupplierRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.data.local.dao.SupplierDao supplierDao = null;
    
    @javax.inject.Inject()
    public RoomSupplierRepository(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.local.dao.SupplierDao supplierDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.domain.model.Supplier>> getAllSuppliers() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.domain.model.Supplier>> searchSuppliers(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object addSupplier(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.Supplier supplier, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteSupplier(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.Supplier supplier, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}