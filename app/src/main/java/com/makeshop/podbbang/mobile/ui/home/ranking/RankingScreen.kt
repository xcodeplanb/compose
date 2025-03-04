package com.makeshop.podbbang.mobile.ui.home.ranking

import android.content.res.Configuration
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.makeshop.podbbang.mobile.R
import com.makeshop.podbbang.mobile.ui.home.HomeBottomNavLayout
import com.makeshop.podbbang.mobile.ui.home.HomeTabs
import com.makeshop.podbbang.mobile.ui.theme.AppTheme
import com.makeshop.podbbang.mobile.ui.theme.normalFont
import com.makeshop.podbbang.mobile.ui.theme.spoqa_hansans_neo_regular
import com.makeshop.podbbang.mobile.util.DateUtil.isTodayFromStringPattern
import com.makeshop.podbbang.shared.data.CategoryList
import com.makeshop.podbbang.shared.data.RankingPaging
import com.makeshop.podbbang.shared.util.LineLog
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
        R.color.light000000DarkFFFFFF,
        R.color.light9A9A9ADark666666,
        RankingDestinations.REALTIME
    ),
    DAILY(
        R.string.ranking_tab_daily,
        R.drawable.ic_navi_rank_sel,
        R.drawable.ic_navi_rank_unsel,
        R.color.light000000DarkFFFFFF,
        R.color.light9A9A9ADark666666,
        RankingDestinations.DAILY
    ),
    WEEKLY(
        R.string.ranking_tab_weekly,
        R.drawable.ic_navi_magazine_sel,
        R.drawable.ic_navi_magazine_unsel,
        R.color.light000000DarkFFFFFF,
        R.color.light9A9A9ADark666666,
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
    navigateTo: (route: String) -> Unit, viewModel: RankingViewModel = hiltViewModel()
) {
    LineLog.d("RankingScreen")
//    val uiState = viewModel.uiState.collectAsState().value
//    val navController = rememberNavController()
    RankingScreenContainer(navigateTo, viewModel)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RankingScreenContainer(navigateTo: (route: String) -> Unit, viewModel: RankingViewModel) {
    LineLog.d("RankingScreenContainer")
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                title = { Text(text = "랭킹", fontSize = 20.sp) },
                actions = {
                    Icon(
                        modifier = Modifier
                            .size(24.dp, 24.dp)
                            .clickable {

                            },
                        imageVector = ImageVector.vectorResource(id = R.drawable.icon_hambuger),
                        contentDescription = "사이드메뉴"
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                },
                navigationIcon = {

                }
            )
        }, bottomBar = {
            HomeBottomNavLayout(
                tabs = HomeTabs.entries.toTypedArray(),
                currentRoute = HomeTabs.RANKING.route,
                navigateTo = navigateTo
            )
        }
    ) { padding ->
        Content(
            navigateTo,
            viewModel,
            RankingTabs.entries.toTypedArray(),
            RankingDestinations.REALTIME,
            padding
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Content(
    navigateTo: (route: String) -> Unit,
    viewModel: RankingViewModel,
    tabs: Array<RankingTabs>,
    currentRoute: String,
    padding: PaddingValues
) {
    LineLog.d("Content")
    val categoryItems = viewModel.categoryList.collectAsStateWithLifecycle()
    val hourlyItems = viewModel.hourlyList.collectAsLazyPagingItems()
    val dailyItems = viewModel.dailyList.collectAsLazyPagingItems()
    val weeklyItems = viewModel.weeklyList.collectAsLazyPagingItems()

    val currentSRoute = tabs.first { it.route == currentRoute }
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val coroutineScope = rememberCoroutineScope()

    Column(
        Modifier
            .fillMaxSize()
            .padding(padding)
    )
    {
        TabRow(
            containerColor = colorResource(R.color.lightFFFFFFDark121212),
            selectedTabIndex = pagerState.currentPage,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            tabs.forEachIndexed { index, tab ->
                val isSelected = pagerState.currentPage == index
                Tab(selected = isSelected, enabled = true, onClick = {
                    coroutineScope.launch {
                        pagerState.scrollToPage(index)
                    }
                }) {
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

        CategoryList(categoryItems)

        // PAGER
        HorizontalPager(
            state = pagerState
        ) { index ->
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                LineLog.d("HorizontalPager ")
                when (tabs[index].route) {
                    RankingDestinations.REALTIME -> HourlyPageList(
                        navigateTo,
                        hourlyItems,
                        "hourly"
                    )

                    RankingDestinations.DAILY -> DailyPageList(navigateTo, dailyItems, "daily")
                    RankingDestinations.WEEKLY -> WeeklyPageList(navigateTo, weeklyItems, "weekly")
                }
            }
        }
    }
}

@Composable
fun CategoryList(categoryItems: State<List<CategoryList.Category>>) {
    LineLog.d("CategoryList categoryItems.value.size ${categoryItems.value.size}")
    LazyRow(
        state = rememberLazyListState(),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(categoryItems.value, key = { item -> item.id }) { item ->
            Box(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(vertical = 10.dp, horizontal = 4.dp)
                    .height(40.dp)
                    .background(
                        color = Color.LightGray, // Replace with your actual color or drawable
                        shape = RoundedCornerShape(15.dp)
                    )
                    .clickable {

                    }
            ) {
                Text(
                    text = item.title.toString(),
                    fontSize = 14.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxHeight()
                        .wrapContentSize(Alignment.Center)
                )
            }

        }

//        items(categoryItems.value.size) { index ->
//            Box(
//                modifier = Modifier
//                    .wrapContentWidth()
//                    .padding(vertical = 10.dp, horizontal = 4.dp)
//                    .height(40.dp)
//                    .background(
//                        color = Color.LightGray, // Replace with your actual color or drawable
//                        shape = RoundedCornerShape(15.dp)
//                    )
//                    .clickable {
//
//                    }
//            ) {
//                Text(
//                    text = categoryItems.value[index].title.toString(),
//                    fontSize = 14.sp,
//                    color = Color.White,
//                    modifier = Modifier
//                        .padding(horizontal = 16.dp)
//                        .fillMaxHeight()
//                        .wrapContentSize(Alignment.Center)
//                )
//            }
//        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HourlyPageList(
    navigateTo: (route: String) -> Unit,
    lazyPagingItems: LazyPagingItems<PagingUiModel>,
    type: String
) {
    LineLog.d("HourlyPageList ")

    LazyColumn(
        state = rememberLazyListState(),
        modifier = Modifier.fillMaxSize()
    ) {
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
                    ItemList(item.item)
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
fun DailyPageList(
    navigateTo: (route: String) -> Unit,
    lazyPagingItems: LazyPagingItems<PagingUiModel>,
    type: String
) {
    LineLog.d("DailyPageList")
    LazyColumn(
        state = rememberLazyListState(),
        modifier = Modifier.fillMaxSize()
    ) {
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
                    ItemList(item.item)
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
fun WeeklyPageList(
    navigateTo: (route: String) -> Unit,
    lazyPagingItems: LazyPagingItems<PagingUiModel>,
    type: String
) {
    LineLog.d("WeeklyPageList")
    LazyColumn(
        state = rememberLazyListState(),
        modifier = Modifier.fillMaxSize()
    ) {
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
                    ItemList(item.item)
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

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ItemList(item: RankingPaging.RankEntity) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .padding(10.dp, 10.dp, 5.dp, 10.dp)
    ) {
        Box(
            modifier = Modifier
                .width(70.dp)
                .height(70.dp)
        ) {
            GlideImage(
                model = item.image,
                contentScale = ContentScale.FillBounds,
                contentDescription = null,
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        colorResource(id = R.color.lightDDDDDDDark1AFFFFFF),
                        RoundedCornerShape(10.dp)
                    )
            )

            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "19",
                style = TextStyle(
                    fontFamily = spoqa_hansans_neo_regular,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    color = colorResource(id = R.color.light000000DarkFFFFFF),
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
            )
        }

        Spacer(modifier = Modifier.width(5.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .width(40.dp)
                .height(70.dp)
                .background(color = Color.White)
        ) {
            Text(
                text = "1", style = normalFont, fontSize = 14.sp
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier
                        .width(7.dp)
                        .height(7.dp),
                    painter = painterResource(id = R.drawable.ic_rank_up),
                    contentDescription = null
                )
                Text(
                    text = "2", style = normalFont, fontSize = 9.sp
                )
            }
        }

        Spacer(modifier = Modifier.width(10.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f)
                .height(70.dp)
                .background(color = Color.White)
        ) {
            Text(
                text = item.title, style = normalFont, fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(2.dp))

            if (item.copyright.isNotEmpty()) {
                Text(
                    text = item.copyright, style = normalFont, fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(2.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                if (item.updatedAt?.isNotEmpty() == true) {
                    val badgeIconResource = if (isTodayFromStringPattern(item.updatedAt)) {
                        R.drawable.ic_up_badge
                    } else {
                        R.drawable.ic_up_badge_disable
                    }
                    val rankDateText = if (isTodayFromStringPattern(item.updatedAt)) {
                        "오늘"
                    } else {
                        item.updatedAt
                    }

                    Image(
                        modifier = Modifier
                            .wrapContentWidth()
                            .height(13.dp),
                        painter = painterResource(id = badgeIconResource),
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(3.dp))

                    Text(
                        text = "$rankDateText \u2022 구독자 21.5만명",
                        style = normalFont,
                        fontSize = 12.sp
                    )
                }
            }
        }

        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .width(56.dp)
                .height(70.dp)
                .padding(start = 5.dp)
        ) {

            Image(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                painter = painterResource(id = R.drawable.ic_rank_badge_disable),
                contentDescription = null
            )
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