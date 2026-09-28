package com.hauliq.app.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u0003H&\u00a8\u0006\f"}, d2 = {"Lcom/hauliq/app/domain/repository/AiAssistantRepository;", "", "getAiInsights", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/hauliq/app/domain/model/AiInsight;", "getChatResponse", "", "message", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReorderSuggestions", "Lcom/hauliq/app/domain/model/ReorderSuggestion;", "app_debug"})
public abstract interface AiAssistantRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.domain.model.AiInsight>> getAiInsights();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.domain.model.ReorderSuggestion>> getReorderSuggestions();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getChatResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion);
}