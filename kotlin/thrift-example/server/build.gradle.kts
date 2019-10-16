plugins {
    application
}

application {
    mainClassName = "thriftserver.Server"
}

dependencies {
    compile(kotlin("stdlib"))
    implementation(project(":model"))
}
