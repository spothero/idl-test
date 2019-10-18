pluginManagement {
  repositories {
    gradlePluginPortal()

    maven {
      url = uri(extra["nexusMavenUrl"] as String)
    }
  }
}

rootProject.name = "kroto-plus"

include(
  ":client",
  ":model",
  ":server"
)
