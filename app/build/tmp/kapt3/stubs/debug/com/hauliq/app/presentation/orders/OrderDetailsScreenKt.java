package com.hauliq.app.presentation.orders;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007\u001a&\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007\u001a\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0007H\u0007\u001a$\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u0012H\u0007\u00a8\u0006\u0013"}, d2 = {"DetailInfoCard", "", "items", "", "Lcom/hauliq/app/presentation/orders/DetailRow;", "OrderDetailsScreen", "orderId", "", "viewModel", "Lcom/hauliq/app/presentation/orders/OrderViewModel;", "onNavigateBack", "Lkotlin/Function0;", "SectionTitle", "title", "TimelineSection", "currentStatus", "Lcom/hauliq/app/domain/model/OrderStatus;", "onStatusUpdate", "Lkotlin/Function1;", "app_debug"})
public final class OrderDetailsScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void OrderDetailsScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String orderId, @org.jetbrains.annotations.NotNull()
    com.hauliq.app.presentation.orders.OrderViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void TimelineSection(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.OrderStatus currentStatus, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.hauliq.app.domain.model.OrderStatus, kotlin.Unit> onStatusUpdate) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SectionTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DetailInfoCard(@org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.presentation.orders.DetailRow> items) {
    }
}