package com.makeshop.podbbang.ui.home.ranking

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.insertFooterItem
import androidx.paging.insertSeparators
import androidx.paging.map
import com.makeshop.podbbang.data.Magazine
import com.makeshop.podbbang.data.RankingPaging
import com.makeshop.podbbang.repository.RankingRepository
import com.makeshop.podbbang.ui.home.sample.TestBackend
import com.makeshop.podbbang.util.LineLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

data class RankingUiState(
    var item: Magazine? = null,
    var isLoading: Boolean = false,
    var isPermission: Boolean = false,
)

var init = false

@HiltViewModel
class RankingViewModel @Inject constructor(private val pagingRepository: RankingRepository) :
    ViewModel() {
    private val _hourlyList: MutableStateFlow<PagingData<PagingUiModel>> =
        MutableStateFlow(value = PagingData.empty())
    val hourlyList: StateFlow<PagingData<PagingUiModel>> get() = _hourlyList

    private val _dailyList: MutableStateFlow<PagingData<PagingUiModel>> =
        MutableStateFlow(value = PagingData.empty())
    val dailyList: StateFlow<PagingData<PagingUiModel>> get() = _dailyList

    private val _weeklyList: MutableStateFlow<PagingData<PagingUiModel>> =
        MutableStateFlow(value = PagingData.empty())
    val weeklyList: StateFlow<PagingData<PagingUiModel>> get() = _weeklyList


    init {

    }

    fun getRankingList(type: String) {
        viewModelScope.launch {
            pagingRepository.rankingList(type, null)
                .map { pagingData ->
                    pagingData.map {
                        PagingUiModel.Item(it)
                    }
                }.map { pagingData ->
                    pagingData.insertSeparators { before, after ->
                        if (after == null || before == null) {
                            null
                        } else {
                            PagingUiModel.SeparatorItem("SeparatorItem${before.item.id}")
                        }
                    }
                }.map { pagingData ->
                    pagingData.insertFooterItem(item = PagingUiModel.Footer("Footer"))
                }.cachedIn(viewModelScope).collectLatest {
                    when (type) {
                        "hourly" -> {
                            _hourlyList.value = it
                        }

                        "daily" -> {
                            _dailyList.value = it
                        }

                        "weekly" -> {
                            _weeklyList.value = it
                        }
                    }

                }
        }
    }
}

