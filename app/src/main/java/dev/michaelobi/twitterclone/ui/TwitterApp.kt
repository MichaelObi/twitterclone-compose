package dev.michaelobi.twitterclone.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import dev.chrisbanes.accompanist.insets.navigationBarsWithImePadding
import dev.michaelobi.twitterclone.R


@Composable
fun Twitter() {
    Scaffold(
        bottomBar = { TwitterBottomNavigation(Modifier.fillMaxWidth()) },
        modifier = Modifier.fillMaxWidth()
    ) {
    }
}

@Composable
fun TwitterBottomNavigation(modifier: Modifier = Modifier) {
    val screens = listOf(
        NavScreen(R.drawable.ic_home, R.drawable.ic_home_focused, R.string.home),
        NavScreen(R.drawable.ic_explore, R.drawable.ic_explore_focused, R.string.explore),
        NavScreen(
            R.drawable.ic_notifications,
            R.drawable.ic_notifications_focused,
            R.string.notifications
        ),
        NavScreen(R.drawable.ic_messages, R.drawable.ic_messages_focused, R.string.messages),
    )

    Column(modifier = modifier) {
        BottomNavigation(
            backgroundColor = MaterialTheme.colors.surface
        ) {
            screens.forEachIndexed { index, screen ->
                val selected = index == 1
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
                    onClick = { /* Nothing for now */ }
                )
            }
        }
    }
}

data class NavScreen(
    @DrawableRes val iconRes: Int,
    @DrawableRes val focusedIconRes: Int,
    @StringRes val titleRes: Int
)