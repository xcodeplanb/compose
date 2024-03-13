package com.makeshop.podbbang.ui.home

import android.annotation.SuppressLint
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
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.web.AccompanistWebViewClient
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberSaveableWebViewState
import com.google.accompanist.web.rememberWebViewNavigator
import com.makeshop.podbbang.theme.AppTheme
import com.makeshop.podbbang.util.LineLog

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebView(
    url: String
) {
    LineLog.p("WebView")
    val context = LocalContext.current
    val url by remember { mutableStateOf(url) }
    var scrolly by rememberSaveable { mutableStateOf(0) }
    val webViewState = rememberSaveableWebViewState()
    val navigator = rememberWebViewNavigator()

    LaunchedEffect(navigator) {
        val bundle = webViewState.viewState
        if (bundle == null) {
            // This is the first time load, so load the home page.
            navigator.loadUrl(url)
            LineLog.p("navigator.loadUrl")
        }
    }

    val webViewClient = remember {
        object : AccompanistWebViewClient() {
            override fun onPageFinished(view: WebView, url: String?) {
                super.onPageFinished(view, url)
            }
        }
    }

    WebView(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        state = webViewState,
        navigator = navigator,
        captureBackPresses = true,
        client = webViewClient,
        onCreated = { it: WebView ->
//            it.setOnScrollChangeListener { view: View, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
//                scrolly = scrollY
//            }
//
//            it.scrollY = scrolly
            it.settings.javaScriptEnabled = true
            it.settings.domStorageEnabled = true
            it.settings.allowContentAccess = true
            it.settings.allowFileAccess = true
            it.settings.loadsImagesAutomatically = true
            it.settings.useWideViewPort = true
            it.settings.loadWithOverviewMode = true
            it.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW // https 이미지 수신
//            it.addJavascriptInterface(WebAppInterface(context, callGetAppId), "Android")
        }
    )
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun WebViewPreview() {
    val navigateTo: (String) -> Unit = {}
    val context = LocalContext.current
//    val navController = rememberNavController()

    AppTheme {
        WebView(context)
    }
}