package com.swmansion.kmpliveactivity

/**
 * Stores immutable Live Activity properties.
 *
 * @param backgroundColor the background color (in hexadecimal format).
 * @param titleColor the title color (in hexadecimal format).
 * @param subtitleColor the subtitle color (in hexadecimal format).
 * @param progressViewTint the tint color of the timer `ProgressView` (in hexadecimal form).
 * @param progressViewLabelColor the label color of the timer `ProgressView` (in hexadecimal form).
 * @param deepLink navigated to when the Live Activity is tapped.
 */
public data class LiveActivityAttributes(
  internal val backgroundColor: String? = null,
  internal val titleColor: String? = null,
  internal val subtitleColor: String? = null,
  internal val progressViewTint: String? = null,
  internal val progressViewLabelColor: String? = null,
  internal val deepLink: String? = null,
) {
  /**
   * Stores mutable Live Activity properties.
   *
   * @param title the title.
   * @param subtitle the subtitle.
   * @param timerEnd the end time of the timer (in epoch milliseconds); `null` hides the timer.
   */
  public data class ContentState(
    internal val title: String,
    internal val subtitle: String? = null,
    internal val timerEnd: Long? = null,
  )
}
