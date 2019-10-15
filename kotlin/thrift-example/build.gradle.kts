plugins {
    kotlin("jvm").version("1.3.50")
    java
}

version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "java")
    dependencies {
        compile(kotlin("stdlib"))
        compile("org.apache.thrift", "libthrift", "0.12.0")
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
