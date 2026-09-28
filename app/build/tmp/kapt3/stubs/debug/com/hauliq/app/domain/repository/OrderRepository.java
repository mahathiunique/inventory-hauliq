package com.hauliq.app.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH&J\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\b2\u0006\u0010\u000b\u001a\u00020\fH&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\bH&J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\bH&J\u001e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u00a6@\u00a2\u0006\u0002\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/hauliq/app/domain/repository/OrderRepository;", "", "createOrder", "", "order", "Lcom/hauliq/app/domain/model/Order;", "(Lcom/hauliq/app/domain/model/Order;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllOrders", "Lkotlinx/coroutines/flow/Flow;", "", "getOrderById", "id", "", "getPendingOrdersCount", "", "getTotalRevenue", "", "updateOrderStatus", "orderId", "status", "Lcom/hauliq/app/domain/model/OrderStatus;", "(Ljava/lang/String;Lcom/hauliq/app/domain/model/OrderStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface OrderRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.domain.model.Order>> getAllOrders();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.hauliq.app.domain.model.Order> getOrderById(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createOrder(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.Order order, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateOrderStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String orderId, @org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.OrderStatus status, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getPendingOrdersCount();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Double> getTotalRevenue();
}