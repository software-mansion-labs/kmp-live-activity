package com.swmansion.kmpliveactivity.sample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Stop
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun Scaffold(
  scrollBehavior: TopAppBarScrollBehavior,
  content: @Composable (PaddingValues) -> Unit,
) {
  val state by ViewModel.state.collectAsState()
  Scaffold(
    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = { TopAppBar(title = { Text("KMP Live Activity") }, scrollBehavior = scrollBehavior) },
    floatingActionButton = {
      Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
      ) {
        if (
          state.id != null &&
            (state.attributesChanged || state.contentStateChanged) &&
            state.titleValid
        ) {
          SmallFloatingActionButton(ViewModel::end) {
            Icon(imageVector = Icons.Rounded.Stop, contentDescription = null)
          }
        }
        if (state.id != null || state.titleValid) {
          FloatingActionButton(
            onClick =
              when {
                state.id == null -> ViewModel::start
                !state.titleValid -> ViewModel::end
                state.attributesChanged -> ViewModel::restart
                state.contentStateChanged -> ViewModel::update
                else -> ViewModel::end
              }
          ) {
            Icon(
              imageVector =
                when {
                  state.id == null -> Icons.Rounded.PlayArrow
                  !state.titleValid -> Icons.Rounded.Stop
                  state.attributesChanged || state.contentStateChanged -> Icons.Rounded.Check
                  else -> Icons.Rounded.Stop
                },
              contentDescription = null,
            )
          }
        }
      }
    },
    contentWindowInsets = WindowInsets.safeDrawing,
    content = content,
  )
}
