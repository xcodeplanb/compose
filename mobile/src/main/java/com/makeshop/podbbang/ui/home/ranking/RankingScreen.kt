package com.makeshop.podbbang.ui.home.ranking

import android.util.Log
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.makeshop.podbbang.R
import com.makeshop.podbbang.data.RankingPaging
import com.makeshop.podbbang.repository.RankingRepository
import com.makeshop.podbbang.theme.AppTheme
import com.makeshop.podbbang.theme.spoqa_hansans_neo_regular
import com.makeshop.podbbang.ui.home.HomeBottomNavLayout
import com.makeshop.podbbang.ui.home.HomeTabs
import com.makeshop.podbbang.util.LineLog
import kotlinx.coroutines.launch

enum class RankingTabs(
    @StringRes var title: Int,
    @DrawableRes var selectIcon: Int,
    @DrawableRes var unSelectIcon: Int,
    @ColorRes var selectTextColor: Int,
    @ColorRes var unSelectTextColor: Int,
    var route: String
) {
    REALTIME(
        R.string.ranking_tab_realtime,
        R.drawable.ic_navi_home_sel,
        R.drawable.ic_navi_home_unsel,
        R.color.day000000NightFFFFFF,
        R.color.day9A9A9ANight666666,
        RankingDestinations.REALTIME
    ),
    DAILY(
        R.string.ranking_tab_daily,
        R.drawable.ic_navi_rank_sel,
        R.drawable.ic_navi_rank_unsel,
        R.color.day000000NightFFFFFF,
        R.color.day9A9A9ANight666666,
        RankingDestinations.DAILY
    ),
    WEEKLY(
        R.string.ranking_tab_weekly,
        R.drawable.ic_navi_magazine_sel,
        R.drawable.ic_navi_magazine_unsel,
        R.color.day000000NightFFFFFF,
        R.color.day9A9A9ANight666666,
        RankingDestinations.WEEKLY
    )
}

object RankingDestinations {
    const val REALTIME = "ranking/realtime"
    const val DAILY = "ranking/daily"
    const val WEEKLY = "ranking/weekly"
}

@Composable
fun RankingScreen(
    navigateTo: (route: String) -> Unit,
    viewModel: RankingViewModel = hiltViewModel()
) {
    LineLog.p("RankingScreen")
//    val uiState = viewModel.uiState.collectAsState().value
//    val navController = rememberNavController()
    RankingScreenContainer(navigateTo, viewModel)

}

@Composable
fun RankingScreenContainer(navigateTo: (route: String) -> Unit, viewModel: RankingViewModel) {
    LineLog.p("RankingScreenContainer")
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "RankingScreen") },
        )
    }, bottomBar = {
        HomeBottomNavLayout(
            tabs = HomeTabs.entries.toTypedArray(),
            currentRoute = HomeTabs.RANKING.route,
            navigateTo = navigateTo
        )
    }) {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            TopTabLayout(
                viewModel,
                RankingTabs.entries.toTypedArray(),
                RankingDestinations.REALTIME
            )
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopTabLayout(
    viewModel: RankingViewModel,
    tabs: Array<RankingTabs>,
    currentRoute: String,
) {
    LineLog.p("TopTabLayout")
    val currentSRoute = tabs.first { it.route == currentRoute }
    val pagerState = rememberPagerState(pageCount = { tabs.size})

//    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    TabRow(
        backgroundColor = colorResource(R.color.dayFFFFFFNight121212),
        selectedTabIndex = pagerState.currentPage,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        tabs.forEachIndexed { index, tab ->
            val isSelected = pagerState.currentPage == index
            Tab(
                selected = isSelected,
                enabled = true,
                onClick = {
                    LineLog.p("TabRow onClick ")
                    coroutineScope.launch {
                        pagerState.scrollToPage(index)
                    }
                })
            {
                Text(
                    stringResource(tab.title),
                    style = TextStyle(
                        fontFamily = spoqa_hansans_neo_regular,
                        fontSize = 20.sp,
                        fontWeight = FontWeight(400),
                        color = colorResource(if (isSelected) tab.selectTextColor else tab.unSelectTextColor),
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                )
            }
        }
    }

    // PAGER
    HorizontalPager(
        state = pagerState
    ) { index ->
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LineLog.p("HorizontalPager ")
            when (tabs[index].route) {
                RankingDestinations.REALTIME -> HourlyPageList(viewModel, "hourly")
                RankingDestinations.DAILY -> DailyPageList(viewModel, "daily")
                RankingDestinations.WEEKLY -> WeeklyPageList(viewModel, "weekly")
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HourlyPageList(viewModel: RankingViewModel, type: String) {
    LineLog.p("HourlyPageList")
    val lazyPagingItems = viewModel.hourlyList.collectAsLazyPagingItems()
    viewModel.getRankingList(type)

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        if (lazyPagingItems.loadState.refresh == LoadState.Loading) {
//            item {
//                Text(
//                    text = "Waiting for items to load from the backend",
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .wrapContentWidth(Alignment.CenterHorizontally)
//                )
//            }
        }

        items(count = lazyPagingItems.itemCount, key = lazyPagingItems.itemKey {
            when (it) {
                is PagingUiModel.Item -> it.item.id
                is PagingUiModel.SeparatorItem -> it.id
                is PagingUiModel.Footer -> it.id
            }
        }) { index ->
            when (val item = lazyPagingItems[index]) {
                is PagingUiModel.Item -> {
                    Text(item.item.title, fontSize = 20.sp)
                }

                else -> {}
            }
        }

        if (lazyPagingItems.loadState.append == LoadState.Loading) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DailyPageList(viewModel: RankingViewModel, type: String) {
    LineLog.p("DailyPageList")
    val lazyPagingItems = viewModel.dailyList.collectAsLazyPagingItems()
    viewModel.getRankingList(type)

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        if (lazyPagingItems.loadState.refresh == LoadState.Loading) {
//            item {
//                Text(
//                    text = "Waiting for items to load from the backend",
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .wrapContentWidth(Alignment.CenterHorizontally)
//                )
//            }
        }
        items(count = lazyPagingItems.itemCount) { index ->
            when (val item = lazyPagingItems[index]) {
                is PagingUiModel.Item -> {
                    Text(item.item.title, fontSize = 20.sp)
                }

                else -> {

                }
            }

        }
        if (lazyPagingItems.loadState.append == LoadState.Loading) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WeeklyPageList(viewModel: RankingViewModel, type: String) {
    LineLog.p("WeeklyPageList")
    val lazyPagingItems = viewModel.weeklyList.collectAsLazyPagingItems()
    viewModel.getRankingList(type)

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        if (lazyPagingItems.loadState.refresh == LoadState.Loading) {
//            item {
//                Text(
//                    text = "Waiting for items to load from the backend",
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .wrapContentWidth(Alignment.CenterHorizontally)
//                )
//            }
        }
        items(count = lazyPagingItems.itemCount) { index ->
            when (val item = lazyPagingItems[index]) {
                is PagingUiModel.Item -> {
                    Text(item.item.title, fontSize = 20.sp)
                }

                else -> {

                }
            }

        }
        if (lazyPagingItems.loadState.append == LoadState.Loading) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun RankingScreenPreview() {
    val navigateTo: (String) -> Unit = {}
    val viewModel: RankingViewModel = hiltViewModel()
//    val navController = rememberNavController()

    AppTheme {
        RankingScreenContainer(navigateTo, viewModel)
    }
}