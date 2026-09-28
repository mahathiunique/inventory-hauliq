package com.hauliq.app.data.repository;

import com.hauliq.app.data.local.dao.InventoryDao;
import com.hauliq.app.data.local.dao.OrderDao;
import com.hauliq.app.data.local.dao.TransactionDao;
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
public final class RoomOrderRepository_Factory implements Factory<RoomOrderRepository> {
  private final Provider<OrderDao> orderDaoProvider;

  private final Provider<InventoryDao> inventoryDaoProvider;

  private final Provider<TransactionDao> transactionDaoProvider;

  public RoomOrderRepository_Factory(Provider<OrderDao> orderDaoProvider,
      Provider<InventoryDao> inventoryDaoProvider,
      Provider<TransactionDao> transactionDaoProvider) {
    this.orderDaoProvider = orderDaoProvider;
    this.inventoryDaoProvider = inventoryDaoProvider;
    this.transactionDaoProvider = transactionDaoProvider;
  }

  @Override
  public RoomOrderRepository get() {
    return newInstance(orderDaoProvider.get(), inventoryDaoProvider.get(), transactionDaoProvider.get());
  }

  public static RoomOrderRepository_Factory create(Provider<OrderDao> orderDaoProvider,
      Provider<InventoryDao> inventoryDaoProvider,
      Provider<TransactionDao> transactionDaoProvider) {
    return new RoomOrderRepository_Factory(orderDaoProvider, inventoryDaoProvider, transactionDaoProvider);
  }

  public static RoomOrderRepository newInstance(OrderDao orderDao, InventoryDao inventoryDao,
      TransactionDao transactionDao) {
    return new RoomOrderRepository(orderDao, inventoryDao, transactionDao);
  }
}
