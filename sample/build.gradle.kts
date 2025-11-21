plugins {
  alias(libs.plugins.jetBrains.compose)
  alias(libs.plugins.jetBrains.kotlin.multiplatform)
  alias(libs.plugins.jetBrains.kotlin.plugin.compose)
}

kotlin {
  listOf(iosArm64(), iosSimulatorArm64()).forEach { iosTarget ->
    iosTarget.binaries.framework {
      baseName = "Sample"
      isStatic = true
    }
  }
  sourceSets {
    commonMain.dependencies {
      implementation(compose.components.resources)
      implementation(compose.components.uiToolingPreview)
      implementation(compose.foundation)
      implementation(compose.material3)
      implementation(compose.runtime)
      implementation(compose.ui)
      implementation(libs.jetBrains.androidX.lifecycle.runtimeCompose)
      implementation(libs.jetBrains.androidX.lifecycle.viewmodelCompose)
    }
  }
}
