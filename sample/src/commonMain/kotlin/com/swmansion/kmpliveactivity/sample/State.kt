package com.swmansion.kmpliveactivity.sample

import com.swmansion.kmpliveactivity.LiveActivityAttributes
import kotlin.time.Clock
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

internal data class State(
  val contentState: Attributes.ContentState? = null,
  val newContentState: Attributes.ContentState = Attributes.ContentState(),
  val attributes: Attributes = Attributes(),
  val newAttributes: Attributes = Attributes(),
  val id: String? = null,
) {
  val contentStateChanged = contentState != newContentState
  val attributesChanged = attributes != newAttributes
  val titleValid = newContentState.title.isNotEmpty()

  data class Attributes(
    val backgroundColor: String = "",
    val titleColor: String = "",
    val subtitleColor: String = "",
    val progressViewTint: String = "",
    val progressViewLabelColor: String = "",
    val deepLink: String = "",
  ) {
    fun toLiveActivityAttributes() =
      LiveActivityAttributes(
        backgroundColor.takeIf(String::isNotEmpty),
        titleColor.takeIf(String::isNotEmpty),
        subtitleColor.takeIf(String::isNotEmpty),
        progressViewTint.takeIf(String::isNotEmpty),
        progressViewLabelColor.takeIf(String::isNotEmpty),
        deepLink.takeIf(String::isNotEmpty),
      )

    data class ContentState(
      val title: String = "Title",
      val subtitle: String = "Subtitle",
      val timerDuration: String = "1m",
    ) {
      fun toLiveActivityContentState() =
        LiveActivityAttributes.ContentState(
          title,
          subtitle.takeIf(String::isNotEmpty),
          @OptIn(ExperimentalTime::class)
          Duration.parseOrNull(timerDuration)?.let(Clock.System.now()::plus)?.toEpochMilliseconds(),
        )
    }
  }
}
