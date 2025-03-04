package com.makeshop.podbbang.mobile.ui.splash

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.makeshop.podbbang.shared.data.Splash
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SplashUiState(
    var item: Splash? = null,
    var isLoading: Boolean = false,
    var isPermission: Boolean = false
)

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(SplashUiState(isLoading = false))
    val uiState: StateFlow<SplashUiState> = _uiState.asStateFlow()

    private val _isApiCallCount = MutableStateFlow(0)
    val isApiCallCount: StateFlow<Int> = _isApiCallCount.asStateFlow()

    init {
        Log.d("SplashViewModel", "init")
        viewModelScope.launch {
            _uiState.update {
                SplashUiState(Splash.mock())
            }
        }
    }

    @SuppressLint("CheckResult")
    fun callSplashApi(useDefaultImage: Boolean, type: String) {
        _uiState.update {
            it.copy(isLoading = true)
        }
    }

    @SuppressLint("CheckResult")
    fun callLoginLogLApi() {

    }

    override fun onCleared() {
        super.onCleared()
    }

    companion object {
        fun provideFactory(): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return SplashViewModel() as T
            }
        }
    }
}

//compositeDisposable.add(Single.just(ConfigurationsReq())
//            .flatMap { atTrackRepository.getConfigurations(it) }
//            .subscribeOn(SchedulerProvider.io())
//            .observeOn(SchedulerProvider.io())
//            .subscribe({
//                ConfigurationDAO.`in`().recoredValue(
//                    Configuration.KEY_PODBBANG_ADMIN_CODE,
//                    it.podbbangUserNo.toString()
//                )
//                _isApiCallCount.value++
//            }, {
//                _isApiCallCount.value++
//            })
//        )