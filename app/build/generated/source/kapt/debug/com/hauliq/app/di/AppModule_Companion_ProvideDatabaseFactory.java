package com.hauliq.app.di;

import android.content.Context;
import com.hauliq.app.data.local.HaulIQDatabase;
import com.hauliq.app.data.local.dao.InventoryDao;
import com.hauliq.app.data.local.dao.NotificationDao;
import com.hauliq.app.data.local.dao.SupplierDao;
import com.hauliq.app.data.local.dao.TransactionDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AppModule_Companion_ProvideDatabaseFactory implements Factory<HaulIQDatabase> {
  private final Provider<Context> contextProvider;

  private final Provider<InventoryDao> inventoryDaoProvider;

  private final Provider<SupplierDao> supplierDaoProvider;

  private final Provider<TransactionDao> transactionDaoProvider;

  private final Provider<NotificationDao> notificationDaoProvider;

  public AppModule_Companion_ProvideDatabaseFactory(Provider<Context> contextProvider,
      Provider<InventoryDao> inventoryDaoProvider, Provider<SupplierDao> supplierDaoProvider,
      Provider<TransactionDao> transactionDaoProvider,
      Provider<NotificationDao> notificationDaoProvider) {
    this.contextProvider = contextProvider;
    this.inventoryDaoProvider = inventoryDaoProvider;
    this.supplierDaoProvider = supplierDaoProvider;
    this.transactionDaoProvider = transactionDaoProvider;
    this.notificationDaoProvider = notificationDaoProvider;
  }

  @Override
  public HaulIQDatabase get() {
    return provideDatabase(contextProvider.get(), inventoryDaoProvider, supplierDaoProvider, transactionDaoProvider, notificationDaoProvider);
  }

  public static AppModule_Companion_ProvideDatabaseFactory create(Provider<Context> contextProvider,
      Provider<InventoryDao> inventoryDaoProvider, Provider<SupplierDao> supplierDaoProvider,
      Provider<TransactionDao> transactionDaoProvider,
      Provider<NotificationDao> notificationDaoProvider) {
    return new AppModule_Companion_ProvideDatabaseFactory(contextProvider, inventoryDaoProvider, supplierDaoProvider, transactionDaoProvider, notificationDaoProvider);
  }

  public static HaulIQDatabase provideDatabase(Context context,
      Provider<InventoryDao> inventoryDaoProvider, Provider<SupplierDao> supplierDaoProvider,
      Provider<TransactionDao> transactionDaoProvider,
      Provider<NotificationDao> notificationDaoProvider) {
    return Preconditions.checkNotNullFromProvides(AppModule.Companion.provideDatabase(context, inventoryDaoProvider, supplierDaoProvider, transactionDaoProvider, notificationDaoProvider));
  }
}
