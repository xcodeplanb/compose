package com.makeshop.podbbang.mobile.ui.common

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.makeshop.podbbang.mobile.PlayModalBottomUiState
import com.makeshop.podbbang.mobile.R
import com.makeshop.podbbang.mobile.ui.theme.AppTheme
import com.makeshop.podbbang.mobile.ui.theme.Color000000
import com.makeshop.podbbang.mobile.ui.theme.normalFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerModalBottomSheet(
    playModalBottomUiState: MutableState<PlayModalBottomUiState>,
    isOpen: (Boolean) -> Unit
) {
    val skipPartiallyExpanded by rememberSaveable { mutableStateOf(true) }
    val bottomSheetState =
        rememberModalBottomSheetState(skipPartiallyExpanded = skipPartiallyExpanded)

    ModalBottomSheet(
        onDismissRequest = { isOpen(false) },
        sheetState = bottomSheetState,
    ) {
        Content(playModalBottomUiState)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Content(playModalBottomUiState: MutableState<PlayModalBottomUiState>) {
//    val selected  = playModalBottomUiState.value.isPlay
    val drawableResource =
        if (playModalBottomUiState.value.isPlay) R.drawable.ic_player_modal_bottom_play_enable else R.drawable.ic_player_modal_bottom_pause_enable

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        MiddleOptionMenu()
        SliderWithCustomTrackAndThumb(playModalBottomUiState)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .height(85.dp)
                .background(color = Color.Gray)
        ) {
            Icon(
                modifier = Modifier
                    .width(17.dp)
                    .height(26.dp)
                    .clickable {

                    },
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_player_modal_bottom_prev_enable),
                contentDescription = "이전",
                tint = Color.Unspecified
            )
            Icon(
                modifier = Modifier
                    .wrapContentSize()
                    .clickable {
                    },
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_player_modal_bottom_prev_seconds_enable),
                contentDescription = "되감기",
                tint = Color.Unspecified
            )
            Icon(
                modifier = Modifier
                    .wrapContentSize()
                    .clickable {
                        playModalBottomUiState.value =
                            playModalBottomUiState.value.copy(isPlay = !playModalBottomUiState.value.isPlay)
                    },
                imageVector = ImageVector.vectorResource(id = drawableResource),
                contentDescription = "재생",
                tint = Color.Unspecified
            )
            Icon(
                modifier = Modifier
                    .wrapContentSize()
                    .clickable {
                    },
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_player_modal_bottom_next_seconds_enable),
                contentDescription = "앞으로가기",
                tint = Color.Unspecified
            )
            Icon(
                modifier = Modifier
                    .width(17.dp)
                    .height(26.dp)
                    .clickable {

                    },
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_player_modal_bottom_next_enable),
                contentDescription = "다음",
                tint = Color.Unspecified
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MiddleOptionMenu() {
    FlowRow(
        modifier = Modifier.background(Color.Transparent),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Column(
            modifier = Modifier
                .width(45.dp)
                .height(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier
                    .wrapContentSize()
                    .clickable {

                    },
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_player_modal_bottom_support),
                contentDescription = "후원",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier
                    .wrapContentSize(),
                text = "후원", style = normalFont, fontSize = 9.sp, color = Color000000
            )
        }
        Column(
            modifier = Modifier
                .width(45.dp)
                .height(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier
                    .wrapContentSize()
                    .clickable {

                    },
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_player_modal_bottom_like),
                contentDescription = "좋아요",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier
                    .wrapContentSize(),
                text = "2", style = normalFont, fontSize = 9.sp, color = Color000000
            )
        }
        Column(
            modifier = Modifier
                .width(45.dp)
                .height(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier
                    .wrapContentSize()
                    .clickable {

                    },
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_player_modal_bottom_reply),
                contentDescription = "댓글",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier
                    .wrapContentSize(),
                text = "댓글", style = normalFont, fontSize = 9.sp, color = Color000000
            )
        }
        Column(
            modifier = Modifier
                .width(45.dp)
                .height(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier
                    .wrapContentSize()
                    .clickable {

                    },
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_player_modal_bottom_report),
                contentDescription = "신고",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier
                    .wrapContentSize(),
                text = "신고", style = normalFont, fontSize = 9.sp, color = Color000000
            )
        }
        Column(
            modifier = Modifier
                .width(45.dp)
                .height(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier
                    .wrapContentSize()
                    .clickable {

                    },
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_player_modal_bottom_download),
                contentDescription = "다운로드",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier
                    .wrapContentSize(),
                text = "다운로드", style = normalFont, fontSize = 9.sp, color = Color000000
            )
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@PreviewLightDark
@Composable
fun ContentPreview() {
    val playModalBottomUiState: MutableState<PlayModalBottomUiState> =
        mutableStateOf(PlayModalBottomUiState(false))
    AppTheme {
        Content(playModalBottomUiState)
    }
}