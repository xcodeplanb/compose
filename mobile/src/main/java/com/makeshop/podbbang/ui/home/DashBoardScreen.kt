package com.makeshop.podbbang.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat.setLayerType
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.web.AccompanistWebViewClient
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberSaveableWebViewState
import com.google.accompanist.web.rememberWebViewNavigator
import com.makeshop.podbbang.theme.AppTheme
import com.makeshop.podbbang.util.LineLog

//@Composable
//fun DashBoardScreen(navigateTo: (route: String) -> Unit) {
////    val uiState = viewModel.uiState.collectAsState().value
////    val navController = rememberNavController
//    Log.d("TAG", "DashBoardScreen")
//    DashBoardScreenContainer(navigateTo)
//}

@Composable
fun DashBoardScreen(
    navigateTo: (route: String) -> Unit,
    viewModel: DashBoardViewModel = viewModel(factory = DashBoardViewModel.provideFactory())
) {
    LineLog.p("DashBoardScreen")
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "DashBoardScreen") },
        )
    }, bottomBar = {
        HomeBottomNavLayout(
            tabs = HomeTabs.entries.toTypedArray(),
            currentRoute = HomeTabs.DASHBOARD.route,
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
            WebView("https://app.podbbang.com/pages/main")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DashBoardScreenPreview() {
    val navigateTo: (String) -> Unit = {}
//    val navController = rememberNavController()

    AppTheme {
        DashBoardScreen(navigateTo)
    }
}