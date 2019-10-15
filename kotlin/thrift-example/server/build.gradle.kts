plugins {
    application
}

application {
    mainClassName = "thriftexample.ServerKt"
}

dependencies {
    compile(kotlin("stdlib"))
    implementation(project(":model"))
}
