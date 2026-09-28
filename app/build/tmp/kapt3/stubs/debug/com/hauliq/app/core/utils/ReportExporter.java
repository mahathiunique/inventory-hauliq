package com.hauliq.app.core.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002J2\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bJ2\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bJ,\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0002J*\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0014H\u0002J(\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002\u00a8\u0006\u001d"}, d2 = {"Lcom/hauliq/app/core/utils/ReportExporter;", "", "()V", "buildCsvContent", "", "state", "Lcom/hauliq/app/presentation/analytics/AnalyticsUiState;", "products", "", "Lcom/hauliq/app/domain/model/Product;", "transactions", "Lcom/hauliq/app/domain/model/Transaction;", "escapeCsv", "str", "exportAndShareCsv", "", "context", "Landroid/content/Context;", "exportAndSharePdf", "generatePdfDocument", "", "saveFileToDownloadsOrStorage", "Landroid/net/Uri;", "filename", "mimeType", "contentBytes", "shareFile", "uri", "title", "app_debug"})
public final class ReportExporter {
    @org.jetbrains.annotations.NotNull()
    public static final com.hauliq.app.core.utils.ReportExporter INSTANCE = null;
    
    private ReportExporter() {
        super();
    }
    
    public final void exportAndShareCsv(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.hauliq.app.presentation.analytics.AnalyticsUiState state, @org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.Product> products, @org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.Transaction> transactions) {
    }
    
    public final void exportAndSharePdf(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.hauliq.app.presentation.analytics.AnalyticsUiState state, @org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.Product> products, @org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.Transaction> transactions) {
    }
    
    private final java.lang.String buildCsvContent(com.hauliq.app.presentation.analytics.AnalyticsUiState state, java.util.List<com.hauliq.app.domain.model.Product> products, java.util.List<com.hauliq.app.domain.model.Transaction> transactions) {
        return null;
    }
    
    private final java.lang.String escapeCsv(java.lang.String str) {
        return null;
    }
    
    private final byte[] generatePdfDocument(com.hauliq.app.presentation.analytics.AnalyticsUiState state, java.util.List<com.hauliq.app.domain.model.Product> products, java.util.List<com.hauliq.app.domain.model.Transaction> transactions) {
        return null;
    }
    
    private final android.net.Uri saveFileToDownloadsOrStorage(android.content.Context context, java.lang.String filename, java.lang.String mimeType, byte[] contentBytes) {
        return null;
    }
    
    private final void shareFile(android.content.Context context, android.net.Uri uri, java.lang.String mimeType, java.lang.String title) {
    }
}