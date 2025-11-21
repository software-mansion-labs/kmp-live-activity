import ActivityKit
import ExpoLiveActivity
import Foundation

@available(iOS 16.2, *)
public class NativeLiveActivityManagerImpl {
  public static let shared = NativeLiveActivityManagerImpl()

  private init() {}

  @objc
  public func startWith(
    title: String,
    subtitle: String?,
    timerEnd: Double,
    backgroundColor: String?,
    titleColor: String?,
    subtitleColor: String?,
    progressViewTint: String?,
    progressViewLabelColor: String?,
    deepLink: String?
  ) -> String? {
    do {
      return try Activity.request(
        attributes: LiveActivityAttributes(
          name: "",
          backgroundColor: backgroundColor,
          titleColor: titleColor,
          subtitleColor: subtitleColor,
          progressViewTint: progressViewTint,
          progressViewLabelColor: progressViewLabelColor,
          deepLinkUrl: deepLink
        ),
        content: .init(
          state: LiveActivityAttributes.ContentState(
            title: title,
            subtitle: subtitle,
            timerEndDateInMilliseconds: timerEnd >= 0 ? timerEnd : nil
          ),
          staleDate: nil
        ),
        pushType: nil
      ).id
    } catch {
      return nil
    }
  }

  @objc
  public func updateWith(id: String, title: String, subtitle: String?, timerEnd: Double) {
    Task {
      await Activity<LiveActivityAttributes>.activities
        .first(where: { $0.id == id })?
        .update(
          ActivityContent(
            state: LiveActivityAttributes.ContentState(
              title: title,
              subtitle: subtitle,
              timerEndDateInMilliseconds: timerEnd >= 0 ? timerEnd : nil
            ),
            staleDate: nil
          )
        )
    }
  }

  @objc
  public func endWith(id: String, title: String, subtitle: String?, timerEnd: Double) {
    Task {
      await Activity<LiveActivityAttributes>.activities
        .first(where: { $0.id == id })?
        .end(
          ActivityContent(
            state: LiveActivityAttributes.ContentState(
              title: title,
              subtitle: subtitle,
              timerEndDateInMilliseconds: timerEnd >= 0 ? timerEnd : nil
            ),
            staleDate: nil
          ),
          dismissalPolicy: .immediate
        )
    }
  }
}
