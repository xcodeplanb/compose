package com.makeshop.podbbang.shared.di;

import com.makeshop.podbbang.shared.api.WebService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class NetworkModule_ProvideWebServiceFactory implements Factory<WebService> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideWebServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public WebService get() {
    return provideWebService(retrofitProvider.get());
  }

  public static NetworkModule_ProvideWebServiceFactory create(Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideWebServiceFactory(retrofitProvider);
  }

  public static WebService provideWebService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideWebService(retrofit));
  }
}
