plugins {
    kotlin("jvm").version("1.3.50")
    id("org.jlleitschuh.gradle.ktlint") version "9.0.0"
    java
    idea // IntelliJ Plugin
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
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    dependencies {
        implementation(kotlin("stdlib"))
        implementation("org.apache.thrift:libthrift:0.12.0")

        // Used for logging
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("ch.qos.logback:logback-core:1.2.3")
        implementation("ch.qos.logback:logback-classic:1.2.3")
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
