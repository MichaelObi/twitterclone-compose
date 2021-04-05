package dev.michaelobi.twitterclone.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.michaelobi.twitterclone.ui.theme.SectionDividerColor

@Composable
fun SectionDivider() {
    Divider(color = SectionDividerColor, thickness = 0.33.dp,modifier = Modifier.fillMaxWidth())
}