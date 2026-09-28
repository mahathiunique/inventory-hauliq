package com.hauliq.app.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bH\u0016J\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/hauliq/app/data/repository/RoomTransactionRepository;", "Lcom/hauliq/app/domain/repository/TransactionRepository;", "transactionDao", "Lcom/hauliq/app/data/local/dao/TransactionDao;", "(Lcom/hauliq/app/data/local/dao/TransactionDao;)V", "addTransaction", "", "transaction", "Lcom/hauliq/app/domain/model/Transaction;", "(Lcom/hauliq/app/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTransactions", "Lkotlinx/coroutines/flow/Flow;", "", "getTransactionsByType", "type", "Lcom/hauliq/app/domain/model/TransactionType;", "app_debug"})
public final class RoomTransactionRepository implements com.hauliq.app.domain.repository.TransactionRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.data.local.dao.TransactionDao transactionDao = null;
    
    @javax.inject.Inject()
    public RoomTransactionRepository(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.local.dao.TransactionDao transactionDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.domain.model.Transaction>> getAllTransactions() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.domain.model.Transaction>> getTransactionsByType(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.TransactionType type) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object addTransaction(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.Transaction transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}