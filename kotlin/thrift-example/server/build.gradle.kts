plugins {
    application
}

application {
    mainClassName = "thriftexample.Server"
}

dependencies {
    compile(kotlin("stdlib"))
    implementation(project(":model"))
}
