package com.hauliq.app.presentation.scanner;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B3\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0017R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/hauliq/app/presentation/scanner/BarcodeAnalyzer;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "onBarcodeDetected", "Lkotlin/Function1;", "", "", "onError", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "scanner", "Lcom/google/mlkit/vision/barcode/BarcodeScanner;", "analyze", "imageProxy", "Landroidx/camera/core/ImageProxy;", "app_debug"})
public final class BarcodeAnalyzer implements androidx.camera.core.ImageAnalysis.Analyzer {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> onBarcodeDetected = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.Exception, kotlin.Unit> onError = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.mlkit.vision.barcode.BarcodeScanner scanner = null;
    
    public BarcodeAnalyzer(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onBarcodeDetected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Exception, kotlin.Unit> onError) {
        super();
    }
    
    @java.lang.Override()
    @androidx.annotation.OptIn(markerClass = {androidx.camera.core.ExperimentalGetImage.class})
    public void analyze(@org.jetbrains.annotations.NotNull()
    androidx.camera.core.ImageProxy imageProxy) {
    }
}