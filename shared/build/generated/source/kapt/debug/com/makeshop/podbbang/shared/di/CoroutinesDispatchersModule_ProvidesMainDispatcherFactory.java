package com.makeshop.podbbang.shared.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata
@QualifierMetadata("com.makeshop.podbbang.shared.di.CoroutinesDispatchersModule.MainDispatcher")
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
public final class CoroutinesDispatchersModule_ProvidesMainDispatcherFactory implements Factory<CoroutineDispatcher> {
  @Override
  public CoroutineDispatcher get() {
    return providesMainDispatcher();
  }

  public static CoroutinesDispatchersModule_ProvidesMainDispatcherFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CoroutineDispatcher providesMainDispatcher() {
    return Preconditions.checkNotNullFromProvides(CoroutinesDispatchersModule.INSTANCE.providesMainDispatcher());
  }

  private static final class InstanceHolder {
    private static final CoroutinesDispatchersModule_ProvidesMainDispatcherFactory INSTANCE = new CoroutinesDispatchersModule_ProvidesMainDispatcherFactory();
  }
}
