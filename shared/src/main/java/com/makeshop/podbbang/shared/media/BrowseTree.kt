package com.makeshop.podbbang.shared.media

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.annotation.OptIn
import androidx.core.net.toUri
import androidx.media.utils.MediaConstants
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaItem.SubtitleConfiguration
import androidx.media3.common.MediaMetadata
import androidx.media3.common.util.UnstableApi
import com.google.common.collect.ImmutableList
import com.makeshop.podbbang.shared.R
import com.makeshop.podbbang.shared.api.Resource
import com.makeshop.podbbang.shared.media.MediaItemTree.MediaItemNode
import com.makeshop.podbbang.shared.media.MediaItemTree.ROOT_ID
import com.makeshop.podbbang.shared.repository.AndroidAutoRepository
import com.makeshop.podbbang.shared.repository.EpisodeRepository
import com.makeshop.podbbang.shared.util.LineLog
import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

/**
 * 차량용 Android Auto
 */

object BrowseTree {
    val BROWSABLE_ROOT = "/"
    val ROOT_HOME = "__HOME__"
    val ROOT_HISTORY = "__HISTORY__"
    val ROOT_DOWNLOAD = "__DOWNLOAD__"
    val ROOT_BUY_EPISODE = "__BUYEPISODE__"
    val ROOT_MUSICPOD = "__MUSICPOD__"
    val ROOT_LIVE_ONAIR = "__LIVEONAIR__"
    val ROOT_SUBSCRIPTION = "__SUBSCRIPTION__"
    val ROOT_RECOMMEND = "__RECOMMEND__"
    val ROOT_MORE = "__MORE__"
    val MORE_RECOMMEND = "__MORE__/__RECOMMEND__"
    val BROWSABLE_CHANNEL = "__BROWSABLE_CHANNEL__"
    val ERROR_LIVE = "__ERROR_LIVE__"
    val NEED_LOGIN = "__NEED_LOGIN__"

    val ACTION_PREV_SEC = "ACTION_PREV_SEC"
    val ACTION_NEXT_SEC = "ACTION_NEXT_SEC"

    val ACTION_CLOSE = "ACTION_CLOSE"
    val ACTION_PLAY = "ACTION_PLAY"
    val ACTION_PAUSE = "ACTION_PAUSE"

    val ACTION_SPEED = "ACTION_SPEED"
    val ACTION_LIST = "ACTION_LIST"
    val KEY_JUMP = "KEY_JUMP"
    val KEY_SPEED = "KEY_SPEED"
    const val RESOURCE_ROOT_URI = "android.resource://com.makeshop.podbbang/drawable/"

    var treeNodes: MutableMap<String, MediaItemNode> = mutableMapOf()
    var titleMap: MutableMap<String, MediaItemNode> = mutableMapOf()

    fun init(context: Context, serviceScope: CoroutineScope, androidAutoRepository: AndroidAutoRepository) {
        setRootList(context, serviceScope, androidAutoRepository)
    }

    /**
     * 루트 메뉴 구성
     */
    private fun setRootList(
        context: Context,
        serviceScope: CoroutineScope,
        androidAutoRepository: AndroidAutoRepository
    ) {
        treeNodes[BROWSABLE_ROOT] = MediaItemNode(
            buildMediaItem(
                title = "/",
                mediaId = BROWSABLE_ROOT,
                isPlayable = false,
                isBrowsable = true,
                mediaType = MediaMetadata.MEDIA_TYPE_FOLDER_MIXED

            )
        )

        treeNodes[ROOT_HOME] = MediaItemNode(
            buildMediaItem(
                title = "홈",
                mediaId = ROOT_HOME,
                isPlayable = false,
                isBrowsable = true,
                mediaType = MediaMetadata.MEDIA_TYPE_FOLDER_MIXED,
                imageUri = Uri.parse(
                    RESOURCE_ROOT_URI +
                            context.resources.getResourceEntryName(R.drawable.auto_home)
                )
            )
        )

        treeNodes[ROOT_HISTORY] = MediaItemNode(
            buildMediaItem(
                title = "최근 청취",
                mediaId = ROOT_HISTORY,
                isPlayable = false,
                isBrowsable = true,
                mediaType = MediaMetadata.MEDIA_TYPE_FOLDER_MIXED,
                imageUri = Uri.parse(
                    RESOURCE_ROOT_URI +
                            context.resources.getResourceEntryName(R.drawable.auto_history)
                )
            )
        )

        treeNodes[ROOT_MORE] = MediaItemNode(
            buildMediaItem(
                title = "보관함",
                mediaId = ROOT_MORE,
                isPlayable = false,
                isBrowsable = true,
                mediaType = MediaMetadata.MEDIA_TYPE_FOLDER_MIXED,
                imageUri = Uri.parse(
                    RESOURCE_ROOT_URI +
                            context.resources.getResourceEntryName(R.drawable.auto_etc)
                )
            )
        )

        treeNodes[BROWSABLE_ROOT]!!.addChild(ROOT_HOME)
        treeNodes[BROWSABLE_ROOT]!!.addChild(ROOT_HISTORY)
        treeNodes[BROWSABLE_ROOT]!!.addChild(ROOT_MORE)

        LineLog.e("AutomotiveMusicService treeNodes ${treeNodes.values}")

        setHomeList(context, serviceScope, androidAutoRepository)
    }

    fun setHomeList(
        context: Context,
        serviceScope: CoroutineScope,
        androidAutoRepository: AndroidAutoRepository
    ) {
        treeNodes[ROOT_LIVE_ONAIR] = MediaItemNode(
            buildMediaItem(
                title = "라이브",
                mediaId = ROOT_LIVE_ONAIR,
                isPlayable = false,
                isBrowsable = true,
                mediaType = MediaMetadata.MEDIA_TYPE_FOLDER_MIXED,
                imageUri = Uri.parse(
                    RESOURCE_ROOT_URI +
                            context.resources.getResourceEntryName(R.drawable.auto_live)
                )
            )
        )

        treeNodes[ROOT_MUSICPOD] = MediaItemNode(
            buildMediaItem(
                title = "뮤직팟",
                mediaId = ROOT_MUSICPOD,
                isPlayable = false,
                isBrowsable = true,
                mediaType = MediaMetadata.MEDIA_TYPE_FOLDER_MIXED,
                imageUri = Uri.parse(
                    RESOURCE_ROOT_URI +
                            context.resources.getResourceEntryName(R.drawable.auto_musicpod)
                )
            )
        )

        treeNodes[ROOT_RECOMMEND] = MediaItemNode(
            buildMediaItem(
                title = "추천 에피소드",
                mediaId = ROOT_RECOMMEND,
                isPlayable = false,
                isBrowsable = true,
                mediaType = MediaMetadata.MEDIA_TYPE_FOLDER_MIXED,
                imageUri = Uri.parse(
                    RESOURCE_ROOT_URI +
                            context.resources.getResourceEntryName(R.drawable.auto_episode)
                )
            )
        )

        treeNodes[ROOT_HOME]!!.addChild(ROOT_LIVE_ONAIR)
        treeNodes[ROOT_HOME]!!.addChild(ROOT_MUSICPOD)
        treeNodes[ROOT_HOME]!!.addChild(ROOT_RECOMMEND)

        LineLog.e("AutomotiveMusicService treeNodes ${treeNodes.values}")

        setRecommendList(context, serviceScope, androidAutoRepository)

    }

    fun setRecommendList(
        context: Context,
        serviceJob: CoroutineScope,
        androidAutoRepository: AndroidAutoRepository
    ) {
        serviceJob.launch {
            val response =
                androidAutoRepository.recommendCastList("https://enterprise.podbbang.com/carplay/recommend")

            if (response is Resource.Success) {
                response.value.forEach { item ->
                    val id = item.podbbangUid.toString()
                    treeNodes[id] = MediaItemNode(
                        buildMediaItem(
                            title = (item.episodeTitle ?: ""),
                            mediaId = (item.podbbangUid ?: ""),
                            isPlayable = true,
                            isBrowsable = false,
                            mediaType = MediaMetadata.MEDIA_TYPE_MUSIC,
                            sourceUri = item.playurl?.toUri(),
                            imageUri = item.image?.toUri()
                        )
                    )

                    LineLog.d("BrowseTree ${item.image?.toUri()}")
                    LineLog.d("BrowseTree ${item.playurl?.toUri()}")
                    treeNodes[ROOT_RECOMMEND]!!.addChild(id)
                }
            }
        }
    }

    fun setHistoryList(
        context: Context,
        serviceScope: CoroutineScope,
        episodeRepository: EpisodeRepository
    ) {
        serviceScope.launch {
            val response = episodeRepository.episodeList("1784142", 0, 10, "desc")
            if (response is Resource.Success) {
                LineLog.d("response$ ${response.value}")
            } else {
                LineLog.d("response$ ${response.toString()}")
            }
        }
    }

    class MediaItemNode(val item: MediaItem) {
        val searchTitle = normalizeSearchText(item.mediaMetadata.title)
        val searchText = StringBuilder().append(searchTitle).append(" ")
            .append(normalizeSearchText(item.mediaMetadata.subtitle)).append(" ")
            .append(normalizeSearchText(item.mediaMetadata.artist)).append(" ")
            .append(normalizeSearchText(item.mediaMetadata.albumArtist)).append(" ")
            .append(normalizeSearchText(item.mediaMetadata.albumTitle)).toString()

        private val children: MutableList<MediaItem> = ArrayList()

        fun addChild(childID: String) {
            this.children.add(treeNodes[childID]!!.item)
        }

        fun getChildren(): List<MediaItem> {
            return ImmutableList.copyOf(children)
        }
    }

    fun buildMediaItem(
        title: String,
        mediaId: String,
        isPlayable: Boolean,
        isBrowsable: Boolean,
        mediaType: @MediaMetadata.MediaType Int,
        subtitleConfigurations: List<SubtitleConfiguration> = mutableListOf(),
        album: String? = null,
        artist: String? = null,
        genre: String? = null,
        sourceUri: Uri? = null,
        imageUri: Uri? = null,
        extras: Bundle? = null
    ): MediaItem {
        val metadata =
            MediaMetadata.Builder().setAlbumTitle(album).setTitle(title).setArtist(artist)
                .setGenre(genre).setIsBrowsable(isBrowsable).setIsPlayable(isPlayable)
                .setArtworkUri(imageUri).setMediaType(mediaType).setExtras(extras).build()

        return MediaItem.Builder().setMediaId(mediaId)
            .setSubtitleConfigurations(subtitleConfigurations).setMediaMetadata(metadata)
            .setUri(sourceUri).build()
    }

    fun getItem(id: String): MediaItem? {
        return treeNodes[id]?.item
    }

    fun expandItem(item: MediaItem): MediaItem? {
        val treeItem = getItem(item.mediaId) ?: return null

        @OptIn(UnstableApi::class) // MediaMetadata.populate
        val metadata = treeItem.mediaMetadata.buildUpon().populate(item.mediaMetadata).build()
        return item.buildUpon().setMediaMetadata(metadata).setSubtitleConfigurations(
            treeItem.localConfiguration?.subtitleConfigurations ?: listOf()
        ).setUri(treeItem.localConfiguration?.uri).build()
    }

    /**
     * Returns the media ID of the parent of the given media ID, or null if the media ID wasn't found.
     *
     * @param mediaId The media ID of which to search the parent.
     * @Param parentId The media ID of the media item to start the search from, or undefined to search
     *   from the top most node.
     */
    fun getParentId(mediaId: String, parentId: String = ROOT_ID): String? {
        for (child in treeNodes[parentId]!!.getChildren()) {
            if (child.mediaId == mediaId) {
                return parentId
            } else if (child.mediaMetadata.isBrowsable == true) {
                val nextParentId = getParentId(mediaId, child.mediaId)
                if (nextParentId != null) {
                    return nextParentId
                }
            }
        }
        return null
    }

    /**
     * Returns the index of the [MediaItem] with the give media ID in the given list of items. If the
     * media ID wasn't found, 0 (zero) is returned.
     */
    fun getIndexInMediaItems(mediaId: String, mediaItems: List<MediaItem>): Int {
        for ((index, child) in mediaItems.withIndex()) {
            if (child.mediaId == mediaId) {
                return index
            }
        }
        return 0
    }

    /**
     * Tokenizes the query into a list of words with at least two letters and searches in the search
     * text of the [MediaItemNode].
     */
    fun search(query: String): List<MediaItem> {
        val matches: MutableList<MediaItem> = mutableListOf()
        val titleMatches: MutableList<MediaItem> = mutableListOf()
        val words = query.split(" ").map { it.trim().lowercase() }.filter { it.length > 1 }
        titleMap.keys.forEach { title ->
            val mediaItemNode = titleMap[title]!!
            for (word in words) {
                if (mediaItemNode.searchText.contains(word)) {
                    if (mediaItemNode.searchTitle.contains(query.lowercase())) {
                        titleMatches.add(mediaItemNode.item)
                    } else {
                        matches.add(mediaItemNode.item)
                    }
                    break
                }
            }
        }
        titleMatches.addAll(matches)
        return titleMatches
    }

    fun getRootItem(): MediaItem {
        return treeNodes[ROOT_ID]!!.item
    }

    fun getChildren(id: String): List<MediaItem> {
        return treeNodes[id]?.getChildren() ?: listOf()
    }

    fun normalizeSearchText(text: CharSequence?): String {
        if (text.isNullOrEmpty() || text.trim().length == 1) {
            return ""
        }
        return "$text".trim().lowercase()
    }
}