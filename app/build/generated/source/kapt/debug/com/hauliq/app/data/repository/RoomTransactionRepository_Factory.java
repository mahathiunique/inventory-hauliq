package com.hauliq.app.data.repository;

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
public final class RoomTransactionRepository_Factory implements Factory<RoomTransactionRepository> {
  private final Provider<TransactionDao> transactionDaoProvider;

  public RoomTransactionRepository_Factory(Provider<TransactionDao> transactionDaoProvider) {
    this.transactionDaoProvider = transactionDaoProvider;
  }

  @Override
  public RoomTransactionRepository get() {
    return newInstance(transactionDaoProvider.get());
  }

  public static RoomTransactionRepository_Factory create(
      Provider<TransactionDao> transactionDaoProvider) {
    return new RoomTransactionRepository_Factory(transactionDaoProvider);
  }

  public static RoomTransactionRepository newInstance(TransactionDao transactionDao) {
    return new RoomTransactionRepository(transactionDao);
  }
}
