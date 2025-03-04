package com.makeshop.podbbang.shared.media;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"ACTION_TOGGLE_SPATIALIZATION", "", "CONTENT_STYLE_BROWSABLE_HINT", "CONTENT_STYLE_GRID", "", "CONTENT_STYLE_LIST", "CONTENT_STYLE_PLAYABLE_HINT", "CONTENT_STYLE_SUPPORTED", "EXTRAS_TOGGLE_SPATIALIZATION", "MEDIA_DESCRIPTION_EXTRAS_START_PLAYBACK_POSITION_MS", "MEDIA_SEARCH_SUPPORTED", "RESOURCE_ROOT_URI", "TAG", "UAMP_ALBUMS_ROOT", "UAMP_BROWSABLE_ROOT", "UAMP_EMPTY_ROOT", "UAMP_RECENT_ROOT", "UAMP_RECOMMENDED_ROOT", "shared_debug"})
public final class MusicServiceKt {
    
    /**
     * Content styling constants
     */
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String CONTENT_STYLE_BROWSABLE_HINT = "android.media.browse.CONTENT_STYLE_BROWSABLE_HINT";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String CONTENT_STYLE_PLAYABLE_HINT = "android.media.browse.CONTENT_STYLE_PLAYABLE_HINT";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CONTENT_STYLE_SUPPORTED = "android.media.browse.CONTENT_STYLE_SUPPORTED";
    private static final int CONTENT_STYLE_LIST = 1;
    private static final int CONTENT_STYLE_GRID = 2;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_TOGGLE_SPATIALIZATION = "com.example.android.uamp.ACTION_TOGGLE_SPATIALIZATION";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRAS_TOGGLE_SPATIALIZATION = "com.example.android.uamp.EXTRAS_TOGGLE_SPATIALIZATION";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MEDIA_DESCRIPTION_EXTRAS_START_PLAYBACK_POSITION_MS = "playback_start_position_ms";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "MusicService";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UAMP_BROWSABLE_ROOT = "/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UAMP_EMPTY_ROOT = "@empty@";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UAMP_RECOMMENDED_ROOT = "__RECOMMENDED__";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UAMP_ALBUMS_ROOT = "__ALBUMS__";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UAMP_RECENT_ROOT = "__RECENT__";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MEDIA_SEARCH_SUPPORTED = "android.media.browse.SEARCH_SUPPORTED";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RESOURCE_ROOT_URI = "android.resource://com.example.android.uamp.next/drawable/";
}