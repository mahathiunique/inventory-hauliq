package com.hauliq.app.data.repository;

import com.hauliq.app.data.local.dao.SupplierDao;
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
public final class RoomSupplierRepository_Factory implements Factory<RoomSupplierRepository> {
  private final Provider<SupplierDao> supplierDaoProvider;

  public RoomSupplierRepository_Factory(Provider<SupplierDao> supplierDaoProvider) {
    this.supplierDaoProvider = supplierDaoProvider;
  }

  @Override
  public RoomSupplierRepository get() {
    return newInstance(supplierDaoProvider.get());
  }

  public static RoomSupplierRepository_Factory create(Provider<SupplierDao> supplierDaoProvider) {
    return new RoomSupplierRepository_Factory(supplierDaoProvider);
  }

  public static RoomSupplierRepository newInstance(SupplierDao supplierDao) {
    return new RoomSupplierRepository(supplierDao);
  }
}
