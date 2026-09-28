package com.hauliq.app.presentation.seeder;

import com.hauliq.app.data.remote.FirebaseSeeder;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class SeederViewModel_Factory implements Factory<SeederViewModel> {
  private final Provider<FirebaseSeeder> seederProvider;

  public SeederViewModel_Factory(Provider<FirebaseSeeder> seederProvider) {
    this.seederProvider = seederProvider;
  }

  @Override
  public SeederViewModel get() {
    return newInstance(seederProvider.get());
  }

  public static SeederViewModel_Factory create(Provider<FirebaseSeeder> seederProvider) {
    return new SeederViewModel_Factory(seederProvider);
  }

  public static SeederViewModel newInstance(FirebaseSeeder seeder) {
    return new SeederViewModel(seeder);
  }
}
