/*
 * Copyright 2022 Google Inc. All rights reserved.
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

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.motion.utils.StopLogic
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.makeshop.podbbang.mobile.HomeDestinations
import com.makeshop.podbbang.mobile.MainActivityViewModel
import com.makeshop.podbbang.mobile.MediaDestinations
import com.makeshop.podbbang.mobile.R
import com.makeshop.podbbang.shared.data.MediaItemData
import com.makeshop.podbbang.mobile.ui.home.HomeBottomNavLayout
import com.makeshop.podbbang.mobile.ui.home.HomeTabs
import com.makeshop.podbbang.shared.util.LineLog
import dagger.hilt.android.EntryPointAccessors

/**
 * This particular instance of MediaItemDescription serves as the function which keeps track of the
 * media items state and recomposes the UI upon any changes
 *
 * @param mediaItemFragmentViewModel to reference MediaItemFragmentViewModel functions
 * @param mainActivityViewModel to reference MainActivityViewModel functions
 */
@Composable
fun MediaItemScreen(
    mediaId: String,
    mainActivityViewModel: MainActivityViewModel,
    navigateTo: (route: String) -> Unit
) {
    val factory = EntryPointAccessors.fromActivity(
        LocalContext.current as Activity,
        ViewModelFactoryProvider::class.java
    ).placeMediaItemFragmentViewModel()

    val mediaItemFragmentViewModel: MediaItemFragmentViewModel = viewModel(
        factory = MediaItemFragmentViewModel.provideFactory(factory, mediaId ?: "/")
    )
    val currentMediaItems by mediaItemFragmentViewModel.mediaItems.observeAsState()
    currentMediaItems?.let { mediaItems ->
        MediaItemDescription(navigateTo, mediaItems, mainActivityViewModel)
    }
}

/**
 * This particular instance of MediaItemDescription displays the mediaItems in a vertical list
 * scroll format
 */
@Composable
private fun MediaItemDescription(
    navigateTo: (route: String) -> Unit,
    mediaItems: List<MediaItemData> = emptyList(),
    mainActivityViewModel: MainActivityViewModel
) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "MediaItemScreen") },
        )
    }, bottomBar = {
        HomeBottomNavLayout(
            tabs = HomeTabs.entries.toTypedArray(),
            currentRoute = HomeTabs.MEDIA.route,
            navigateTo = navigateTo
        )
    })
    {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (mediaItems.isEmpty()) {
                Text(stringResource(R.string.media_items_empty))
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    for (mediaItem in mediaItems) {
                        item {
                            MediaItem(navigateTo, mediaItem, mainActivityViewModel)
                        }
                    }
                }
            }
        }
    }
}

/**
 * This function describes the UI of a mediaItem instance
 *
 * @param mediaItemData to reference details of a mediaItem in the current branch
 * @param mainActivityViewModel to reference MainActivityViewModel functions
 */
@Composable
private fun MediaItem(navigateTo: (route: String) -> Unit,
                      mediaItemData: MediaItemData,
                      mainActivityViewModel: MainActivityViewModel) {
    val mediaItemArtDimen = dimensionResource(R.dimen.media_item_art)
    val imageModel = mediaItemData.mediaItem.mediaMetadata.artworkUri
    val mediaItemTitle = mediaItemData.mediaItem.mediaMetadata.title

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                LineLog.e("MediaItemScreen 1")
                mainActivityViewModel.mediaItemClicked(mediaItemData)
                navigateTo(MediaDestinations.MEDIADETAIL)
//                mainActivityViewModel.mediaItemClicked(mediaItemData)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = imageModel,
            contentDescription = null,
            modifier = Modifier
                .width(mediaItemArtDimen)
                .height(mediaItemArtDimen),
            placeholder = painterResource(id = com.makeshop.podbbang.shared.R.drawable.default_art),
            error = painterResource(id = com.makeshop.podbbang.shared.R.drawable.default_art)
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = mediaItemTitle.toString(), modifier = Modifier
                    .padding(horizontal = dimensionResource(id = R.dimen.text_margin))
                    .fillMaxWidth(),
                style = MaterialTheme.typography.h6
            )
            Text(
                text = "", modifier = Modifier
                    .padding(horizontal = dimensionResource(id = R.dimen.text_margin))
                    .fillMaxWidth(),
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}