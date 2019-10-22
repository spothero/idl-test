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
  ":model",
  ":client",
  ":server",
  ":coroutine-client",
  ":coroutine-server",
  ":micronaut-grpc"
)
