package com.makeshop.podbbang.shared.media.library;

/**
 * Represents a tree of media that's used by [MusicService.onLoadChildren].
 *
 * [BrowseTree] maps a media id (see: [MediaMetadataCompat.METADATA_KEY_MEDIA_ID]) to one (or
 * more) [MediaMetadataCompat] objects, which are children of that media id.
 *
 * For example, given the following conceptual tree:
 * root
 * +-- Albums
 * |    +-- Album_A
 * |    |    +-- Song_1
 * |    |    +-- Song_2
 * ...
 * +-- Artists
 * ...
 *
 * Requesting `browseTree["root"]` would return a list that included "Albums", "Artists", and
 * any other direct children. Taking the media ID of "Albums" ("Albums" in this example),
 * `browseTree["Albums"]` would return a single item list "Album_A", and, finally,
 * `browseTree["Album_A"]` would return "Song_1" and "Song_2". Since those are leaf nodes,
 * requesting `browseTree["Song_1"]` would return null (there aren't any children of it).
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\u0019\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u001b\u001a\u00020\u0007H\u0086\u0002J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/makeshop/podbbang/shared/media/library/BrowseTree;", "", "context", "Landroid/content/Context;", "musicSource", "Lcom/makeshop/podbbang/shared/media/library/MusicSource;", "recentMediaId", "", "(Landroid/content/Context;Lcom/makeshop/podbbang/shared/media/library/MusicSource;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "mediaIdToChildren", "", "", "Landroidx/media3/common/MediaItem;", "mediaIdToMediaItem", "getMusicSource", "()Lcom/makeshop/podbbang/shared/media/library/MusicSource;", "getRecentMediaId", "()Ljava/lang/String;", "searchableByUnknownCaller", "", "getSearchableByUnknownCaller", "()Z", "buildAlbumRoot", "mediaItem", "get", "mediaId", "getMediaItemByMediaId", "shared_debug"})
public final class BrowseTree {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable()
    private final com.makeshop.podbbang.shared.media.library.MusicSource musicSource = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String recentMediaId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.util.List<androidx.media3.common.MediaItem>> mediaIdToChildren = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, androidx.media3.common.MediaItem> mediaIdToMediaItem = null;
    
    /**
     * Whether to allow clients which are unknown (not on the allowed list) to use search on this
     * [BrowseTree].
     */
    private final boolean searchableByUnknownCaller = true;
    
    public BrowseTree(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    com.makeshop.podbbang.shared.media.library.MusicSource musicSource, @org.jetbrains.annotations.Nullable()
    java.lang.String recentMediaId) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.makeshop.podbbang.shared.media.library.MusicSource getMusicSource() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRecentMediaId() {
        return null;
    }
    
    /**
     * Whether to allow clients which are unknown (not on the allowed list) to use search on this
     * [BrowseTree].
     */
    public final boolean getSearchableByUnknownCaller() {
        return false;
    }
    
    /**
     * Provides access to the list of children with the `get` operator.
     * i.e.: `browseTree\[UAMP_BROWSABLE_ROOT\]`
     */
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<androidx.media3.common.MediaItem> get(@org.jetbrains.annotations.NotNull()
    java.lang.String mediaId) {
        return null;
    }
    
    /**
     * Provides access to the media items by media id.
     */
    @org.jetbrains.annotations.Nullable()
    public final androidx.media3.common.MediaItem getMediaItemByMediaId(@org.jetbrains.annotations.NotNull()
    java.lang.String mediaId) {
        return null;
    }
    
    /**
     * Builds a node, under the root, that represents an album, given
     * a [MediaItem] object that's one of the songs on that album,
     * marking the item as [MediaMetadata.FOLDER_TYPE_ALBUMS], since it will have child
     * node(s) AKA at least 1 song.
     */
    private final java.util.List<androidx.media3.common.MediaItem> buildAlbumRoot(androidx.media3.common.MediaItem mediaItem) {
        return null;
    }
}