/*
 * Copyright 2018 Google Inc. All rights reserved.
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

package com.makeshop.podbbang.mobile.ui.home.mediaplayer

import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.PlaybackStateCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import com.makeshop.podbbang.shared.data.MediaItemData
import com.makeshop.podbbang.shared.common.EMPTY_PLAYBACK_STATE
import com.makeshop.podbbang.shared.common.MusicServiceConnection
import com.makeshop.podbbang.shared.common.NOTHING_PLAYING
import com.makeshop.podbbang.shared.common.PlaybackState
import com.makeshop.podbbang.shared.util.LineLog
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * [ViewModel] for [MediaItemFragment].
 */
@EntryPoint
@InstallIn(ActivityComponent::class)
interface ViewModelFactoryProvider {
    fun placeMediaItemFragmentViewModel(): MediaItemFragmentViewModel.Factory
}

class MediaItemFragmentViewModel @AssistedInject constructor(
    @Assisted val mediaId: String, musicServiceConnection: MusicServiceConnection
) : ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(
            mediaId: String
        ): MediaItemFragmentViewModel
    }

    companion object {
        fun provideFactory(
            assistedFactory: Factory, mediaId: String
        ): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return assistedFactory.create(mediaId) as T
                }
            }
        }
    }


    /**
     * Use a backing property so consumers of mediaItems only get a [LiveData] instance so
     * they don't inadvertently modify it.
     */
    private val _mediaItems = MutableLiveData<List<MediaItemData>>()
    val mediaItems: LiveData<List<MediaItemData>> = _mediaItems

    /**
     * Pass the status of the [MusicServiceConnection.networkFailure] through.
     */

    /**
     * When the session's [PlaybackStateCompat] changes, the [mediaItems] need to be updated
     * so the correct [MediaItemData.playbackRes] is displayed on the active item.
     * (i.e.: play/pause button or blank)
     */
    private val playbackStateObserver = Observer<PlaybackState> {
        val playbackState = it ?: EMPTY_PLAYBACK_STATE
        val mediaItem = musicServiceConnection.nowPlaying.value ?: NOTHING_PLAYING
        if (mediaItem != MediaItem.EMPTY) {
            LineLog.e("playbackStateObserver ${mediaItem.mediaMetadata.title}")
            _mediaItems.postValue(updateState(playbackState, mediaItem))
        }
    }

    /**
     * When the session's [MediaMetadataCompat] changes, the [mediaItems] need to be updated
     * as it means the currently active item has changed. As a result, the new, and potentially
     * old item (if there was one), both need to have their [MediaItemData.playbackRes]
     * changed. (i.e.: play/pause button or blank)
     */
    private val nowPlayingObserver = Observer<MediaItem> {
        val playbackState = musicServiceConnection.playbackState.value ?: EMPTY_PLAYBACK_STATE
        val mediaItem = it ?: NOTHING_PLAYING
        if (mediaItem != MediaItem.EMPTY) {
            LineLog.e("nowPlayingObserver mediaItem ${mediaItem.mediaMetadata.title}")
            _mediaItems.postValue(updateState(playbackState, mediaItem))
        }
    }

    /**
     * Because there's a complex dance between this [ViewModel] and the [MusicServiceConnection]
     * (which is wrapping a [MediaBrowser] object), the usual guidance of using
     * [Transformations] doesn't quite work.
     *
     * Specifically there's three things that are watched that will cause the single piece of
     * [LiveData] exposed from this class to be updated.
     *
     * [MusicServiceConnection.playbackState] changes state based on the playback state of
     * the player, which can change the [MediaItemData.playbackRes]s in the list to possibly mark
     * the playing item in the list.
     *
     * [MusicServiceConnection.nowPlaying] changes based on the item that's being played,
     * which can also change the [MediaItemData.playbackRes]s in the list.
     */
    private val musicServiceConnection = musicServiceConnection.also {
        it.playbackState.observeForever(playbackStateObserver)
        it.nowPlaying.observeForever(nowPlayingObserver)
    }

    init {
        viewModelScope.launch {
            LineLog.d("MediaItem ")
            val mediaItemList = musicServiceConnection.getChildren(mediaId)
            val itemsList = mediaItemList.map { child ->
                MediaItemData(
                    child,
                    child.mediaMetadata.isPlayable == true,
                    getResourceForMediaId(child.mediaId),/* parentMediaId= */
                    child.mediaMetadata.title.toString(),
                    ""
                )
            }
            _mediaItems.postValue(itemsList)
        }
    }

    /**
     * Since we use [LiveData.observeForever] above (in [musicServiceConnection]), we want
     * to call [LiveData.removeObserver] here to prevent leaking resources when the [ViewModel]
     * is not longer in use.
     *
     * For more details, see the kdoc on [musicServiceConnection] above.
     */
    override fun onCleared() {
        super.onCleared()
        // Remove the permanent observers from the MusicServiceConnection.
        musicServiceConnection.playbackState.removeObserver(playbackStateObserver)
        musicServiceConnection.nowPlaying.removeObserver(nowPlayingObserver)
    }

    private fun getResourceForMediaId(mediaId: String): Int {
        val isActive = mediaId == musicServiceConnection.nowPlaying.value?.mediaId
        val isPlaying = musicServiceConnection.playbackState.value?.isPlaying ?: false
        return when {
            !isActive -> NO_RES
            isPlaying -> androidx.mediarouter.R.drawable.ic_media_pause_dark
            else -> androidx.media3.cast.R.drawable.ic_media_play_dark
        }
    }

    private fun updateState(
        playbackState: PlaybackState, nowPlaying: MediaItem
    ): List<MediaItemData> {

        val newResId = when (playbackState.isPlaying) {
            true -> androidx.mediarouter.R.drawable.ic_media_pause_dark
            else -> androidx.media3.cast.R.drawable.ic_media_play_dark
        }

        return mediaItems.value?.map {
            val useResId = if (it.mediaItem.mediaId == nowPlaying.mediaId) newResId else NO_RES
            it.copy(playbackRes = useResId)
        } ?: emptyList()
    }

//    class Factory(
//        private val mediaId: String,
//        private val musicServiceConnection: MusicServiceConnection
//    ) : ViewModelProvider.NewInstanceFactory() {
//
//        @Suppress("unchecked_cast")
//        override fun <T : ViewModel> create(modelClass: Class<T>): T {
//            return MediaItemFragmentViewModel(mediaId, musicServiceConnection) as T
//        }
//    }

//    class Factory(
//        private val mediaId: String,
//        private val musicServiceConnection: MusicServiceConnection
//    ) : ViewModelProvider.NewInstanceFactory() {
//
//        @Suppress("unchecked_cast")
//        override fun <T : ViewModel> create(modelClass: Class<T>): T {
//            return MediaItemFragmentViewModel(mediaId, musicServiceConnection) as T
//        }
//    }

}


private const val NO_RES = 0
