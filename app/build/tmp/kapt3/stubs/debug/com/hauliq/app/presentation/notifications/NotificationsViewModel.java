package com.hauliq.app.presentation.notifications;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/hauliq/app/presentation/notifications/NotificationsViewModel;", "Landroidx/lifecycle/ViewModel;", "notificationRepository", "Lcom/hauliq/app/domain/repository/NotificationRepository;", "(Lcom/hauliq/app/domain/repository/NotificationRepository;)V", "notifications", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/hauliq/app/domain/model/NotificationItem;", "getNotifications", "()Lkotlinx/coroutines/flow/StateFlow;", "deleteNotification", "", "id", "", "markAllAsRead", "markAsRead", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class NotificationsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.domain.repository.NotificationRepository notificationRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.hauliq.app.domain.model.NotificationItem>> notifications = null;
    
    @javax.inject.Inject()
    public NotificationsViewModel(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.repository.NotificationRepository notificationRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.hauliq.app.domain.model.NotificationItem>> getNotifications() {
        return null;
    }
    
    public final void markAsRead(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    public final void markAllAsRead() {
    }
    
    public final void deleteNotification(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
}