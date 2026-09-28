package com.hauliq.app.di;

import com.google.firebase.database.FirebaseDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class FirebaseModule_Companion_ProvideFirebaseDatabaseFactory implements Factory<FirebaseDatabase> {
  @Override
  public FirebaseDatabase get() {
    return provideFirebaseDatabase();
  }

  public static FirebaseModule_Companion_ProvideFirebaseDatabaseFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FirebaseDatabase provideFirebaseDatabase() {
    return Preconditions.checkNotNullFromProvides(FirebaseModule.Companion.provideFirebaseDatabase());
  }

  private static final class InstanceHolder {
    private static final FirebaseModule_Companion_ProvideFirebaseDatabaseFactory INSTANCE = new FirebaseModule_Companion_ProvideFirebaseDatabaseFactory();
  }
}
