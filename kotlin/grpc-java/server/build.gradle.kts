plugins {
    application
}

application {
    mainClassName = "com.spothero.grpcjava.server.ServerMainKt"
}

dependencies {
    implementation(project(":model"))
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core")
}
