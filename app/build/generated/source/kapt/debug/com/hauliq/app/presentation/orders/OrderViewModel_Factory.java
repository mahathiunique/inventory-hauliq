package com.hauliq.app.presentation.orders;

import com.hauliq.app.domain.repository.InventoryRepository;
import com.hauliq.app.domain.repository.OrderRepository;
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
public final class OrderViewModel_Factory implements Factory<OrderViewModel> {
  private final Provider<OrderRepository> orderRepositoryProvider;

  private final Provider<InventoryRepository> inventoryRepositoryProvider;

  public OrderViewModel_Factory(Provider<OrderRepository> orderRepositoryProvider,
      Provider<InventoryRepository> inventoryRepositoryProvider) {
    this.orderRepositoryProvider = orderRepositoryProvider;
    this.inventoryRepositoryProvider = inventoryRepositoryProvider;
  }

  @Override
  public OrderViewModel get() {
    return newInstance(orderRepositoryProvider.get(), inventoryRepositoryProvider.get());
  }

  public static OrderViewModel_Factory create(Provider<OrderRepository> orderRepositoryProvider,
      Provider<InventoryRepository> inventoryRepositoryProvider) {
    return new OrderViewModel_Factory(orderRepositoryProvider, inventoryRepositoryProvider);
  }

  public static OrderViewModel newInstance(OrderRepository orderRepository,
      InventoryRepository inventoryRepository) {
    return new OrderViewModel(orderRepository, inventoryRepository);
  }
}
