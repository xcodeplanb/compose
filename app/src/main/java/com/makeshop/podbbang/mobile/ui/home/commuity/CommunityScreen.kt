package com.makeshop.podbbang.mobile.ui.home.commuity

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.makeshop.podbbang.mobile.MainNavController
import com.makeshop.podbbang.mobile.PodbbangApplication
import com.makeshop.podbbang.mobile.ui.common.WebViewScreen
import com.makeshop.podbbang.mobile.rememberMainNavController
import com.makeshop.podbbang.mobile.ui.theme.AppTheme
import com.makeshop.podbbang.mobile.ui.home.HomeBottomNavLayout
import com.makeshop.podbbang.mobile.ui.home.HomeTabs
import com.makeshop.podbbang.shared.util.LineLog

@Composable
fun CommunityScreen(
    navigateTo: MainNavController
) {

//    val uiState = viewModel.uiState.collectAsState().value
//    val navController = rememberNavController()
    CommunityScreenContainer(navigateTo)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunityScreenContainer(
    navigateTo: MainNavController
) {
    LineLog.d("CommunityScreen")
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "MagazineScreen") },
        )
    }, bottomBar = {
        HomeBottomNavLayout(
            tabs = HomeTabs.entries.toTypedArray(),
            currentRoute = HomeTabs.COMMUNITY.route,
            navigateTo = navigateTo::navigateToBottomBarRoute
        )
    }) {
        WebViewScreen(
            navigateTo,
             "CommunityScreen",
            PodbbangApplication.WebUrl.HOME_COMMUNITY_TAB,
            it
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CommunityScreenPreview() {
    val navigateTo: (String) -> Unit = { }
    val navController = rememberMainNavController()

    AppTheme {
        CommunityScreenContainer(navController)
    }
}