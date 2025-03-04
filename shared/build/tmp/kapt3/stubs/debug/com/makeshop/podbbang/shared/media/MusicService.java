package com.makeshop.podbbang.shared.media;

/**
 * Service for browsing the catalogue and and receiving a [MediaController] from the app's UI
 * and other apps that wish to play music via UAMP (for example, Android Auto or
 * the Google Assistant).
 *
 * Browsing begins with the method [MusicService.MusicServiceCallback.onGetLibraryRoot], and
 * continues in the callback [MusicService.MusicServiceCallback.onGetChildren].
 *
 * This class also handles playback for Cast sessions. When a Cast session is active, playback
 * commands are passed to a [CastPlayer].
 */
@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001:\u0002TUB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020CH\u0016J\u0012\u0010E\u001a\u0004\u0018\u00010%2\u0006\u0010F\u001a\u00020GH\u0016J\u0012\u0010H\u001a\u00020C2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u001c\u0010K\u001a\u000e\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020C0L2\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010P\u001a\u00020C2\u0006\u0010Q\u001a\u00020\nH\u0002J\b\u0010R\u001a\u00020CH\u0002J\b\u0010S\u001a\u00020CH\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R#\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b\u001f\u0010 R\u000e\u0010\"\u001a\u00020#X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u0012\u0010*\u001a\u00060+R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010,\u001a\u00020-8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u000203X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020#X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000205X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010:\u001a\u00020;8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?\u00a8\u0006V"}, d2 = {"Lcom/makeshop/podbbang/shared/media/MusicService;", "Landroidx/media3/session/MediaLibraryService;", "()V", "androidAutoRepository", "Lcom/makeshop/podbbang/shared/repository/AndroidAutoRepository;", "getAndroidAutoRepository", "()Lcom/makeshop/podbbang/shared/repository/AndroidAutoRepository;", "setAndroidAutoRepository", "(Lcom/makeshop/podbbang/shared/repository/AndroidAutoRepository;)V", "catalogueRootMediaItem", "Landroidx/media3/common/MediaItem;", "getCatalogueRootMediaItem", "()Landroidx/media3/common/MediaItem;", "catalogueRootMediaItem$delegate", "Lkotlin/Lazy;", "currentMediaItemIndex", "", "episodeRepository", "Lcom/makeshop/podbbang/shared/repository/EpisodeRepository;", "getEpisodeRepository", "()Lcom/makeshop/podbbang/shared/repository/EpisodeRepository;", "setEpisodeRepository", "(Lcom/makeshop/podbbang/shared/repository/EpisodeRepository;)V", "executorService", "Lcom/google/common/util/concurrent/ListeningExecutorService;", "kotlin.jvm.PlatformType", "getExecutorService", "()Lcom/google/common/util/concurrent/ListeningExecutorService;", "executorService$delegate", "exoPlayer", "Landroidx/media3/exoplayer/ExoPlayer;", "getExoPlayer", "()Landroidx/media3/exoplayer/ExoPlayer;", "exoPlayer$delegate", "job", "Lkotlinx/coroutines/CompletableJob;", "mediaSession", "Landroidx/media3/session/MediaLibraryService$MediaLibrarySession;", "getMediaSession", "()Landroidx/media3/session/MediaLibraryService$MediaLibrarySession;", "setMediaSession", "(Landroidx/media3/session/MediaLibraryService$MediaLibrarySession;)V", "playerListener", "Lcom/makeshop/podbbang/shared/media/MusicService$PlayerEventListener;", "rankingRepository", "Lcom/makeshop/podbbang/shared/repository/RankingRepository;", "getRankingRepository", "()Lcom/makeshop/podbbang/shared/repository/RankingRepository;", "setRankingRepository", "(Lcom/makeshop/podbbang/shared/repository/RankingRepository;)V", "remoteJsonSource", "Landroid/net/Uri;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "serviceJob", "serviceScope", "uAmpAudioAttributesBuilder", "Landroidx/media3/common/AudioAttributes$Builder;", "userInfoDBRepository", "Lcom/makeshop/podbbang/shared/data/db/user/UserInfoDBRepository;", "getUserInfoDBRepository", "()Lcom/makeshop/podbbang/shared/data/db/user/UserInfoDBRepository;", "setUserInfoDBRepository", "(Lcom/makeshop/podbbang/shared/data/db/user/UserInfoDBRepository;)V", "getCallback", "Landroidx/media3/session/MediaLibraryService$MediaLibrarySession$Callback;", "onCreate", "", "onDestroy", "onGetSession", "controllerInfo", "Landroidx/media3/session/MediaSession$ControllerInfo;", "onTaskRemoved", "rootIntent", "Landroid/content/Intent;", "openWhenReady", "Lkotlin/Function1;", "", "conditionVariable", "Landroid/os/ConditionVariable;", "preparePlayerForResumption", "mediaItem", "releaseMediaSession", "saveRecentSongToStorage", "MusicServiceCallback", "PlayerEventListener", "shared_debug"})
public class MusicService extends androidx.media3.session.MediaLibraryService {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CompletableJob serviceJob = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope serviceScope = null;
    public androidx.media3.session.MediaLibraryService.MediaLibrarySession mediaSession;
    private int currentMediaItemIndex = 0;
    @javax.inject.Inject()
    public com.makeshop.podbbang.shared.repository.EpisodeRepository episodeRepository;
    @javax.inject.Inject()
    public com.makeshop.podbbang.shared.repository.RankingRepository rankingRepository;
    @javax.inject.Inject()
    public com.makeshop.podbbang.shared.repository.AndroidAutoRepository androidAutoRepository;
    @javax.inject.Inject()
    public com.makeshop.podbbang.shared.data.db.user.UserInfoDBRepository userInfoDBRepository;
    
    /**
     * This must be `by lazy` because the [musicSource] won't initially be ready. Use
     * [callWhenMusicSourceReady] to be sure it is safely ready for usage.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CompletableJob job = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy catalogueRootMediaItem$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy executorService$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final android.net.Uri remoteJsonSource = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.media3.common.AudioAttributes.Builder uAmpAudioAttributesBuilder = null;
    @org.jetbrains.annotations.NotNull()
    private final com.makeshop.podbbang.shared.media.MusicService.PlayerEventListener playerListener = null;
    
    /**
     * Configure ExoPlayer to handle audio focus for us. See [ExoPlayer.Builder.setAudioAttributes]
     * for details.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy exoPlayer$delegate = null;
    
    public MusicService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.media3.session.MediaLibraryService.MediaLibrarySession getMediaSession() {
        return null;
    }
    
    public final void setMediaSession(@org.jetbrains.annotations.NotNull()
    androidx.media3.session.MediaLibraryService.MediaLibrarySession p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.makeshop.podbbang.shared.repository.EpisodeRepository getEpisodeRepository() {
        return null;
    }
    
    public final void setEpisodeRepository(@org.jetbrains.annotations.NotNull()
    com.makeshop.podbbang.shared.repository.EpisodeRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.makeshop.podbbang.shared.repository.RankingRepository getRankingRepository() {
        return null;
    }
    
    public final void setRankingRepository(@org.jetbrains.annotations.NotNull()
    com.makeshop.podbbang.shared.repository.RankingRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.makeshop.podbbang.shared.repository.AndroidAutoRepository getAndroidAutoRepository() {
        return null;
    }
    
    public final void setAndroidAutoRepository(@org.jetbrains.annotations.NotNull()
    com.makeshop.podbbang.shared.repository.AndroidAutoRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.makeshop.podbbang.shared.data.db.user.UserInfoDBRepository getUserInfoDBRepository() {
        return null;
    }
    
    public final void setUserInfoDBRepository(@org.jetbrains.annotations.NotNull()
    com.makeshop.podbbang.shared.data.db.user.UserInfoDBRepository p0) {
    }
    
    private final androidx.media3.common.MediaItem getCatalogueRootMediaItem() {
        return null;
    }
    
    private final com.google.common.util.concurrent.ListeningExecutorService getExecutorService() {
        return null;
    }
    
    /**
     * Configure ExoPlayer to handle audio focus for us. See [ExoPlayer.Builder.setAudioAttributes]
     * for details.
     */
    private final androidx.media3.exoplayer.ExoPlayer getExoPlayer() {
        return null;
    }
    
    /**
     * @return the {@link MediaLibrarySessionCallback} to be used to build the media session.
     */
    @org.jetbrains.annotations.NotNull()
    public androidx.media3.session.MediaLibraryService.MediaLibrarySession.Callback getCallback() {
        return null;
    }
    
    @java.lang.Override()
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.DelicateCoroutinesApi.class})
    public void onCreate() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public androidx.media3.session.MediaLibraryService.MediaLibrarySession onGetSession(@org.jetbrains.annotations.NotNull()
    androidx.media3.session.MediaSession.ControllerInfo controllerInfo) {
        return null;
    }
    
    /**
     * Called when swiping the activity away from recents.
     */
    @java.lang.Override()
    public void onTaskRemoved(@org.jetbrains.annotations.Nullable()
    android.content.Intent rootIntent) {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    private final void releaseMediaSession() {
    }
    
    private final void saveRecentSongToStorage() {
    }
    
    private final void preparePlayerForResumption(androidx.media3.common.MediaItem mediaItem) {
    }
    
    /**
     * Returns a function that opens the condition variable when called.
     */
    private final kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> openWhenReady(android.os.ConditionVariable conditionVariable) {
        return null;
    }
    
    /**
     * Returns a future that executes the action when the music source is ready. This may be an
     * immediate execution if the music source is ready, or a deferred asynchronous execution if the
     * music source is still loading.
     *
     * @param action The function to be called when the music source is ready.
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0096\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0003J2\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J.\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016JL\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001e0\u001d0\f2\u0006\u0010\u0015\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J,\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001d0\f2\u0006\u0010\u0015\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010(\u001a\u00020\"H\u0016J.\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001d0\f2\u0006\u0010\u0015\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00112\b\u0010%\u001a\u0004\u0018\u00010&H\u0017JL\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001e0\u001d0\f2\u0006\u0010\u0015\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010+\u001a\u00020\"2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J6\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u001d0\f2\u0006\u0010\u0015\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010+\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J<\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017J\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0002\u00a8\u00060"}, d2 = {"Lcom/makeshop/podbbang/shared/media/MusicService$MusicServiceCallback;", "Landroidx/media3/session/MediaLibraryService$MediaLibrarySession$Callback;", "(Lcom/makeshop/podbbang/shared/media/MusicService;)V", "maybeExpandSingleItemToPlaylist", "Landroidx/media3/session/MediaSession$MediaItemsWithStartPosition;", "mediaItem", "Landroidx/media3/common/MediaItem;", "startIndex", "", "startPositionMs", "", "onAddMediaItems", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "mediaSession", "Landroidx/media3/session/MediaSession;", "controller", "Landroidx/media3/session/MediaSession$ControllerInfo;", "mediaItems", "onConnect", "Landroidx/media3/session/MediaSession$ConnectionResult;", "session", "onCustomCommand", "Landroidx/media3/session/SessionResult;", "customCommand", "Landroidx/media3/session/SessionCommand;", "args", "Landroid/os/Bundle;", "onGetChildren", "Landroidx/media3/session/LibraryResult;", "Lcom/google/common/collect/ImmutableList;", "Landroidx/media3/session/MediaLibraryService$MediaLibrarySession;", "browser", "parentId", "", "page", "pageSize", "params", "Landroidx/media3/session/MediaLibraryService$LibraryParams;", "onGetItem", "mediaId", "onGetLibraryRoot", "onGetSearchResult", "query", "onSearch", "Ljava/lang/Void;", "onSetMediaItems", "resolveMediaItems", "shared_debug"})
    public class MusicServiceCallback implements androidx.media3.session.MediaLibraryService.MediaLibrarySession.Callback {
        
        public MusicServiceCallback() {
            super();
        }
        
        /**
         * Establishes media connection
         * Set up custom command for Spatial Audio toggle
         */
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public androidx.media3.session.MediaSession.ConnectionResult onConnect(@org.jetbrains.annotations.NotNull()
        androidx.media3.session.MediaSession session, @org.jetbrains.annotations.NotNull()
        androidx.media3.session.MediaSession.ControllerInfo controller) {
            return null;
        }
        
        @java.lang.Override()
        @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
        @org.jetbrains.annotations.NotNull()
        public com.google.common.util.concurrent.ListenableFuture<androidx.media3.session.LibraryResult<androidx.media3.common.MediaItem>> onGetLibraryRoot(@org.jetbrains.annotations.NotNull()
        androidx.media3.session.MediaLibraryService.MediaLibrarySession session, @org.jetbrains.annotations.NotNull()
        androidx.media3.session.MediaSession.ControllerInfo browser, @org.jetbrains.annotations.Nullable()
        androidx.media3.session.MediaLibraryService.LibraryParams params) {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.google.common.util.concurrent.ListenableFuture<androidx.media3.session.LibraryResult<com.google.common.collect.ImmutableList<androidx.media3.common.MediaItem>>> onGetChildren(@org.jetbrains.annotations.NotNull()
        androidx.media3.session.MediaLibraryService.MediaLibrarySession session, @org.jetbrains.annotations.NotNull()
        androidx.media3.session.MediaSession.ControllerInfo browser, @org.jetbrains.annotations.NotNull()
        java.lang.String parentId, int page, int pageSize, @org.jetbrains.annotations.Nullable()
        androidx.media3.session.MediaLibraryService.LibraryParams params) {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.google.common.util.concurrent.ListenableFuture<androidx.media3.session.LibraryResult<androidx.media3.common.MediaItem>> onGetItem(@org.jetbrains.annotations.NotNull()
        androidx.media3.session.MediaLibraryService.MediaLibrarySession session, @org.jetbrains.annotations.NotNull()
        androidx.media3.session.MediaSession.ControllerInfo browser, @org.jetbrains.annotations.NotNull()
        java.lang.String mediaId) {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.google.common.util.concurrent.ListenableFuture<androidx.media3.session.LibraryResult<java.lang.Void>> onSearch(@org.jetbrains.annotations.NotNull()
        androidx.media3.session.MediaLibraryService.MediaLibrarySession session, @org.jetbrains.annotations.NotNull()
        androidx.media3.session.MediaSession.ControllerInfo browser, @org.jetbrains.annotations.NotNull()
        java.lang.String query, @org.jetbrains.annotations.Nullable()
        androidx.media3.session.MediaLibraryService.LibraryParams params) {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.google.common.util.concurrent.ListenableFuture<androidx.media3.session.LibraryResult<com.google.common.collect.ImmutableList<androidx.media3.common.MediaItem>>> onGetSearchResult(@org.jetbrains.annotations.NotNull()
        androidx.media3.session.MediaLibraryService.MediaLibrarySession session, @org.jetbrains.annotations.NotNull()
        androidx.media3.session.MediaSession.ControllerInfo browser, @org.jetbrains.annotations.NotNull()
        java.lang.String query, int page, int pageSize, @org.jetbrains.annotations.Nullable()
        androidx.media3.session.MediaLibraryService.LibraryParams params) {
            return null;
        }
        
        @java.lang.Override()
        @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
        @org.jetbrains.annotations.NotNull()
        public com.google.common.util.concurrent.ListenableFuture<androidx.media3.session.MediaSession.MediaItemsWithStartPosition> onSetMediaItems(@org.jetbrains.annotations.NotNull()
        androidx.media3.session.MediaSession mediaSession, @org.jetbrains.annotations.NotNull()
        androidx.media3.session.MediaSession.ControllerInfo browser, @org.jetbrains.annotations.NotNull()
        java.util.List<androidx.media3.common.MediaItem> mediaItems, int startIndex, long startPositionMs) {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.google.common.util.concurrent.ListenableFuture<java.util.List<androidx.media3.common.MediaItem>> onAddMediaItems(@org.jetbrains.annotations.NotNull()
        androidx.media3.session.MediaSession mediaSession, @org.jetbrains.annotations.NotNull()
        androidx.media3.session.MediaSession.ControllerInfo controller, @org.jetbrains.annotations.NotNull()
        java.util.List<androidx.media3.common.MediaItem> mediaItems) {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.google.common.util.concurrent.ListenableFuture<androidx.media3.session.SessionResult> onCustomCommand(@org.jetbrains.annotations.NotNull()
        androidx.media3.session.MediaSession session, @org.jetbrains.annotations.NotNull()
        androidx.media3.session.MediaSession.ControllerInfo controller, @org.jetbrains.annotations.NotNull()
        androidx.media3.session.SessionCommand customCommand, @org.jetbrains.annotations.NotNull()
        android.os.Bundle args) {
            return null;
        }
        
        private final java.util.List<androidx.media3.common.MediaItem> resolveMediaItems(java.util.List<androidx.media3.common.MediaItem> mediaItems) {
            return null;
        }
        
        @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
        private final androidx.media3.session.MediaSession.MediaItemsWithStartPosition maybeExpandSingleItemToPlaylist(androidx.media3.common.MediaItem mediaItem, int startIndex, long startPositionMs) {
            return null;
        }
    }
    
    /**
     * Listen for events from ExoPlayer.
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/makeshop/podbbang/shared/media/MusicService$PlayerEventListener;", "Landroidx/media3/common/Player$Listener;", "(Lcom/makeshop/podbbang/shared/media/MusicService;)V", "onEvents", "", "player", "Landroidx/media3/common/Player;", "events", "Landroidx/media3/common/Player$Events;", "onPlayerError", "error", "Landroidx/media3/common/PlaybackException;", "shared_debug"})
    final class PlayerEventListener implements androidx.media3.common.Player.Listener {
        
        public PlayerEventListener() {
            super();
        }
        
        @java.lang.Override()
        public void onEvents(@org.jetbrains.annotations.NotNull()
        androidx.media3.common.Player player, @org.jetbrains.annotations.NotNull()
        androidx.media3.common.Player.Events events) {
        }
        
        @java.lang.Override()
        public void onPlayerError(@org.jetbrains.annotations.NotNull()
        androidx.media3.common.PlaybackException error) {
        }
    }
}