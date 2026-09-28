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
public final class AnalyticsRepositoryImpl_Factory implements Factory<AnalyticsRepositoryImpl> {
  private final Provider<InventoryDao> inventoryDaoProvider;

  private final Provider<OrderDao> orderDaoProvider;

  public AnalyticsRepositoryImpl_Factory(Provider<InventoryDao> inventoryDaoProvider,
      Provider<OrderDao> orderDaoProvider) {
    this.inventoryDaoProvider = inventoryDaoProvider;
    this.orderDaoProvider = orderDaoProvider;
  }

  @Override
  public AnalyticsRepositoryImpl get() {
    return newInstance(inventoryDaoProvider.get(), orderDaoProvider.get());
  }

  public static AnalyticsRepositoryImpl_Factory create(Provider<InventoryDao> inventoryDaoProvider,
      Provider<OrderDao> orderDaoProvider) {
    return new AnalyticsRepositoryImpl_Factory(inventoryDaoProvider, orderDaoProvider);
  }

  public static AnalyticsRepositoryImpl newInstance(InventoryDao inventoryDao, OrderDao orderDao) {
    return new AnalyticsRepositoryImpl(inventoryDao, orderDao);
  }
}
