package com.swmansion.kmpliveactivity

/** @suppress */
public interface NativeLiveActivityManager {
  public fun startWith(
    title: String,
    subtitle: String?,
    timerEnd: Double,
    largeImage: String?,
    smallImage: String?,
    backgroundColor: String?,
    titleColor: String?,
    subtitleColor: String?,
    progressViewTint: String?,
    progressViewLabelColor: String?,
    deepLink: String?,
  ): String?

  public fun updateWith(
    id: String,
    title: String,
    subtitle: String?,
    timerEnd: Double,
    largeImage: String?,
    smallImage: String?,
  )

  public fun endWith(
    id: String,
    title: String,
    subtitle: String?,
    timerEnd: Double,
    largeImage: String?,
    smallImage: String?,
  )
}
