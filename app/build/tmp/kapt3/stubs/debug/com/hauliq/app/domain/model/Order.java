package com.hauliq.app.domain.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0015J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\bH\u00c6\u0003J\t\u00100\u001a\u00020\nH\u00c6\u0003J\t\u00101\u001a\u00020\fH\u00c6\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u00c6\u0003J\t\u00103\u001a\u00020\u0011H\u00c6\u0003J\u008b\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00108\u001a\u000209H\u00d6\u0001J\t\u0010:\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0017\u00a8\u0006;"}, d2 = {"Lcom/hauliq/app/domain/model/Order;", "", "id", "", "customerName", "customerPhone", "shippingAddress", "orderDate", "", "status", "Lcom/hauliq/app/domain/model/OrderStatus;", "priority", "Lcom/hauliq/app/domain/model/OrderPriority;", "items", "", "Lcom/hauliq/app/domain/model/OrderItem;", "totalPrice", "", "paymentStatus", "trackingNumber", "notes", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/hauliq/app/domain/model/OrderStatus;Lcom/hauliq/app/domain/model/OrderPriority;Ljava/util/List;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCustomerName", "()Ljava/lang/String;", "getCustomerPhone", "getId", "getItems", "()Ljava/util/List;", "getNotes", "getOrderDate", "()J", "getPaymentStatus", "getPriority", "()Lcom/hauliq/app/domain/model/OrderPriority;", "getShippingAddress", "getStatus", "()Lcom/hauliq/app/domain/model/OrderStatus;", "getTotalPrice", "()D", "getTrackingNumber", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class Order {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String customerName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String customerPhone = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String shippingAddress = null;
    private final long orderDate = 0L;
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.domain.model.OrderStatus status = null;
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.domain.model.OrderPriority priority = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.hauliq.app.domain.model.OrderItem> items = null;
    private final double totalPrice = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String paymentStatus = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String trackingNumber = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String notes = null;
    
    public Order(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String customerName, @org.jetbrains.annotations.NotNull()
    java.lang.String customerPhone, @org.jetbrains.annotations.NotNull()
    java.lang.String shippingAddress, long orderDate, @org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.OrderStatus status, @org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.OrderPriority priority, @org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.OrderItem> items, double totalPrice, @org.jetbrains.annotations.NotNull()
    java.lang.String paymentStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String trackingNumber, @org.jetbrains.annotations.Nullable()
    java.lang.String notes) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCustomerName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCustomerPhone() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getShippingAddress() {
        return null;
    }
    
    public final long getOrderDate() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.hauliq.app.domain.model.OrderStatus getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.hauliq.app.domain.model.OrderPriority getPriority() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.hauliq.app.domain.model.OrderItem> getItems() {
        return null;
    }
    
    public final double getTotalPrice() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPaymentStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTrackingNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNotes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    public final long component5() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.hauliq.app.domain.model.OrderStatus component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.hauliq.app.domain.model.OrderPriority component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.hauliq.app.domain.model.OrderItem> component8() {
        return null;
    }
    
    public final double component9() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.hauliq.app.domain.model.Order copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String customerName, @org.jetbrains.annotations.NotNull()
    java.lang.String customerPhone, @org.jetbrains.annotations.NotNull()
    java.lang.String shippingAddress, long orderDate, @org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.OrderStatus status, @org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.OrderPriority priority, @org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.OrderItem> items, double totalPrice, @org.jetbrains.annotations.NotNull()
    java.lang.String paymentStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String trackingNumber, @org.jetbrains.annotations.Nullable()
    java.lang.String notes) {
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