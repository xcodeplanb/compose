package com.makeshop.podbbang.mobile.ui.common

import android.annotation.SuppressLint
import android.app.Activity
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.makeshop.podbbang.mobile.MainNavController
import com.makeshop.podbbang.mobile.PodbbangWebBridge
import com.makeshop.podbbang.mobile.rememberMainNavController
import com.makeshop.podbbang.mobile.ui.theme.AppTheme
import com.makeshop.podbbang.shared.util.LineLog


@SuppressLint("StaticFieldLeak")
object KeepWebView {
    var webViewMap : HashMap<String,WebView> = HashMap()
    fun setWebViewMap(key : String, webView: WebView) {
        webViewMap[key] = webView
    }

    fun getWebViewMap(key : String) : WebView? {
        return webViewMap[key]
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewScreen(
    navigateTo: MainNavController?,
    screenName: String,
    url: String,
    paddingValues: PaddingValues
) {
    LineLog.d("WebView WebViewScreen")
    val backPressedCallback = object : OnBackPressedCallback(false) {
        override fun handleOnBackPressed() {
        }
    }

    val podbbangWebBridge: PodbbangWebBridge by lazy {
        PodbbangWebBridge()
    }

    val handlerListener = object : PodbbangWebBridge.HandlerListener {
        override fun getPaymentInapp(product_id: String?) {
        }

        override fun getPaymentInappList(type: String?) {

        }

        override fun setPaymentInapp(type: String?, ProductId: String?) {

        }

        override fun restorePurchase(cash: String?) {

        }

        override fun changeMagazineSubscriptionState(magazineId: String?, state: String?) {
        }

        override fun sendAlert(data: String?) {
        }

        override fun enableSkeleton(enable: Boolean?) {
        }

        override fun emailLogin(email: String?, password: String?) {
        }

        override fun backPress() {

        }

        override fun showFreeCashScreen() {
        }

        override fun closeFreeCashScreen() {
        }

        override fun showCardPointScreen() {
        }

        override fun closeCardPointScreen() {
        }

        override fun refreshToken() {
        }

        override fun enableBackPressCallback(enable: Boolean?) {
        }

        override fun useChangeLivePlayerState(use: Boolean) {
        }

        override fun onClearPlayerTackList() {
        }

        override fun onGetPlayerTrackList() {
        }

        override fun onPlayPlayerTrackList() {
        }

        override fun onPlayPlayer() {
        }

        override fun onPausePlayer() {
        }

        override fun onStopPlayer() {
        }

        override fun onShowCertifyDialog(title: String?, message: String?) {
        }

        override fun setAudioMute(mute: Boolean?) {
        }

        override fun showConfirmDialog(message: String?) {
        }
    }

    var webView = KeepWebView.getWebViewMap(screenName)
    var canGoBack by rememberSaveable { mutableStateOf(false) }
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    val activity = LocalContext.current as Activity
    val callback = object : OnBackPressedCallback(enabled = true) {
        override fun handleOnBackPressed() {
            LineLog.d("WebView handleOnBackPressed")
            if (webView?.canGoBack() == true) {
                webView?.goBack()
            } else {
                if (navigateTo?.navController?.navigateUp() == false) {
                    webView?.let { onBackPress(it, backPressedCallback, activity) }
                }
            }
        }
    }

    onBackPressedDispatcher?.addCallback(callback)

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        AndroidView(
            factory = { context ->
//                val parentLayout = FrameLayout(context).apply {
                if (webView == null) {
                    webView = WebView(context).apply {

                        settings.apply {
                            javaScriptEnabled = true
                            domStorageEnabled = true
                            allowContentAccess = true
                            allowFileAccess = true
                            mixedContentMode =
                                WebSettings.MIXED_CONTENT_ALWAYS_ALLOW // https 이미지 수신
//                            setUserAgentString(
//                                userAgentString.replace(
//                                    " wv",
//                                    ""
//                                ) + " V" + "7.22.1" + " PODBBANG_APP"
//                            )
//                            allowFileAccessFromFileURLs = true
//                            allowUniversalAccessFromFileURLs = true
//                            javaScriptCanOpenWindowsAutomatically = true
//                            loadsImagesAutomatically = true
//                            useWideViewPort = true
//                            loadWithOverviewMode = true
//                            textZoom = 100
//                            setSupportMultipleWindows(true)
//                            cacheMode = WebSettings.LOAD_NO_CACHE       // 캐싱 안함
//                            mediaPlaybackRequiresUserGesture = false
                        }

//                        setInitialScale(1)

                        webViewClient = object : WebViewClient() {
                            override fun doUpdateVisitedHistory(
                                view: WebView?,
                                url: String?,
                                isReload: Boolean,
                            ) {
                                canGoBack = view?.canGoBack() == true
                            }
                        }

                        layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )

                        val header = HashMap<String, String>()
                        header.put("os", "Android")
                        header.put(
                            "device_id",
                            "6d73cfa2-bf4c-35f9-8a7e-108268806ea2_null_1739771778380"
                        )
                        header.put("ad_id", "01368675-5b39-4517-978e-b13b275a3da0")
                        header.put("atappid", "ATa7ac3756a6214033601d47a1d5ebbcc4")
                        header.put("auth_code", "2a5ea3742e740c14239a4435caa978c1fc7d6540")

                        podbbangWebBridge.setHandlerListener(handlerListener)
                        webView?.addJavascriptInterface(podbbangWebBridge, "podbbangJs")

                        loadUrl(url, header)
                    }
                    KeepWebView.setWebViewMap(screenName, webView!!)
                }
                webView!!
//                    addView(webView)
//                }
//                parentLayout
            },
            update = {
//                webView?.loadUrl(url)
//                LineLog.d("WebView update")
            },
            onRelease = { parentFrame ->
//                (parentFrame.children.first() as? WebView)?.let {
//                    parentFrame.removeView(it)
//                }
//                LineLog.d("WebView onRelease")
            }
        )
    }

//    val context = LocalContext.current
//    val url by remember { mutableStateOf(url) }
//    var scrolly by rememberSaveable { mutableIntStateOf(0) }
//    val webViewState = rememberSaveableWebViewState()
//    val navigator = rememberWebViewNavigator()
//
//    LaunchedEffect(navigator) {
//        val bundle = webViewState.viewState
//        if (bundle == null) {
//            // This is the first time load, so load the home page.
//            navigator.loadUrl(url)
//            LineLog.d("navigator.loadUrl")
//        }
//    }
//
//    val webViewClient = remember {
//        object : AccompanistWebViewClient() {
//            override fun onPageFinished(view: WebView, url: String?) {
//                super.onPageFinished(view, url)
//            }
//        }
//    }
//
//    WebView(
//        modifier = Modifier
//            .fillMaxSize(),
//        state = webViewState,
//        navigator = navigator,
//        captureBackPresses = true,
//        client = webViewClient,
//        onCreated = { it: WebView ->
//            it.settings.javaScriptCanOpenWindowsAutomatically = true
//            it.settings.loadsImagesAutomatically = true
//            it.settings.javaScriptEnabled = true
//            it.settings.domStorageEnabled = true
//            it.settings.allowContentAccess = true
//            it.settings.allowFileAccess = true
//            it.settings.loadsImagesAutomatically = true
//            it.settings.useWideViewPort = true
//            it.settings.loadWithOverviewMode = true
//            it.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW // https 이미지 수신
//        }
//    )
}

fun onBackPress(
    webView: WebView, backPressedCallback: OnBackPressedCallback, acttivity: Activity
) {
    if (backPressedCallback.isEnabled) {
        LineLog.d("onBackPress() CustomBackEventState")
        webView.loadUrl("javascript:PB.appEvent('backPress');")
    } else {
        LineLog.d("onBackPress() popBackStack")
        acttivity.onBackPressed()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun WebViewPreview() {
    val navigateTo: (String) -> Unit = {}
    val context = LocalContext.current
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val navController = rememberMainNavController()

    val screenName: String = "WebViewScreen"
    val paddingValues: PaddingValues = PaddingValues(0.dp)

    AppTheme {
        WebViewScreen(
            navController,
            "WebViewScreen",
            "https://naver.com",
            paddingValues
        )
    }
}
