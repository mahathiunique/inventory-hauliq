package com.hauliq.app.presentation.auth;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u001c\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010J\u0016\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000bJ&\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/hauliq/app/presentation/auth/AuthViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_authState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/hauliq/app/presentation/auth/AuthState;", "authState", "Lkotlinx/coroutines/flow/StateFlow;", "getAuthState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearError", "", "forgotPassword", "email", "", "onEmailSent", "Lkotlin/Function0;", "login", "javaPassword", "logout", "register", "name", "businessName", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AuthViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.hauliq.app.presentation.auth.AuthState> _authState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.presentation.auth.AuthState> authState = null;
    
    @javax.inject.Inject()
    public AuthViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.presentation.auth.AuthState> getAuthState() {
        return null;
    }
    
    public final void login(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String javaPassword) {
    }
    
    public final void register(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String javaPassword, @org.jetbrains.annotations.NotNull()
    java.lang.String businessName) {
    }
    
    public final void forgotPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onEmailSent) {
    }
    
    public final void logout() {
    }
    
    public final void clearError() {
    }
}