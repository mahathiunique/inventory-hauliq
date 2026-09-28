package com.hauliq.app.data.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\'J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bH\'J\u0016\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0016"}, d2 = {"Lcom/hauliq/app/data/local/dao/NotificationDao;", "", "deleteById", "", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllNotifications", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/hauliq/app/data/local/entity/NotificationEntity;", "getUnreadCount", "", "insertNotification", "notification", "(Lcom/hauliq/app/data/local/entity/NotificationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertNotifications", "notifications", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAllAsRead", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAsRead", "app_debug"})
@androidx.room.Dao()
public abstract interface NotificationDao {
    
    @androidx.room.Query(value = "SELECT * FROM notifications ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.data.local.entity.NotificationEntity>> getAllNotifications();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertNotification(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.local.entity.NotificationEntity notification, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertNotifications(@org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.data.local.entity.NotificationEntity> notifications, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE notifications SET isRead = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object markAllAsRead(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE notifications SET isRead = 1 WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object markAsRead(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM notifications WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM notifications WHERE isRead = 0")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getUnreadCount();
}