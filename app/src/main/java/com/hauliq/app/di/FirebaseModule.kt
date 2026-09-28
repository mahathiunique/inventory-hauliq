package com.hauliq.app.di

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.hauliq.app.data.repository.FirebaseRepositoryImpl
import com.hauliq.app.domain.repository.FirebaseRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class FirebaseModule {

    @Binds
    @Singleton
    abstract fun bindFirebaseRepository(
        impl: FirebaseRepositoryImpl
    ): FirebaseRepository

    companion object {
        @Provides
        @Singleton
        fun provideFirebaseDatabase(): FirebaseDatabase {
            return FirebaseDatabase.getInstance("https://hauliq-bcda2-default-rtdb.asia-southeast1.firebasedatabase.app")
        }

        @Provides
        @Singleton
        fun provideRootReference(database: FirebaseDatabase): DatabaseReference {
            return database.reference
        }
    }
}
