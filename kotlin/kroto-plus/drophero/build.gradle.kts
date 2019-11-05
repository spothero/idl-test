plugins {
    application
}

application {
    mainClassName = "com.spothero.grpcjava.drophero.AppKt"
}

dependencies {
    implementation(project(":server-core"))
    implementation("com.spothero", "spothero-drophero", "0.5.2")
    implementation("io.github.msteinhoff:dropwizard-grpc:1.2.3-2")

    implementation(platform("com.fasterxml.jackson:jackson-bom:2.9.9"))
    implementation("com.fasterxml.jackson.module", "jackson-module-kotlin")
}

tasks.withType<JavaExec> {
    jvmArgs = listOf(
        "--add-opens",
        "java.base/java.lang=ALL-UNNAMED",
        "-Dlogback.configurationFile=logback-dev.xml",
        "-XX:+ExitOnOutOfMemoryError",
        "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5008"
    )
}
