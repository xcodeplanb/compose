package com.makeshop.podbbang.ui.splash

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.webkit.JavascriptInterface
import android.webkit.WebView
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.web.AccompanistWebViewClient
import com.google.accompanist.web.rememberWebViewState
import com.makeshop.podbbang.R
import com.makeshop.podbbang.util.OnLifecycleEvent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.TextField
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.web.WebView
import com.makeshop.podbbang.data.Splash
import com.makeshop.podbbang.theme.spoqa_hansans_neo_regular
import com.makeshop.podbbang.ui.MainDestinations

@Composable
fun SplashScreen(
    navigateTo: (route: String) -> Unit,
    viewModel: SplashViewModel = viewModel(factory = SplashViewModel.provideFactory())
) {
//    val viewModel: SplashViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsState().value
    SplashScreenContainer(navigateTo, uiState)
}

@Composable
fun SplashScreenContainer(navigateTo: (route: String) -> Unit, uiState: SplashUiState) {
    var text by rememberSaveable { mutableStateOf("") }
    OnLifecycleEvent { owner, event ->
        when (event) {
            Lifecycle.Event.ON_START -> {
            }

            else -> {

            }
        }
    }

    ConstraintLayout(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = colorResource(id = R.color.color1A1A1A))
    ) {
        val splashItem = uiState.item
        val (textfield, backGroundImage, logoImage, liveTime, progressBar) = createRefs()

        AnimatedVisibility(
            visible = true,
            enter = scaleIn(initialScale = 1.2f, animationSpec = tween(1700)),
        ) {
            AsyncImage(
                model = uiState.item?.let {
                    if (it.image?.isNotEmpty() == true) {
                        ImageRequest.Builder(LocalContext.current)
                            .data(it.image)
                            .crossfade(true)
                            .build()
                    } else {
                        R.drawable.splash_default_bg
                    }
                },
                contentDescription = "Translated description of what the image contains",
                modifier = Modifier
                    .constrainAs(backGroundImage) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }
                    .fillMaxSize()
                    .clickable { /* .. */ },
            )
        }


        Image(
            painter = painterResource(R.drawable.ic_splash_logo),
            contentDescription = "", // 필수 param
            modifier = Modifier
                .constrainAs(logoImage) {
                    top.linkTo(parent.top, margin = 61.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                }
                .clickable {
                    navigateTo(MainDestinations.HOME)
                }
        )

        Row(
            modifier = Modifier
                .constrainAs(liveTime) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(progressBar.top, margin = 41.dp)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Badge(splashItem)
        }

        TextField(
            modifier = Modifier
                .constrainAs(textfield) {
                    top.linkTo(parent.top, margin = 100.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                }.background(Color.White),
            textStyle = TextStyle(color = Color.Blue),
            value = text,
            onValueChange = {
                text = it.toString()
            },
            label = { Text("Label") }
        )

        LinearProgressIndicator(
            modifier = Modifier
                .constrainAs(progressBar) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom, margin = 38.dp)
                }
                .clip(RoundedCornerShape(10.dp))
                .width(160.dp)
                .height(3.dp),
            backgroundColor = colorResource(id = R.color.color222222),
            color = colorResource(id = R.color.color1FA1EB)
        )
    }
}

@Composable
fun Badge(splash: Splash?) {
    splash?.badges?.forEach {
        Spacer(modifier = Modifier.width(3.dp))

        val borderStroke = if (it.type == "outline") {
            BorderStroke(2.5.dp, Color(android.graphics.Color.parseColor(it.tintColor)))
        } else {
            null
        }

        val backgroundColor = if (it.type == "outline") {
            Color.Transparent
        } else {
            Color(android.graphics.Color.parseColor(it.tintColor))
        }

        Surface(
            border = borderStroke,
            color = backgroundColor,
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .width(64.dp)
                .height(27.dp)
        ) {
            Text(
                text = it.text ?: "",
                style = TextStyle(
                    fontFamily = spoqa_hansans_neo_regular,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                    color = Color(android.graphics.Color.parseColor(it.textColor)),
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
            )
        }

        Spacer(modifier = Modifier.width(3.dp))
    }

    Spacer(modifier = Modifier.width(7.dp))

    Text(
        text = splash?.description ?: "",
        style = TextStyle(
            fontFamily = spoqa_hansans_neo_regular,
            fontSize = 14.sp,
            fontWeight = FontWeight(500),
            color = Color(0xFFF1F1F2),
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            )
        ),
        fontSize = 16.sp,
        fontFamily = spoqa_hansans_neo_regular
    )
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun SplashWebView(
    url: String,
    callGetAppId: () -> Unit
) {
    val url by remember { mutableStateOf(url) }
    val webViewState = rememberWebViewState(url = url)
    val webViewClient = remember {
        object : AccompanistWebViewClient() {
            override fun onPageFinished(view: WebView, url: String?) {
                super.onPageFinished(view, url)
            }
        }
    }

    val context = LocalContext.current

    WebView(
        modifier = Modifier
            .width(0.dp)
            .height(0.dp),
        state = webViewState,
        client = webViewClient,
        captureBackPresses = true,
        onCreated = { it: WebView ->
            it.settings.javaScriptEnabled = true
            it.addJavascriptInterface(WebAppInterface(context, callGetAppId), "Android")
        }
    )
}

class WebAppInterface(private val context: Context, val callGetAppId: () -> Unit) {
    /**
     * 브라우저 지문 라이브러리
     */
    @JavascriptInterface
    fun browserFingerprint(data: String) {

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable()
fun SplashScreenPreview() {
//    val mainNavController = rememberNavController()
//    AppTheme {
//        SplashScreenContainer(
//            mainNavController = mainNavController,
//            uiState = SplashUiState(Splash.mock())
//        )
//    }
}