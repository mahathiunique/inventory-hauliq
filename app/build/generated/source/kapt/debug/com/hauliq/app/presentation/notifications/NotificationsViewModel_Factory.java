package com.hauliq.app.presentation.notifications;

import com.hauliq.app.domain.repository.NotificationRepository;
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
public final class NotificationsViewModel_Factory implements Factory<NotificationsViewModel> {
  private final Provider<NotificationRepository> notificationRepositoryProvider;

  public NotificationsViewModel_Factory(
      Provider<NotificationRepository> notificationRepositoryProvider) {
    this.notificationRepositoryProvider = notificationRepositoryProvider;
  }

  @Override
  public NotificationsViewModel get() {
    return newInstance(notificationRepositoryProvider.get());
  }

  public static NotificationsViewModel_Factory create(
      Provider<NotificationRepository> notificationRepositoryProvider) {
    return new NotificationsViewModel_Factory(notificationRepositoryProvider);
  }

  public static NotificationsViewModel newInstance(NotificationRepository notificationRepository) {
    return new NotificationsViewModel(notificationRepository);
  }
}
