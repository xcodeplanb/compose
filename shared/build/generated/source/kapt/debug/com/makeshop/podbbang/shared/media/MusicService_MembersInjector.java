package com.makeshop.podbbang.shared.media;

import com.makeshop.podbbang.shared.data.db.user.UserInfoDBRepository;
import com.makeshop.podbbang.shared.repository.AndroidAutoRepository;
import com.makeshop.podbbang.shared.repository.EpisodeRepository;
import com.makeshop.podbbang.shared.repository.RankingRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class MusicService_MembersInjector implements MembersInjector<MusicService> {
  private final Provider<EpisodeRepository> episodeRepositoryProvider;

  private final Provider<RankingRepository> rankingRepositoryProvider;

  private final Provider<AndroidAutoRepository> androidAutoRepositoryProvider;

  private final Provider<UserInfoDBRepository> userInfoDBRepositoryProvider;

  public MusicService_MembersInjector(Provider<EpisodeRepository> episodeRepositoryProvider,
      Provider<RankingRepository> rankingRepositoryProvider,
      Provider<AndroidAutoRepository> androidAutoRepositoryProvider,
      Provider<UserInfoDBRepository> userInfoDBRepositoryProvider) {
    this.episodeRepositoryProvider = episodeRepositoryProvider;
    this.rankingRepositoryProvider = rankingRepositoryProvider;
    this.androidAutoRepositoryProvider = androidAutoRepositoryProvider;
    this.userInfoDBRepositoryProvider = userInfoDBRepositoryProvider;
  }

  public static MembersInjector<MusicService> create(
      Provider<EpisodeRepository> episodeRepositoryProvider,
      Provider<RankingRepository> rankingRepositoryProvider,
      Provider<AndroidAutoRepository> androidAutoRepositoryProvider,
      Provider<UserInfoDBRepository> userInfoDBRepositoryProvider) {
    return new MusicService_MembersInjector(episodeRepositoryProvider, rankingRepositoryProvider, androidAutoRepositoryProvider, userInfoDBRepositoryProvider);
  }

  @Override
  public void injectMembers(MusicService instance) {
    injectEpisodeRepository(instance, episodeRepositoryProvider.get());
    injectRankingRepository(instance, rankingRepositoryProvider.get());
    injectAndroidAutoRepository(instance, androidAutoRepositoryProvider.get());
    injectUserInfoDBRepository(instance, userInfoDBRepositoryProvider.get());
  }

  @InjectedFieldSignature("com.makeshop.podbbang.shared.media.MusicService.episodeRepository")
  public static void injectEpisodeRepository(MusicService instance,
      EpisodeRepository episodeRepository) {
    instance.episodeRepository = episodeRepository;
  }

  @InjectedFieldSignature("com.makeshop.podbbang.shared.media.MusicService.rankingRepository")
  public static void injectRankingRepository(MusicService instance,
      RankingRepository rankingRepository) {
    instance.rankingRepository = rankingRepository;
  }

  @InjectedFieldSignature("com.makeshop.podbbang.shared.media.MusicService.androidAutoRepository")
  public static void injectAndroidAutoRepository(MusicService instance,
      AndroidAutoRepository androidAutoRepository) {
    instance.androidAutoRepository = androidAutoRepository;
  }

  @InjectedFieldSignature("com.makeshop.podbbang.shared.media.MusicService.userInfoDBRepository")
  public static void injectUserInfoDBRepository(MusicService instance,
      UserInfoDBRepository userInfoDBRepository) {
    instance.userInfoDBRepository = userInfoDBRepository;
  }
}
