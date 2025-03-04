package com.makeshop.podbbang.shared.data.db.user;

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
public final class UserInfoDBRepository_Factory implements Factory<UserInfoDBRepository> {
  private final Provider<UserInfoDao> userInfoDaoProvider;

  public UserInfoDBRepository_Factory(Provider<UserInfoDao> userInfoDaoProvider) {
    this.userInfoDaoProvider = userInfoDaoProvider;
  }

  @Override
  public UserInfoDBRepository get() {
    return newInstance(userInfoDaoProvider.get());
  }

  public static UserInfoDBRepository_Factory create(Provider<UserInfoDao> userInfoDaoProvider) {
    return new UserInfoDBRepository_Factory(userInfoDaoProvider);
  }

  public static UserInfoDBRepository newInstance(UserInfoDao userInfoDao) {
    return new UserInfoDBRepository(userInfoDao);
  }
}
