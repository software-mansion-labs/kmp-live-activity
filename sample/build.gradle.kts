plugins {
  alias(libs.plugins.jetBrains.compose)
  alias(libs.plugins.jetBrains.kotlin.multiplatform)
  alias(libs.plugins.jetBrains.kotlin.plugin.compose)
}

kotlin {
  listOf(iosArm64(), iosSimulatorArm64()).forEach { target ->
    target.binaries.framework {
      baseName = "Framework"
      export(project(":lib"))
      isStatic = true
    }
  }
  sourceSets {
    commonMain.dependencies {
      api(project(":lib"))
      implementation(compose.material3)
      implementation(compose.materialIconsExtended)
    }
  }
}
