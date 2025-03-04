package com.makeshop.podbbang.shared.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata
@QualifierMetadata("com.makeshop.podbbang.shared.di.CoroutinesDispatchersModule.MainImmediateDispatcher")
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
public final class CoroutinesDispatchersModule_ProvidesMainImmediateDispatcherFactory implements Factory<CoroutineDispatcher> {
  @Override
  public CoroutineDispatcher get() {
    return providesMainImmediateDispatcher();
  }

  public static CoroutinesDispatchersModule_ProvidesMainImmediateDispatcherFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CoroutineDispatcher providesMainImmediateDispatcher() {
    return Preconditions.checkNotNullFromProvides(CoroutinesDispatchersModule.INSTANCE.providesMainImmediateDispatcher());
  }

  private static final class InstanceHolder {
    private static final CoroutinesDispatchersModule_ProvidesMainImmediateDispatcherFactory INSTANCE = new CoroutinesDispatchersModule_ProvidesMainImmediateDispatcherFactory();
  }
}
