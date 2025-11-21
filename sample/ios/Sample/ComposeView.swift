import Framework
import SwiftUI
import UIKit

struct ComposeView: UIViewControllerRepresentable {
  func makeUIViewController(context _: Context) -> UIViewController {
    ViewControllerKt.ViewController()
  }

  func updateUIViewController(_: UIViewController, context _: Context) {}
}
