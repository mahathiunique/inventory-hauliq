package com.hauliq.app.presentation.inventory;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a2\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u00a8\u0006\u000f"}, d2 = {"InventoryItemCard", "", "product", "Lcom/hauliq/app/domain/model/Product;", "onClick", "Lkotlin/Function0;", "onEdit", "onDelete", "InventoryScreen", "viewModel", "Lcom/hauliq/app/presentation/inventory/InventoryViewModel;", "onNavigateToDetails", "Lkotlin/Function1;", "", "onNavigateToAddProduct", "app_debug"})
public final class InventoryScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void InventoryScreen(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.presentation.inventory.InventoryViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNavigateToDetails, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToAddProduct) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void InventoryItemCard(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.Product product, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onEdit, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDelete) {
    }
}