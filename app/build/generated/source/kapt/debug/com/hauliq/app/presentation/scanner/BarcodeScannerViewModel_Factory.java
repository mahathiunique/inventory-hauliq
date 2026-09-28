package com.hauliq.app.presentation.scanner;

import com.hauliq.app.domain.repository.InventoryRepository;
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
public final class BarcodeScannerViewModel_Factory implements Factory<BarcodeScannerViewModel> {
  private final Provider<InventoryRepository> repositoryProvider;

  public BarcodeScannerViewModel_Factory(Provider<InventoryRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public BarcodeScannerViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static BarcodeScannerViewModel_Factory create(
      Provider<InventoryRepository> repositoryProvider) {
    return new BarcodeScannerViewModel_Factory(repositoryProvider);
  }

  public static BarcodeScannerViewModel newInstance(InventoryRepository repository) {
    return new BarcodeScannerViewModel(repository);
  }
}
