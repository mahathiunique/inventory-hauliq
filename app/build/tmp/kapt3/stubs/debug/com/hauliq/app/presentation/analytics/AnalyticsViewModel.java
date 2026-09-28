package com.hauliq.app.presentation.analytics;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/hauliq/app/presentation/analytics/AnalyticsViewModel;", "Landroidx/lifecycle/ViewModel;", "analyticsRepository", "Lcom/hauliq/app/domain/repository/AnalyticsRepository;", "inventoryRepository", "Lcom/hauliq/app/domain/repository/InventoryRepository;", "orderRepository", "Lcom/hauliq/app/domain/repository/OrderRepository;", "transactionRepository", "Lcom/hauliq/app/domain/repository/TransactionRepository;", "(Lcom/hauliq/app/domain/repository/AnalyticsRepository;Lcom/hauliq/app/domain/repository/InventoryRepository;Lcom/hauliq/app/domain/repository/OrderRepository;Lcom/hauliq/app/domain/repository/TransactionRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/hauliq/app/presentation/analytics/AnalyticsUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadAnalytics", "", "onFilterSelected", "filter", "Lcom/hauliq/app/presentation/analytics/TimeFilter;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AnalyticsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.domain.repository.AnalyticsRepository analyticsRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.domain.repository.InventoryRepository inventoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.domain.repository.OrderRepository orderRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.domain.repository.TransactionRepository transactionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.hauliq.app.presentation.analytics.AnalyticsUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.presentation.analytics.AnalyticsUiState> uiState = null;
    
    @javax.inject.Inject()
    public AnalyticsViewModel(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.repository.AnalyticsRepository analyticsRepository, @org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.repository.InventoryRepository inventoryRepository, @org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.repository.OrderRepository orderRepository, @org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.repository.TransactionRepository transactionRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.presentation.analytics.AnalyticsUiState> getUiState() {
        return null;
    }
    
    private final void loadAnalytics() {
    }
    
    public final void onFilterSelected(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.presentation.analytics.TimeFilter filter) {
    }
}