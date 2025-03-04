package com.makeshop.podbbang.mobile.ui.home.magazine

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.makeshop.podbbang.mobile.MainNavController
import com.makeshop.podbbang.mobile.PodbbangApplication
import com.makeshop.podbbang.mobile.ui.common.WebViewScreen
import com.makeshop.podbbang.mobile.rememberMainNavController
import com.makeshop.podbbang.mobile.ui.theme.AppTheme
import com.makeshop.podbbang.mobile.ui.home.HomeBottomNavLayout
import com.makeshop.podbbang.mobile.ui.home.HomeTabs
import com.makeshop.podbbang.shared.util.LineLog


@Composable
fun MagazineScreen(
    navigateTo: MainNavController, viewModel: MagazineViewModel = hiltViewModel()
) {

//    val uiState = viewModel.uiState.collectAsState().value
//    val navController = rememberNavController()
    MagazineScreenContainer(viewModel, navigateTo)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MagazineScreenContainer(
    viewModel: MagazineViewModel,
    navigateTo: MainNavController
) {
    LineLog.d("DashBoardScreen")
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "MagazineScreen") },
        )
    }, bottomBar = {
        HomeBottomNavLayout(
            tabs = HomeTabs.entries.toTypedArray(),
            currentRoute = HomeTabs.MAGAZINE.route,
            navigateTo = navigateTo::navigateToBottomBarRoute
        )
    }) {
        WebViewScreen(
            navigateTo,
            "MagazineScreen",
            PodbbangApplication.WebUrl.HOME_MAGAZINE_TAB,
            it
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MagazineScreenPreview() {
    val viewModel: MagazineViewModel = hiltViewModel()
    val navigateTo: (String) -> Unit = { }
    val navController = rememberMainNavController()

    AppTheme {
        MagazineScreenContainer(viewModel, navController)
    }
}