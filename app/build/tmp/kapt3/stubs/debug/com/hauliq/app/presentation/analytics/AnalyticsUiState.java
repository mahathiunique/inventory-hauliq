package com.hauliq.app.presentation.analytics;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\b\u0086\b\u0018\u00002\u00020\u0001B\u00e5\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011\u0012\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00050\u0017\u0012\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00050\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u00a2\u0006\u0002\u0010\u001eJ\u000b\u00107\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\u0007H\u00c6\u0003J\t\u00109\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u00c6\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u00c6\u0003J\u000f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011H\u00c6\u0003J\u0015\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00050\u0017H\u00c6\u0003J\u0015\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00050\u0017H\u00c6\u0003J\t\u0010?\u001a\u00020\u001bH\u00c6\u0003J\t\u0010@\u001a\u00020\u001dH\u00c6\u0003J\t\u0010A\u001a\u00020\u0005H\u00c6\u0003J\t\u0010B\u001a\u00020\u0007H\u00c6\u0003J\t\u0010C\u001a\u00020\u0005H\u00c6\u0003J\t\u0010D\u001a\u00020\u0005H\u00c6\u0003J\t\u0010E\u001a\u00020\u0005H\u00c6\u0003J\t\u0010F\u001a\u00020\u0005H\u00c6\u0003J\t\u0010G\u001a\u00020\u0005H\u00c6\u0003J\t\u0010H\u001a\u00020\u0007H\u00c6\u0003J\u00e9\u0001\u0010I\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00112\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00050\u00172\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00050\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u00c6\u0001J\u0013\u0010J\u001a\u00020\u001b2\b\u0010K\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010L\u001a\u00020\u0005H\u00d6\u0001J\t\u0010M\u001a\u00020\u0018H\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00050\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010 R\u0011\u0010\u001a\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010(R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u001d\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00050\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010&R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0011\u0010\u001c\u001a\u00020\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010 R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010$R\u0011\u0010\r\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010$R\u0011\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010$\u00a8\u0006N"}, d2 = {"Lcom/hauliq/app/presentation/analytics/AnalyticsUiState;", "", "summary", "Lcom/hauliq/app/domain/model/AnalyticsSummary;", "totalInventoryCount", "", "totalInventoryValue", "", "lowStockCount", "outOfStockCount", "activeOrdersCount", "completedOrdersCount", "todayShipments", "totalRevenue", "weeklyRevenue", "avgOrderValue", "lowStockProducts", "", "Lcom/hauliq/app/domain/model/Product;", "allProducts", "recentActivities", "Lcom/hauliq/app/domain/model/Transaction;", "categoryDistribution", "", "", "orderStatusDistribution", "isLoading", "", "selectedTimeFilter", "Lcom/hauliq/app/presentation/analytics/TimeFilter;", "(Lcom/hauliq/app/domain/model/AnalyticsSummary;IDIIIIIDDDLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;ZLcom/hauliq/app/presentation/analytics/TimeFilter;)V", "getActiveOrdersCount", "()I", "getAllProducts", "()Ljava/util/List;", "getAvgOrderValue", "()D", "getCategoryDistribution", "()Ljava/util/Map;", "getCompletedOrdersCount", "()Z", "getLowStockCount", "getLowStockProducts", "getOrderStatusDistribution", "getOutOfStockCount", "getRecentActivities", "getSelectedTimeFilter", "()Lcom/hauliq/app/presentation/analytics/TimeFilter;", "getSummary", "()Lcom/hauliq/app/domain/model/AnalyticsSummary;", "getTodayShipments", "getTotalInventoryCount", "getTotalInventoryValue", "getTotalRevenue", "getWeeklyRevenue", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class AnalyticsUiState {
    @org.jetbrains.annotations.Nullable()
    private final com.hauliq.app.domain.model.AnalyticsSummary summary = null;
    private final int totalInventoryCount = 0;
    private final double totalInventoryValue = 0.0;
    private final int lowStockCount = 0;
    private final int outOfStockCount = 0;
    private final int activeOrdersCount = 0;
    private final int completedOrdersCount = 0;
    private final int todayShipments = 0;
    private final double totalRevenue = 0.0;
    private final double weeklyRevenue = 0.0;
    private final double avgOrderValue = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.hauliq.app.domain.model.Product> lowStockProducts = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.hauliq.app.domain.model.Product> allProducts = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.hauliq.app.domain.model.Transaction> recentActivities = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.Integer> categoryDistribution = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.Integer> orderStatusDistribution = null;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.presentation.analytics.TimeFilter selectedTimeFilter = null;
    
    public AnalyticsUiState(@org.jetbrains.annotations.Nullable()
    com.hauliq.app.domain.model.AnalyticsSummary summary, int totalInventoryCount, double totalInventoryValue, int lowStockCount, int outOfStockCount, int activeOrdersCount, int completedOrdersCount, int todayShipments, double totalRevenue, double weeklyRevenue, double avgOrderValue, @org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.Product> lowStockProducts, @org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.Product> allProducts, @org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.Transaction> recentActivities, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Integer> categoryDistribution, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Integer> orderStatusDistribution, boolean isLoading, @org.jetbrains.annotations.NotNull()
    com.hauliq.app.presentation.analytics.TimeFilter selectedTimeFilter) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.hauliq.app.domain.model.AnalyticsSummary getSummary() {
        return null;
    }
    
    public final int getTotalInventoryCount() {
        return 0;
    }
    
    public final double getTotalInventoryValue() {
        return 0.0;
    }
    
    public final int getLowStockCount() {
        return 0;
    }
    
    public final int getOutOfStockCount() {
        return 0;
    }
    
    public final int getActiveOrdersCount() {
        return 0;
    }
    
    public final int getCompletedOrdersCount() {
        return 0;
    }
    
    public final int getTodayShipments() {
        return 0;
    }
    
    public final double getTotalRevenue() {
        return 0.0;
    }
    
    public final double getWeeklyRevenue() {
        return 0.0;
    }
    
    public final double getAvgOrderValue() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.hauliq.app.domain.model.Product> getLowStockProducts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.hauliq.app.domain.model.Product> getAllProducts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.hauliq.app.domain.model.Transaction> getRecentActivities() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Integer> getCategoryDistribution() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Integer> getOrderStatusDistribution() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.hauliq.app.presentation.analytics.TimeFilter getSelectedTimeFilter() {
        return null;
    }
    
    public AnalyticsUiState() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.hauliq.app.domain.model.AnalyticsSummary component1() {
        return null;
    }
    
    public final double component10() {
        return 0.0;
    }
    
    public final double component11() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.hauliq.app.domain.model.Product> component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.hauliq.app.domain.model.Product> component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.hauliq.app.domain.model.Transaction> component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Integer> component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Integer> component16() {
        return null;
    }
    
    public final boolean component17() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.hauliq.app.presentation.analytics.TimeFilter component18() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final double component3() {
        return 0.0;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int component7() {
        return 0;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final double component9() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.hauliq.app.presentation.analytics.AnalyticsUiState copy(@org.jetbrains.annotations.Nullable()
    com.hauliq.app.domain.model.AnalyticsSummary summary, int totalInventoryCount, double totalInventoryValue, int lowStockCount, int outOfStockCount, int activeOrdersCount, int completedOrdersCount, int todayShipments, double totalRevenue, double weeklyRevenue, double avgOrderValue, @org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.Product> lowStockProducts, @org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.Product> allProducts, @org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.Transaction> recentActivities, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Integer> categoryDistribution, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Integer> orderStatusDistribution, boolean isLoading, @org.jetbrains.annotations.NotNull()
    com.hauliq.app.presentation.analytics.TimeFilter selectedTimeFilter) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}