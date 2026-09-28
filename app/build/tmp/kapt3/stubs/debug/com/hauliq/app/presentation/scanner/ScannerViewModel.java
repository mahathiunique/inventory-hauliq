package com.hauliq.app.presentation.scanner;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0014J\u0006\u0010\u0019\u001a\u00020\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/hauliq/app/presentation/scanner/ScannerViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_isContinuousScanOn", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_isFlashOn", "_lastScannedProduct", "Lcom/hauliq/app/domain/model/Product;", "_scanHistory", "", "isContinuousScanOn", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "isFlashOn", "lastScannedProduct", "getLastScannedProduct", "scanHistory", "getScanHistory", "clearHistory", "", "simulateScan", "barcode", "", "toggleContinuousScan", "toggleFlash", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ScannerViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.hauliq.app.domain.model.Product>> _scanHistory = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.hauliq.app.domain.model.Product>> scanHistory = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isFlashOn = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isFlashOn = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isContinuousScanOn = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isContinuousScanOn = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.hauliq.app.domain.model.Product> _lastScannedProduct = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.domain.model.Product> lastScannedProduct = null;
    
    @javax.inject.Inject()
    public ScannerViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.hauliq.app.domain.model.Product>> getScanHistory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isFlashOn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isContinuousScanOn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.domain.model.Product> getLastScannedProduct() {
        return null;
    }
    
    public final void toggleFlash() {
    }
    
    public final void toggleContinuousScan() {
    }
    
    public final void simulateScan(@org.jetbrains.annotations.NotNull()
    java.lang.String barcode) {
    }
    
    public final void clearHistory() {
    }
}