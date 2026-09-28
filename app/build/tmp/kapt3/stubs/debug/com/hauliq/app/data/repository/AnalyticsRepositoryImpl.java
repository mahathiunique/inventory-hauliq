package com.hauliq.app.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u001a\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\bH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\bH\u0016J\u001a\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/hauliq/app/data/repository/AnalyticsRepositoryImpl;", "Lcom/hauliq/app/domain/repository/AnalyticsRepository;", "inventoryDao", "Lcom/hauliq/app/data/local/dao/InventoryDao;", "orderDao", "Lcom/hauliq/app/data/local/dao/OrderDao;", "(Lcom/hauliq/app/data/local/dao/InventoryDao;Lcom/hauliq/app/data/local/dao/OrderDao;)V", "getAnalyticsSummary", "Lkotlinx/coroutines/flow/Flow;", "Lcom/hauliq/app/domain/model/AnalyticsSummary;", "getInventoryByCategory", "", "", "", "getLowStockProducts", "", "Lcom/hauliq/app/domain/model/Product;", "getOrderStatusDistribution", "app_debug"})
public final class AnalyticsRepositoryImpl implements com.hauliq.app.domain.repository.AnalyticsRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.data.local.dao.InventoryDao inventoryDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.data.local.dao.OrderDao orderDao = null;
    
    @javax.inject.Inject()
    public AnalyticsRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.local.dao.InventoryDao inventoryDao, @org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.local.dao.OrderDao orderDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.hauliq.app.domain.model.AnalyticsSummary> getAnalyticsSummary() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.domain.model.Product>> getLowStockProducts() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.Map<java.lang.String, java.lang.Integer>> getInventoryByCategory() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.Map<java.lang.String, java.lang.Integer>> getOrderStatusDistribution() {
        return null;
    }
}