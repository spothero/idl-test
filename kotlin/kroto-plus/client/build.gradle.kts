plugins {
    application
}

application {
    mainClassName = "com.spothero.grpcjava.client.ClientMainKt"
}

dependencies {
    implementation(project(":model"))
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core")
}
