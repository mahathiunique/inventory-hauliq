package com.hauliq.app.presentation.ai;

import com.hauliq.app.domain.repository.AiAssistantRepository;
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
public final class AiAssistantViewModel_Factory implements Factory<AiAssistantViewModel> {
  private final Provider<AiAssistantRepository> aiAssistantRepositoryProvider;

  public AiAssistantViewModel_Factory(
      Provider<AiAssistantRepository> aiAssistantRepositoryProvider) {
    this.aiAssistantRepositoryProvider = aiAssistantRepositoryProvider;
  }

  @Override
  public AiAssistantViewModel get() {
    return newInstance(aiAssistantRepositoryProvider.get());
  }

  public static AiAssistantViewModel_Factory create(
      Provider<AiAssistantRepository> aiAssistantRepositoryProvider) {
    return new AiAssistantViewModel_Factory(aiAssistantRepositoryProvider);
  }

  public static AiAssistantViewModel newInstance(AiAssistantRepository aiAssistantRepository) {
    return new AiAssistantViewModel(aiAssistantRepository);
  }
}
