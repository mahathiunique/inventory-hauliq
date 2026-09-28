package com.hauliq.app.data.repository;

import com.hauliq.app.data.local.dao.NotificationDao;
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
public final class RoomNotificationRepository_Factory implements Factory<RoomNotificationRepository> {
  private final Provider<NotificationDao> notificationDaoProvider;

  public RoomNotificationRepository_Factory(Provider<NotificationDao> notificationDaoProvider) {
    this.notificationDaoProvider = notificationDaoProvider;
  }

  @Override
  public RoomNotificationRepository get() {
    return newInstance(notificationDaoProvider.get());
  }

  public static RoomNotificationRepository_Factory create(
      Provider<NotificationDao> notificationDaoProvider) {
    return new RoomNotificationRepository_Factory(notificationDaoProvider);
  }

  public static RoomNotificationRepository newInstance(NotificationDao notificationDao) {
    return new RoomNotificationRepository(notificationDao);
  }
}
