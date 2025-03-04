package com.makeshop.podbbang.mobile.ui.home.dashboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.accompanist.web.WebContent
import com.google.accompanist.web.WebViewNavigator
import com.google.accompanist.web.WebViewState
import com.makeshop.podbbang.shared.data.Magazine
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
data class DashBoardUiState(
    var item: Magazine? = null,
    var isLoading: Boolean = false,
    var isPermission : Boolean = false,
)

@HiltViewModel
class DashBoardViewModel @Inject constructor() : ViewModel() {
    companion object {
        fun provideFactory(): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DashBoardViewModel() as T
            }
        }
    }
}