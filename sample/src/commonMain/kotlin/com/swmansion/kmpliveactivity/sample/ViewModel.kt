package com.swmansion.kmpliveactivity.sample

import com.swmansion.kmpliveactivity.LiveActivityManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

internal object ViewModel {
  private val _state = MutableStateFlow((State()))

  val state: StateFlow<State> = _state

  fun start() {
    _state.update { state ->
      state.copy(
        contentState = state.newContentState,
        attributes = state.newAttributes,
        id =
          LiveActivityManager.start(
            state.newContentState.toLiveActivityContentState(),
            state.newAttributes.toLiveActivityAttributes(),
          ),
      )
    }
  }

  fun restart() {
    _state.update { state ->
      if (state.id != null && state.contentState != null) {
        LiveActivityManager.end(state.id, state.contentState.toLiveActivityContentState())
      }
      state.copy(
        contentState = state.newContentState,
        attributes = state.newAttributes,
        id =
          LiveActivityManager.start(
            state.newContentState.toLiveActivityContentState(),
            state.newAttributes.toLiveActivityAttributes(),
          ),
      )
    }
  }

  fun update() {
    _state.update { state ->
      if (state.id != null) {
        LiveActivityManager.update(state.id, state.newContentState.toLiveActivityContentState())
      }
      state.copy(contentState = state.newContentState)
    }
  }

  fun end() {
    _state.update { state ->
      if (state.id != null && state.contentState != null) {
        LiveActivityManager.end(state.id, state.contentState.toLiveActivityContentState())
      }
      state.copy(id = null, contentState = null)
    }
  }

  fun setTitle(title: String) {
    _state.update { it.copy(newContentState = it.newContentState.copy(title)) }
  }

  fun setSubtitle(subtitle: String) {
    _state.update { it.copy(newContentState = it.newContentState.copy(subtitle = subtitle)) }
  }

  fun setTimerDuration(duration: String) {
    _state.update { it.copy(newContentState = it.newContentState.copy(timerDuration = duration)) }
  }

  fun setBackgroundColor(color: String) {
    _state.update { state -> state.copy(newAttributes = state.newAttributes.copy(color)) }
  }

  fun setTitleColor(color: String) {
    _state.update { it.copy(newAttributes = it.newAttributes.copy(titleColor = color)) }
  }

  fun setSubtitleColor(color: String) {
    _state.update { it.copy(newAttributes = it.newAttributes.copy(subtitleColor = color)) }
  }

  fun setProgressViewTint(tint: String) {
    _state.update { it.copy(newAttributes = it.newAttributes.copy(progressViewTint = tint)) }
  }

  fun setProgressViewLabelColor(color: String) {
    _state.update { it.copy(newAttributes = it.newAttributes.copy(progressViewLabelColor = color)) }
  }

  fun setDeepLink(link: String) {
    _state.update { it.copy(newAttributes = it.newAttributes.copy(deepLink = link)) }
  }
}
