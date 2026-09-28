package com.hauliq.app.di;

import com.hauliq.app.data.local.HaulIQDatabase;
import com.hauliq.app.data.local.dao.OrderDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_Companion_ProvideOrderDaoFactory implements Factory<OrderDao> {
  private final Provider<HaulIQDatabase> databaseProvider;

  public AppModule_Companion_ProvideOrderDaoFactory(Provider<HaulIQDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public OrderDao get() {
    return provideOrderDao(databaseProvider.get());
  }

  public static AppModule_Companion_ProvideOrderDaoFactory create(
      Provider<HaulIQDatabase> databaseProvider) {
    return new AppModule_Companion_ProvideOrderDaoFactory(databaseProvider);
  }

  public static OrderDao provideOrderDao(HaulIQDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.Companion.provideOrderDao(database));
  }
}
