package com.makeshop.podbbang.ui.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.makeshop.podbbang.data.Home
import com.makeshop.podbbang.data.Magazine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class MagazineUiState(
    var item: Magazine? = null,
    var isLoading: Boolean = false,
    var isPermission : Boolean = false,
)
@HiltViewModel
class MagazineViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(MagazineUiState(isLoading = false))
    val uiState: StateFlow<MagazineUiState> = _uiState.asStateFlow()

    init {
    }

    var dname by mutableStateOf("init value")

    fun updateInputText(inputText : String) {
        _uiState.value.item?.inputText = inputText
    }
    companion object {
        fun provideFactory(): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MagazineViewModel() as T
            }
        }
    }
}