package com.hauliq.app.presentation.profile;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/hauliq/app/presentation/profile/ProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_profile", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/hauliq/app/presentation/profile/UserProfile;", "profile", "Lkotlinx/coroutines/flow/StateFlow;", "getProfile", "()Lkotlinx/coroutines/flow/StateFlow;", "updateProfile", "", "name", "", "email", "businessName", "location", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ProfileViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.hauliq.app.presentation.profile.UserProfile> _profile = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.presentation.profile.UserProfile> profile = null;
    
    @javax.inject.Inject()
    public ProfileViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.presentation.profile.UserProfile> getProfile() {
        return null;
    }
    
    public final void updateProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String businessName, @org.jetbrains.annotations.NotNull()
    java.lang.String location) {
    }
}