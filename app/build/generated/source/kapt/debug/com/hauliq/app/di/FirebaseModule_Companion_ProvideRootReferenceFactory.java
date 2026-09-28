package com.hauliq.app.di;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class FirebaseModule_Companion_ProvideRootReferenceFactory implements Factory<DatabaseReference> {
  private final Provider<FirebaseDatabase> databaseProvider;

  public FirebaseModule_Companion_ProvideRootReferenceFactory(
      Provider<FirebaseDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public DatabaseReference get() {
    return provideRootReference(databaseProvider.get());
  }

  public static FirebaseModule_Companion_ProvideRootReferenceFactory create(
      Provider<FirebaseDatabase> databaseProvider) {
    return new FirebaseModule_Companion_ProvideRootReferenceFactory(databaseProvider);
  }

  public static DatabaseReference provideRootReference(FirebaseDatabase database) {
    return Preconditions.checkNotNullFromProvides(FirebaseModule.Companion.provideRootReference(database));
  }
}
