package com.hauliq.app.presentation.suppliers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J<\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\nJ\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/hauliq/app/presentation/suppliers/SupplierViewModel;", "Landroidx/lifecycle/ViewModel;", "supplierRepository", "Lcom/hauliq/app/domain/repository/SupplierRepository;", "(Lcom/hauliq/app/domain/repository/SupplierRepository;)V", "_searchQuery", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "filteredSuppliers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/hauliq/app/domain/model/Supplier;", "getFilteredSuppliers", "()Lkotlinx/coroutines/flow/StateFlow;", "searchQuery", "getSearchQuery", "addSupplier", "", "name", "contact", "email", "phone", "address", "categories", "setSearchQuery", "query", "app_debug"})
@kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SupplierViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.domain.repository.SupplierRepository supplierRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.hauliq.app.domain.model.Supplier>> filteredSuppliers = null;
    
    @javax.inject.Inject()
    public SupplierViewModel(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.repository.SupplierRepository supplierRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSearchQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.hauliq.app.domain.model.Supplier>> getFilteredSuppliers() {
        return null;
    }
    
    public final void setSearchQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final void addSupplier(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String contact, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.NotNull()
    java.lang.String address, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> categories) {
    }
}