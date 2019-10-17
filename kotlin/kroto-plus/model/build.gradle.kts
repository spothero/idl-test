import com.google.protobuf.gradle.*

plugins {
  id("com.google.protobuf").version("0.8.8")
}

repositories {
  maven("https://plugins.gradle.org/m2/")
}

sourceSets{
  main {
    proto {
      srcDir("src/main/proto")
    }
  }
}

dependencies {
  implementation("io.grpc", "grpc-netty-shaded")
  implementation("io.grpc", "grpc-protobuf")
  implementation("io.grpc", "grpc-stub")

  implementation(platform("com.google.protobuf:protobuf-bom"))
  implementation("com.google.protobuf", "protobuf-java")
  implementation("javax.annotation", "javax.annotation-api")
}

protobuf {
  protoc {
    // The artifact spec for the Protobuf Compiler
    artifact = "com.google.protobuf:protoc:3.10.0"
  }
  plugins {
    // Optional: an artifact spec for a protoc plugin, with "grpc" as
    // the identifier, which can be referred to in the "plugins"
    // container of the "generateProtoTasks" closure.
    id("grpc") {
      artifact = "io.grpc:protoc-gen-grpc-java:1.24.0"
    }
  }
  generateProtoTasks {
    ofSourceSet("main").forEach {
      it.plugins {
        // Apply the "grpc" plugin whose spec is defined above, without options.
        id("grpc")
      }
    }
  }
}