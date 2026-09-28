package com.hauliq.app.presentation.analytics;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u001a\u0016\u0010\f\u001a\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007\u001a\u001a\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0016\u0010\u0015\u001a\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000eH\u0007\u001a\u0010\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001aH\u0007\u001a\u001c\u0010\u001b\u001a\u00020\u00012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00170\u001cH\u0007\u001a\"\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\b\u0010\u001f\u001a\u00020\u0001H\u0007\u001a2\u0010 \u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010#\u001a\u0010\u0010$\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001aH\u0007\u001a\u0016\u0010%\u001a\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020&0\u000eH\u0007\u001a\u0010\u0010\'\u001a\u00020\u00012\u0006\u0010(\u001a\u00020)H\u0007\u001a\u0016\u0010*\u001a\u00020\u00012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u000eH\u0007\u001a\u001c\u0010,\u001a\u00020\u00012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00170\u001cH\u0007\u001a\u0010\u0010-\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001aH\u0007\u001a\u0018\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003H\u0007\u001a<\u00101\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u00103\u001a\u0010\u00104\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001aH\u0007\u001a$\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u000109H\u0007\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006:"}, d2 = {"ActivityItem", "", "title", "", "desc", "time", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "color", "Landroidx/compose/ui/graphics/Color;", "ActivityItem-xwkQ0AY", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;J)V", "ActivityTimelineSection", "activities", "", "Lcom/hauliq/app/domain/model/Transaction;", "AnalyticsScreen", "viewModel", "Lcom/hauliq/app/presentation/analytics/AnalyticsViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "BarChart", "data", "", "ChartsSection", "state", "Lcom/hauliq/app/presentation/analytics/AnalyticsUiState;", "DonutChart", "", "ExportButton", "text", "ExportSection", "InsightCard", "details", "InsightCard-g2O1Hgs", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;J)V", "InventoryInsightsSection", "LineChart", "", "LowStockCard", "product", "Lcom/hauliq/app/domain/model/Product;", "LowStockSection", "products", "PieChart", "RevenueSection", "RevenueStat", "label", "value", "StatCard", "StatCard-42QJj7c", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;JLandroidx/compose/ui/Modifier;)V", "SummarySection", "TimeFilterSection", "selectedFilter", "Lcom/hauliq/app/presentation/analytics/TimeFilter;", "onFilterSelected", "Lkotlin/Function1;", "app_debug"})
public final class AnalyticsScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void AnalyticsScreen(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.presentation.analytics.AnalyticsViewModel viewModel, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void TimeFilterSection(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.presentation.analytics.TimeFilter selectedFilter, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.hauliq.app.presentation.analytics.TimeFilter, kotlin.Unit> onFilterSelected) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SummarySection(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.presentation.analytics.AnalyticsUiState state) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ChartsSection(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.presentation.analytics.AnalyticsUiState state) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void BarChart(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> data) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LineChart(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Float> data) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void PieChart(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Integer> data) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DonutChart(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Integer> data) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LowStockSection(@org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.Product> products) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LowStockCard(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.Product product) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void RevenueSection(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.presentation.analytics.AnalyticsUiState state) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void RevenueStat(@org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void InventoryInsightsSection(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.presentation.analytics.AnalyticsUiState state) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ActivityTimelineSection(@org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.Transaction> activities) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ExportSection() {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ExportButton(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.vector.ImageVector icon, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}