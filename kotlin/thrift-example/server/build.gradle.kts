plugins {
    application
}

application {
    mainClassName = "thriftserver.Server"
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":model"))
}
