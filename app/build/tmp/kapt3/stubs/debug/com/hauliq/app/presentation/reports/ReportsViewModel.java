package com.hauliq.app.presentation.reports;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bR\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/hauliq/app/presentation/reports/ReportsViewModel;", "Landroidx/lifecycle/ViewModel;", "inventoryRepository", "Lcom/hauliq/app/domain/repository/InventoryRepository;", "transactionRepository", "Lcom/hauliq/app/domain/repository/TransactionRepository;", "(Lcom/hauliq/app/domain/repository/InventoryRepository;Lcom/hauliq/app/domain/repository/TransactionRepository;)V", "_exportStatusMessage", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_isExporting", "", "_reports", "", "Lcom/hauliq/app/domain/model/ReportItem;", "exportStatusMessage", "Lkotlinx/coroutines/flow/StateFlow;", "getExportStatusMessage", "()Lkotlinx/coroutines/flow/StateFlow;", "isExporting", "reports", "getReports", "dismissStatus", "", "downloadExistingReport", "report", "context", "Landroid/content/Context;", "exportReport", "type", "Lcom/hauliq/app/domain/model/ReportType;", "format", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ReportsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.domain.repository.InventoryRepository inventoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.domain.repository.TransactionRepository transactionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.hauliq.app.domain.model.ReportItem>> _reports = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.hauliq.app.domain.model.ReportItem>> reports = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isExporting = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isExporting = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _exportStatusMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> exportStatusMessage = null;
    
    @javax.inject.Inject()
    public ReportsViewModel(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.repository.InventoryRepository inventoryRepository, @org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.repository.TransactionRepository transactionRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.hauliq.app.domain.model.ReportItem>> getReports() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isExporting() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getExportStatusMessage() {
        return null;
    }
    
    public final void exportReport(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.ReportType type, @org.jetbrains.annotations.NotNull()
    java.lang.String format, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void downloadExistingReport(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.ReportItem report, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void dismissStatus() {
    }
}