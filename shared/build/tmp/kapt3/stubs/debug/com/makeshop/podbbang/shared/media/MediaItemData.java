package com.makeshop.podbbang.shared.media;

/**
 * Data class to encapsulate properties of a [MediaItem].
 *
 * If an item is [browsable] it means that it has a list of child media items that
 * can be retrieved by passing the mediaId to [MusicServiceConnection].
 *
 * Objects of this class are built from [MediaItem]s in
 * [MediaItemFragmentViewModel.subscriptionCallback].
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u0010\u001d\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001e\u001a\u00020\tH\u00c6\u0003JG\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\u0007H\u00d6\u0001J\t\u0010#\u001a\u00020\tH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012\u00a8\u0006%"}, d2 = {"Lcom/makeshop/podbbang/shared/media/MediaItemData;", "", "mediaItem", "Landroidx/media3/common/MediaItem;", "browsable", "", "playbackRes", "", "parentMediaId", "", "title", "subtitle", "(Landroidx/media3/common/MediaItem;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrowsable", "()Z", "getMediaItem", "()Landroidx/media3/common/MediaItem;", "getParentMediaId", "()Ljava/lang/String;", "getPlaybackRes", "()I", "setPlaybackRes", "(I)V", "getSubtitle", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "Companion", "shared_debug"})
public final class MediaItemData {
    @org.jetbrains.annotations.NotNull()
    private final androidx.media3.common.MediaItem mediaItem = null;
    private final boolean browsable = false;
    private int playbackRes;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String parentMediaId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String subtitle = null;
    
    /**
     * Indicates [playbackRes] has changed.
     */
    public static final int PLAYBACK_RES_CHANGED = 1;
    
    /**
     * [DiffUtil.ItemCallback] for a [MediaItemData].
     *
     * Since all [MediaItemData]s have a unique ID, it's easiest to check if two
     * items are the same by simply comparing that ID.
     *
     * To check if the contents are the same, we use the same ID, but it may be the
     * case that it's only the play state itself which has changed (from playing to
     * paused, or perhaps a different item is the active item now). In this case
     * we check both the ID and the playback resource.
     *
     * To calculate the payload, we use the simplest method possible:
     * - Since the title, subtitle, and albumArtUri are constant (with respect to mediaId),
     *  there's no reason to check if they've changed. If the mediaId is the same, none of
     *  those properties have changed.
     * - If the playback resource (playbackRes) has changed to reflect the change in playback
     *  state, that's all that needs to be updated. We return [PLAYBACK_RES_CHANGED] as
     *  the payload in this case.
     * - If something else changed, then refresh the full item for simplicity.
     */
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.makeshop.podbbang.shared.media.MediaItemData> diffCallback = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.makeshop.podbbang.shared.media.MediaItemData.Companion Companion = null;
    
    public MediaItemData(@org.jetbrains.annotations.NotNull()
    androidx.media3.common.MediaItem mediaItem, boolean browsable, int playbackRes, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMediaId, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String subtitle) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.media3.common.MediaItem getMediaItem() {
        return null;
    }
    
    public final boolean getBrowsable() {
        return false;
    }
    
    public final int getPlaybackRes() {
        return 0;
    }
    
    public final void setPlaybackRes(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getParentMediaId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSubtitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.media3.common.MediaItem component1() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final int component3() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.makeshop.podbbang.shared.media.MediaItemData copy(@org.jetbrains.annotations.NotNull()
    androidx.media3.common.MediaItem mediaItem, boolean browsable, int playbackRes, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMediaId, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String subtitle) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/makeshop/podbbang/shared/media/MediaItemData$Companion;", "", "()V", "PLAYBACK_RES_CHANGED", "", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/makeshop/podbbang/shared/media/MediaItemData;", "getDiffCallback", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "shared_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * [DiffUtil.ItemCallback] for a [MediaItemData].
         *
         * Since all [MediaItemData]s have a unique ID, it's easiest to check if two
         * items are the same by simply comparing that ID.
         *
         * To check if the contents are the same, we use the same ID, but it may be the
         * case that it's only the play state itself which has changed (from playing to
         * paused, or perhaps a different item is the active item now). In this case
         * we check both the ID and the playback resource.
         *
         * To calculate the payload, we use the simplest method possible:
         * - Since the title, subtitle, and albumArtUri are constant (with respect to mediaId),
         *  there's no reason to check if they've changed. If the mediaId is the same, none of
         *  those properties have changed.
         * - If the playback resource (playbackRes) has changed to reflect the change in playback
         *  state, that's all that needs to be updated. We return [PLAYBACK_RES_CHANGED] as
         *  the payload in this case.
         * - If something else changed, then refresh the full item for simplicity.
         */
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.makeshop.podbbang.shared.media.MediaItemData> getDiffCallback() {
            return null;
        }
    }
}