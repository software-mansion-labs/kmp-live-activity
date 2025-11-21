package com.swmansion.kmpliveactivity

/** Manages Live Activities. */
public object LiveActivityManager {
  private var nativeManager: NativeLiveActivityManager? = null

  /** @suppress */
  public fun bind(nativeManager: NativeLiveActivityManager) {
    this.nativeManager = nativeManager
  }

  /** Starts a Live Activity; returns its ID or, if starting failed, `null`. */
  public fun start(
    contentState: LiveActivityAttributes.ContentState,
    attributes: LiveActivityAttributes = LiveActivityAttributes(),
  ): String? =
    nativeManager?.startWith(
      contentState.title,
      contentState.subtitle,
      contentState.timerEnd?.toDouble() ?: -1.0,
      attributes.backgroundColor,
      attributes.titleColor,
      attributes.subtitleColor,
      attributes.progressViewTint,
      attributes.progressViewLabelColor,
      attributes.deepLink,
    )

  /** Updates the Live Activity with the given ID. */
  public fun update(id: String, contentState: LiveActivityAttributes.ContentState) {
    nativeManager?.updateWith(
      id,
      contentState.title,
      contentState.subtitle,
      contentState.timerEnd?.toDouble() ?: -1.0,
    )
  }

  /** Ends the Live Activity with the given ID. */
  public fun end(id: String, contentState: LiveActivityAttributes.ContentState) {
    nativeManager?.endWith(
      id,
      contentState.title,
      contentState.subtitle,
      contentState.timerEnd?.toDouble() ?: -1.0,
    )
  }
}
