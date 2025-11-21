package com.swmansion.kmpliveactivity.sample

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SampleApp() {
  val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
  val state by ViewModel.state.collectAsState()
  val layoutDirection = LocalLayoutDirection.current
  MaterialTheme(if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()) {
    Scaffold(
      modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
      topBar = {
        TopAppBar(title = { Text("KMP Live Activity") }, scrollBehavior = scrollBehavior)
      },
      bottomBar = {
        BottomAppBar(Modifier.imePadding()) {
          Row(
            Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
          ) {
            if (state.id == null) {
              Button(onClick = ViewModel::start, enabled = state.titleValid) { Text("Start") }
            } else {
              when {
                state.attributesChanged ->
                  Button(onClick = ViewModel::restart, enabled = state.titleValid) {
                    Text("Restart")
                  }
                state.contentStateChanged ->
                  Button(onClick = ViewModel::update, enabled = state.titleValid) { Text("Update") }
              }
              Button(ViewModel::end) { Text("End") }
            }
          }
        }
      },
    ) { padding ->
      LazyColumn(
        contentPadding =
          PaddingValues(
            padding.calculateStartPadding(layoutDirection) + 16.dp,
            padding.calculateTopPadding() + 8.dp,
            padding.calculateEndPadding(layoutDirection) + 16.dp,
            padding.calculateBottomPadding() + 16.dp,
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
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Title") },
            isError = !state.titleValid,
            singleLine = true,
          )
        }
        item {
          TextField(
            value = state.newContentState.subtitle,
            onValueChange = ViewModel::setSubtitle,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Subtitle") },
            singleLine = true,
          )
        }
        item {
          TextField(
            value = state.newContentState.timerDuration,
            onValueChange = ViewModel::setTimerDuration,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Timer duration") },
            placeholder = { Text("10s, 1h 30m") },
            singleLine = true,
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
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Background color") },
            prefix = { Text("#") },
            singleLine = true,
          )
        }
        item {
          TextField(
            value = state.newAttributes.titleColor,
            onValueChange = ViewModel::setTitleColor,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Title color") },
            prefix = { Text("#") },
            singleLine = true,
          )
        }
        item {
          TextField(
            value = state.newAttributes.subtitleColor,
            onValueChange = ViewModel::setSubtitleColor,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Subtitle color") },
            prefix = { Text("#") },
            singleLine = true,
          )
        }
        item {
          TextField(
            value = state.newAttributes.progressViewTint,
            onValueChange = ViewModel::setProgressViewTint,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Progress-view tint") },
            prefix = { Text("#") },
            singleLine = true,
          )
        }
        item {
          TextField(
            value = state.newAttributes.progressViewLabelColor,
            onValueChange = ViewModel::setProgressViewLabelColor,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Progress-view label color") },
            prefix = { Text("#") },
            singleLine = true,
          )
        }
        item {
          TextField(
            value = state.newAttributes.deepLink,
            onValueChange = ViewModel::setDeepLink,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Deep link") },
            singleLine = true,
          )
        }
      }
    }
  }
}
