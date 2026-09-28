package com.hauliq.app.presentation.dashboard;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u001e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007\u001a\\\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a|\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007\u001a8\u0010#\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00122\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\'"}, d2 = {"ActivityItem", "", "activity", "Lcom/hauliq/app/domain/model/ActivityLog;", "AiInsightDashboardCard", "insight", "Lcom/hauliq/app/domain/model/AiInsight;", "onClick", "Lkotlin/Function0;", "AnimatedDashboardCard", "title", "", "targetValue", "", "subtitle", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "iconColor", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "isCurrency", "", "AnimatedDashboardCard-yrwZFoE", "(Ljava/lang/String;FLjava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;JLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Z)V", "DashboardScreen", "viewModel", "Lcom/hauliq/app/presentation/dashboard/DashboardViewModel;", "onNavigateToInventory", "onNavigateToScanner", "onNavigateToReports", "onNavigateToAnalytics", "onNavigateToNotifications", "onNavigateToOrders", "onNavigateToAiAssistant", "QuickActionButton", "color", "QuickActionButton-9LQNqLg", "(Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;JLkotlin/jvm/functions/Function0;)V", "app_debug"})
public final class DashboardScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void DashboardScreen(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.presentation.dashboard.DashboardViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToInventory, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToScanner, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToReports, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToAnalytics, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToNotifications, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToOrders, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToAiAssistant, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AiInsightDashboardCard(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.AiInsight insight, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ActivityItem(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.ActivityLog activity) {
    }
}