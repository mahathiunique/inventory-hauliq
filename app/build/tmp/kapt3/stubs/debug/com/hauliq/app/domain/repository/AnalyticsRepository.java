package com.hauliq.app.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u001a\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003H&J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0003H&J\u001a\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003H&\u00a8\u0006\r"}, d2 = {"Lcom/hauliq/app/domain/repository/AnalyticsRepository;", "", "getAnalyticsSummary", "Lkotlinx/coroutines/flow/Flow;", "Lcom/hauliq/app/domain/model/AnalyticsSummary;", "getInventoryByCategory", "", "", "", "getLowStockProducts", "", "Lcom/hauliq/app/domain/model/Product;", "getOrderStatusDistribution", "app_debug"})
public abstract interface AnalyticsRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.hauliq.app.domain.model.AnalyticsSummary> getAnalyticsSummary();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.domain.model.Product>> getLowStockProducts();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.Map<java.lang.String, java.lang.Integer>> getInventoryByCategory();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.Map<java.lang.String, java.lang.Integer>> getOrderStatusDistribution();
}