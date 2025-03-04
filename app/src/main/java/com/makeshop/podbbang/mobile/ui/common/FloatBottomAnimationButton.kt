package com.makeshop.podbbang.mobile.ui.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.makeshop.podbbang.shared.util.LineLog

@Composable
fun FloatBottomAnimationButton(paddingValues: PaddingValues) {
    val floatButtonState = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(paddingValues)
                .wrapContentSize()
        ) {
            AnimatedVisibility(
                visible = floatButtonState.value,
                enter = fadeIn(initialAlpha = 1f) + slideInVertically(initialOffsetY = { it * 2 }),
                exit = fadeOut(targetAlpha = 0f) + slideOutVertically(targetOffsetY = { it * 2 })
            ) {
                Row {
                    FloatingActionButton(modifier = Modifier.clip(CircleShape), onClick = {
                        LineLog.d("onClick = ")
                    }) {
                        Icon(
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable {},
                            imageVector = Icons.Default.Build,
                            contentDescription = "Build",
                            tint = Color.Unspecified
                        )
                    }
                    Spacer(Modifier.width(5.dp))
                    Text(text = "1번플로팅메뉴", modifier = Modifier.align(Alignment.CenterVertically))
                }
            }

            Spacer(modifier = Modifier.height(5.dp))

            AnimatedVisibility(
                visible = floatButtonState.value,
                enter = fadeIn(initialAlpha = 1f) + slideInVertically(initialOffsetY = { it }),
                exit = fadeOut(targetAlpha = 0f) + slideOutVertically(targetOffsetY = { it })
            ) {
                Row {
                    FloatingActionButton(modifier = Modifier.clip(CircleShape), onClick = {
                        LineLog.d("onClick = ")

                    }) {
                        Icon(
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable {

                                },
                            imageVector = Icons.Default.Face,
                            contentDescription = "Face",
                            tint = Color.Unspecified
                        )
                    }
                    Spacer(Modifier.width(5.dp))
                    Text(text = "2번플로팅메뉴", modifier = Modifier.align(Alignment.CenterVertically))
                }
            }

            Spacer(modifier = Modifier.height(5.dp))

            FloatingActionButton(modifier = Modifier.clip(CircleShape), onClick = {
                LineLog.d("onClick = ")
            }) {
                Icon(
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            floatButtonState.value = floatButtonState.value.not()
                        },
                    imageVector = Icons.Default.Add,
                    contentDescription = "재생",
                    tint = Color.Unspecified
                )
            }
        }
    }
}


