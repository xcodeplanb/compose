/*
 * Copyright 2019 Google Inc. All rights reserved.
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

package com.makeshop.podbbang.shared.media.library

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaDescriptionCompat
import android.util.Log
import androidx.media.utils.MediaConstants
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import com.makeshop.podbbang.shared.R
import com.makeshop.podbbang.shared.media.MusicService
import com.makeshop.podbbang.shared.media.library.MusicSource
import com.makeshop.podbbang.shared.media.extensions.urlEncoded
import com.makeshop.podbbang.shared.util.LineLog
import java.util.ArrayList

/**
 * Represents a tree of media that's used by [MusicService.onLoadChildren].
 *
 * [BrowseTree] maps a media id (see: [MediaMetadataCompat.METADATA_KEY_MEDIA_ID]) to one (or
 * more) [MediaMetadataCompat] objects, which are children of that media id.
 *
 * For example, given the following conceptual tree:
 * root
 *  +-- Albums
 *  |    +-- Album_A
 *  |    |    +-- Song_1
 *  |    |    +-- Song_2
 *  ...
 *  +-- Artists
 *  ...
 *
 *  Requesting `browseTree["root"]` would return a list that included "Albums", "Artists", and
 *  any other direct children. Taking the media ID of "Albums" ("Albums" in this example),
 *  `browseTree["Albums"]` would return a single item list "Album_A", and, finally,
 *  `browseTree["Album_A"]` would return "Song_1" and "Song_2". Since those are leaf nodes,
 *  requesting `browseTree["Song_1"]` would return null (there aren't any children of it).
 */
class BrowseTree(
    val context: Context,
    val musicSource: MusicSource?,
    val recentMediaId: String? = null
) {
    private val mediaIdToChildren = mutableMapOf<String, MutableList<MediaItem>>()
    private val mediaIdToMediaItem = mutableMapOf<String, MediaItem>()

    /**
     * Whether to allow clients which are unknown (not on the allowed list) to use search on this
     * [BrowseTree].
     */
    val searchableByUnknownCaller = true

    /**
     * In this example, there's a single root node (identified by the constant
     * [UAMP_BROWSABLE_ROOT]). The root's children are each album included in the
     * [MusicSource], and the children of each album are the songs on that album.
     * (See [BrowseTree.buildAlbumRoot] for more details.)
     *
     * TODO: Expand to allow more browsing types.
     */
    init {
        if(musicSource != null) {
            val rootList = mediaIdToChildren[BROWSABLE_ROOT] ?: mutableListOf()
            val homeCategory = MediaMetadata.Builder().apply {
                setTitle(context.getString(R.string.root_tab_home))
                setArtworkUri(
                    Uri.parse(
                        RESOURCE_ROOT_URI +
                                context.resources.getResourceEntryName(R.drawable.ic_auto_home)
                    )
                )
                setIsPlayable(false)
                setIsBrowsable(true)
            }.build()

            rootList += MediaItem.Builder().apply {
                setMediaId(ROOT_HOME)
                setMediaMetadata(homeCategory)
            }.build()

            val historyCategory = MediaMetadata.Builder().apply {
                setTitle(context.getString(R.string.root_tab_history))
                setArtworkUri(
                    Uri.parse(
                        RESOURCE_ROOT_URI +
                                context.resources.getResourceEntryName(R.drawable.ic_auto_history)
                    )
                )
                setIsPlayable(false)
                setIsBrowsable(true)
            }.build()

            rootList += MediaItem.Builder().apply {
                setMediaId(ROOT_HISTORY)
                setMediaMetadata(historyCategory)
            }.build()

            val etcCategory = MediaMetadata.Builder().apply {
                setTitle(context.getString(R.string.root_tab_more))
                setArtworkUri(
                    Uri.parse(
                        RESOURCE_ROOT_URI +
                                context.resources.getResourceEntryName(R.drawable.ic_auto_etc)
                    )
                )
                setIsPlayable(false)
                setIsBrowsable(true)
            }.build()

            rootList += MediaItem.Builder().apply {
                setMediaId(ROOT_MORE)
                setMediaMetadata(etcCategory)
            }.build()

            mediaIdToChildren[BROWSABLE_ROOT] = rootList

            val homeList = mediaIdToChildren[ROOT_HOME] ?: mutableListOf()
            val liveCategory = MediaMetadata.Builder().apply {
                setTitle(context.getString(R.string.home_list_live))
                setArtworkUri(
                    Uri.parse(
                        RESOURCE_ROOT_URI +
                                context.resources.getResourceEntryName(R.drawable.ic_auto_live)
                    )
                )
                setIsPlayable(false)
                setIsBrowsable(true)
            }.build()

            homeList += MediaItem.Builder().apply {
                setMediaId(HOME_LIVE)
                setMediaMetadata(liveCategory)
            }.build()

            val musicPodCategory = MediaMetadata.Builder().apply {
                setTitle(context.getString(R.string.home_list_musicpod))
                setArtworkUri(
                    Uri.parse(
                        RESOURCE_ROOT_URI +
                                context.resources.getResourceEntryName(R.drawable.ic_auto_musicpod)
                    )
                )
                setIsPlayable(false)
                setIsBrowsable(true)
            }.build()

            homeList += MediaItem.Builder().apply {
                setMediaId(HOME_MUSICPOD)
                setMediaMetadata(musicPodCategory)
            }.build()

            LineLog.e("BrowseTree homeList ${homeList}")

//            mediaIdToChildren[ROOT_HOME] = homeList


            musicSource.forEach { mediaItem ->
//            val albumMediaId = mediaItem.mediaMetadata.albumTitle.toString().urlEncoded
//            val albumChildren = mediaIdToChildren[albumMediaId] ?: buildAlbumRoot(mediaItem)
//            albumChildren += mediaItem
                // Add the first track of each album to the 'Recommended' category
                if (mediaItem.mediaMetadata.trackNumber == 1) {
                    LineLog.e("BrowseTree mediaItem.mediaMetadata " + mediaItem.mediaMetadata.title)
                    val recommendedChildren = mediaIdToChildren[ROOT_HOME] ?: mutableListOf()
                    recommendedChildren += mediaItem
                    mediaIdToChildren[ROOT_HOME] = recommendedChildren
                }
//
//            // If this was recently played, add it to the recent root.
//            if (mediaItem.mediaId == recentMediaId) {
//                mediaIdToChildren[UAMP_RECENT_ROOT] = mutableListOf(mediaItem)
//            }
//            mediaIdToMediaItem[mediaItem.mediaId] = mediaItem
                mediaIdToMediaItem[mediaItem.mediaId] = mediaItem
            }

//            musicSource.forEach { mediaItem ->
//                val musicPodChildren = mediaIdToChildren[HOME_MUSICPOD] ?: mutableListOf()
//                musicPodChildren += mediaItem
//                mediaIdToChildren[HOME_MUSICPOD] = musicPodChildren
//                mediaIdToMediaItem[mediaItem.mediaId] = mediaItem
//            }

            mediaIdToChildren[BROWSABLE_ROOT]?.forEach {
                LineLog.e("BrowseTree mediaIdToChildren[BROWSABLE_ROOT] ${it.mediaMetadata.title}")
            }

            mediaIdToChildren[ROOT_HOME]?.forEach {
                LineLog.e("BrowseTree mediaIdToChildren[ROOT_HOME] ${it.mediaMetadata.title}")
            }

            LineLog.e("BrowseTree ${mediaIdToChildren.size}")
//            LineLog.e("BrowseTree ${mediaIdToMediaItem.size}")
        }
    }

    /**
     * Provides access to the list of children with the `get` operator.
     * i.e.: `browseTree\[UAMP_BROWSABLE_ROOT\]`
     */
    operator fun get(mediaId: String) = mediaIdToChildren[mediaId]

    /** Provides access to the media items by media id. */
    fun getMediaItemByMediaId(mediaId: String) = mediaIdToMediaItem[mediaId]

    /**
     * Builds a node, under the root, that represents an album, given
     * a [MediaItem] object that's one of the songs on that album,
     * marking the item as [MediaMetadata.FOLDER_TYPE_ALBUMS], since it will have child
     * node(s) AKA at least 1 song.
     */
    private fun buildAlbumRoot(mediaItem: MediaItem): MutableList<MediaItem> {
        // Get or create the albums Category list.
        val rootList = mediaIdToChildren[HOME_MUSICPOD] ?: mutableListOf()
        // Create the album and add it to the 'Albums' category.
        val albumMetadata = mediaItem.mediaMetadata.buildUpon().apply {
            setFolderType(MediaMetadata.FOLDER_TYPE_ALBUMS)
            setIsPlayable(false)
        }.build()
        val albumMediaItem = mediaItem.buildUpon().apply {
            setMediaId(albumMetadata.albumTitle.toString().urlEncoded)
            setMediaMetadata(albumMetadata)
        }.build()
        rootList += albumMediaItem
        // Set the album root list for look up later,
        mediaIdToChildren[HOME_MUSICPOD] = rootList
        // Insert the album's root with an empty list for its children, and return the list.
        return mutableListOf<MediaItem>().also {
            mediaIdToChildren[albumMediaItem.mediaId] = it
        }
    }

    /**
     * 홈메뉴
     */
//    fun getHomeList(context: Context): ArrayList<MediaBrowserCompat.MediaItem> {
//        val homeList = mediaIdToChildren[ROOT_HOME] ?: mutableListOf()
//
//        val liveCategory = MediaMetadata.Builder().apply {
//            setTitle(context.getString(R.string.home_list_live))
//            setArtworkUri(
//                Uri.parse(
//                    RESOURCE_ROOT_URI +
//                            context.resources.getResourceEntryName(R.drawable.ic_auto_live)
//                )
//            )
//
//            setFolderType(MediaMetadata.FOLDER_TYPE_MIXED)
//            setIsPlayable(false)
//        }.build()
//        homeList += MediaItem.Builder().apply {
//            setMediaId(HOME_LIVE)
//            setMediaMetadata(liveCategory)
//        }.build()
//
//        val musicPodCategory = MediaMetadata.Builder().apply {
//            setTitle(context.getString(R.string.home_list_musicpod))
//            setArtworkUri(
//                Uri.parse(
//                    RESOURCE_ROOT_URI +
//                            context.resources.getResourceEntryName(R.drawable.ic_auto_musicpod)
//                )
//            )
//
//            setIsPlayable(false)
//            setFolderType(MediaMetadata.FOLDER_TYPE_ALBUMS)
//        }.build()
//        homeList += MediaItem.Builder().apply {
//            setMediaId(HOME_MUSICPOD)
//            setMediaMetadata(musicPodCategory)
//        }.build()
//
//        mediaIdToChildren[ROOT_HOME] = homeList
//
//        return mediaIdToChildren
//    }
}

const val BROWSABLE_ROOT = "/"
const val UAMP_EMPTY_ROOT = "@empty@"
const val ROOT_HOME = "__HOME__"
const val ROOT_HISTORY = "__HISTORY__"
const val ROOT_MORE = "__MORE__"
const val HOME_LIVE = "__LIVE__"
const val HOME_MUSICPOD = "__MUSICPOD__"
const val MEDIA_SEARCH_SUPPORTED = "android.media.browse.SEARCH_SUPPORTED"

const val RESOURCE_ROOT_URI = "android.resource://com.makeshop.podbbang/drawable/"