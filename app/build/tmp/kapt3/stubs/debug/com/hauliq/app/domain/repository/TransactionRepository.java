package com.hauliq.app.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH&J\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/hauliq/app/domain/repository/TransactionRepository;", "", "addTransaction", "", "transaction", "Lcom/hauliq/app/domain/model/Transaction;", "(Lcom/hauliq/app/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTransactions", "Lkotlinx/coroutines/flow/Flow;", "", "getTransactionsByType", "type", "Lcom/hauliq/app/domain/model/TransactionType;", "app_debug"})
public abstract interface TransactionRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.domain.model.Transaction>> getAllTransactions();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.domain.model.Transaction>> getTransactionsByType(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.TransactionType type);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addTransaction(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.Transaction transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}