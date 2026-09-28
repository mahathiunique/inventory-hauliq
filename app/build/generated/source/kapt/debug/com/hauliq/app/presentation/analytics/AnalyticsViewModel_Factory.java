package com.hauliq.app.presentation.analytics;

import com.hauliq.app.domain.repository.AnalyticsRepository;
import com.hauliq.app.domain.repository.InventoryRepository;
import com.hauliq.app.domain.repository.OrderRepository;
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
public final class AnalyticsViewModel_Factory implements Factory<AnalyticsViewModel> {
  private final Provider<AnalyticsRepository> analyticsRepositoryProvider;

  private final Provider<InventoryRepository> inventoryRepositoryProvider;

  private final Provider<OrderRepository> orderRepositoryProvider;

  private final Provider<TransactionRepository> transactionRepositoryProvider;

  public AnalyticsViewModel_Factory(Provider<AnalyticsRepository> analyticsRepositoryProvider,
      Provider<InventoryRepository> inventoryRepositoryProvider,
      Provider<OrderRepository> orderRepositoryProvider,
      Provider<TransactionRepository> transactionRepositoryProvider) {
    this.analyticsRepositoryProvider = analyticsRepositoryProvider;
    this.inventoryRepositoryProvider = inventoryRepositoryProvider;
    this.orderRepositoryProvider = orderRepositoryProvider;
    this.transactionRepositoryProvider = transactionRepositoryProvider;
  }

  @Override
  public AnalyticsViewModel get() {
    return newInstance(analyticsRepositoryProvider.get(), inventoryRepositoryProvider.get(), orderRepositoryProvider.get(), transactionRepositoryProvider.get());
  }

  public static AnalyticsViewModel_Factory create(
      Provider<AnalyticsRepository> analyticsRepositoryProvider,
      Provider<InventoryRepository> inventoryRepositoryProvider,
      Provider<OrderRepository> orderRepositoryProvider,
      Provider<TransactionRepository> transactionRepositoryProvider) {
    return new AnalyticsViewModel_Factory(analyticsRepositoryProvider, inventoryRepositoryProvider, orderRepositoryProvider, transactionRepositoryProvider);
  }

  public static AnalyticsViewModel newInstance(AnalyticsRepository analyticsRepository,
      InventoryRepository inventoryRepository, OrderRepository orderRepository,
      TransactionRepository transactionRepository) {
    return new AnalyticsViewModel(analyticsRepository, inventoryRepository, orderRepository, transactionRepository);
  }
}
