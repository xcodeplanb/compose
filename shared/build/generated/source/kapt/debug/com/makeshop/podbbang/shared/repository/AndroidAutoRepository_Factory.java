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
public final class AndroidAutoRepository_Factory implements Factory<AndroidAutoRepository> {
  private final Provider<WebService> webServiceProvider;

  public AndroidAutoRepository_Factory(Provider<WebService> webServiceProvider) {
    this.webServiceProvider = webServiceProvider;
  }

  @Override
  public AndroidAutoRepository get() {
    return newInstance(webServiceProvider.get());
  }

  public static AndroidAutoRepository_Factory create(Provider<WebService> webServiceProvider) {
    return new AndroidAutoRepository_Factory(webServiceProvider);
  }

  public static AndroidAutoRepository newInstance(WebService webService) {
    return new AndroidAutoRepository(webService);
  }
}
