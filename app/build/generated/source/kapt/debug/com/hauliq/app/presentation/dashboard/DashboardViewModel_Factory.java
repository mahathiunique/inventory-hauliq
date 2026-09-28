package com.hauliq.app.presentation.dashboard;

import com.hauliq.app.domain.repository.AiAssistantRepository;
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
public final class DashboardViewModel_Factory implements Factory<DashboardViewModel> {
  private final Provider<InventoryRepository> inventoryRepositoryProvider;

  private final Provider<OrderRepository> orderRepositoryProvider;

  private final Provider<AiAssistantRepository> aiAssistantRepositoryProvider;

  public DashboardViewModel_Factory(Provider<InventoryRepository> inventoryRepositoryProvider,
      Provider<OrderRepository> orderRepositoryProvider,
      Provider<AiAssistantRepository> aiAssistantRepositoryProvider) {
    this.inventoryRepositoryProvider = inventoryRepositoryProvider;
    this.orderRepositoryProvider = orderRepositoryProvider;
    this.aiAssistantRepositoryProvider = aiAssistantRepositoryProvider;
  }

  @Override
  public DashboardViewModel get() {
    return newInstance(inventoryRepositoryProvider.get(), orderRepositoryProvider.get(), aiAssistantRepositoryProvider.get());
  }

  public static DashboardViewModel_Factory create(
      Provider<InventoryRepository> inventoryRepositoryProvider,
      Provider<OrderRepository> orderRepositoryProvider,
      Provider<AiAssistantRepository> aiAssistantRepositoryProvider) {
    return new DashboardViewModel_Factory(inventoryRepositoryProvider, orderRepositoryProvider, aiAssistantRepositoryProvider);
  }

  public static DashboardViewModel newInstance(InventoryRepository inventoryRepository,
      OrderRepository orderRepository, AiAssistantRepository aiAssistantRepository) {
    return new DashboardViewModel(inventoryRepository, orderRepository, aiAssistantRepository);
  }
}
