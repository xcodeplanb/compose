/*
 * Copyright 2017 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.makeshop.podbbang.shared.media

//import com.makeshop.podbbang.shared.media.library.UAMP_RECENT_ROOT
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.ConditionVariable
import android.util.Log
import android.widget.Toast
import androidx.annotation.OptIn
import androidx.media.utils.MediaConstants
import androidx.media3.cast.CastPlayer
import androidx.media3.common.AudioAttributes
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.common.Player.EVENT_MEDIA_ITEM_TRANSITION
import androidx.media3.common.Player.EVENT_PLAY_WHEN_READY_CHANGED
import androidx.media3.common.Player.EVENT_POSITION_DISCONTINUITY
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.util.EventLogger
import androidx.media3.session.LibraryResult
import androidx.media3.session.MediaLibraryService
import androidx.media3.session.MediaSession
import androidx.media3.session.MediaSession.MediaItemsWithStartPosition
import androidx.media3.session.SessionCommand
import androidx.media3.session.SessionResult
import com.google.common.collect.ImmutableList
import com.google.common.util.concurrent.Futures
import com.google.common.util.concurrent.ListenableFuture
import com.google.common.util.concurrent.MoreExecutors
import com.makeshop.podbbang.shared.R
import com.makeshop.podbbang.shared.data.db.user.UserInfo
import com.makeshop.podbbang.shared.data.db.user.UserInfoDBRepository
import com.makeshop.podbbang.shared.repository.AndroidAutoRepository
import com.makeshop.podbbang.shared.repository.EpisodeRepository
import com.makeshop.podbbang.shared.repository.RankingRepository
import com.makeshop.podbbang.shared.util.LineLog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import javax.inject.Inject

/**
 * Service for browsing the catalogue and and receiving a [MediaController] from the app's UI
 * and other apps that wish to play music via UAMP (for example, Android Auto or
 * the Google Assistant).
 *
 * Browsing begins with the method [MusicService.MusicServiceCallback.onGetLibraryRoot], and
 * continues in the callback [MusicService.MusicServiceCallback.onGetChildren].
 *
 * This class also handles playback for Cast sessions. When a Cast session is active, playback
 * commands are passed to a [CastPlayer].
 */
@AndroidEntryPoint
open class MusicService : MediaLibraryService() {
    private val serviceJob = SupervisorJob()
    private val serviceScope = CoroutineScope(Dispatchers.Main + serviceJob)

    lateinit var mediaSession: MediaLibrarySession
    private var currentMediaItemIndex: Int = 0

    @Inject
    lateinit var episodeRepository: EpisodeRepository

    @Inject
    lateinit var rankingRepository: RankingRepository

    @Inject
    lateinit var androidAutoRepository: AndroidAutoRepository

    @Inject
    lateinit var userInfoDBRepository: UserInfoDBRepository
//    private lateinit var musicSource: MusicSource
//    private lateinit var packageValidator: PackageValidator
//    private lateinit var storage: PersistentStorage

    /**
     * This must be `by lazy` because the [musicSource] won't initially be ready. Use
     * [callWhenMusicSourceReady] to be sure it is safely ready for usage.
     */
//    private val browseTree: BrowseTree by lazy {
//        BrowseTree(applicationContext, musicSource)
//    }

    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.IO + job)


    private val catalogueRootMediaItem: MediaItem by lazy {
        MediaItem.Builder().setMediaId(UAMP_BROWSABLE_ROOT).setMediaMetadata(
            MediaMetadata.Builder().setFolderType(MediaMetadata.FOLDER_TYPE_ALBUMS)
                .setIsPlayable(false).build()
        ).build()
    }

    private val executorService by lazy {
        MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor())
    }

    private val remoteJsonSource: Uri =
        Uri.parse("https://storage.googleapis.com/uamp/catalog.json")

    private val uAmpAudioAttributesBuilder =
        AudioAttributes.Builder().setContentType(C.AUDIO_CONTENT_TYPE_MUSIC).setUsage(C.USAGE_MEDIA)

    private val playerListener = PlayerEventListener()

    /**
     * Configure ExoPlayer to handle audio focus for us. See [ExoPlayer.Builder.setAudioAttributes]
     * for details.
     */
    private val exoPlayer: ExoPlayer by lazy {
        val player = ExoPlayer.Builder(this).build().apply {
            setAudioAttributes(uAmpAudioAttributesBuilder.build(), true)
            setHandleAudioBecomingNoisy(true)
            addListener(playerListener)
        }
        player.addAnalyticsListener(EventLogger("exoplayer-uamp"))
        player
    }

    /** @return the {@link MediaLibrarySessionCallback} to be used to build the media session. */
    open fun getCallback(): MediaLibrarySession.Callback {
        return MusicServiceCallback()
    }

    @kotlin.OptIn(DelicateCoroutinesApi::class)
    override fun onCreate() {
        super.onCreate()
        LineLog.d("MusicService onCreate")

        mediaSession = with(
            MediaLibrarySession.Builder(
                this, exoPlayer, getCallback()
            )
        ) {
            setId(packageName)
            packageManager?.getLaunchIntentForPackage(packageName)?.let { sessionIntent ->
                setSessionActivity(
                    PendingIntent.getActivity(/* context= */ this@MusicService,/* requestCode= */
                        0, sessionIntent, if (Build.VERSION.SDK_INT >= 23) FLAG_IMMUTABLE
                        else FLAG_UPDATE_CURRENT
                    )
                )
            }
            build()
        }

        // The media library is built from a remote JSON file. We start loading asynchronously here.
        // Use [callWhenMusicSourceReady] to execute code that needs the source load being
        // completed.
//        musicSource = JsonSource(source = remoteJsonSource)
//        serviceScope.launch {
//            musicSource.load()
//        }

//        packageValidator = PackageValidator(this, R.xml.allowed_media_browser_callers)
//        storage = PersistentStorage.getInstance(applicationContext)
    }

    override fun onGetSession(controllerInfo: MediaSession.ControllerInfo): MediaLibrarySession? {
        return mediaSession
//        return if ("android.media.session.MediaController" == controllerInfo.packageName || packageValidator.isKnownCaller(
//                controllerInfo.packageName, controllerInfo.uid
//            )
//        ) {
//            mediaSession
//        } else null
    }

    /** Called when swiping the activity away from recents. */
    override fun onTaskRemoved(rootIntent: Intent?) {
//        saveRecentSongToStorage()
        super.onTaskRemoved(rootIntent)
        // The choice what to do here is app specific. Some apps stop playback, while others allow
        // playback to continue and allow users to stop it with the notification.
        releaseMediaSession()
        stopSelf()
    }

    override fun onDestroy() {
        super.onDestroy()
        releaseMediaSession()
    }

    private fun releaseMediaSession() {
        mediaSession.run {
            release()
            if (player.playbackState != Player.STATE_IDLE) {
                player.removeListener(playerListener)
                player.release()
            }
        }
        // Cancel coroutines when the service is going away.
//        serviceJob.cancel()
    }

    private fun saveRecentSongToStorage() {
        // Obtain the current song details *before* saving them on a separate thread, otherwise
        // the current player may have been unloaded by the time the save routine runs.
//        val currentMediaItem = exoPlayer.currentMediaItem ?: return
//        serviceScope.launch {
//            val mediaItem =
//                browseTree.getMediaItemByMediaId(currentMediaItem.mediaId) ?: return@launch
//            storage.saveRecentSong(mediaItem, exoPlayer.currentPosition)
//        }
    }

    private fun preparePlayerForResumption(mediaItem: MediaItem) {
//        musicSource.whenReady {
//            if (it) {
//                val playableMediaItem = browseTree.getMediaItemByMediaId(mediaItem.mediaId)
//                val startPositionMs = mediaItem.mediaMetadata.extras?.getLong(
//                    MEDIA_DESCRIPTION_EXTRAS_START_PLAYBACK_POSITION_MS
//                ) ?: 0
//                playableMediaItem?.let {
//                    exoPlayer.setMediaItem(playableMediaItem)
//                    exoPlayer.seekTo(startPositionMs)
//                    exoPlayer.prepare()
//                }
//            }
//        }
    }

    /** Returns a function that opens the condition variable when called. */
    private fun openWhenReady(conditionVariable: ConditionVariable): (Boolean) -> Unit = {
        val successfullyInitialized = it
        if (!successfullyInitialized) {
            Log.e(TAG, "loading music source failed")
        }
        conditionVariable.open()
    }

    /**
     * Returns a future that executes the action when the music source is ready. This may be an
     * immediate execution if the music source is ready, or a deferred asynchronous execution if the
     * music source is still loading.
     *
     * @param action The function to be called when the music source is ready.
     */
//    private fun <T> callWhenMusicSourceReady(action: () -> T): ListenableFuture<T> {
//        val conditionVariable = ConditionVariable()
//        return if (musicSource.whenReady(openWhenReady(conditionVariable))) {
//            Futures.immediateFuture(action())
//        } else {
//            executorService.submit<T> {
//                conditionVariable.block()
//                action()
//            }
//        }
//    }

    open inner class MusicServiceCallback : MediaLibrarySession.Callback {
        init {
            BrowseTree.init(applicationContext, serviceScope, androidAutoRepository)
        }

        /**
         * Establishes media connection
         * Set up custom command for Spatial Audio toggle
         */
        override fun onConnect(
            session: MediaSession, controller: MediaSession.ControllerInfo
        ): MediaSession.ConnectionResult {
            val connectionResult = super.onConnect(session, controller)
            val sessionCommands = connectionResult.availableSessionCommands.buildUpon()
                // Add custom commands
                .add(SessionCommand(ACTION_TOGGLE_SPATIALIZATION, Bundle())).build()
            return MediaSession.ConnectionResult.accept(
                sessionCommands, connectionResult.availablePlayerCommands
            )
        }

        @OptIn(UnstableApi::class) override fun onGetLibraryRoot(
            session: MediaLibrarySession,
            browser: MediaSession.ControllerInfo,
            params: LibraryParams?
        ): ListenableFuture<LibraryResult<MediaItem>> {
//            var responseParams = params
//            val rootHintParams = params ?: LibraryParams.Builder().build()
//            rootHintParams.extras.putInt(
//                androidx.media3.session.MediaConstants.EXTRAS_KEY_CONTENT_STYLE_BROWSABLE,
//                androidx.media3.session.MediaConstants.EXTRAS_VALUE_CONTENT_STYLE_GRID_ITEM
//            )
//            rootHintParams.extras.putInt(
//                androidx.media3.session.MediaConstants.EXTRAS_KEY_CONTENT_STYLE_PLAYABLE,
//                androidx.media3.session.MediaConstants.EXTRAS_VALUE_CONTENT_STYLE_LIST_ITEM
//            )
//            // Tweaked params are propagated to Automotive browsers as root hints.
//            responseParams = rootHintParams

            // By default, all known clients are permitted to search, but only tell unknown callers
            // about search if permitted by the [BrowseTree].
            return Futures.immediateFuture(
                LibraryResult.ofItem(
                    BrowseTree.getRootItem(), params
                )
            )
        }

        override fun onGetChildren(
            session: MediaLibrarySession,
            browser: MediaSession.ControllerInfo,
            parentId: String,
            page: Int,
            pageSize: Int,
            params: LibraryParams?
        ): ListenableFuture<LibraryResult<ImmutableList<MediaItem>>> {
            val children = BrowseTree.getChildren(parentId)
            if (children.isNotEmpty()) {
                return Futures.immediateFuture(LibraryResult.ofItemList(children, params))
            }
            return Futures.immediateFuture(LibraryResult.ofError(LibraryResult.RESULT_ERROR_BAD_VALUE))
        }

        override fun onGetItem(
            session: MediaLibrarySession, browser: MediaSession.ControllerInfo, mediaId: String
        ): ListenableFuture<LibraryResult<MediaItem>> {
            BrowseTree.getItem(mediaId)?.let {
                return Futures.immediateFuture(LibraryResult.ofItem(it, /* params= */ null))
            }
            return Futures.immediateFuture(LibraryResult.ofError(LibraryResult.RESULT_ERROR_BAD_VALUE))
        }

        override fun onSearch(
            session: MediaLibrarySession,
            browser: MediaSession.ControllerInfo,
            query: String,
            params: LibraryParams?
        ): ListenableFuture<LibraryResult<Void>> {
            session.notifySearchResultChanged(
                browser, query, BrowseTree.search(query).size, params
            )
            return Futures.immediateFuture(LibraryResult.ofVoid())
        }

        override fun onGetSearchResult(
            session: MediaLibrarySession,
            browser: MediaSession.ControllerInfo,
            query: String,
            page: Int,
            pageSize: Int,
            params: LibraryParams?
        ): ListenableFuture<LibraryResult<ImmutableList<MediaItem>>> {
            return Futures.immediateFuture(
                LibraryResult.ofItemList(
                    BrowseTree.search(query), params
                )
            )
        }

        @OptIn(UnstableApi::class) // MediaSession.MediaItemsWithStartPosition
        override fun onSetMediaItems(
            mediaSession: MediaSession,
            browser: MediaSession.ControllerInfo,
            mediaItems: List<MediaItem>,
            startIndex: Int,
            startPositionMs: Long,
        ): ListenableFuture<MediaItemsWithStartPosition> {
            if (mediaItems.size == 1) {
                // Try to expand a single item to a playlist.
                maybeExpandSingleItemToPlaylist(mediaItems.first(), startIndex, startPositionMs)?.also {
                    return Futures.immediateFuture(it)
                }
            }
            return Futures.immediateFuture(
                MediaItemsWithStartPosition(resolveMediaItems(mediaItems), startIndex, startPositionMs)
            )
        }

        override fun onAddMediaItems(
            mediaSession: MediaSession,
            controller: MediaSession.ControllerInfo,
            mediaItems: List<MediaItem>,
        ): ListenableFuture<List<MediaItem>> {
            return Futures.immediateFuture(resolveMediaItems(mediaItems))
        }

        override fun onCustomCommand(
            session: MediaSession,
            controller: MediaSession.ControllerInfo,
            customCommand: SessionCommand,
            args: Bundle
        ): ListenableFuture<SessionResult> {/*
            Toggle spatial audio
             */
            if (customCommand.customAction == ACTION_TOGGLE_SPATIALIZATION) {
                val enable = customCommand.customExtras.getBoolean(EXTRAS_TOGGLE_SPATIALIZATION)

                if (enable) {
                    uAmpAudioAttributesBuilder.setSpatializationBehavior(C.SPATIALIZATION_BEHAVIOR_AUTO)
                } else {
                    uAmpAudioAttributesBuilder.setSpatializationBehavior(C.SPATIALIZATION_BEHAVIOR_NEVER)
                }

                exoPlayer.setAudioAttributes(
                    uAmpAudioAttributesBuilder.build(), true
                )

                return Futures.immediateFuture(SessionResult(SessionResult.RESULT_SUCCESS))
            }
            return Futures.immediateFuture(SessionResult(SessionResult.RESULT_ERROR_NOT_SUPPORTED))
        }

        private fun resolveMediaItems(mediaItems: List<MediaItem>): List<MediaItem> {
            val playlist = mutableListOf<MediaItem>()
            mediaItems.forEach { mediaItem ->
                if (mediaItem.mediaId.isNotEmpty()) {
                    BrowseTree.expandItem(mediaItem)?.let { playlist.add(it) }
                } else if (mediaItem.requestMetadata.searchQuery != null) {
                    playlist.addAll(BrowseTree.search(mediaItem.requestMetadata.searchQuery!!))
                }
            }
            return playlist
        }

        @OptIn(UnstableApi::class) // MediaSession.MediaItemsWithStartPosition
        private fun maybeExpandSingleItemToPlaylist(
            mediaItem: MediaItem,
            startIndex: Int,
            startPositionMs: Long,
        ): MediaItemsWithStartPosition? {
            var playlist = listOf<MediaItem>()
            var indexInPlaylist = startIndex
            BrowseTree.getItem(mediaItem.mediaId)?.apply {
                if (mediaMetadata.isBrowsable == true) {
                    // Get children browsable item.
                    playlist = BrowseTree.getChildren(mediaId)
                } else if (requestMetadata.searchQuery == null) {
                    // Try to get the parent and its children.
                    BrowseTree.getParentId(mediaId)?.let {
                        playlist =
                            BrowseTree.getChildren(it).map { mediaItem ->
                                if (mediaItem.mediaId == mediaId) BrowseTree.expandItem(mediaItem)!! else mediaItem
                            }
                        indexInPlaylist = BrowseTree.getIndexInMediaItems(mediaId, playlist)
                    }
                }
            }
            if (playlist.isNotEmpty()) {
                return MediaItemsWithStartPosition(playlist, indexInPlaylist, startPositionMs)
            }
            return null
        }
    }

    /** Listen for events from ExoPlayer. */
    private inner class PlayerEventListener : Player.Listener {

        override fun onEvents(player: Player, events: Player.Events) {
            if (events.contains(EVENT_POSITION_DISCONTINUITY) || events.contains(
                    EVENT_MEDIA_ITEM_TRANSITION
                ) || events.contains(EVENT_PLAY_WHEN_READY_CHANGED)
            ) {
                currentMediaItemIndex = player.currentMediaItemIndex
//                saveRecentSongToStorage()
            }
        }

        override fun onPlayerError(error: PlaybackException) {
            var message = R.string.generic_error
            Log.e(
                TAG, "Player error: " + error.errorCodeName + " (" + error.errorCode + ")", error
            )
            if (error.errorCode == PlaybackException.ERROR_CODE_IO_BAD_HTTP_STATUS || error.errorCode == PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND) {
                message = R.string.error_media_not_found
            }
            Toast.makeText(
                applicationContext, message, Toast.LENGTH_LONG
            ).show()
        }
    }
}

/** Content styling constants */
private const val CONTENT_STYLE_BROWSABLE_HINT = "android.media.browse.CONTENT_STYLE_BROWSABLE_HINT"
private const val CONTENT_STYLE_PLAYABLE_HINT = "android.media.browse.CONTENT_STYLE_PLAYABLE_HINT"
const val CONTENT_STYLE_SUPPORTED = "android.media.browse.CONTENT_STYLE_SUPPORTED"
private const val CONTENT_STYLE_LIST = 1
private const val CONTENT_STYLE_GRID = 2

const val ACTION_TOGGLE_SPATIALIZATION = "com.example.android.uamp.ACTION_TOGGLE_SPATIALIZATION"
const val EXTRAS_TOGGLE_SPATIALIZATION = "com.example.android.uamp.EXTRAS_TOGGLE_SPATIALIZATION"

const val MEDIA_DESCRIPTION_EXTRAS_START_PLAYBACK_POSITION_MS = "playback_start_position_ms"

private const val TAG = "MusicService"


const val UAMP_BROWSABLE_ROOT = "/"
const val UAMP_EMPTY_ROOT = "@empty@"
const val UAMP_RECOMMENDED_ROOT = "__RECOMMENDED__"
const val UAMP_ALBUMS_ROOT = "__ALBUMS__"
const val UAMP_RECENT_ROOT = "__RECENT__"

const val MEDIA_SEARCH_SUPPORTED = "android.media.browse.SEARCH_SUPPORTED"

const val RESOURCE_ROOT_URI = "android.resource://com.example.android.uamp.next/drawable/"