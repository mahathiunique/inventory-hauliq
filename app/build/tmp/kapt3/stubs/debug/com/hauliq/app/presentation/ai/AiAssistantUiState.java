package com.hauliq.app.presentation.ai;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\nH\u00c6\u0003J\t\u0010\u0019\u001a\u00020\fH\u00c6\u0003JM\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020\fH\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011\u00a8\u0006 "}, d2 = {"Lcom/hauliq/app/presentation/ai/AiAssistantUiState;", "", "insights", "", "Lcom/hauliq/app/domain/model/AiInsight;", "suggestions", "Lcom/hauliq/app/domain/model/ReorderSuggestion;", "messages", "Lcom/hauliq/app/domain/model/ChatMessage;", "isLoading", "", "currentInput", "", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;ZLjava/lang/String;)V", "getCurrentInput", "()Ljava/lang/String;", "getInsights", "()Ljava/util/List;", "()Z", "getMessages", "getSuggestions", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class AiAssistantUiState {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.hauliq.app.domain.model.AiInsight> insights = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.hauliq.app.domain.model.ReorderSuggestion> suggestions = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.hauliq.app.domain.model.ChatMessage> messages = null;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String currentInput = null;
    
    public AiAssistantUiState(@org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.AiInsight> insights, @org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.ReorderSuggestion> suggestions, @org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.ChatMessage> messages, boolean isLoading, @org.jetbrains.annotations.NotNull()
    java.lang.String currentInput) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.hauliq.app.domain.model.AiInsight> getInsights() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.hauliq.app.domain.model.ReorderSuggestion> getSuggestions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.hauliq.app.domain.model.ChatMessage> getMessages() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentInput() {
        return null;
    }
    
    public AiAssistantUiState() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.hauliq.app.domain.model.AiInsight> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.hauliq.app.domain.model.ReorderSuggestion> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.hauliq.app.domain.model.ChatMessage> component3() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.hauliq.app.presentation.ai.AiAssistantUiState copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.AiInsight> insights, @org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.ReorderSuggestion> suggestions, @org.jetbrains.annotations.NotNull()
    java.util.List<com.hauliq.app.domain.model.ChatMessage> messages, boolean isLoading, @org.jetbrains.annotations.NotNull()
    java.lang.String currentInput) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}