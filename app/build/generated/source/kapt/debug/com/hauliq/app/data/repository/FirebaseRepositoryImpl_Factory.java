package com.hauliq.app.data.repository;

import com.google.firebase.database.DatabaseReference;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class FirebaseRepositoryImpl_Factory implements Factory<FirebaseRepositoryImpl> {
  private final Provider<DatabaseReference> rootRefProvider;

  public FirebaseRepositoryImpl_Factory(Provider<DatabaseReference> rootRefProvider) {
    this.rootRefProvider = rootRefProvider;
  }

  @Override
  public FirebaseRepositoryImpl get() {
    return newInstance(rootRefProvider.get());
  }

  public static FirebaseRepositoryImpl_Factory create(Provider<DatabaseReference> rootRefProvider) {
    return new FirebaseRepositoryImpl_Factory(rootRefProvider);
  }

  public static FirebaseRepositoryImpl newInstance(DatabaseReference rootRef) {
    return new FirebaseRepositoryImpl(rootRef);
  }
}
