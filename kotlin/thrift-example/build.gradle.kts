plugins {
    kotlin("jvm").version("1.3.50")
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
    dependencies {
        compile(kotlin("stdlib"))
        compile("org.apache.thrift:libthrift:0.12.0")

        // Used for logging
        compile("org.jetbrains.kotlin:kotlin-reflect")
        compile("ch.qos.logback:logback-core:1.2.3")
        compile("ch.qos.logback:logback-classic:1.2.3")
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
