package com.makeshop.podbbang.shared.media.library;

/**
 * Base class for music sources in UAMP.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\n2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u0086\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001c"}, d2 = {"Lcom/makeshop/podbbang/shared/media/library/AbstractMusicSource;", "Lcom/makeshop/podbbang/shared/media/library/MusicSource;", "()V", "EXTRA_MEDIA_GENRE", "", "getEXTRA_MEDIA_GENRE", "()Ljava/lang/String;", "onReadyListeners", "", "Lkotlin/Function1;", "", "", "value", "", "state", "getState$annotations", "getState", "()I", "setState", "(I)V", "search", "", "Landroidx/media3/common/MediaItem;", "query", "extras", "Landroid/os/Bundle;", "whenReady", "performAction", "shared_debug"})
public abstract class AbstractMusicSource implements com.makeshop.podbbang.shared.media.library.MusicSource {
    private int state = 1;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit>> onReadyListeners = null;
    
    public AbstractMusicSource() {
        super();
    }
    
    public final int getState() {
        return 0;
    }
    
    @State()
    @java.lang.Deprecated()
    public static void getState$annotations() {
    }
    
    public final void setState(int value) {
    }
    
    /**
     * Performs an action when this MusicSource is ready.
     *
     * This method is *not* threadsafe. Ensure actions and state changes are only performed
     * on a single thread.
     */
    @java.lang.Override()
    public boolean whenReady(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> performAction) {
        return false;
    }
    
    /**
     * Handles searching a [MusicSource] from a focused voice search, often coming
     * from the Google Assistant.
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<androidx.media3.common.MediaItem> search(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    android.os.Bundle extras) {
        return null;
    }
    
    private final java.lang.String getEXTRA_MEDIA_GENRE() {
        return null;
    }
    
    @java.lang.Override()
    public java.util.Iterator<androidx.media3.common.MediaItem> iterator() {
        return null;
    }
}