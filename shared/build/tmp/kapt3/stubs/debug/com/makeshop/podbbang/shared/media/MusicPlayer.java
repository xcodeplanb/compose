package com.makeshop.podbbang.shared.media;

/**
 * A [Player] implementation that delegates to an actual [Player] implementation that is
 * replaceable by another instance by calling [setPlayer].
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\bS\u0018\u00002\u00020\u0001:\u0002\u00b4\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u001e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H\u0016J\u0016\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\rH\u0017J\u0010\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0005H\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010\'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020-H\u0016J\b\u0010/\u001a\u00020-H\u0016J\b\u00100\u001a\u00020-H\u0016J\b\u00101\u001a\u00020\u0005H\u0016J\b\u00102\u001a\u00020\u0005H\u0016J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020-H\u0016J\n\u00106\u001a\u0004\u0018\u000107H\u0017J\n\u00108\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u00109\u001a\u00020\u0005H\u0016J\b\u0010:\u001a\u00020\u0005H\u0016J\b\u0010;\u001a\u00020-H\u0016J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020\u0005H\u0017J\b\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020\u0005H\u0016J\b\u0010D\u001a\u00020-H\u0016J\b\u0010E\u001a\u00020-H\u0016J\u0010\u0010F\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010G\u001a\u00020\u0005H\u0016J\b\u0010H\u001a\u00020IH\u0016J\b\u0010J\u001a\u00020\u0005H\u0016J\b\u0010K\u001a\u00020\u0005H\u0017J\b\u0010L\u001a\u00020\u0015H\u0016J\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020\u0005H\u0016J\b\u0010P\u001a\u00020\u0005H\u0016J\n\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\b\u0010S\u001a\u00020IH\u0016J\b\u0010T\u001a\u00020\u0005H\u0016J\b\u0010U\u001a\u00020\u0005H\u0017J\b\u0010V\u001a\u00020\u0005H\u0016J\b\u0010W\u001a\u00020-H\u0016J\b\u0010X\u001a\u00020-H\u0016J\b\u0010Y\u001a\u00020\u0015H\u0016J\b\u0010Z\u001a\u00020[H\u0017J\b\u0010\\\u001a\u00020-H\u0016J\b\u0010]\u001a\u00020^H\u0016J\b\u0010_\u001a\u00020`H\u0016J\b\u0010a\u001a\u00020bH\u0016J\t\u0010c\u001a\u00020\u0015H\u0097\u0002J\b\u0010d\u001a\u00020\u0015H\u0016J\b\u0010e\u001a\u00020\u0015H\u0017J\b\u0010f\u001a\u00020\u0015H\u0017J\b\u0010g\u001a\u00020\u0015H\u0016J\b\u0010h\u001a\u00020\u0015H\u0017J\b\u0010i\u001a\u00020\rH\u0017J\u0010\u0010i\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0005H\u0016J\u0010\u0010j\u001a\u00020\u00152\u0006\u0010k\u001a\u00020\u0005H\u0016J\b\u0010l\u001a\u00020\u0015H\u0016J\b\u0010m\u001a\u00020\u0015H\u0016J\b\u0010n\u001a\u00020\u0015H\u0016J\b\u0010o\u001a\u00020\u0015H\u0017J\b\u0010p\u001a\u00020\u0015H\u0017J\b\u0010q\u001a\u00020\u0015H\u0017J\b\u0010r\u001a\u00020\u0015H\u0016J\b\u0010s\u001a\u00020\u0015H\u0016J\b\u0010t\u001a\u00020\u0015H\u0016J\b\u0010u\u001a\u00020\u0015H\u0016J\u0018\u0010v\u001a\u00020\r2\u0006\u0010w\u001a\u00020\u00052\u0006\u0010x\u001a\u00020\u0005H\u0016J \u0010y\u001a\u00020\r2\u0006\u0010z\u001a\u00020\u00052\u0006\u0010{\u001a\u00020\u00052\u0006\u0010x\u001a\u00020\u0005H\u0016J\t\u0010|\u001a\u00020\rH\u0097\u0002J\b\u0010}\u001a\u00020\rH\u0016J\b\u0010~\u001a\u00020\rH\u0016J\b\u0010\u007f\u001a\u00020\rH\u0016J\t\u0010\u0080\u0001\u001a\u00020\rH\u0017J\t\u0010\u0081\u0001\u001a\u00020\rH\u0016J\u0011\u0010\u0082\u0001\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0011\u0010\u0083\u0001\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0019\u0010\u0084\u0001\u001a\u00020\r2\u0006\u0010z\u001a\u00020\u00052\u0006\u0010{\u001a\u00020\u0005H\u0016J\u0019\u0010\u0085\u0001\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\'\u0010\u0086\u0001\u001a\u00020\r2\u0006\u0010z\u001a\u00020\u00052\u0006\u0010{\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H\u0016J\t\u0010\u0087\u0001\u001a\u00020\rH\u0016J\t\u0010\u0088\u0001\u001a\u00020\rH\u0016J\u001b\u0010\u0089\u0001\u001a\u00020\r2\u0007\u0010\u008a\u0001\u001a\u00020\u00052\u0007\u0010\u008b\u0001\u001a\u00020-H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020\r2\u0007\u0010\u008b\u0001\u001a\u00020-H\u0016J\t\u0010\u008c\u0001\u001a\u00020\rH\u0016J\u0012\u0010\u008c\u0001\u001a\u00020\r2\u0007\u0010\u008a\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u008d\u0001\u001a\u00020\rH\u0016J\t\u0010\u008e\u0001\u001a\u00020\rH\u0016J\t\u0010\u008f\u0001\u001a\u00020\rH\u0017J\t\u0010\u0090\u0001\u001a\u00020\rH\u0016J\t\u0010\u0091\u0001\u001a\u00020\rH\u0016J\t\u0010\u0092\u0001\u001a\u00020\rH\u0017J\u001b\u0010\u0093\u0001\u001a\u00020\r2\u0007\u0010\u0094\u0001\u001a\u00020(2\u0007\u0010\u0095\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010\u0096\u0001\u001a\u00020\r2\u0007\u0010\u0097\u0001\u001a\u00020\u0015H\u0017J\u001a\u0010\u0096\u0001\u001a\u00020\r2\u0007\u0010\u0097\u0001\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0005H\u0016J\u0012\u0010\u0098\u0001\u001a\u00020\r2\u0007\u0010\u0099\u0001\u001a\u00020\u0005H\u0017J\u001a\u0010\u0098\u0001\u001a\u00020\r2\u0007\u0010\u0099\u0001\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0016J\u0011\u0010\u009a\u0001\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u001a\u0010\u009a\u0001\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000b2\u0007\u0010\u009b\u0001\u001a\u00020\u0015H\u0016J\u001a\u0010\u009a\u0001\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000b2\u0007\u0010\u009c\u0001\u001a\u00020-H\u0016J\u0017\u0010\u009d\u0001\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H\u0016J \u0010\u009d\u0001\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0007\u0010\u009b\u0001\u001a\u00020\u0015H\u0016J)\u0010\u009d\u0001\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0007\u0010\u009e\u0001\u001a\u00020\u00052\u0007\u0010\u009c\u0001\u001a\u00020-H\u0016J\u0012\u0010\u009f\u0001\u001a\u00020\r2\u0007\u0010\u00a0\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010\u00a1\u0001\u001a\u00020\r2\u0007\u0010\u00a2\u0001\u001a\u00020NH\u0016J\u0012\u0010\u00a3\u0001\u001a\u00020\r2\u0007\u0010\u00a4\u0001\u001a\u00020bH\u0016J\u000f\u0010\u00a5\u0001\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0001J\u0012\u0010\u00a6\u0001\u001a\u00020\r2\u0007\u0010\u00a7\u0001\u001a\u00020IH\u0016J\u0012\u0010\u00a8\u0001\u001a\u00020\r2\u0007\u0010\u00a9\u0001\u001a\u00020\u0005H\u0016J\u0012\u0010\u00aa\u0001\u001a\u00020\r2\u0007\u0010\u00ab\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010\u00ac\u0001\u001a\u00020\r2\u0007\u0010\u00ad\u0001\u001a\u00020^H\u0016J\u0013\u0010\u00ae\u0001\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0013\u0010\u00af\u0001\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0013\u0010\u00b0\u0001\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0013\u0010\u00b1\u0001\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010\u00b2\u0001\u001a\u00020\r2\u0007\u0010\u0099\u0001\u001a\u00020bH\u0016J\t\u0010\u00b3\u0001\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00b5\u0001"}, d2 = {"Lcom/makeshop/podbbang/shared/media/MusicPlayer;", "Landroidx/media3/common/Player;", "player", "(Landroidx/media3/common/Player;)V", "currentMediaItemIndex", "", "listeners", "", "Landroidx/media3/common/Player$Listener;", "playerListener", "playlist", "Landroidx/media3/common/MediaItem;", "addListener", "", "listener", "addMediaItem", "mediaItem", "index", "addMediaItems", "mediaItems", "canAdvertiseSession", "", "clearMediaItems", "clearVideoSurface", "surface", "Landroid/view/Surface;", "clearVideoSurfaceHolder", "surfaceHolder", "Landroid/view/SurfaceHolder;", "clearVideoSurfaceView", "surfaceView", "Landroid/view/SurfaceView;", "clearVideoTextureView", "textureView", "Landroid/view/TextureView;", "decreaseDeviceVolume", "flags", "getApplicationLooper", "Landroid/os/Looper;", "getAudioAttributes", "Landroidx/media3/common/AudioAttributes;", "getAvailableCommands", "Landroidx/media3/common/Player$Commands;", "getBufferedPercentage", "getBufferedPosition", "", "getContentBufferedPosition", "getContentDuration", "getContentPosition", "getCurrentAdGroupIndex", "getCurrentAdIndexInAdGroup", "getCurrentCues", "Landroidx/media3/common/text/CueGroup;", "getCurrentLiveOffset", "getCurrentManifest", "", "getCurrentMediaItem", "getCurrentMediaItemIndex", "getCurrentPeriodIndex", "getCurrentPosition", "getCurrentTimeline", "Landroidx/media3/common/Timeline;", "getCurrentTracks", "Landroidx/media3/common/Tracks;", "getCurrentWindowIndex", "getDeviceInfo", "Landroidx/media3/common/DeviceInfo;", "getDeviceVolume", "getDuration", "getMaxSeekToPreviousPosition", "getMediaItemAt", "getMediaItemCount", "getMediaMetadata", "Landroidx/media3/common/MediaMetadata;", "getNextMediaItemIndex", "getNextWindowIndex", "getPlayWhenReady", "getPlaybackParameters", "Landroidx/media3/common/PlaybackParameters;", "getPlaybackState", "getPlaybackSuppressionReason", "getPlayerError", "Landroidx/media3/common/PlaybackException;", "getPlaylistMetadata", "getPreviousMediaItemIndex", "getPreviousWindowIndex", "getRepeatMode", "getSeekBackIncrement", "getSeekForwardIncrement", "getShuffleModeEnabled", "getSurfaceSize", "Landroidx/media3/common/util/Size;", "getTotalBufferedDuration", "getTrackSelectionParameters", "Landroidx/media3/common/TrackSelectionParameters;", "getVideoSize", "Landroidx/media3/common/VideoSize;", "getVolume", "", "hasNext", "hasNextMediaItem", "hasNextWindow", "hasPrevious", "hasPreviousMediaItem", "hasPreviousWindow", "increaseDeviceVolume", "isCommandAvailable", "command", "isCurrentMediaItemDynamic", "isCurrentMediaItemLive", "isCurrentMediaItemSeekable", "isCurrentWindowDynamic", "isCurrentWindowLive", "isCurrentWindowSeekable", "isDeviceMuted", "isLoading", "isPlaying", "isPlayingAd", "moveMediaItem", "currentIndex", "newIndex", "moveMediaItems", "fromIndex", "toIndex", "next", "pause", "play", "prepare", "previous", "release", "removeListener", "removeMediaItem", "removeMediaItems", "replaceMediaItem", "replaceMediaItems", "seekBack", "seekForward", "seekTo", "windowIndex", "positionMs", "seekToDefaultPosition", "seekToNext", "seekToNextMediaItem", "seekToNextWindow", "seekToPrevious", "seekToPreviousMediaItem", "seekToPreviousWindow", "setAudioAttributes", "audioAttributes", "handleAudioFocus", "setDeviceMuted", "muted", "setDeviceVolume", "volume", "setMediaItem", "resetPosition", "startPositionMs", "setMediaItems", "startWindowIndex", "setPlayWhenReady", "playWhenReady", "setPlaybackParameters", "playbackParameters", "setPlaybackSpeed", "speed", "setPlayer", "setPlaylistMetadata", "mediaMetadata", "setRepeatMode", "repeatMode", "setShuffleModeEnabled", "shuffleModeEnabled", "setTrackSelectionParameters", "parameters", "setVideoSurface", "setVideoSurfaceHolder", "setVideoSurfaceView", "setVideoTextureView", "setVolume", "stop", "PlayerListener", "shared_debug"})
public final class MusicPlayer implements androidx.media3.common.Player {
    @org.jetbrains.annotations.NotNull()
    private androidx.media3.common.Player player;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<androidx.media3.common.Player.Listener> listeners = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<androidx.media3.common.MediaItem> playlist = null;
    private int currentMediaItemIndex = 0;
    @org.jetbrains.annotations.NotNull()
    private final androidx.media3.common.Player.Listener playerListener = null;
    
    public MusicPlayer(@org.jetbrains.annotations.NotNull()
    androidx.media3.common.Player player) {
        super();
    }
    
    /**
     * Sets a new [Player] instance to which the state of the previous player is transferred.
     */
    public final void setPlayer(@org.jetbrains.annotations.NotNull()
    androidx.media3.common.Player player) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.os.Looper getApplicationLooper() {
        return null;
    }
    
    @java.lang.Override()
    public void addListener(@org.jetbrains.annotations.NotNull()
    androidx.media3.common.Player.Listener listener) {
    }
    
    @java.lang.Override()
    public void removeListener(@org.jetbrains.annotations.NotNull()
    androidx.media3.common.Player.Listener listener) {
    }
    
    @java.lang.Override()
    public void setMediaItems(@org.jetbrains.annotations.NotNull()
    java.util.List<androidx.media3.common.MediaItem> mediaItems) {
    }
    
    @java.lang.Override()
    public void setMediaItems(@org.jetbrains.annotations.NotNull()
    java.util.List<androidx.media3.common.MediaItem> mediaItems, boolean resetPosition) {
    }
    
    @java.lang.Override()
    public void setMediaItems(@org.jetbrains.annotations.NotNull()
    java.util.List<androidx.media3.common.MediaItem> mediaItems, int startWindowIndex, long startPositionMs) {
    }
    
    @java.lang.Override()
    public void setMediaItem(@org.jetbrains.annotations.NotNull()
    androidx.media3.common.MediaItem mediaItem) {
    }
    
    @java.lang.Override()
    public void setMediaItem(@org.jetbrains.annotations.NotNull()
    androidx.media3.common.MediaItem mediaItem, long startPositionMs) {
    }
    
    @java.lang.Override()
    public void setMediaItem(@org.jetbrains.annotations.NotNull()
    androidx.media3.common.MediaItem mediaItem, boolean resetPosition) {
    }
    
    @java.lang.Override()
    public void addMediaItem(@org.jetbrains.annotations.NotNull()
    androidx.media3.common.MediaItem mediaItem) {
    }
    
    @java.lang.Override()
    public void addMediaItem(int index, @org.jetbrains.annotations.NotNull()
    androidx.media3.common.MediaItem mediaItem) {
    }
    
    @java.lang.Override()
    public void addMediaItems(@org.jetbrains.annotations.NotNull()
    java.util.List<androidx.media3.common.MediaItem> mediaItems) {
    }
    
    @java.lang.Override()
    public void addMediaItems(int index, @org.jetbrains.annotations.NotNull()
    java.util.List<androidx.media3.common.MediaItem> mediaItems) {
    }
    
    @java.lang.Override()
    public void moveMediaItem(int currentIndex, int newIndex) {
    }
    
    @java.lang.Override()
    public void moveMediaItems(int fromIndex, int toIndex, int newIndex) {
    }
    
    @java.lang.Override()
    public void replaceMediaItem(int index, @org.jetbrains.annotations.NotNull()
    androidx.media3.common.MediaItem mediaItem) {
    }
    
    @java.lang.Override()
    public void replaceMediaItems(int fromIndex, int toIndex, @org.jetbrains.annotations.NotNull()
    java.util.List<androidx.media3.common.MediaItem> mediaItems) {
    }
    
    @java.lang.Override()
    public void removeMediaItem(int index) {
    }
    
    @java.lang.Override()
    public void removeMediaItems(int fromIndex, int toIndex) {
    }
    
    @java.lang.Override()
    public void clearMediaItems() {
    }
    
    @java.lang.Override()
    public boolean isCommandAvailable(int command) {
        return false;
    }
    
    @java.lang.Override()
    public boolean canAdvertiseSession() {
        return false;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public androidx.media3.common.Player.Commands getAvailableCommands() {
        return null;
    }
    
    @java.lang.Override()
    public void prepare() {
    }
    
    @java.lang.Override()
    public int getPlaybackState() {
        return 0;
    }
    
    @java.lang.Override()
    public int getPlaybackSuppressionReason() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean isPlaying() {
        return false;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public androidx.media3.common.PlaybackException getPlayerError() {
        return null;
    }
    
    @java.lang.Override()
    public void play() {
    }
    
    @java.lang.Override()
    public void pause() {
    }
    
    @java.lang.Override()
    public void setPlayWhenReady(boolean playWhenReady) {
    }
    
    @java.lang.Override()
    public boolean getPlayWhenReady() {
        return false;
    }
    
    @java.lang.Override()
    public void setRepeatMode(int repeatMode) {
    }
    
    @java.lang.Override()
    public int getRepeatMode() {
        return 0;
    }
    
    @java.lang.Override()
    public void setShuffleModeEnabled(boolean shuffleModeEnabled) {
    }
    
    @java.lang.Override()
    public boolean getShuffleModeEnabled() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isLoading() {
        return false;
    }
    
    @java.lang.Override()
    public void seekToDefaultPosition() {
    }
    
    @java.lang.Override()
    public void seekToDefaultPosition(int windowIndex) {
    }
    
    @java.lang.Override()
    public void seekTo(long positionMs) {
    }
    
    @java.lang.Override()
    public void seekTo(int windowIndex, long positionMs) {
    }
    
    @java.lang.Override()
    public long getSeekBackIncrement() {
        return 0L;
    }
    
    @java.lang.Override()
    public void seekBack() {
    }
    
    @java.lang.Override()
    public long getSeekForwardIncrement() {
        return 0L;
    }
    
    @java.lang.Override()
    public void seekForward() {
    }
    
    @java.lang.Override()
    @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
    @java.lang.Deprecated()
    public boolean hasPrevious() {
        return false;
    }
    
    @java.lang.Override()
    @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
    @java.lang.Deprecated()
    public boolean hasPreviousWindow() {
        return false;
    }
    
    @java.lang.Override()
    public boolean hasPreviousMediaItem() {
        return false;
    }
    
    @java.lang.Override()
    @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
    @java.lang.Deprecated()
    public void previous() {
    }
    
    @java.lang.Override()
    @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
    @java.lang.Deprecated()
    public void seekToPreviousWindow() {
    }
    
    @java.lang.Override()
    public void seekToPreviousMediaItem() {
    }
    
    @java.lang.Override()
    public long getMaxSeekToPreviousPosition() {
        return 0L;
    }
    
    @java.lang.Override()
    public void seekToPrevious() {
    }
    
    @java.lang.Override()
    @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
    @java.lang.Deprecated()
    public boolean hasNext() {
        return false;
    }
    
    @java.lang.Override()
    @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
    @java.lang.Deprecated()
    public boolean hasNextWindow() {
        return false;
    }
    
    @java.lang.Override()
    public boolean hasNextMediaItem() {
        return false;
    }
    
    @java.lang.Override()
    @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
    @java.lang.Deprecated()
    public void next() {
    }
    
    @java.lang.Override()
    @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
    @java.lang.Deprecated()
    public void seekToNextWindow() {
    }
    
    @java.lang.Override()
    public void seekToNextMediaItem() {
    }
    
    @java.lang.Override()
    public void seekToNext() {
    }
    
    @java.lang.Override()
    public void setPlaybackParameters(@org.jetbrains.annotations.NotNull()
    androidx.media3.common.PlaybackParameters playbackParameters) {
    }
    
    @java.lang.Override()
    public void setPlaybackSpeed(float speed) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public androidx.media3.common.PlaybackParameters getPlaybackParameters() {
        return null;
    }
    
    @java.lang.Override()
    public void stop() {
    }
    
    @java.lang.Override()
    public void release() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public androidx.media3.common.Tracks getCurrentTracks() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public androidx.media3.common.TrackSelectionParameters getTrackSelectionParameters() {
        return null;
    }
    
    @java.lang.Override()
    public void setTrackSelectionParameters(@org.jetbrains.annotations.NotNull()
    androidx.media3.common.TrackSelectionParameters parameters) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public androidx.media3.common.MediaMetadata getMediaMetadata() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public androidx.media3.common.MediaMetadata getPlaylistMetadata() {
        return null;
    }
    
    @java.lang.Override()
    public void setPlaylistMetadata(@org.jetbrains.annotations.NotNull()
    androidx.media3.common.MediaMetadata mediaMetadata) {
    }
    
    @java.lang.Override()
    @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCurrentManifest() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public androidx.media3.common.Timeline getCurrentTimeline() {
        return null;
    }
    
    @java.lang.Override()
    public int getCurrentPeriodIndex() {
        return 0;
    }
    
    @java.lang.Override()
    @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
    @java.lang.Deprecated()
    public int getCurrentWindowIndex() {
        return 0;
    }
    
    @java.lang.Override()
    public int getCurrentMediaItemIndex() {
        return 0;
    }
    
    @java.lang.Override()
    @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
    @java.lang.Deprecated()
    public int getNextWindowIndex() {
        return 0;
    }
    
    @java.lang.Override()
    public int getNextMediaItemIndex() {
        return 0;
    }
    
    @java.lang.Override()
    @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
    @java.lang.Deprecated()
    public int getPreviousWindowIndex() {
        return 0;
    }
    
    @java.lang.Override()
    public int getPreviousMediaItemIndex() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public androidx.media3.common.MediaItem getCurrentMediaItem() {
        return null;
    }
    
    @java.lang.Override()
    public int getMediaItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public androidx.media3.common.MediaItem getMediaItemAt(int index) {
        return null;
    }
    
    @java.lang.Override()
    public long getDuration() {
        return 0L;
    }
    
    @java.lang.Override()
    public long getCurrentPosition() {
        return 0L;
    }
    
    @java.lang.Override()
    public long getBufferedPosition() {
        return 0L;
    }
    
    @java.lang.Override()
    public int getBufferedPercentage() {
        return 0;
    }
    
    @java.lang.Override()
    public long getTotalBufferedDuration() {
        return 0L;
    }
    
    @java.lang.Override()
    @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
    @java.lang.Deprecated()
    public boolean isCurrentWindowDynamic() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isCurrentMediaItemDynamic() {
        return false;
    }
    
    @java.lang.Override()
    @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
    @java.lang.Deprecated()
    public boolean isCurrentWindowLive() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isCurrentMediaItemLive() {
        return false;
    }
    
    @java.lang.Override()
    public long getCurrentLiveOffset() {
        return 0L;
    }
    
    @java.lang.Override()
    @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
    @java.lang.Deprecated()
    public boolean isCurrentWindowSeekable() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isCurrentMediaItemSeekable() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isPlayingAd() {
        return false;
    }
    
    @java.lang.Override()
    public int getCurrentAdGroupIndex() {
        return 0;
    }
    
    @java.lang.Override()
    public int getCurrentAdIndexInAdGroup() {
        return 0;
    }
    
    @java.lang.Override()
    public long getContentDuration() {
        return 0L;
    }
    
    @java.lang.Override()
    public long getContentPosition() {
        return 0L;
    }
    
    @java.lang.Override()
    public long getContentBufferedPosition() {
        return 0L;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public androidx.media3.common.AudioAttributes getAudioAttributes() {
        return null;
    }
    
    @java.lang.Override()
    public void setVolume(float volume) {
    }
    
    @java.lang.Override()
    public float getVolume() {
        return 0.0F;
    }
    
    @java.lang.Override()
    public void clearVideoSurface() {
    }
    
    @java.lang.Override()
    public void clearVideoSurface(@org.jetbrains.annotations.Nullable()
    android.view.Surface surface) {
    }
    
    @java.lang.Override()
    public void setVideoSurface(@org.jetbrains.annotations.Nullable()
    android.view.Surface surface) {
    }
    
    @java.lang.Override()
    public void setVideoSurfaceHolder(@org.jetbrains.annotations.Nullable()
    android.view.SurfaceHolder surfaceHolder) {
    }
    
    @java.lang.Override()
    public void clearVideoSurfaceHolder(@org.jetbrains.annotations.Nullable()
    android.view.SurfaceHolder surfaceHolder) {
    }
    
    @java.lang.Override()
    public void setVideoSurfaceView(@org.jetbrains.annotations.Nullable()
    android.view.SurfaceView surfaceView) {
    }
    
    @java.lang.Override()
    public void clearVideoSurfaceView(@org.jetbrains.annotations.Nullable()
    android.view.SurfaceView surfaceView) {
    }
    
    @java.lang.Override()
    public void setVideoTextureView(@org.jetbrains.annotations.Nullable()
    android.view.TextureView textureView) {
    }
    
    @java.lang.Override()
    public void clearVideoTextureView(@org.jetbrains.annotations.Nullable()
    android.view.TextureView textureView) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public androidx.media3.common.VideoSize getVideoSize() {
        return null;
    }
    
    @java.lang.Override()
    @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
    @org.jetbrains.annotations.NotNull()
    public androidx.media3.common.util.Size getSurfaceSize() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public androidx.media3.common.text.CueGroup getCurrentCues() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public androidx.media3.common.DeviceInfo getDeviceInfo() {
        return null;
    }
    
    @java.lang.Override()
    public int getDeviceVolume() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean isDeviceMuted() {
        return false;
    }
    
    @java.lang.Override()
    @java.lang.Deprecated()
    public void setDeviceVolume(int volume) {
    }
    
    @java.lang.Override()
    public void setDeviceVolume(int volume, int flags) {
    }
    
    @java.lang.Override()
    @java.lang.Deprecated()
    public void increaseDeviceVolume() {
    }
    
    @java.lang.Override()
    public void increaseDeviceVolume(int flags) {
    }
    
    @java.lang.Override()
    @java.lang.Deprecated()
    public void decreaseDeviceVolume() {
    }
    
    @java.lang.Override()
    public void decreaseDeviceVolume(int flags) {
    }
    
    @java.lang.Override()
    @java.lang.Deprecated()
    public void setDeviceMuted(boolean muted) {
    }
    
    @java.lang.Override()
    public void setDeviceMuted(boolean muted, int flags) {
    }
    
    @java.lang.Override()
    public void setAudioAttributes(@org.jetbrains.annotations.NotNull()
    androidx.media3.common.AudioAttributes audioAttributes, boolean handleAudioFocus) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/makeshop/podbbang/shared/media/MusicPlayer$PlayerListener;", "Landroidx/media3/common/Player$Listener;", "(Lcom/makeshop/podbbang/shared/media/MusicPlayer;)V", "onEvents", "", "player", "Landroidx/media3/common/Player;", "events", "Landroidx/media3/common/Player$Events;", "shared_debug"})
    final class PlayerListener implements androidx.media3.common.Player.Listener {
        
        public PlayerListener() {
            super();
        }
        
        @java.lang.Override()
        public void onEvents(@org.jetbrains.annotations.NotNull()
        androidx.media3.common.Player player, @org.jetbrains.annotations.NotNull()
        androidx.media3.common.Player.Events events) {
        }
    }
}