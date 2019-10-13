pluginManagement {
  repositories {
    gradlePluginPortal()

    maven {
      url = uri(extra["nexusMavenUrl"] as String)
    }
  }
}

rootProject.name = "grpc-java"

include(
  ":client",
  ":model",
  ":server"
)
