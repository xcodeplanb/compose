package com.makeshop.podbbang.ui

import android.util.Log
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.makeshop.podbbang.ui.home.AudioBookScreen
import com.makeshop.podbbang.ui.home.DashBoardScreen
import com.makeshop.podbbang.ui.home.HomeTabs
import com.makeshop.podbbang.ui.home.MagazineScreen
import com.makeshop.podbbang.ui.home.MyScreen
import com.makeshop.podbbang.ui.home.ranking.RankingScreen
import com.makeshop.podbbang.ui.splash.SplashScreen

object MainDestinations {
    const val SPLASH = "splash"
    const val HOME = "home"
}

object HomeDestinations {
    const val DASHBOARD = "home/dashboard"
    const val RANKING = "home/ranking"
    const val MAGAZINE = "home/magazine"
    const val AUDIOBOOK = "home/audiobook"
    const val MY = "home/my"
}

@Composable
fun rememberMainNavController(
    navController: NavHostController = rememberNavController()
): MainNavController = remember(navController) {
    MainNavController(navController)
}

@Stable
class MainNavController(
    val navController: NavHostController
) {

    val currentRoute: String?
        get() = navController.currentDestination?.route

    fun navigateToBottomBarRoute(route: String) {

        if (route != currentRoute) {


            navController.navigate(route) {
                launchSingleTop = true
                restoreState = true
                // Pop up backstack to the first destination and save state. This makes going back
                // to the start destination when pressing back in any other bottom tab.
                currentRoute?.let {
                    popUpTo(it) {
                        saveState = true
                        inclusive = true
                    }
                }
            }
        }
    }
}


private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)

/**
 * Copied from similar function in NavigationUI.kt
 *
 * https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:navigation/navigation-ui/src/main/java/androidx/navigation/ui/NavigationUI.kt
 */
private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}

@Stable
class HomeNavController(
    val navController: NavHostController
) {

}

@Composable
fun PodbbangNavGraph(
    route: String,
    navController: MainNavController,
    navigateTo: (String) -> Unit
) {
    NavHost(
        navController = navController.navController,
        startDestination = route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }) {
        navigation(
            route = MainDestinations.HOME,
            startDestination = HomeTabs.DASHBOARD.route
        ) {
            composable(HomeTabs.DASHBOARD.route)
            {
                DashBoardScreen(navigateTo)
            }
            composable(HomeTabs.RANKING.route)
            {
                RankingScreen(navigateTo)
            }
            composable(HomeTabs.MAGAZINE.route)
            {
                MagazineScreen(navigateTo)
            }
            composable(HomeTabs.AUDIOBOOK.route)
            {
                AudioBookScreen(navigateTo)
            }
            composable(HomeTabs.MY.route)
            {
                MyScreen(navigateTo)
            }
        }
        composable(route = MainDestinations.SPLASH)
        {
            SplashScreen(navigateTo)
        }
    }
}