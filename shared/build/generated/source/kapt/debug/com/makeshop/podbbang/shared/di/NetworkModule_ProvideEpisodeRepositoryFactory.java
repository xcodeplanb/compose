package com.makeshop.podbbang.shared.di;

import com.makeshop.podbbang.shared.api.WebService;
import com.makeshop.podbbang.shared.repository.EpisodeRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class NetworkModule_ProvideEpisodeRepositoryFactory implements Factory<EpisodeRepository> {
  private final Provider<WebService> webServiceProvider;

  public NetworkModule_ProvideEpisodeRepositoryFactory(Provider<WebService> webServiceProvider) {
    this.webServiceProvider = webServiceProvider;
  }

  @Override
  public EpisodeRepository get() {
    return provideEpisodeRepository(webServiceProvider.get());
  }

  public static NetworkModule_ProvideEpisodeRepositoryFactory create(
      Provider<WebService> webServiceProvider) {
    return new NetworkModule_ProvideEpisodeRepositoryFactory(webServiceProvider);
  }

  public static EpisodeRepository provideEpisodeRepository(WebService webService) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideEpisodeRepository(webService));
  }
}
