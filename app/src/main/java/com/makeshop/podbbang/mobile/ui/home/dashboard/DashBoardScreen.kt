package com.makeshop.podbbang.mobile.ui.home.dashboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.makeshop.podbbang.mobile.MainNavController
import com.makeshop.podbbang.mobile.PodbbangApplication
import com.makeshop.podbbang.mobile.R
import com.makeshop.podbbang.mobile.ui.common.WebViewScreen
import com.makeshop.podbbang.mobile.rememberMainNavController
import com.makeshop.podbbang.mobile.ui.home.HomeBottomNavLayout
import com.makeshop.podbbang.mobile.ui.home.HomeTabs
import com.makeshop.podbbang.mobile.ui.home.SideMenuScreen
import com.makeshop.podbbang.mobile.ui.theme.AppTheme
import com.makeshop.podbbang.shared.util.LineLog
import kotlinx.coroutines.launch

//@Composable
//fun DashBoardScreen(navigateTo: (route: String, haveStack : Boolean) -> Unit) {
////    val uiState = viewModel.uiState.collectAsState().value
////    val navController = rememberNavController
//    Log.d("TAG", "DashBoardScreen")
//    DashBoardScreenContainer(navigateTo)
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashBoardScreen(
    navigateTo: MainNavController,
    viewModel: DashBoardViewModel = viewModel(factory = DashBoardViewModel.provideFactory())
) {
    LineLog.d("DashBoardScreen")
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val drawerState = rememberDrawerState(androidx.compose.material3.DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    val deviceWidth = LocalConfiguration.current.screenWidthDp * 0.8

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        ModalNavigationDrawer(drawerContent = {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                ModalDrawerSheet(
                    modifier = Modifier.width(deviceWidth.dp)
                ) {
                    SideMenuScreen()
                }
            }
        }, content = {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                Scaffold(
                    topBar = {
                        TopAppBar(scrollBehavior = scrollBehavior,
                            title = { Text(text = "대시보드") },
                            actions = {
                                Icon(
                                    modifier = Modifier
                                        .size(24.dp, 24.dp)
                                        .clickable {
                                            coroutineScope.launch {
                                                drawerState.open()
                                            }
                                        },
                                    imageVector = ImageVector.vectorResource(id = R.drawable.icon_hambuger),
                                    contentDescription = "사이드메뉴",
                                    tint = Color.Unspecified
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                            },
                            navigationIcon = {

                            })
                    },
                    bottomBar = {
                        HomeBottomNavLayout(
                            tabs = HomeTabs.entries.toTypedArray(),
                            currentRoute = HomeTabs.DASHBOARD.route,
                            navigateTo = navigateTo::navigateToBottomBarRoute
                        )
                    },
                ) { paddingValues ->
                    WebViewScreen(
                        navigateTo, "DashBoardScreen", PodbbangApplication.WebUrl.HOME_DASHBOARD_TAB, paddingValues
                    )
//                    FloatBottomAnimationButton(paddingValues)
                }
            }
        })
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DashBoardScreenPreview() {
    val navController = rememberMainNavController()

    AppTheme {
        DashBoardScreen(navController)
    }
}