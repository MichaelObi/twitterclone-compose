package dev.michaelobi.twitterclone.ui.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.insets.LocalWindowInsets
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import dev.chrisbanes.accompanist.insets.toPaddingValues
import dev.michaelobi.twitterclone.R
import dev.michaelobi.twitterclone.ui.theme.TwitterCloneTheme

@Composable
fun ExploreScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        SearchBar()
    }
}

@Composable
private fun SearchBar() {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.surface,
        contentPadding = LocalWindowInsets.current.systemBars.toPaddingValues(
            bottom = false,
            additionalHorizontal = 20.dp
        )
    ) {
        var searchText by remember { mutableStateOf("") }

        Image(
            painter = painterResource(id = R.drawable.avi_placeholder),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(32.dp)
                .align(Alignment.CenterVertically)
        )

        SearchTextField(
            value = searchText,
            onValueChange = { searchText = it },
            placeholder = { "Search Twitter" },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .weight(1f)
                .align(Alignment.CenterVertically)
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_explore_settings),
            contentDescription = "Search settings",
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}


@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: (() -> String)? = null
) {

    Surface(
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colors.background,
        modifier = modifier.height(32.dp)
    ) {
        Box(
            modifier = Modifier,
            contentAlignment = Alignment.CenterStart
        ) {

            BasicTextField(
                value = value,
                onValueChange = { onValueChange(it) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            // Placeholder
            if (value.isEmpty() && placeholder != null) {
                Text(
                    text = placeholder(),
                    modifier = Modifier.padding(horizontal = 17.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun ExploreScreenPreview() {
    TwitterCloneTheme {
        ProvideWindowInsets {
            ExploreScreen()
        }
    }
}