package com.makeshop.podbbang.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.accompanist.web.WebContent
import com.google.accompanist.web.WebViewNavigator
import com.google.accompanist.web.WebViewState
import com.makeshop.podbbang.data.Home
import com.makeshop.podbbang.ui.splash.SplashViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DashBoardViewModel @Inject constructor() : ViewModel() {
    var dname by mutableStateOf("init value")
    val webViewState = WebViewState(
        WebContent.Url(
            url = "https://app.podbbang.com/pages/main",
            additionalHttpHeaders = emptyMap()
        )
    )
    val webViewNavigator = WebViewNavigator(viewModelScope)
    init {

    }
    companion object {
        fun provideFactory(): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DashBoardViewModel() as T
            }
        }
    }
}