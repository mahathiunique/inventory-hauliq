package com.hauliq.app.data.repository;

import com.hauliq.app.data.local.dao.InventoryDao;
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
public final class RoomInventoryRepository_Factory implements Factory<RoomInventoryRepository> {
  private final Provider<InventoryDao> inventoryDaoProvider;

  public RoomInventoryRepository_Factory(Provider<InventoryDao> inventoryDaoProvider) {
    this.inventoryDaoProvider = inventoryDaoProvider;
  }

  @Override
  public RoomInventoryRepository get() {
    return newInstance(inventoryDaoProvider.get());
  }

  public static RoomInventoryRepository_Factory create(
      Provider<InventoryDao> inventoryDaoProvider) {
    return new RoomInventoryRepository_Factory(inventoryDaoProvider);
  }

  public static RoomInventoryRepository newInstance(InventoryDao inventoryDao) {
    return new RoomInventoryRepository(inventoryDao);
  }
}
