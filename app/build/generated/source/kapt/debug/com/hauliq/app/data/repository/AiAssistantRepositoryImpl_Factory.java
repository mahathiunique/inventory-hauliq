package com.hauliq.app.data.repository;

import com.hauliq.app.data.local.dao.InventoryDao;
import com.hauliq.app.data.local.dao.OrderDao;
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
public final class AiAssistantRepositoryImpl_Factory implements Factory<AiAssistantRepositoryImpl> {
  private final Provider<InventoryDao> inventoryDaoProvider;

  private final Provider<OrderDao> orderDaoProvider;

  public AiAssistantRepositoryImpl_Factory(Provider<InventoryDao> inventoryDaoProvider,
      Provider<OrderDao> orderDaoProvider) {
    this.inventoryDaoProvider = inventoryDaoProvider;
    this.orderDaoProvider = orderDaoProvider;
  }

  @Override
  public AiAssistantRepositoryImpl get() {
    return newInstance(inventoryDaoProvider.get(), orderDaoProvider.get());
  }

  public static AiAssistantRepositoryImpl_Factory create(
      Provider<InventoryDao> inventoryDaoProvider, Provider<OrderDao> orderDaoProvider) {
    return new AiAssistantRepositoryImpl_Factory(inventoryDaoProvider, orderDaoProvider);
  }

  public static AiAssistantRepositoryImpl newInstance(InventoryDao inventoryDao,
      OrderDao orderDao) {
    return new AiAssistantRepositoryImpl(inventoryDao, orderDao);
  }
}
