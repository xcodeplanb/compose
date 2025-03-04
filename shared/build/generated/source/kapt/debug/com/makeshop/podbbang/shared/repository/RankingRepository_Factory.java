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
public final class RankingRepository_Factory implements Factory<RankingRepository> {
  private final Provider<WebService> webServiceProvider;

  public RankingRepository_Factory(Provider<WebService> webServiceProvider) {
    this.webServiceProvider = webServiceProvider;
  }

  @Override
  public RankingRepository get() {
    return newInstance(webServiceProvider.get());
  }

  public static RankingRepository_Factory create(Provider<WebService> webServiceProvider) {
    return new RankingRepository_Factory(webServiceProvider);
  }

  public static RankingRepository newInstance(WebService webService) {
    return new RankingRepository(webService);
  }
}
