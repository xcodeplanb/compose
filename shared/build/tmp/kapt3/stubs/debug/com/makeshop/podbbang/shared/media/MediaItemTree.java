package com.makeshop.podbbang.shared.media;

/**
 * A sample media catalog that represents media items as a tree.
 *
 * It fetched the data from {@code catalog.json}. The root's children are folders containing media
 * items from the same album/artist/genre.
 *
 * Each app should have their own way of representing the tree. MediaItemTree is used for
 * demonstration purpose only.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001:B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002Jz\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%J\u0010\u0010\'\u001a\u0004\u0018\u00010\u00172\u0006\u0010(\u001a\u00020\u0017J\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00170\u001f2\u0006\u0010*\u001a\u00020\u0004J\u001c\u0010+\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u00042\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170\u001fJ\u0010\u0010-\u001a\u0004\u0018\u00010\u00172\u0006\u0010*\u001a\u00020\u0004J\u001a\u0010.\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u00020\u0004J\u0006\u00100\u001a\u00020\u0017J\u000e\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u000203J\u0010\u00104\u001a\u00020\u00042\u0006\u00102\u001a\u000203H\u0002J\u0012\u00105\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u000107H\u0002J\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020\u00170\u001f2\u0006\u00109\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/makeshop/podbbang/shared/media/MediaItemTree;", "", "()V", "ALBUM_ID", "", "ALBUM_PREFIX", "ARTIST_ID", "ARTIST_PREFIX", "GENRE_ID", "GENRE_PREFIX", "ITEM_PREFIX", "ROOT_ID", "isInitialized", "", "titleMap", "", "Lcom/makeshop/podbbang/shared/media/MediaItemTree$MediaItemNode;", "treeNodes", "addNodeToTree", "", "mediaObject", "Lorg/json/JSONObject;", "buildMediaItem", "Landroidx/media3/common/MediaItem;", "title", "mediaId", "isPlayable", "isBrowsable", "mediaType", "", "subtitleConfigurations", "", "Landroidx/media3/common/MediaItem$SubtitleConfiguration;", "album", "artist", "genre", "sourceUri", "Landroid/net/Uri;", "imageUri", "expandItem", "item", "getChildren", "id", "getIndexInMediaItems", "mediaItems", "getItem", "getParentId", "parentId", "getRootItem", "initialize", "assets", "Landroid/content/res/AssetManager;", "loadJSONFromAsset", "normalizeSearchText", "text", "", "search", "query", "MediaItemNode", "shared_debug"})
public final class MediaItemTree {
    @org.jetbrains.annotations.NotNull()
    private static java.util.Map<java.lang.String, com.makeshop.podbbang.shared.media.MediaItemTree.MediaItemNode> treeNodes;
    @org.jetbrains.annotations.NotNull()
    private static java.util.Map<java.lang.String, com.makeshop.podbbang.shared.media.MediaItemTree.MediaItemNode> titleMap;
    private static boolean isInitialized = false;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ROOT_ID = "/";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ALBUM_ID = "[albumID]";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String GENRE_ID = "[genreID]";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ARTIST_ID = "[artistID]";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ALBUM_PREFIX = "[album]";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String GENRE_PREFIX = "[genre]";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ARTIST_PREFIX = "[artist]";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ITEM_PREFIX = "[item]";
    @org.jetbrains.annotations.NotNull()
    public static final com.makeshop.podbbang.shared.media.MediaItemTree INSTANCE = null;
    
    private MediaItemTree() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.media3.common.MediaItem buildMediaItem(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String mediaId, boolean isPlayable, boolean isBrowsable, int mediaType, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends androidx.media3.common.MediaItem.SubtitleConfiguration> subtitleConfigurations, @org.jetbrains.annotations.Nullable()
    java.lang.String album, @org.jetbrains.annotations.Nullable()
    java.lang.String artist, @org.jetbrains.annotations.Nullable()
    java.lang.String genre, @org.jetbrains.annotations.Nullable()
    android.net.Uri sourceUri, @org.jetbrains.annotations.Nullable()
    android.net.Uri imageUri) {
        return null;
    }
    
    private final java.lang.String loadJSONFromAsset(android.content.res.AssetManager assets) {
        return null;
    }
    
    public final void initialize(@org.jetbrains.annotations.NotNull()
    android.content.res.AssetManager assets) {
    }
    
    private final void addNodeToTree(org.json.JSONObject mediaObject) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.media3.common.MediaItem getItem(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.media3.common.MediaItem expandItem(@org.jetbrains.annotations.NotNull()
    androidx.media3.common.MediaItem item) {
        return null;
    }
    
    /**
     * Returns the media ID of the parent of the given media ID, or null if the media ID wasn't found.
     *
     * @param mediaId The media ID of which to search the parent.
     * @Param parentId The media ID of the media item to start the search from, or undefined to search
     *  from the top most node.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getParentId(@org.jetbrains.annotations.NotNull()
    java.lang.String mediaId, @org.jetbrains.annotations.NotNull()
    java.lang.String parentId) {
        return null;
    }
    
    /**
     * Returns the index of the [MediaItem] with the give media ID in the given list of items. If the
     * media ID wasn't found, 0 (zero) is returned.
     */
    public final int getIndexInMediaItems(@org.jetbrains.annotations.NotNull()
    java.lang.String mediaId, @org.jetbrains.annotations.NotNull()
    java.util.List<androidx.media3.common.MediaItem> mediaItems) {
        return 0;
    }
    
    /**
     * Tokenizes the query into a list of words with at least two letters and searches in the search
     * text of the [MediaItemNode].
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<androidx.media3.common.MediaItem> search(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.media3.common.MediaItem getRootItem() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<androidx.media3.common.MediaItem> getChildren(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    private final java.lang.String normalizeSearchText(java.lang.CharSequence text) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/makeshop/podbbang/shared/media/MediaItemTree$MediaItemNode;", "", "item", "Landroidx/media3/common/MediaItem;", "(Landroidx/media3/common/MediaItem;)V", "children", "", "getItem", "()Landroidx/media3/common/MediaItem;", "searchText", "", "getSearchText", "()Ljava/lang/String;", "searchTitle", "getSearchTitle", "addChild", "", "childID", "getChildren", "", "shared_debug"})
    public static final class MediaItemNode {
        @org.jetbrains.annotations.NotNull()
        private final androidx.media3.common.MediaItem item = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String searchTitle = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String searchText = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<androidx.media3.common.MediaItem> children = null;
        
        public MediaItemNode(@org.jetbrains.annotations.NotNull()
        androidx.media3.common.MediaItem item) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.media3.common.MediaItem getItem() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSearchTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSearchText() {
            return null;
        }
        
        public final void addChild(@org.jetbrains.annotations.NotNull()
        java.lang.String childID) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<androidx.media3.common.MediaItem> getChildren() {
            return null;
        }
    }
}