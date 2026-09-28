package com.hauliq.app.presentation.reports;

import com.hauliq.app.domain.repository.InventoryRepository;
import com.hauliq.app.domain.repository.TransactionRepository;
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
public final class ReportsViewModel_Factory implements Factory<ReportsViewModel> {
  private final Provider<InventoryRepository> inventoryRepositoryProvider;

  private final Provider<TransactionRepository> transactionRepositoryProvider;

  public ReportsViewModel_Factory(Provider<InventoryRepository> inventoryRepositoryProvider,
      Provider<TransactionRepository> transactionRepositoryProvider) {
    this.inventoryRepositoryProvider = inventoryRepositoryProvider;
    this.transactionRepositoryProvider = transactionRepositoryProvider;
  }

  @Override
  public ReportsViewModel get() {
    return newInstance(inventoryRepositoryProvider.get(), transactionRepositoryProvider.get());
  }

  public static ReportsViewModel_Factory create(
      Provider<InventoryRepository> inventoryRepositoryProvider,
      Provider<TransactionRepository> transactionRepositoryProvider) {
    return new ReportsViewModel_Factory(inventoryRepositoryProvider, transactionRepositoryProvider);
  }

  public static ReportsViewModel newInstance(InventoryRepository inventoryRepository,
      TransactionRepository transactionRepository) {
    return new ReportsViewModel(inventoryRepository, transactionRepository);
  }
}
