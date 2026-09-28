package com.hauliq.app.data.remote;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J>\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0082@\u00a2\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u0017J4\u0010\u0018\u001a\u00020\r\"\b\b\u0000\u0010\u0019*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u0002H\u00190\u001dH\u0082@\u00a2\u0006\u0002\u0010\u001eR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006!"}, d2 = {"Lcom/hauliq/app/data/remote/FirebaseSeeder;", "", "rootRef", "Lcom/google/firebase/database/DatabaseReference;", "(Lcom/google/firebase/database/DatabaseReference;)V", "_uploadProgress", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/hauliq/app/data/remote/FirebaseSeeder$SeedingStatus;", "uploadProgress", "Lkotlinx/coroutines/flow/StateFlow;", "getUploadProgress", "()Lkotlinx/coroutines/flow/StateFlow;", "performResumableSeeding", "", "needsSuppliers", "", "needsWarehouses", "needsProducts", "needsTransactions", "needsSales", "needsUsers", "(ZZZZZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "seedDatabaseIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadInBatches", "T", "path", "", "data", "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "SeedingStatus", "app_debug"})
public final class FirebaseSeeder {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.database.DatabaseReference rootRef = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.hauliq.app.data.remote.FirebaseSeeder.SeedingStatus> _uploadProgress = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.data.remote.FirebaseSeeder.SeedingStatus> uploadProgress = null;
    @java.lang.Deprecated()
    public static final int TARGET_SUPPLIERS = 100;
    @java.lang.Deprecated()
    public static final int TARGET_WAREHOUSES = 5;
    @java.lang.Deprecated()
    public static final int TARGET_PRODUCTS = 500;
    @java.lang.Deprecated()
    public static final int TARGET_TRANSACTIONS = 1000;
    @java.lang.Deprecated()
    public static final int TARGET_SALES = 1000;
    @java.lang.Deprecated()
    public static final int TARGET_USERS = 2;
    @java.lang.Deprecated()
    public static final long GLOBAL_TIMEOUT = 60000L;
    @java.lang.Deprecated()
    public static final int BATCH_SIZE = 50;
    @org.jetbrains.annotations.NotNull()
    private static final com.hauliq.app.data.remote.FirebaseSeeder.Companion Companion = null;
    
    @javax.inject.Inject()
    public FirebaseSeeder(@org.jetbrains.annotations.NotNull()
    com.google.firebase.database.DatabaseReference rootRef) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.data.remote.FirebaseSeeder.SeedingStatus> getUploadProgress() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object seedDatabaseIfNeeded(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object performResumableSeeding(boolean needsSuppliers, boolean needsWarehouses, boolean needsProducts, boolean needsTransactions, boolean needsSales, boolean needsUsers, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final <T extends java.lang.Object>java.lang.Object uploadInBatches(java.lang.String path, java.util.Map<java.lang.String, ? extends T> data, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/hauliq/app/data/remote/FirebaseSeeder$Companion;", "", "()V", "BATCH_SIZE", "", "GLOBAL_TIMEOUT", "", "TARGET_PRODUCTS", "TARGET_SALES", "TARGET_SUPPLIERS", "TARGET_TRANSACTIONS", "TARGET_USERS", "TARGET_WAREHOUSES", "app_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/hauliq/app/data/remote/FirebaseSeeder$SeedingStatus;", "", "()V", "Failure", "Idle", "Progress", "Success", "Lcom/hauliq/app/data/remote/FirebaseSeeder$SeedingStatus$Failure;", "Lcom/hauliq/app/data/remote/FirebaseSeeder$SeedingStatus$Idle;", "Lcom/hauliq/app/data/remote/FirebaseSeeder$SeedingStatus$Progress;", "Lcom/hauliq/app/data/remote/FirebaseSeeder$SeedingStatus$Success;", "app_debug"})
    public static abstract class SeedingStatus {
        
        private SeedingStatus() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/hauliq/app/data/remote/FirebaseSeeder$SeedingStatus$Failure;", "Lcom/hauliq/app/data/remote/FirebaseSeeder$SeedingStatus;", "error", "", "(Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class Failure extends com.hauliq.app.data.remote.FirebaseSeeder.SeedingStatus {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String error = null;
            
            public Failure(@org.jetbrains.annotations.NotNull()
            java.lang.String error) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getError() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.hauliq.app.data.remote.FirebaseSeeder.SeedingStatus.Failure copy(@org.jetbrains.annotations.NotNull()
            java.lang.String error) {
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
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/hauliq/app/data/remote/FirebaseSeeder$SeedingStatus$Idle;", "Lcom/hauliq/app/data/remote/FirebaseSeeder$SeedingStatus;", "()V", "app_debug"})
        public static final class Idle extends com.hauliq.app.data.remote.FirebaseSeeder.SeedingStatus {
            @org.jetbrains.annotations.NotNull()
            public static final com.hauliq.app.data.remote.FirebaseSeeder.SeedingStatus.Idle INSTANCE = null;
            
            private Idle() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/hauliq/app/data/remote/FirebaseSeeder$SeedingStatus$Progress;", "Lcom/hauliq/app/data/remote/FirebaseSeeder$SeedingStatus;", "percentage", "", "message", "", "(ILjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getPercentage", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "app_debug"})
        public static final class Progress extends com.hauliq.app.data.remote.FirebaseSeeder.SeedingStatus {
            private final int percentage = 0;
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String message = null;
            
            public Progress(int percentage, @org.jetbrains.annotations.NotNull()
            java.lang.String message) {
            }
            
            public final int getPercentage() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getMessage() {
                return null;
            }
            
            public final int component1() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component2() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.hauliq.app.data.remote.FirebaseSeeder.SeedingStatus.Progress copy(int percentage, @org.jetbrains.annotations.NotNull()
            java.lang.String message) {
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
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/hauliq/app/data/remote/FirebaseSeeder$SeedingStatus$Success;", "Lcom/hauliq/app/data/remote/FirebaseSeeder$SeedingStatus;", "()V", "app_debug"})
        public static final class Success extends com.hauliq.app.data.remote.FirebaseSeeder.SeedingStatus {
            @org.jetbrains.annotations.NotNull()
            public static final com.hauliq.app.data.remote.FirebaseSeeder.SeedingStatus.Success INSTANCE = null;
            
            private Success() {
            }
        }
    }
}