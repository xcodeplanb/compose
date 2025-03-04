package com.makeshop.podbbang.shared.media;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J4\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/makeshop/podbbang/shared/media/MediaNotificationProvider;", "Landroidx/media3/session/DefaultMediaNotificationProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "addNotificationActions", "", "mediaSession", "Landroidx/media3/session/MediaSession;", "mediaButtons", "Lcom/google/common/collect/ImmutableList;", "Landroidx/media3/session/CommandButton;", "builder", "Landroidx/core/app/NotificationCompat$Builder;", "actionFactory", "Landroidx/media3/session/MediaNotification$ActionFactory;", "getMediaButtons", "session", "playerCommands", "Landroidx/media3/common/Player$Commands;", "customLayout", "showPauseButton", "", "shared_debug"})
@androidx.media3.common.util.UnstableApi()
public final class MediaNotificationProvider extends androidx.media3.session.DefaultMediaNotificationProvider {
    
    public MediaNotificationProvider(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected com.google.common.collect.ImmutableList<androidx.media3.session.CommandButton> getMediaButtons(@org.jetbrains.annotations.NotNull()
    androidx.media3.session.MediaSession session, @org.jetbrains.annotations.NotNull()
    androidx.media3.common.Player.Commands playerCommands, @org.jetbrains.annotations.NotNull()
    com.google.common.collect.ImmutableList<androidx.media3.session.CommandButton> customLayout, boolean showPauseButton) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected int[] addNotificationActions(@org.jetbrains.annotations.NotNull()
    androidx.media3.session.MediaSession mediaSession, @org.jetbrains.annotations.NotNull()
    com.google.common.collect.ImmutableList<androidx.media3.session.CommandButton> mediaButtons, @org.jetbrains.annotations.NotNull()
    androidx.core.app.NotificationCompat.Builder builder, @org.jetbrains.annotations.NotNull()
    androidx.media3.session.MediaNotification.ActionFactory actionFactory) {
        return null;
    }
}