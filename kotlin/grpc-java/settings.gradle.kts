pluginManagement {
    repositories {
        gradlePluginPortal()

        maven {
            url = uri(extra["nexusMavenUrl"] as String)
        }
    }
}

rootProject.name = "java-grpc-idl-test"

include(
  "single-module"
)
