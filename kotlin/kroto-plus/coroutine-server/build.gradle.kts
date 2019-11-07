plugins {
    application
}

application {
    mainClassName = "com.spothero.grpcjava.server.ServerMainKt"
}

dependencies {
    implementation(project(":model"))
    implementation(project(":server-core"))
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core")
}
