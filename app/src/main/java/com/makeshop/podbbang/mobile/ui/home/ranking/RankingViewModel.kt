package com.makeshop.podbbang.mobile.ui.home.ranking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.insertFooterItem
import androidx.paging.insertSeparators
import androidx.paging.map
import com.makeshop.podbbang.shared.repository.RankingRepository
import com.makeshop.podbbang.mobile.ui.home.ranking.PagingUiModel
import com.makeshop.podbbang.shared.api.Resource
import com.makeshop.podbbang.shared.data.CategoryList
import com.makeshop.podbbang.shared.util.LineLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

data class RankingUiState(
    val hourlyList: PagingData<PagingUiModel> = PagingData.empty(),
    val dailyList: PagingData<PagingUiModel> = PagingData.empty(),
    val weeklyList: PagingData<PagingUiModel> = PagingData.empty(),
    var isLoading: Boolean = false
)

@HiltViewModel
class RankingViewModel @Inject constructor(private val rankingRepository: RankingRepository) :
    ViewModel() {

    private val _uiState = MutableStateFlow(RankingUiState(isLoading = true))
    val uiState: StateFlow<RankingUiState> = _uiState.asStateFlow()

    private val _hourlyList: MutableStateFlow<PagingData<PagingUiModel>> =
        MutableStateFlow(value = PagingData.empty())
    val hourlyList: StateFlow<PagingData<PagingUiModel>> get() = _hourlyList

    private val _dailyList: MutableStateFlow<PagingData<PagingUiModel>> =
        MutableStateFlow(value = PagingData.empty())
    val dailyList: StateFlow<PagingData<PagingUiModel>> get() = _dailyList

    private val _weeklyList: MutableStateFlow<PagingData<PagingUiModel>> =
        MutableStateFlow(value = PagingData.empty())
    val weeklyList: StateFlow<PagingData<PagingUiModel>> get() = _weeklyList

    private val _categoryList: MutableStateFlow<List<CategoryList.Category>> =
        MutableStateFlow(emptyList())
    val categoryList: StateFlow<List<CategoryList.Category>> get() = _categoryList

    val saveMap = mutableMapOf<String, KeyParams>()

    data class KeyParams(
        val params: String = "",
        val index: Int,
        val scrollOffset: Int
    )

    init {
        getRankingList()
        getCategoryList()
    }

    fun getCategoryList() {
        LineLog.d("getCategoryList")
        viewModelScope.launch {
            val response = rankingRepository.categoryList(true)
            if(response is Resource.Success) {
                val dumpList = ArrayList<CategoryList.Category>()
                dumpList.add(CategoryList.Category("0","전체","https://dimg.podbbang.com/categories//1661915149.png",true))
                dumpList.addAll(response.value.data)
                _categoryList.value = dumpList
                LineLog.d("getCategoryList response ${response.value.data}")
            } else {
                LineLog.d("getCategoryList failed ")
            }
        }
    }

    fun getRankingList() {
        LineLog.d("getRankingList")
        viewModelScope.launch {
            async {
                rankingRepository.rankingList("hourly", null)
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
                    }.cachedIn(viewModelScope).collectLatest { pageData ->
                        _hourlyList.value = pageData
                    }
            }

            async {
                rankingRepository.rankingList("daily", null)
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
                    }.cachedIn(viewModelScope).collectLatest { pageData ->
                        _dailyList.value = pageData
                    }
            }

            async {
                rankingRepository.rankingList("weekly", null)
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
                    }.cachedIn(viewModelScope).collectLatest { pageData ->
                        _weeklyList.value = pageData
                    }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}