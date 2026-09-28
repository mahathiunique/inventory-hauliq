package com.hauliq.app.presentation.suppliers;

import com.hauliq.app.domain.repository.SupplierRepository;
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
public final class SupplierViewModel_Factory implements Factory<SupplierViewModel> {
  private final Provider<SupplierRepository> supplierRepositoryProvider;

  public SupplierViewModel_Factory(Provider<SupplierRepository> supplierRepositoryProvider) {
    this.supplierRepositoryProvider = supplierRepositoryProvider;
  }

  @Override
  public SupplierViewModel get() {
    return newInstance(supplierRepositoryProvider.get());
  }

  public static SupplierViewModel_Factory create(
      Provider<SupplierRepository> supplierRepositoryProvider) {
    return new SupplierViewModel_Factory(supplierRepositoryProvider);
  }

  public static SupplierViewModel newInstance(SupplierRepository supplierRepository) {
    return new SupplierViewModel(supplierRepository);
  }
}
