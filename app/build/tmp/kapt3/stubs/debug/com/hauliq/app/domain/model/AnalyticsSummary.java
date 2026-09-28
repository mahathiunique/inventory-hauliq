package com.hauliq.app.domain.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0003\u0012\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0002\u0010\u000eJ\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u001b\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0003H\u00c6\u0003J\u001b\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\fH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\fH\u00c6\u0003Ju\u0010\u001d\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u00032\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\tH\u00d6\u0001J\t\u0010\"\u001a\u00020\bH\u00d6\u0001R#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014\u00a8\u0006#"}, d2 = {"Lcom/hauliq/app/domain/model/AnalyticsSummary;", "", "salesTrend", "", "Lcom/hauliq/app/domain/model/ChartPoint;", "inventoryTrend", "fastMovingProducts", "Lkotlin/Pair;", "", "", "deadStockProducts", "turnRate", "", "monthlyRevenue", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;DD)V", "getDeadStockProducts", "()Ljava/util/List;", "getFastMovingProducts", "getInventoryTrend", "getMonthlyRevenue", "()D", "getSalesTrend", "getTurnRate", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class AnalyticsSummary {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.hauliq.app.domain.model.ChartPoint> salesTrend = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.hauliq.app.domain.model.ChartPoint> inventoryTrend = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<kotlin.Pair<java.lang.String, java.lang.Integer>> fastMovingProducts = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<kotlin.Pair<java.lang.String, java.lang.Integer>> deadStockProducts = null;
    private final double turnRate = 0.0;
    private final double monthlyRevenue = 0.0;
    
    public AnalyticsSummary(@org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.ChartPoint> salesTrend, @org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.ChartPoint> inventoryTrend, @org.jetbrains.annotations.NotNull()
    java.util.List<kotlin.Pair<java.lang.String, java.lang.Integer>> fastMovingProducts, @org.jetbrains.annotations.NotNull()
    java.util.List<kotlin.Pair<java.lang.String, java.lang.Integer>> deadStockProducts, double turnRate, double monthlyRevenue) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.hauliq.app.domain.model.ChartPoint> getSalesTrend() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.hauliq.app.domain.model.ChartPoint> getInventoryTrend() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<kotlin.Pair<java.lang.String, java.lang.Integer>> getFastMovingProducts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<kotlin.Pair<java.lang.String, java.lang.Integer>> getDeadStockProducts() {
        return null;
    }
    
    public final double getTurnRate() {
        return 0.0;
    }
    
    public final double getMonthlyRevenue() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.hauliq.app.domain.model.ChartPoint> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.hauliq.app.domain.model.ChartPoint> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<kotlin.Pair<java.lang.String, java.lang.Integer>> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<kotlin.Pair<java.lang.String, java.lang.Integer>> component4() {
        return null;
    }
    
    public final double component5() {
        return 0.0;
    }
    
    public final double component6() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.hauliq.app.domain.model.AnalyticsSummary copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.ChartPoint> salesTrend, @org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.ChartPoint> inventoryTrend, @org.jetbrains.annotations.NotNull()
    java.util.List<kotlin.Pair<java.lang.String, java.lang.Integer>> fastMovingProducts, @org.jetbrains.annotations.NotNull()
    java.util.List<kotlin.Pair<java.lang.String, java.lang.Integer>> deadStockProducts, double turnRate, double monthlyRevenue) {
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