package com.hauliq.app.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0016J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\t0\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/hauliq/app/data/repository/AiAssistantRepositoryImpl;", "Lcom/hauliq/app/domain/repository/AiAssistantRepository;", "inventoryDao", "Lcom/hauliq/app/data/local/dao/InventoryDao;", "orderDao", "Lcom/hauliq/app/data/local/dao/OrderDao;", "(Lcom/hauliq/app/data/local/dao/InventoryDao;Lcom/hauliq/app/data/local/dao/OrderDao;)V", "getAiInsights", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/hauliq/app/domain/model/AiInsight;", "getChatResponse", "", "message", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReorderSuggestions", "Lcom/hauliq/app/domain/model/ReorderSuggestion;", "app_debug"})
public final class AiAssistantRepositoryImpl implements com.hauliq.app.domain.repository.AiAssistantRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.data.local.dao.InventoryDao inventoryDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.data.local.dao.OrderDao orderDao = null;
    
    @javax.inject.Inject()
    public AiAssistantRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.local.dao.InventoryDao inventoryDao, @org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.local.dao.OrderDao orderDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.domain.model.AiInsight>> getAiInsights() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.domain.model.ReorderSuggestion>> getReorderSuggestions() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getChatResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
}