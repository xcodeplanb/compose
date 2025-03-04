package com.makeshop.podbbang.shared.media;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/makeshop/podbbang/shared/media/PersistentStorage;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "preferences", "Landroid/content/SharedPreferences;", "loadRecentSong", "Landroidx/media3/common/MediaItem;", "saveRecentSong", "", "mediaItem", "position", "", "(Landroidx/media3/common/MediaItem;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "shared_debug"})
public final class PersistentStorage {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    /**
     * Store any data which must persist between restarts, such as the most recently played song.
     */
    @org.jetbrains.annotations.NotNull()
    private android.content.SharedPreferences preferences;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.makeshop.podbbang.shared.media.PersistentStorage instance;
    @org.jetbrains.annotations.NotNull()
    public static final com.makeshop.podbbang.shared.media.PersistentStorage.Companion Companion = null;
    
    private PersistentStorage(android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveRecentSong(@org.jetbrains.annotations.NotNull()
    androidx.media3.common.MediaItem mediaItem, long position, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.media3.common.MediaItem loadRecentSong() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/makeshop/podbbang/shared/media/PersistentStorage$Companion;", "", "()V", "instance", "Lcom/makeshop/podbbang/shared/media/PersistentStorage;", "getInstance", "context", "Landroid/content/Context;", "shared_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.makeshop.podbbang.shared.media.PersistentStorage getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}