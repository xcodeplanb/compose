package com.makeshop.podbbang.shared.media.library;

/**
 * Interface used by [MusicService] for looking up [MediaMetadataCompat] objects.
 *
 * Because Kotlin provides methods such as [Iterable.find] and [Iterable.filter],
 * this is a convenient interface to have on sources.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000e\u0010\u0003\u001a\u00020\u0004H\u00a6@\u00a2\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u001c\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\u000fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/makeshop/podbbang/shared/media/library/MusicSource;", "", "Landroidx/media3/common/MediaItem;", "load", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "query", "", "extras", "Landroid/os/Bundle;", "whenReady", "", "performAction", "Lkotlin/Function1;", "shared_debug"})
public abstract interface MusicSource extends java.lang.Iterable<androidx.media3.common.MediaItem>, kotlin.jvm.internal.markers.KMappedMarker {
    
    /**
     * Begins loading the data for this music source.
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object load(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Method which will perform a given action after this [MusicSource] is ready to be used.
     *
     * @param performAction A lambda expression to be called with a boolean parameter when
     * the source is ready. `true` indicates the source was successfully prepared, `false`
     * indicates an error occurred.
     * @return True if the music source is ready to be read, false if it still loading.
     */
    public abstract boolean whenReady(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> performAction);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<androidx.media3.common.MediaItem> search(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    android.os.Bundle extras);
}