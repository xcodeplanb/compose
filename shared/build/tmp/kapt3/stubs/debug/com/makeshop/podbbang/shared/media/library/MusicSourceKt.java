package com.makeshop.podbbang.shared.media.library;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"STATE_CREATED", "", "STATE_ERROR", "STATE_INITIALIZED", "STATE_INITIALIZING", "TAG", "", "isArtist", "", "mediaItem", "Landroidx/media3/common/MediaItem;", "artist", "", "shared_debug"})
public final class MusicSourceKt {
    
    /**
     * State indicating the source was created, but no initialization has performed.
     */
    public static final int STATE_CREATED = 1;
    
    /**
     * State indicating initialization of the source is in progress.
     */
    public static final int STATE_INITIALIZING = 2;
    
    /**
     * State indicating the source has been initialized and is ready to be used.
     */
    public static final int STATE_INITIALIZED = 3;
    
    /**
     * State indicating an error has occurred.
     */
    public static final int STATE_ERROR = 4;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "MusicSource";
    
    public static final boolean isArtist(@org.jetbrains.annotations.NotNull()
    androidx.media3.common.MediaItem mediaItem, @org.jetbrains.annotations.Nullable()
    java.lang.Object artist) {
        return false;
    }
}