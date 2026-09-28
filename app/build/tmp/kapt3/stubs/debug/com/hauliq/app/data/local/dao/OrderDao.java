package com.hauliq.app.data.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\'J\u0018\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\u0006\u0010\f\u001a\u00020\rH\'J\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000f\u001a\u00020\rH\'J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\bH\'J\u0010\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\bH\'J\u0016\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0015\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\tH\u00a7@\u00a2\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u001a"}, d2 = {"Lcom/hauliq/app/data/local/dao/OrderDao;", "", "deleteOrder", "", "order", "Lcom/hauliq/app/data/local/entity/OrderEntity;", "(Lcom/hauliq/app/data/local/entity/OrderEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllOrders", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/hauliq/app/data/local/entity/OrderWithItems;", "getOrderById", "id", "", "getOrdersByStatus", "status", "getPendingOrdersCount", "", "getTotalRevenue", "", "insertOrder", "insertOrderItems", "items", "Lcom/hauliq/app/data/local/entity/OrderItemEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateOrder", "app_debug"})
@androidx.room.Dao()
public abstract interface OrderDao {
    
    @androidx.room.Transaction()
    @androidx.room.Query(value = "SELECT * FROM orders ORDER BY orderDate DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.data.local.entity.OrderWithItems>> getAllOrders();
    
    @androidx.room.Transaction()
    @androidx.room.Query(value = "SELECT * FROM orders WHERE id = :id")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.hauliq.app.data.local.entity.OrderWithItems> getOrderById(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertOrder(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.local.entity.OrderEntity order, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertOrderItems(@org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.data.local.entity.OrderItemEntity> items, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateOrder(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.local.entity.OrderEntity order, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteOrder(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.local.entity.OrderEntity order, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM orders WHERE status = :status")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.data.local.entity.OrderWithItems>> getOrdersByStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String status);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM orders WHERE status = \'Pending\'")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getPendingOrdersCount();
    
    @androidx.room.Query(value = "SELECT SUM(totalPrice) FROM orders WHERE status != \'Cancelled\'")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Double> getTotalRevenue();
}