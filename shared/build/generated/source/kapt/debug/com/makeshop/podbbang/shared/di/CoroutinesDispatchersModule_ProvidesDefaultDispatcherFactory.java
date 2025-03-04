package com.makeshop.podbbang.shared.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata
@QualifierMetadata("com.makeshop.podbbang.shared.di.CoroutinesDispatchersModule.DefaultDispatcher")
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
public final class CoroutinesDispatchersModule_ProvidesDefaultDispatcherFactory implements Factory<CoroutineDispatcher> {
  @Override
  public CoroutineDispatcher get() {
    return providesDefaultDispatcher();
  }

  public static CoroutinesDispatchersModule_ProvidesDefaultDispatcherFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CoroutineDispatcher providesDefaultDispatcher() {
    return Preconditions.checkNotNullFromProvides(CoroutinesDispatchersModule.INSTANCE.providesDefaultDispatcher());
  }

  private static final class InstanceHolder {
    private static final CoroutinesDispatchersModule_ProvidesDefaultDispatcherFactory INSTANCE = new CoroutinesDispatchersModule_ProvidesDefaultDispatcherFactory();
  }
}
