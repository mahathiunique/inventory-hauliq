package com.hauliq.app.data.remote;

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
public final class FirebaseSeeder_Factory implements Factory<FirebaseSeeder> {
  private final Provider<DatabaseReference> rootRefProvider;

  public FirebaseSeeder_Factory(Provider<DatabaseReference> rootRefProvider) {
    this.rootRefProvider = rootRefProvider;
  }

  @Override
  public FirebaseSeeder get() {
    return newInstance(rootRefProvider.get());
  }

  public static FirebaseSeeder_Factory create(Provider<DatabaseReference> rootRefProvider) {
    return new FirebaseSeeder_Factory(rootRefProvider);
  }

  public static FirebaseSeeder newInstance(DatabaseReference rootRef) {
    return new FirebaseSeeder(rootRef);
  }
}
