package com.hauliq.app.presentation.orders;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a>\u0010\u0006\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u00a8\u0006\u000e"}, d2 = {"CreateOrderScreen", "", "viewModel", "Lcom/hauliq/app/presentation/orders/OrderViewModel;", "onNavigateBack", "Lkotlin/Function0;", "ProductPickerDialog", "inventory", "", "Lcom/hauliq/app/domain/model/Product;", "onProductSelected", "Lkotlin/Function2;", "", "onDismiss", "app_debug"})
public final class CreateOrderScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void CreateOrderScreen(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.presentation.orders.OrderViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ProductPickerDialog(@org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.Product> inventory, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.hauliq.app.domain.model.Product, ? super java.lang.Integer, kotlin.Unit> onProductSelected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
}