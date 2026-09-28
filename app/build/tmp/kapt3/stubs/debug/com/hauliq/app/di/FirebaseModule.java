package com.hauliq.app.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\b"}, d2 = {"Lcom/hauliq/app/di/FirebaseModule;", "", "()V", "bindFirebaseRepository", "Lcom/hauliq/app/domain/repository/FirebaseRepository;", "impl", "Lcom/hauliq/app/data/repository/FirebaseRepositoryImpl;", "Companion", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class FirebaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.hauliq.app.di.FirebaseModule.Companion Companion = null;
    
    public FirebaseModule() {
        super();
    }
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.hauliq.app.domain.repository.FirebaseRepository bindFirebaseRepository(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.data.repository.FirebaseRepositoryImpl impl);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/hauliq/app/di/FirebaseModule$Companion;", "", "()V", "provideFirebaseDatabase", "Lcom/google/firebase/database/FirebaseDatabase;", "provideRootReference", "Lcom/google/firebase/database/DatabaseReference;", "database", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @dagger.Provides()
        @javax.inject.Singleton()
        @org.jetbrains.annotations.NotNull()
        public final com.google.firebase.database.FirebaseDatabase provideFirebaseDatabase() {
            return null;
        }
        
        @dagger.Provides()
        @javax.inject.Singleton()
        @org.jetbrains.annotations.NotNull()
        public final com.google.firebase.database.DatabaseReference provideRootReference(@org.jetbrains.annotations.NotNull()
        com.google.firebase.database.FirebaseDatabase database) {
            return null;
        }
    }
}