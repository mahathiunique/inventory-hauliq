package com.hauliq.app;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hauliq.app.data.local.HaulIQDatabase;
import com.hauliq.app.data.local.dao.InventoryDao;
import com.hauliq.app.data.local.dao.NotificationDao;
import com.hauliq.app.data.local.dao.OrderDao;
import com.hauliq.app.data.local.dao.SupplierDao;
import com.hauliq.app.data.local.dao.TransactionDao;
import com.hauliq.app.data.remote.FirebaseSeeder;
import com.hauliq.app.data.repository.AiAssistantRepositoryImpl;
import com.hauliq.app.data.repository.AnalyticsRepositoryImpl;
import com.hauliq.app.data.repository.RoomInventoryRepository;
import com.hauliq.app.data.repository.RoomNotificationRepository;
import com.hauliq.app.data.repository.RoomOrderRepository;
import com.hauliq.app.data.repository.RoomSupplierRepository;
import com.hauliq.app.data.repository.RoomTransactionRepository;
import com.hauliq.app.di.AppModule_Companion_ProvideDatabaseFactory;
import com.hauliq.app.di.AppModule_Companion_ProvideInventoryDaoFactory;
import com.hauliq.app.di.AppModule_Companion_ProvideNotificationDaoFactory;
import com.hauliq.app.di.AppModule_Companion_ProvideOrderDaoFactory;
import com.hauliq.app.di.AppModule_Companion_ProvideSupplierDaoFactory;
import com.hauliq.app.di.AppModule_Companion_ProvideTransactionDaoFactory;
import com.hauliq.app.di.FirebaseModule_Companion_ProvideFirebaseDatabaseFactory;
import com.hauliq.app.di.FirebaseModule_Companion_ProvideRootReferenceFactory;
import com.hauliq.app.presentation.ai.AiAssistantViewModel;
import com.hauliq.app.presentation.ai.AiAssistantViewModel_HiltModules_KeyModule_ProvideFactory;
import com.hauliq.app.presentation.analytics.AnalyticsViewModel;
import com.hauliq.app.presentation.analytics.AnalyticsViewModel_HiltModules_KeyModule_ProvideFactory;
import com.hauliq.app.presentation.auth.AuthViewModel;
import com.hauliq.app.presentation.auth.AuthViewModel_HiltModules_KeyModule_ProvideFactory;
import com.hauliq.app.presentation.dashboard.DashboardViewModel;
import com.hauliq.app.presentation.dashboard.DashboardViewModel_HiltModules_KeyModule_ProvideFactory;
import com.hauliq.app.presentation.inventory.InventoryViewModel;
import com.hauliq.app.presentation.inventory.InventoryViewModel_HiltModules_KeyModule_ProvideFactory;
import com.hauliq.app.presentation.notifications.NotificationsViewModel;
import com.hauliq.app.presentation.notifications.NotificationsViewModel_HiltModules_KeyModule_ProvideFactory;
import com.hauliq.app.presentation.orders.OrderViewModel;
import com.hauliq.app.presentation.orders.OrderViewModel_HiltModules_KeyModule_ProvideFactory;
import com.hauliq.app.presentation.profile.ProfileViewModel;
import com.hauliq.app.presentation.profile.ProfileViewModel_HiltModules_KeyModule_ProvideFactory;
import com.hauliq.app.presentation.reports.ReportsViewModel;
import com.hauliq.app.presentation.reports.ReportsViewModel_HiltModules_KeyModule_ProvideFactory;
import com.hauliq.app.presentation.scanner.BarcodeScannerViewModel;
import com.hauliq.app.presentation.scanner.BarcodeScannerViewModel_HiltModules_KeyModule_ProvideFactory;
import com.hauliq.app.presentation.scanner.ScannerViewModel;
import com.hauliq.app.presentation.scanner.ScannerViewModel_HiltModules_KeyModule_ProvideFactory;
import com.hauliq.app.presentation.seeder.SeederViewModel;
import com.hauliq.app.presentation.seeder.SeederViewModel_HiltModules_KeyModule_ProvideFactory;
import com.hauliq.app.presentation.settings.SettingsViewModel;
import com.hauliq.app.presentation.settings.SettingsViewModel_HiltModules_KeyModule_ProvideFactory;
import com.hauliq.app.presentation.suppliers.SupplierViewModel;
import com.hauliq.app.presentation.suppliers.SupplierViewModel_HiltModules_KeyModule_ProvideFactory;
import com.hauliq.app.presentation.transactions.TransactionsViewModel;
import com.hauliq.app.presentation.transactions.TransactionsViewModel_HiltModules_KeyModule_ProvideFactory;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.SetBuilder;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

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
public final class DaggerMainApplication_HiltComponents_SingletonC {
  private DaggerMainApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public MainApplication_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements MainApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public MainApplication_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements MainApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public MainApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements MainApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public MainApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements MainApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public MainApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements MainApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public MainApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements MainApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public MainApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements MainApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public MainApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends MainApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends MainApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends MainApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends MainApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Set<String> getViewModelKeys() {
      return SetBuilder.<String>newSetBuilder(15).add(AiAssistantViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(AnalyticsViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(AuthViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(BarcodeScannerViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(DashboardViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(InventoryViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(NotificationsViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(OrderViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(ProfileViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(ReportsViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(ScannerViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(SeederViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(SettingsViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(SupplierViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(TransactionsViewModel_HiltModules_KeyModule_ProvideFactory.provide()).build();
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }
  }

  private static final class ViewModelCImpl extends MainApplication_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<AiAssistantViewModel> aiAssistantViewModelProvider;

    private Provider<AnalyticsViewModel> analyticsViewModelProvider;

    private Provider<AuthViewModel> authViewModelProvider;

    private Provider<BarcodeScannerViewModel> barcodeScannerViewModelProvider;

    private Provider<DashboardViewModel> dashboardViewModelProvider;

    private Provider<InventoryViewModel> inventoryViewModelProvider;

    private Provider<NotificationsViewModel> notificationsViewModelProvider;

    private Provider<OrderViewModel> orderViewModelProvider;

    private Provider<ProfileViewModel> profileViewModelProvider;

    private Provider<ReportsViewModel> reportsViewModelProvider;

    private Provider<ScannerViewModel> scannerViewModelProvider;

    private Provider<SeederViewModel> seederViewModelProvider;

    private Provider<SettingsViewModel> settingsViewModelProvider;

    private Provider<SupplierViewModel> supplierViewModelProvider;

    private Provider<TransactionsViewModel> transactionsViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.aiAssistantViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.analyticsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.authViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.barcodeScannerViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.dashboardViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.inventoryViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.notificationsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
      this.orderViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 7);
      this.profileViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 8);
      this.reportsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 9);
      this.scannerViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 10);
      this.seederViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 11);
      this.settingsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 12);
      this.supplierViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 13);
      this.transactionsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 14);
    }

    @Override
    public Map<String, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return MapBuilder.<String, javax.inject.Provider<ViewModel>>newMapBuilder(15).put("com.hauliq.app.presentation.ai.AiAssistantViewModel", ((Provider) aiAssistantViewModelProvider)).put("com.hauliq.app.presentation.analytics.AnalyticsViewModel", ((Provider) analyticsViewModelProvider)).put("com.hauliq.app.presentation.auth.AuthViewModel", ((Provider) authViewModelProvider)).put("com.hauliq.app.presentation.scanner.BarcodeScannerViewModel", ((Provider) barcodeScannerViewModelProvider)).put("com.hauliq.app.presentation.dashboard.DashboardViewModel", ((Provider) dashboardViewModelProvider)).put("com.hauliq.app.presentation.inventory.InventoryViewModel", ((Provider) inventoryViewModelProvider)).put("com.hauliq.app.presentation.notifications.NotificationsViewModel", ((Provider) notificationsViewModelProvider)).put("com.hauliq.app.presentation.orders.OrderViewModel", ((Provider) orderViewModelProvider)).put("com.hauliq.app.presentation.profile.ProfileViewModel", ((Provider) profileViewModelProvider)).put("com.hauliq.app.presentation.reports.ReportsViewModel", ((Provider) reportsViewModelProvider)).put("com.hauliq.app.presentation.scanner.ScannerViewModel", ((Provider) scannerViewModelProvider)).put("com.hauliq.app.presentation.seeder.SeederViewModel", ((Provider) seederViewModelProvider)).put("com.hauliq.app.presentation.settings.SettingsViewModel", ((Provider) settingsViewModelProvider)).put("com.hauliq.app.presentation.suppliers.SupplierViewModel", ((Provider) supplierViewModelProvider)).put("com.hauliq.app.presentation.transactions.TransactionsViewModel", ((Provider) transactionsViewModelProvider)).build();
    }

    @Override
    public Map<String, Object> getHiltViewModelAssistedMap() {
      return Collections.<String, Object>emptyMap();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.hauliq.app.presentation.ai.AiAssistantViewModel 
          return (T) new AiAssistantViewModel(singletonCImpl.aiAssistantRepositoryImplProvider.get());

          case 1: // com.hauliq.app.presentation.analytics.AnalyticsViewModel 
          return (T) new AnalyticsViewModel(singletonCImpl.analyticsRepositoryImplProvider.get(), singletonCImpl.roomInventoryRepositoryProvider.get(), singletonCImpl.roomOrderRepositoryProvider.get(), singletonCImpl.roomTransactionRepositoryProvider.get());

          case 2: // com.hauliq.app.presentation.auth.AuthViewModel 
          return (T) new AuthViewModel();

          case 3: // com.hauliq.app.presentation.scanner.BarcodeScannerViewModel 
          return (T) new BarcodeScannerViewModel(singletonCImpl.roomInventoryRepositoryProvider.get());

          case 4: // com.hauliq.app.presentation.dashboard.DashboardViewModel 
          return (T) new DashboardViewModel(singletonCImpl.roomInventoryRepositoryProvider.get(), singletonCImpl.roomOrderRepositoryProvider.get(), singletonCImpl.aiAssistantRepositoryImplProvider.get());

          case 5: // com.hauliq.app.presentation.inventory.InventoryViewModel 
          return (T) new InventoryViewModel(singletonCImpl.roomInventoryRepositoryProvider.get());

          case 6: // com.hauliq.app.presentation.notifications.NotificationsViewModel 
          return (T) new NotificationsViewModel(singletonCImpl.roomNotificationRepositoryProvider.get());

          case 7: // com.hauliq.app.presentation.orders.OrderViewModel 
          return (T) new OrderViewModel(singletonCImpl.roomOrderRepositoryProvider.get(), singletonCImpl.roomInventoryRepositoryProvider.get());

          case 8: // com.hauliq.app.presentation.profile.ProfileViewModel 
          return (T) new ProfileViewModel();

          case 9: // com.hauliq.app.presentation.reports.ReportsViewModel 
          return (T) new ReportsViewModel(singletonCImpl.roomInventoryRepositoryProvider.get(), singletonCImpl.roomTransactionRepositoryProvider.get());

          case 10: // com.hauliq.app.presentation.scanner.ScannerViewModel 
          return (T) new ScannerViewModel();

          case 11: // com.hauliq.app.presentation.seeder.SeederViewModel 
          return (T) new SeederViewModel(singletonCImpl.firebaseSeederProvider.get());

          case 12: // com.hauliq.app.presentation.settings.SettingsViewModel 
          return (T) new SettingsViewModel();

          case 13: // com.hauliq.app.presentation.suppliers.SupplierViewModel 
          return (T) new SupplierViewModel(singletonCImpl.roomSupplierRepositoryProvider.get());

          case 14: // com.hauliq.app.presentation.transactions.TransactionsViewModel 
          return (T) new TransactionsViewModel(singletonCImpl.roomTransactionRepositoryProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends MainApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends MainApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends MainApplication_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<InventoryDao> provideInventoryDaoProvider;

    private Provider<HaulIQDatabase> provideDatabaseProvider;

    private Provider<SupplierDao> provideSupplierDaoProvider;

    private Provider<TransactionDao> provideTransactionDaoProvider;

    private Provider<NotificationDao> provideNotificationDaoProvider;

    private Provider<AiAssistantRepositoryImpl> aiAssistantRepositoryImplProvider;

    private Provider<AnalyticsRepositoryImpl> analyticsRepositoryImplProvider;

    private Provider<RoomInventoryRepository> roomInventoryRepositoryProvider;

    private Provider<RoomOrderRepository> roomOrderRepositoryProvider;

    private Provider<RoomTransactionRepository> roomTransactionRepositoryProvider;

    private Provider<RoomNotificationRepository> roomNotificationRepositoryProvider;

    private Provider<FirebaseDatabase> provideFirebaseDatabaseProvider;

    private Provider<DatabaseReference> provideRootReferenceProvider;

    private Provider<FirebaseSeeder> firebaseSeederProvider;

    private Provider<RoomSupplierRepository> roomSupplierRepositoryProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    private OrderDao orderDao() {
      return AppModule_Companion_ProvideOrderDaoFactory.provideOrderDao(provideDatabaseProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.provideInventoryDaoProvider = new DelegateFactory<>();
      this.provideDatabaseProvider = new DelegateFactory<>();
      this.provideSupplierDaoProvider = new SwitchingProvider<>(singletonCImpl, 3);
      this.provideTransactionDaoProvider = new SwitchingProvider<>(singletonCImpl, 4);
      this.provideNotificationDaoProvider = new SwitchingProvider<>(singletonCImpl, 5);
      DelegateFactory.setDelegate(provideDatabaseProvider, DoubleCheck.provider(new SwitchingProvider<HaulIQDatabase>(singletonCImpl, 2)));
      DelegateFactory.setDelegate(provideInventoryDaoProvider, new SwitchingProvider<>(singletonCImpl, 1));
      this.aiAssistantRepositoryImplProvider = DoubleCheck.provider(new SwitchingProvider<AiAssistantRepositoryImpl>(singletonCImpl, 0));
      this.analyticsRepositoryImplProvider = DoubleCheck.provider(new SwitchingProvider<AnalyticsRepositoryImpl>(singletonCImpl, 6));
      this.roomInventoryRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<RoomInventoryRepository>(singletonCImpl, 7));
      this.roomOrderRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<RoomOrderRepository>(singletonCImpl, 8));
      this.roomTransactionRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<RoomTransactionRepository>(singletonCImpl, 9));
      this.roomNotificationRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<RoomNotificationRepository>(singletonCImpl, 10));
      this.provideFirebaseDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseDatabase>(singletonCImpl, 13));
      this.provideRootReferenceProvider = DoubleCheck.provider(new SwitchingProvider<DatabaseReference>(singletonCImpl, 12));
      this.firebaseSeederProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseSeeder>(singletonCImpl, 11));
      this.roomSupplierRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<RoomSupplierRepository>(singletonCImpl, 14));
    }

    @Override
    public void injectMainApplication(MainApplication mainApplication) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.hauliq.app.data.repository.AiAssistantRepositoryImpl 
          return (T) new AiAssistantRepositoryImpl(singletonCImpl.provideInventoryDaoProvider.get(), singletonCImpl.orderDao());

          case 1: // com.hauliq.app.data.local.dao.InventoryDao 
          return (T) AppModule_Companion_ProvideInventoryDaoFactory.provideInventoryDao(singletonCImpl.provideDatabaseProvider.get());

          case 2: // com.hauliq.app.data.local.HaulIQDatabase 
          return (T) AppModule_Companion_ProvideDatabaseFactory.provideDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule), singletonCImpl.provideInventoryDaoProvider, singletonCImpl.provideSupplierDaoProvider, singletonCImpl.provideTransactionDaoProvider, singletonCImpl.provideNotificationDaoProvider);

          case 3: // com.hauliq.app.data.local.dao.SupplierDao 
          return (T) AppModule_Companion_ProvideSupplierDaoFactory.provideSupplierDao(singletonCImpl.provideDatabaseProvider.get());

          case 4: // com.hauliq.app.data.local.dao.TransactionDao 
          return (T) AppModule_Companion_ProvideTransactionDaoFactory.provideTransactionDao(singletonCImpl.provideDatabaseProvider.get());

          case 5: // com.hauliq.app.data.local.dao.NotificationDao 
          return (T) AppModule_Companion_ProvideNotificationDaoFactory.provideNotificationDao(singletonCImpl.provideDatabaseProvider.get());

          case 6: // com.hauliq.app.data.repository.AnalyticsRepositoryImpl 
          return (T) new AnalyticsRepositoryImpl(singletonCImpl.provideInventoryDaoProvider.get(), singletonCImpl.orderDao());

          case 7: // com.hauliq.app.data.repository.RoomInventoryRepository 
          return (T) new RoomInventoryRepository(singletonCImpl.provideInventoryDaoProvider.get());

          case 8: // com.hauliq.app.data.repository.RoomOrderRepository 
          return (T) new RoomOrderRepository(singletonCImpl.orderDao(), singletonCImpl.provideInventoryDaoProvider.get(), singletonCImpl.provideTransactionDaoProvider.get());

          case 9: // com.hauliq.app.data.repository.RoomTransactionRepository 
          return (T) new RoomTransactionRepository(singletonCImpl.provideTransactionDaoProvider.get());

          case 10: // com.hauliq.app.data.repository.RoomNotificationRepository 
          return (T) new RoomNotificationRepository(singletonCImpl.provideNotificationDaoProvider.get());

          case 11: // com.hauliq.app.data.remote.FirebaseSeeder 
          return (T) new FirebaseSeeder(singletonCImpl.provideRootReferenceProvider.get());

          case 12: // com.google.firebase.database.DatabaseReference 
          return (T) FirebaseModule_Companion_ProvideRootReferenceFactory.provideRootReference(singletonCImpl.provideFirebaseDatabaseProvider.get());

          case 13: // com.google.firebase.database.FirebaseDatabase 
          return (T) FirebaseModule_Companion_ProvideFirebaseDatabaseFactory.provideFirebaseDatabase();

          case 14: // com.hauliq.app.data.repository.RoomSupplierRepository 
          return (T) new RoomSupplierRepository(singletonCImpl.provideSupplierDaoProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
