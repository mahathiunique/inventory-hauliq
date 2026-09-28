package com.hauliq.app.presentation.inventory;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tJ\u0016\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a2\u0006\u0010\u0018\u001a\u00020\tJ\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\tJ\u000e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\tJ\u0012\u0010%\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\'\u001a\u00020(H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e\u00a8\u0006)"}, d2 = {"Lcom/hauliq/app/presentation/inventory/InventoryViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/hauliq/app/domain/repository/InventoryRepository;", "(Lcom/hauliq/app/domain/repository/InventoryRepository;)V", "_formState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/hauliq/app/presentation/inventory/InventoryFormState;", "_searchQuery", "", "_selectedCategory", "formState", "Lkotlinx/coroutines/flow/StateFlow;", "getFormState", "()Lkotlinx/coroutines/flow/StateFlow;", "searchQuery", "getSearchQuery", "selectedCategory", "getSelectedCategory", "uiState", "Lcom/hauliq/app/presentation/inventory/InventoryUiState;", "getUiState", "deleteProduct", "", "id", "getProduct", "Lkotlinx/coroutines/flow/Flow;", "Lcom/hauliq/app/domain/model/Product;", "loadProductIntoForm", "product", "onCategorySelect", "category", "onFormEvent", "event", "Lcom/hauliq/app/presentation/inventory/InventoryFormEvent;", "onSearchQueryChange", "query", "saveProduct", "productId", "validateForm", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class InventoryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.domain.repository.InventoryRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _selectedCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> selectedCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.hauliq.app.presentation.inventory.InventoryFormState> _formState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.presentation.inventory.InventoryFormState> formState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.presentation.inventory.InventoryUiState> uiState = null;
    
    @javax.inject.Inject()
    public InventoryViewModel(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.repository.InventoryRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSearchQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSelectedCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.presentation.inventory.InventoryFormState> getFormState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.hauliq.app.domain.model.Product> getProduct(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    public final void onFormEvent(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.presentation.inventory.InventoryFormEvent event) {
    }
    
    private final void loadProductIntoForm(com.hauliq.app.domain.model.Product product) {
    }
    
    private final void saveProduct(java.lang.String productId) {
    }
    
    private final boolean validateForm() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.presentation.inventory.InventoryUiState> getUiState() {
        return null;
    }
    
    public final void onSearchQueryChange(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final void onCategorySelect(@org.jetbrains.annotations.NotNull()
    java.lang.String category) {
    }
    
    public final void deleteProduct(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
}