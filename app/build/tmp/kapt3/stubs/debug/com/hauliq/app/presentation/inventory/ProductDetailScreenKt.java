package com.hauliq.app.presentation.inventory;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007\u001a:\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000eH\u0007\u001a\u0018\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0007\u00a8\u0006\u0013"}, d2 = {"DetailSection", "", "title", "", "items", "", "Lcom/hauliq/app/presentation/inventory/DetailItem;", "ProductDetailScreen", "productId", "viewModel", "Lcom/hauliq/app/presentation/inventory/InventoryViewModel;", "onNavigateBack", "Lkotlin/Function0;", "onNavigateToEdit", "Lkotlin/Function1;", "StockStatusChip", "quantity", "", "threshold", "app_debug"})
public final class ProductDetailScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void ProductDetailScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String productId, @org.jetbrains.annotations.NotNull()
    com.hauliq.app.presentation.inventory.InventoryViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNavigateToEdit) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DetailSection(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.presentation.inventory.DetailItem> items) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void StockStatusChip(int quantity, int threshold) {
    }
}