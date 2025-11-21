plugins { alias(libs.plugins.jetBrains.kotlin.multiplatform) }

kotlin {
  listOf(iosArm64(), iosSimulatorArm64()).forEach { iosTarget ->
    iosTarget.binaries.framework {
      baseName = "KMPLiveActivity"
      isStatic = true
    }
  }
}
