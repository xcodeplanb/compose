package com.makeshop.podbbang.mobile

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
import com.makeshop.podbbang.mobile.ui.home.audiobook.AudioBookScreen
import com.makeshop.podbbang.mobile.ui.home.commuity.CommunityScreen
import com.makeshop.podbbang.mobile.ui.home.mediaplayer.MediaItemScreen
import com.makeshop.podbbang.mobile.ui.home.dashboard.DashBoardScreen
import com.makeshop.podbbang.mobile.ui.home.magazine.MagazineScreen
import com.makeshop.podbbang.mobile.ui.home.ranking.RankingScreen
import com.makeshop.podbbang.shared.util.LineLog

object MainDestinations {
    const val SPLASH = "splash"
    const val HOME = "home"
}

object HomeDestinations {
    const val DASHBOARD = "dashboard"
    const val RANKING = "ranking"
    const val MAGAZINE = "magazine"
    const val AUDIOBOOK = "audiobook"
    const val COMMUNITY = "community"
    const val MEDIA = "media"
}

object MediaDestinations {
    const val MEDIALIST = "medialist"
    const val MEDIADETAIL = "mediadetail"
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

    private val currentRoute: String?
        get() = navController.currentDestination?.route

    fun navigateToBottomBarRoute(route: String) {
        if (route != currentRoute) {
            navController.navigate(route) {
                launchSingleTop = false
                restoreState = true
                // Pop up backstack to the first destination and save state. This makes going back
                // to the start destination when pressing back in any other bottom tab.
                currentRoute?.let {
                    if (route != MediaDestinations.MEDIADETAIL) {
                        popUpTo(findStartDestination(navController.graph).id) {
                            saveState = true
                        }
                    }
                }
            }
        } else {
            LineLog.d("route == currentRoute}")
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
    mainActivityViewModel: MainActivityViewModel,
    route: String,
    navController: MainNavController,
    navigateTo: (String) -> Unit
) {
    NavHost(navController = navController.navController,
        startDestination = route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }) {

        composable(HomeDestinations.DASHBOARD) {
            DashBoardScreen(navController)
        }
        composable(HomeDestinations.RANKING) {
            RankingScreen(navigateTo)
        }
        composable(HomeDestinations.MAGAZINE) {
            MagazineScreen(navController)
        }
        composable(HomeDestinations.AUDIOBOOK) {
            AudioBookScreen(navigateTo)
        }
        composable(HomeDestinations.COMMUNITY) {
            CommunityScreen(navController)
        }
        navigation(
            route = HomeDestinations.MEDIA, startDestination = MediaDestinations.MEDIALIST
        ) {
            composable(MediaDestinations.MEDIALIST) {
                MediaItemScreen("/", mainActivityViewModel, navigateTo)
            }

            composable(MediaDestinations.MEDIADETAIL) {
                MediaItemScreen("[albumID]", mainActivityViewModel, navigateTo)
            }
        }
    }
}