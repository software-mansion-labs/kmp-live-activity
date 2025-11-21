import Framework
import KMPLiveActivity
import SwiftUI

extension NativeLiveActivityManagerImpl: @retroactive NativeLiveActivityManager {}

@main
struct SampleApp: App {
  var body: some Scene {
    WindowGroup {
      ComposeView().ignoresSafeArea()
    }
  }

  init() {
    LiveActivityManager.shared.bind(nativeManager: NativeLiveActivityManagerImpl.shared)
  }
}
