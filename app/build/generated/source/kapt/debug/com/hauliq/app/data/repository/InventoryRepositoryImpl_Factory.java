package com.hauliq.app.data.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class InventoryRepositoryImpl_Factory implements Factory<InventoryRepositoryImpl> {
  @Override
  public InventoryRepositoryImpl get() {
    return newInstance();
  }

  public static InventoryRepositoryImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static InventoryRepositoryImpl newInstance() {
    return new InventoryRepositoryImpl();
  }

  private static final class InstanceHolder {
    private static final InventoryRepositoryImpl_Factory INSTANCE = new InventoryRepositoryImpl_Factory();
  }
}
