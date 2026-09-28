package com.hauliq.app.presentation.settings;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/hauliq/app/presentation/settings/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_isDarkTheme", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_isNotificationsEnabled", "_selectedLanguage", "", "isDarkTheme", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "isNotificationsEnabled", "selectedLanguage", "getSelectedLanguage", "setLanguage", "", "lang", "toggleDarkTheme", "enabled", "toggleNotifications", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SettingsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isDarkTheme = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isDarkTheme = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _selectedLanguage = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> selectedLanguage = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isNotificationsEnabled = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isNotificationsEnabled = null;
    
    @javax.inject.Inject()
    public SettingsViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isDarkTheme() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSelectedLanguage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isNotificationsEnabled() {
        return null;
    }
    
    public final void toggleDarkTheme(boolean enabled) {
    }
    
    public final void toggleNotifications(boolean enabled) {
    }
    
    public final void setLanguage(@org.jetbrains.annotations.NotNull()
    java.lang.String lang) {
    }
}