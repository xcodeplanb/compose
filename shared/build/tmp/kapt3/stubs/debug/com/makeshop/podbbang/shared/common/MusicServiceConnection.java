package com.makeshop.podbbang.shared.common;

/**
 * Class that manages a connection to a [MediaLibraryService] instance, typically a
 * [MusicService] or one of its subclasses.
 *
 * Typically it's best to construct/inject dependencies either using DI or, as UAMP does,
 * using [InjectorUtils] in the app module. There are a few difficulties for that here:
 * - [MediaBrowser] is a final class, so mocking it directly is difficult.
 * - A [MediaBrowserConnectionCallback] is a parameter into the construction of
 *  a [MediaBrowserCompat], and provides callbacks to this class.
 * - [MediaBrowserCompat.ConnectionCallback.onConnected] is the best place to construct
 *  a [MediaControllerCompat] that will be used to control the [MediaSessionCompat].
 *
 * Because of these reasons, rather than constructing additional classes, this is treated as
 * a black box (which is why there's very little logic here).
 *
 * This is also why the parameters to construct a [MusicServiceConnection] are simple
 * parameters, rather than private properties. They're only required to build the
 * [MediaBrowserConnectionCallback] and [MediaBrowserCompat] objects.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u0003234B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00110!2\u0006\u0010\"\u001a\u00020#H\u0086@\u00a2\u0006\u0002\u0010$J\u0006\u0010%\u001a\u00020&J \u0010\'\u001a\u00020\r2\u0006\u0010(\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010*H\u0086@\u00a2\u0006\u0002\u0010+J<\u0010\'\u001a\u00020\r2\u0006\u0010(\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010*2\u001a\u0010,\u001a\u0016\u0012\u0004\u0012\u00020.\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0004\u0012\u00020&0-H\u0086@\u00a2\u0006\u0002\u0010/J\u0010\u00100\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u00101\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00060\u001bR\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000fR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/makeshop/podbbang/shared/common/MusicServiceConnection;", "", "context", "Landroid/content/Context;", "serviceComponent", "Landroid/content/ComponentName;", "(Landroid/content/Context;Landroid/content/ComponentName;)V", "browser", "Landroidx/media3/session/MediaBrowser;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "networkFailure", "Landroidx/lifecycle/MutableLiveData;", "", "getNetworkFailure", "()Landroidx/lifecycle/MutableLiveData;", "nowPlaying", "Landroidx/media3/common/MediaItem;", "getNowPlaying", "playbackState", "Lcom/makeshop/podbbang/shared/common/PlaybackState;", "getPlaybackState", "player", "Landroidx/media3/common/Player;", "getPlayer", "()Landroidx/media3/common/Player;", "playerListener", "Lcom/makeshop/podbbang/shared/common/MusicServiceConnection$PlayerListener;", "rootMediaItem", "getRootMediaItem", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getChildren", "Lcom/google/common/collect/ImmutableList;", "parentId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "", "sendCommand", "command", "parameters", "Landroid/os/Bundle;", "(Ljava/lang/String;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resultCallback", "Lkotlin/Function2;", "", "(Ljava/lang/String;Landroid/os/Bundle;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNowPlaying", "updatePlaybackState", "BrowserListener", "Companion", "PlayerListener", "shared_debug"})
public final class MusicServiceConnection {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<androidx.media3.common.MediaItem> rootMediaItem = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.makeshop.podbbang.shared.common.PlaybackState> playbackState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<androidx.media3.common.MediaItem> nowPlaying = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> networkFailure = null;
    @org.jetbrains.annotations.Nullable()
    private androidx.media3.session.MediaBrowser browser;
    @org.jetbrains.annotations.NotNull()
    private final com.makeshop.podbbang.shared.common.MusicServiceConnection.PlayerListener playerListener = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.coroutines.CoroutineContext coroutineContext = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.makeshop.podbbang.shared.common.MusicServiceConnection instance;
    @org.jetbrains.annotations.NotNull()
    public static final com.makeshop.podbbang.shared.common.MusicServiceConnection.Companion Companion = null;
    
    public MusicServiceConnection(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.content.ComponentName serviceComponent) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<androidx.media3.common.MediaItem> getRootMediaItem() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.makeshop.podbbang.shared.common.PlaybackState> getPlaybackState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<androidx.media3.common.MediaItem> getNowPlaying() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.media3.common.Player getPlayer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getNetworkFailure() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getChildren(@org.jetbrains.annotations.NotNull()
    java.lang.String parentId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.google.common.collect.ImmutableList<androidx.media3.common.MediaItem>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object sendCommand(@org.jetbrains.annotations.NotNull()
    java.lang.String command, @org.jetbrains.annotations.Nullable()
    android.os.Bundle parameters, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object sendCommand(@org.jetbrains.annotations.NotNull()
    java.lang.String command, @org.jetbrains.annotations.Nullable()
    android.os.Bundle parameters, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super android.os.Bundle, kotlin.Unit> resultCallback, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    public final void release() {
    }
    
    private final void updatePlaybackState(androidx.media3.common.Player player) {
    }
    
    private final void updateNowPlaying(androidx.media3.common.Player player) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/makeshop/podbbang/shared/common/MusicServiceConnection$BrowserListener;", "Landroidx/media3/session/MediaBrowser$Listener;", "(Lcom/makeshop/podbbang/shared/common/MusicServiceConnection;)V", "onDisconnected", "", "controller", "Landroidx/media3/session/MediaController;", "shared_debug"})
    final class BrowserListener implements androidx.media3.session.MediaBrowser.Listener {
        
        public BrowserListener() {
            super();
        }
        
        @java.lang.Override()
        public void onDisconnected(@org.jetbrains.annotations.NotNull()
        androidx.media3.session.MediaController controller) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/makeshop/podbbang/shared/common/MusicServiceConnection$Companion;", "", "()V", "instance", "Lcom/makeshop/podbbang/shared/common/MusicServiceConnection;", "getInstance", "context", "Landroid/content/Context;", "serviceComponent", "Landroid/content/ComponentName;", "shared_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.makeshop.podbbang.shared.common.MusicServiceConnection getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.content.ComponentName serviceComponent) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/makeshop/podbbang/shared/common/MusicServiceConnection$PlayerListener;", "Landroidx/media3/common/Player$Listener;", "(Lcom/makeshop/podbbang/shared/common/MusicServiceConnection;)V", "onEvents", "", "player", "Landroidx/media3/common/Player;", "events", "Landroidx/media3/common/Player$Events;", "onPlayerErrorChanged", "error", "Landroidx/media3/common/PlaybackException;", "shared_debug"})
    final class PlayerListener implements androidx.media3.common.Player.Listener {
        
        public PlayerListener() {
            super();
        }
        
        @java.lang.Override()
        public void onEvents(@org.jetbrains.annotations.NotNull()
        androidx.media3.common.Player player, @org.jetbrains.annotations.NotNull()
        androidx.media3.common.Player.Events events) {
        }
        
        @java.lang.Override()
        public void onPlayerErrorChanged(@org.jetbrains.annotations.Nullable()
        androidx.media3.common.PlaybackException error) {
        }
    }
}