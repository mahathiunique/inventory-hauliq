package com.hauliq.app.presentation.transactions;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/hauliq/app/presentation/transactions/TransactionsViewModel;", "Landroidx/lifecycle/ViewModel;", "transactionRepository", "Lcom/hauliq/app/domain/repository/TransactionRepository;", "(Lcom/hauliq/app/domain/repository/TransactionRepository;)V", "_selectedFilter", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/hauliq/app/domain/model/TransactionType;", "filteredTransactions", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/hauliq/app/domain/model/Transaction;", "getFilteredTransactions", "()Lkotlinx/coroutines/flow/StateFlow;", "selectedFilter", "getSelectedFilter", "setFilter", "", "type", "app_debug"})
@kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class TransactionsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.domain.repository.TransactionRepository transactionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.hauliq.app.domain.model.TransactionType> _selectedFilter = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.domain.model.TransactionType> selectedFilter = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.hauliq.app.domain.model.Transaction>> filteredTransactions = null;
    
    @javax.inject.Inject()
    public TransactionsViewModel(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.repository.TransactionRepository transactionRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.domain.model.TransactionType> getSelectedFilter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.hauliq.app.domain.model.Transaction>> getFilteredTransactions() {
        return null;
    }
    
    public final void setFilter(@org.jetbrains.annotations.Nullable()
    com.hauliq.app.domain.model.TransactionType type) {
    }
}