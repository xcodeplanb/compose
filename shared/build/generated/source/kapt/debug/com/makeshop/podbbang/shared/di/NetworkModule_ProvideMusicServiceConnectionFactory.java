package com.makeshop.podbbang.shared.di;

import android.content.Context;
import com.makeshop.podbbang.shared.common.MusicServiceConnection;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class NetworkModule_ProvideMusicServiceConnectionFactory implements Factory<MusicServiceConnection> {
  private final Provider<Context> appContextProvider;

  public NetworkModule_ProvideMusicServiceConnectionFactory(Provider<Context> appContextProvider) {
    this.appContextProvider = appContextProvider;
  }

  @Override
  public MusicServiceConnection get() {
    return provideMusicServiceConnection(appContextProvider.get());
  }

  public static NetworkModule_ProvideMusicServiceConnectionFactory create(
      Provider<Context> appContextProvider) {
    return new NetworkModule_ProvideMusicServiceConnectionFactory(appContextProvider);
  }

  public static MusicServiceConnection provideMusicServiceConnection(Context appContext) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideMusicServiceConnection(appContext));
  }
}
