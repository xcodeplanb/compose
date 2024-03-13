package com.makeshop.podbbang.ui.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.makeshop.podbbang.theme.AppTheme

@Composable
fun AudioBookScreen(
    navigateTo: (route: String) -> Unit
) {
//    val uiState = viewModel.uiState.collectAsState().value
//    val navController = rememberNavController()
    AudioBookScreenContainer(navigateTo)
}

@Composable
fun AudioBookScreenContainer(navigateTo: (route: String) -> Unit) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "AudioBookScreen") },
        )
    }, bottomBar = {
        HomeBottomNavLayout(
            tabs = HomeTabs.entries.toTypedArray(),
            currentRoute = HomeTabs.AUDIOBOOK.route,
            navigateTo = navigateTo
        )
    }) {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
        }
    }
}
//
//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun AudioBookScreenPreview() {
//    val navigateTo: (String) -> Unit = {}
////    val navController = rememberNavController()
//
//    AppTheme {
//        RankingScreenContainer(navigateTo)
//    }
//}