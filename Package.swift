// swift-tools-version: 5.10

import PackageDescription

let package = Package(
  name: "KMPLiveActivity",
  platforms: [.iOS(.v16)],
  products: [.library(name: "KMPLiveActivity", targets: ["KMPLiveActivity"])],
  dependencies: [
    .package(
      url: "https://github.com/software-mansion-labs/expo-live-activity.git",
      revision: "9979cee"
    ),
  ],
  targets: [
    .target(
      name: "KMPLiveActivity",
      dependencies: [.product(name: "ExpoLiveActivity", package: "expo-live-activity")],
      path: "lib/ios/Sources/KMPLiveActivity"
    ),
  ]
)
