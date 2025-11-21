package com.swmansion.kmpliveactivity.sample

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SampleApp() {
  val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
  val state by ViewModel.state.collectAsState()
  val layoutDirection = LocalLayoutDirection.current
  MaterialTheme(if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()) {
    Scaffold(scrollBehavior) { padding ->
      LazyColumn(
        contentPadding =
          PaddingValues(
            padding.calculateStartPadding(layoutDirection) + 16.dp,
            padding.calculateTopPadding() + 8.dp,
            padding.calculateEndPadding(layoutDirection) + 16.dp,
            padding.calculateBottomPadding() + 140.dp,
          ),
        verticalArrangement = Arrangement.spacedBy(16.dp),
      ) {
        item {
          Text(
            text = "Content state",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleSmall,
          )
        }
        item {
          TextField(
            value = state.newContentState.title,
            onValueChange = ViewModel::setTitle,
            label = "Title",
            hasError = !state.titleValid,
          )
        }
        item {
          TextField(
            value = state.newContentState.subtitle,
            onValueChange = ViewModel::setSubtitle,
            label = "Subtitle",
          )
        }
        item {
          TextField(
            value = state.newContentState.timerDuration,
            onValueChange = ViewModel::setTimerDuration,
            label = "Timer duration",
            placeholder = "10s, 1h 30m",
          )
        }
        item {
          Text(
            text = "Attributes",
            modifier = Modifier.padding(top = 8.dp),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleSmall,
          )
        }
        item {
          TextField(
            value = state.newAttributes.backgroundColor,
            onValueChange = ViewModel::setBackgroundColor,
            label = "Background color",
            prefix = "#",
          )
        }
        item {
          TextField(
            value = state.newAttributes.titleColor,
            onValueChange = ViewModel::setTitleColor,
            label = "Title color",
            prefix = "#",
          )
        }
        item {
          TextField(
            value = state.newAttributes.subtitleColor,
            onValueChange = ViewModel::setSubtitleColor,
            label = "Subtitle color",
            prefix = "#",
          )
        }
        item {
          TextField(
            value = state.newAttributes.progressViewTint,
            onValueChange = ViewModel::setProgressViewTint,
            label =
              buildAnnotatedString {
                withStyle(SpanStyle(fontFamily = FontFamily.Monospace)) { append("ProgressView") }
                append(" tint")
              },
            prefix = "#",
          )
        }
        item {
          TextField(
            value = state.newAttributes.progressViewLabelColor,
            onValueChange = ViewModel::setProgressViewLabelColor,
            label =
              buildAnnotatedString {
                withStyle(SpanStyle(fontFamily = FontFamily.Monospace)) { append("ProgressView") }
                append(" label color")
              },
            prefix = "#",
          )
        }
        item {
          TextField(
            value = state.newAttributes.deepLink,
            onValueChange = ViewModel::setDeepLink,
            label = "Deep link",
          )
        }
      }
    }
  }
}
