package com.makeshop.podbbang.mobile.ui.home

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.makeshop.podbbang.mobile.R
import com.makeshop.podbbang.mobile.ui.theme.AppTheme
import com.makeshop.podbbang.mobile.ui.theme.spoqa_hansans_neo_regular
import com.makeshop.podbbang.mobile.HomeDestinations
import com.makeshop.podbbang.mobile.MainNavController
import com.makeshop.podbbang.mobile.rememberMainNavController

enum class HomeTabs(
    @StringRes var title: Int,
    @DrawableRes var selectIcon: Int,
    @DrawableRes var unSelectIcon: Int,
    @ColorRes var selectTextColor: Int,
    @ColorRes var unSelectTextColor: Int,
    var route: String
) {
    DASHBOARD(
        R.string.bottom_nav_title_home,
        R.drawable.ic_navi_home_sel,
        R.drawable.ic_navi_home_unsel,
        R.color.light000000DarkFFFFFF,
        R.color.light9A9A9ADark666666,
        HomeDestinations.DASHBOARD
    ),
    RANKING(
        R.string.bottom_nav_title_ranking,
        R.drawable.ic_navi_rank_sel,
        R.drawable.ic_navi_rank_unsel,
        R.color.light000000DarkFFFFFF,
        R.color.light9A9A9ADark666666,
        HomeDestinations.RANKING
    ),
    MAGAZINE(
        R.string.bottom_nav_title_magazine,
        R.drawable.ic_navi_magazine_sel,
        R.drawable.ic_navi_magazine_unsel,
        R.color.light000000DarkFFFFFF,
        R.color.light9A9A9ADark666666,
        HomeDestinations.MAGAZINE
    ),
    AUDIOBOOK(
        R.string.bottom_nav_title_audiobook,
        R.drawable.ic_navi_audiobook_sel,
        R.drawable.ic_navi_audiobook_unsel,
        R.color.light000000DarkFFFFFF,
        R.color.light9A9A9ADark666666,
        HomeDestinations.AUDIOBOOK
    ),
    COMMUNITY(
        R.string.bottom_nav_title_community,
        R.drawable.ic_navi_community_sel,
        R.drawable.ic_navi_community_unsel,
        R.color.light000000DarkFFFFFF,
        R.color.light9A9A9ADark666666,
        HomeDestinations.COMMUNITY
    ),
    MEDIA(
        R.string.bottom_nav_title_media,
        R.drawable.ic_navi_my_sel,
        R.drawable.ic_navi_my_unsel,
        R.color.light000000DarkFFFFFF,
        R.color.light9A9A9ADark666666,
        HomeDestinations.MEDIA
    )
}

/**
 * Destinations used in)
 */

//data class TabItem(
//    var title: Int,
//    val selectIcon: Int,
//    val unSelectIcon: Int,
//    val selectTextColor: Int,
//    val unSelectTextColor: Int
//)
//
//val tabs = listOf<TabItem>(
//    TabItem(
//        title = R.string.bottom_nav_title_home,
//        selectIcon = R.drawable.ic_navi_home_sel,
//        unSelectIcon = R.drawable.ic_navi_home_unsel,
//        selectTextColor = R.color.day000000NightFFFFFF,
//        unSelectTextColor = R.color.day9A9A9ANight666666
//    ),
//    TabItem(
//        title = R.string.bottom_nav_title_ranking,
//        selectIcon = R.drawable.ic_navi_rank_sel,
//        unSelectIcon = R.drawable.ic_navi_rank_unsel,
//        selectTextColor = R.color.day000000NightFFFFFF,
//        unSelectTextColor = R.color.day9A9A9ANight666666
//    ),
//    TabItem(
//        title = R.string.bottom_nav_title_magazine,
//        selectIcon = R.drawable.ic_navi_magazine_sel,
//        unSelectIcon = R.drawable.ic_navi_magazine_unsel,
//        selectTextColor = R.color.day000000NightFFFFFF,
//        unSelectTextColor = R.color.day9A9A9ANight666666
//    ),
//    TabItem(
//        title = R.string.bottom_nav_title_audiobook,
//        selectIcon = R.drawable.ic_navi_audiobook_sel,
//        unSelectIcon = R.drawable.ic_navi_audiobook_unsel,
//        selectTextColor = R.color.day000000NightFFFFFF,
//        unSelectTextColor = R.color.day9A9A9ANight666666
//    ),
//    TabItem(
//        title = R.string.bottom_nav_title_my,
//        selectIcon = R.drawable.ic_navi_my_sel,
//        unSelectIcon = R.drawable.ic_navi_my_unsel,
//        selectTextColor = R.color.day000000NightFFFFFF,
//        unSelectTextColor = R.color.day9A9A9ANight666666
//    )
//)

@Composable
fun HomeScreen(
    mainNavController: MainNavController
) {
}

@Composable
fun HomeBottomNavLayout(
    tabs: Array<HomeTabs>, currentRoute: String, navigateTo: (route: String) -> Unit
) {
    val currentSRoute = tabs.first { it.route == currentRoute }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = colorResource(id = R.color.color1A1A1A))
    ) {
        TabRow(containerColor = colorResource(R.color.lightFFFFFFDark121212),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            selectedTabIndex = currentSRoute.ordinal,
            indicator = {

            }) {
            tabs.forEachIndexed { index, tab ->
                val isSelected = tab == currentSRoute
                Tab(selected = isSelected, enabled = true, onClick = {
                    navigateTo(tab.route)
                }) {
                    Column(
                        Modifier
                            .wrapContentSize()
                            .padding(vertical = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp),
                            painter = painterResource(if (isSelected) tab.selectIcon else tab.unSelectIcon),
                            contentDescription = null,
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            stringResource(tab.title),
                            style = TextStyle(
                                fontFamily = spoqa_hansans_neo_regular,
                                fontSize = 10.sp,
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
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Preview(device = Devices.PHONE)
@Preview(device = Devices.FOLDABLE)
@Preview(device = Devices.TABLET)
@Composable
fun HomeScreenPreview() {
    val navController = rememberMainNavController()

    AppTheme {
        HomeBottomNavLayout(
            HomeTabs.entries.toTypedArray(),
            HomeTabs.DASHBOARD.route,
            navController::navigateToBottomBarRoute
        )
    }
}