package com.makeshop.podbbang.shared.di;

import android.content.Context;
import com.makeshop.podbbang.shared.data.db.Database;
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
public final class RoomDatabaseModule_ProvideDatabaseFactory implements Factory<Database> {
  private final Provider<Context> appContextProvider;

  public RoomDatabaseModule_ProvideDatabaseFactory(Provider<Context> appContextProvider) {
    this.appContextProvider = appContextProvider;
  }

  @Override
  public Database get() {
    return provideDatabase(appContextProvider.get());
  }

  public static RoomDatabaseModule_ProvideDatabaseFactory create(
      Provider<Context> appContextProvider) {
    return new RoomDatabaseModule_ProvideDatabaseFactory(appContextProvider);
  }

  public static Database provideDatabase(Context appContext) {
    return Preconditions.checkNotNullFromProvides(RoomDatabaseModule.INSTANCE.provideDatabase(appContext));
  }
}
