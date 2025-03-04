package com.makeshop.podbbang.shared.repository;

import com.makeshop.podbbang.shared.api.WebService;
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
public final class EpisodeRepository_Factory implements Factory<EpisodeRepository> {
  private final Provider<WebService> webServiceProvider;

  public EpisodeRepository_Factory(Provider<WebService> webServiceProvider) {
    this.webServiceProvider = webServiceProvider;
  }

  @Override
  public EpisodeRepository get() {
    return newInstance(webServiceProvider.get());
  }

  public static EpisodeRepository_Factory create(Provider<WebService> webServiceProvider) {
    return new EpisodeRepository_Factory(webServiceProvider);
  }

  public static EpisodeRepository newInstance(WebService webService) {
    return new EpisodeRepository(webService);
  }
}
