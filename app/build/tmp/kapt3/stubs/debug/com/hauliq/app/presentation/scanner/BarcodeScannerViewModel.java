package com.hauliq.app.presentation.scanner;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0012R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/hauliq/app/presentation/scanner/BarcodeScannerViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/hauliq/app/domain/repository/InventoryRepository;", "(Lcom/hauliq/app/domain/repository/InventoryRepository;)V", "_isFlashEnabled", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_uiState", "Lcom/hauliq/app/presentation/scanner/ScannerUiState;", "isFlashEnabled", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "lastScannedBarcode", "", "uiState", "getUiState", "onBarcodeDetected", "", "barcode", "onManualBarcodeSubmit", "resetScanner", "toggleFlash", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class BarcodeScannerViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.domain.repository.InventoryRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.hauliq.app.presentation.scanner.ScannerUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.presentation.scanner.ScannerUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isFlashEnabled = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isFlashEnabled = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String lastScannedBarcode;
    
    @javax.inject.Inject()
    public BarcodeScannerViewModel(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.repository.InventoryRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.presentation.scanner.ScannerUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isFlashEnabled() {
        return null;
    }
    
    public final void onBarcodeDetected(@org.jetbrains.annotations.NotNull()
    java.lang.String barcode) {
    }
    
    public final void toggleFlash() {
    }
    
    public final void resetScanner() {
    }
    
    public final void onManualBarcodeSubmit(@org.jetbrains.annotations.NotNull()
    java.lang.String barcode) {
    }
}