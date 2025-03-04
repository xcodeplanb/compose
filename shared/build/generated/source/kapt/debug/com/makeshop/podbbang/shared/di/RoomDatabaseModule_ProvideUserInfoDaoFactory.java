package com.makeshop.podbbang.shared.di;

import com.makeshop.podbbang.shared.data.db.Database;
import com.makeshop.podbbang.shared.data.db.user.UserInfoDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class RoomDatabaseModule_ProvideUserInfoDaoFactory implements Factory<UserInfoDao> {
  private final Provider<Database> databaseProvider;

  public RoomDatabaseModule_ProvideUserInfoDaoFactory(Provider<Database> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public UserInfoDao get() {
    return provideUserInfoDao(databaseProvider.get());
  }

  public static RoomDatabaseModule_ProvideUserInfoDaoFactory create(
      Provider<Database> databaseProvider) {
    return new RoomDatabaseModule_ProvideUserInfoDaoFactory(databaseProvider);
  }

  public static UserInfoDao provideUserInfoDao(Database database) {
    return Preconditions.checkNotNullFromProvides(RoomDatabaseModule.INSTANCE.provideUserInfoDao(database));
  }
}
