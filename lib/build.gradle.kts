group = "com.swmansion.kmpliveactivity"

version = "0.1.0"

plugins {
  alias(libs.plugins.jetBrains.dokka)
  alias(libs.plugins.jetBrains.kotlin.multiplatform)
  alias(libs.plugins.vanniktech.maven.publish)
}

kotlin {
  listOf(iosArm64(), iosSimulatorArm64()).forEach { target ->
    target.binaries.framework {
      baseName = "KMPLiveActivity"
      isStatic = true
    }
  }
  explicitApi()
}

dokka {
  moduleName = "kmp-live-activity"
  pluginsConfiguration.html.footerMessage = "© 2025 Software Mansion"
}

mavenPublishing {
  coordinates(artifactId = "kmp-live-activity")
  publishToMavenCentral()
  signAllPublications()
  pom {
    name = "KMP Live Activity"
    description = "Provides a Live Activity API for Kotlin Multiplatform."
    url = "https://github.com/software-mansion-labs/kmp-live-activity"
    licenses {
      license {
        name = "The MIT License"
        url = "http://www.opensource.org/licenses/mit-license.php"
      }
    }
    scm {
      connection = "scm:git:git://github.com/software-mansion-labs/kmp-live-activity.git"
      developerConnection = "scm:git:ssh://github.com/software-mansion-labs/kmp-live-activity.git"
      url = "https://github.com/software-mansion-labs/kmp-live-activity"
    }
    developers {
      developer {
        id = "patrickmichalik"
        name = "Patrick Michalik"
        email = "patrick.michalik@swmansion.com"
      }
    }
  }
}
