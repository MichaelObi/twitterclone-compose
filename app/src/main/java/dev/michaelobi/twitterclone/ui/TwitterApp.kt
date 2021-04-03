package dev.michaelobi.twitterclone.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import dev.chrisbanes.accompanist.insets.navigationBarsWithImePadding
import dev.michaelobi.twitterclone.R
import dev.michaelobi.twitterclone.ui.explore.ExploreScreen


@Composable
fun Twitter() {
    val navController = rememberNavController()
    val bottomNavigationScreens = listOf(
        NavScreen.Home,
        NavScreen.Explore,
        NavScreen.Notifications,
        NavScreen.Messages
    )
    Scaffold(
        bottomBar = { TwitterBottomNavigation(navController, bottomNavigationScreens, Modifier.fillMaxWidth()) },
        modifier = Modifier.fillMaxWidth()
    ) {
        MainNavigationConfig(navController)
    }
}

@Composable
fun TwitterBottomNavigation(
    navController: NavHostController,
    bottomNavigationScreens: List<NavScreen>,
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.surface,
        modifier = modifier
    ) {
        val currentRoute = currentRoute(navController)
        bottomNavigationScreens.forEach { screen ->
            val selected = currentRoute == screen.navRoute
            val iconRes = if (selected) {
                screen.focusedIconRes
            } else {
                screen.iconRes
            }
            BottomNavigationItem(
                selected = selected,
                icon = {
                    Icon(
                        painterResource(id = iconRes),
                        stringResource(id = screen.titleRes)
                    )
                },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = MaterialTheme.colors.onSurface,
                modifier = Modifier.navigationBarsWithImePadding(),
                onClick = {
                    if (!selected) {
                        navController.navigate(screen.navRoute)
                    }
                }
            )
        }
    }
}


sealed class NavScreen(
    val navRoute: String,
    @DrawableRes val iconRes: Int,
    @DrawableRes val focusedIconRes: Int,
    @StringRes val titleRes: Int
) {
    object Home : NavScreen(
        "home",
        R.drawable.ic_home,
        R.drawable.ic_home_focused,
        R.string.home
    )

    object Explore : NavScreen(
        "explore",
        R.drawable.ic_explore,
        R.drawable.ic_explore_focused,
        R.string.explore
    )

    object Notifications : NavScreen(
        "notifications",
        R.drawable.ic_notifications,
        R.drawable.ic_notifications_focused,
        R.string.notifications
    )

    object Messages : NavScreen(
        "messages",
        R.drawable.ic_messages,
        R.drawable.ic_messages_focused,
        R.string.messages
    )
}

@Composable
private fun MainNavigationConfig(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavScreen.Explore.navRoute) {
        composable(NavScreen.Explore.navRoute) { ExploreScreen() }
    }
}

@Composable
private fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
}