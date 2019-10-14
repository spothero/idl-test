plugins {
    application
}

application {
    mainClassName = "com.spothero.grpcjava.client.ClientMainKt"
}

dependencies {
    implementation(project(":model"))
    implementation(platform("com.google.protobuf:protobuf-bom:3.10.0"))
    implementation("com.google.protobuf", "protobuf-java")
    implementation("io.grpc", "grpc-stub", "1.24.0")
}
