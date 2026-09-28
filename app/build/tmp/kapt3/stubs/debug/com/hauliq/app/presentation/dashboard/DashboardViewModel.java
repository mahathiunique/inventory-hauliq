package com.hauliq.app.presentation.dashboard;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u001dR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/hauliq/app/presentation/dashboard/DashboardViewModel;", "Landroidx/lifecycle/ViewModel;", "inventoryRepository", "Lcom/hauliq/app/domain/repository/InventoryRepository;", "orderRepository", "Lcom/hauliq/app/domain/repository/OrderRepository;", "aiAssistantRepository", "Lcom/hauliq/app/domain/repository/AiAssistantRepository;", "(Lcom/hauliq/app/domain/repository/InventoryRepository;Lcom/hauliq/app/domain/repository/OrderRepository;Lcom/hauliq/app/domain/repository/AiAssistantRepository;)V", "_activities", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/hauliq/app/domain/model/ActivityLog;", "_aiInsights", "Lcom/hauliq/app/domain/model/AiInsight;", "_isRefreshing", "", "_stats", "Lcom/hauliq/app/domain/model/DashboardStats;", "activities", "Lkotlinx/coroutines/flow/StateFlow;", "getActivities", "()Lkotlinx/coroutines/flow/StateFlow;", "aiInsights", "getAiInsights", "isRefreshing", "stats", "getStats", "loadDashboardData", "", "refreshDashboard", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class DashboardViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.domain.repository.InventoryRepository inventoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.domain.repository.OrderRepository orderRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.domain.repository.AiAssistantRepository aiAssistantRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.hauliq.app.domain.model.DashboardStats> _stats = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.domain.model.DashboardStats> stats = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.hauliq.app.domain.model.ActivityLog>> _activities = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.hauliq.app.domain.model.ActivityLog>> activities = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.hauliq.app.domain.model.AiInsight>> _aiInsights = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.hauliq.app.domain.model.AiInsight>> aiInsights = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isRefreshing = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRefreshing = null;
    
    @javax.inject.Inject()
    public DashboardViewModel(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.repository.InventoryRepository inventoryRepository, @org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.repository.OrderRepository orderRepository, @org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.repository.AiAssistantRepository aiAssistantRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.domain.model.DashboardStats> getStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.hauliq.app.domain.model.ActivityLog>> getActivities() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.hauliq.app.domain.model.AiInsight>> getAiInsights() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRefreshing() {
        return null;
    }
    
    private final void loadDashboardData() {
    }
    
    public final void refreshDashboard() {
    }
}