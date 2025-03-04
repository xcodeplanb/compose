package com.makeshop.podbbang.mobile.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.makeshop.podbbang.mobile.PlayModalBottomUiState
import com.makeshop.podbbang.mobile.ui.theme.Color1FA1EB
import com.makeshop.podbbang.mobile.ui.theme.ColorFFCCCCCC
import com.makeshop.podbbang.shared.util.LineLog

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SliderWithCustomTrackAndThumb(playModalBottomUiState: MutableState<PlayModalBottomUiState>) {
    val sliderState = remember {
        SliderState(value = playModalBottomUiState.value.playPosition,
            valueRange = 0f..100f,
            onValueChangeFinished = {
                playModalBottomUiState.value =
                    playModalBottomUiState.value.copy(playPosition = playModalBottomUiState.value.playPosition)
                LineLog.d("SliderState onValueChangeFinished ${playModalBottomUiState.value.playPosition}")
                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
            })
    }

    val interactionSource = remember { MutableInteractionSource() }
    val thumbColors =
        SliderDefaults.colors(thumbColor = Color1FA1EB, disabledThumbColor = Color1FA1EB)
    val trackColors =
        SliderDefaults.colors(inactiveTrackColor = ColorFFCCCCCC, activeTrackColor = Color1FA1EB)

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.background(color = Color.DarkGray).height(30.dp),
    ) {
//        Text(text = "test")
        Slider(
//            state = sliderState,
            valueRange = sliderState.valueRange,
            value = playModalBottomUiState.value.playPosition,
            onValueChange = {
                playModalBottomUiState.value = playModalBottomUiState.value.copy(playPosition = it)
            },
            modifier = Modifier.semantics { contentDescription = "Localized Description" },
            interactionSource = interactionSource,
            thumb = {
                SliderDefaults.Thumb(interactionSource = interactionSource, colors = thumbColors)
            },
            track = { sliderState ->
                SliderDefaults.Track(
                    colors = trackColors, sliderState = sliderState
                )
            })
    }
}