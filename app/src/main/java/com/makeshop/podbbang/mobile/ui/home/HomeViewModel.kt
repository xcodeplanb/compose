package com.makeshop.podbbang.mobile.ui.home

import androidx.lifecycle.ViewModel
import com.makeshop.podbbang.shared.data.Home
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class HomeUiState(
    var item: Home? = null,
    var isLoading: Boolean = false,
    var isPermission : Boolean = false
)

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState(isLoading = false))
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    companion object {
        const val TAG = "SplashViewModel"
    }
}