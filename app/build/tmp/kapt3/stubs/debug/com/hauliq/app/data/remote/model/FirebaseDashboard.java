package com.hauliq.app.data.remote.model;

@com.google.firebase.database.IgnoreExtraProperties()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0006H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/hauliq/app/data/remote/model/FirebaseDashboard;", "", "total_inventory_value", "", "total_sales_today", "low_stock_alerts", "", "pending_shipments", "(DDII)V", "getLow_stock_alerts", "()I", "getPending_shipments", "getTotal_inventory_value", "()D", "getTotal_sales_today", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class FirebaseDashboard {
    private final double total_inventory_value = 0.0;
    private final double total_sales_today = 0.0;
    private final int low_stock_alerts = 0;
    private final int pending_shipments = 0;
    
    public FirebaseDashboard(double total_inventory_value, double total_sales_today, int low_stock_alerts, int pending_shipments) {
        super();
    }
    
    public final double getTotal_inventory_value() {
        return 0.0;
    }
    
    public final double getTotal_sales_today() {
        return 0.0;
    }
    
    public final int getLow_stock_alerts() {
        return 0;
    }
    
    public final int getPending_shipments() {
        return 0;
    }
    
    public FirebaseDashboard() {
        super();
    }
    
    public final double component1() {
        return 0.0;
    }
    
    public final double component2() {
        return 0.0;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int component4() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.hauliq.app.data.remote.model.FirebaseDashboard copy(double total_inventory_value, double total_sales_today, int low_stock_alerts, int pending_shipments) {
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