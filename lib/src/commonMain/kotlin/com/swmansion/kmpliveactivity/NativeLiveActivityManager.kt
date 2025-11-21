package com.swmansion.kmpliveactivity

/** @suppress */
public interface NativeLiveActivityManager {
  public fun startWith(
    title: String,
    subtitle: String?,
    timerEnd: Double,
    backgroundColor: String?,
    titleColor: String?,
    subtitleColor: String?,
    progressViewTint: String?,
    progressViewLabelColor: String?,
    deepLink: String?,
  ): String?

  public fun updateWith(id: String, title: String, subtitle: String?, timerEnd: Double)

  public fun endWith(id: String, title: String, subtitle: String?, timerEnd: Double)
}
