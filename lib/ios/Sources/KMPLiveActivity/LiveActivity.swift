import ActivityKit
import ExpoLiveActivity
import SwiftUI
import WidgetKit

@available(iOS 16.1, *)
public struct LiveActivity: Widget {
  private let delegate = LiveActivityWidget()

  public var body: some WidgetConfiguration {
    delegate.body
  }

  public init() {}
}
