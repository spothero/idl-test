plugins {
    application
}

application {
    mainClassName = "thriftclient.Client"
}

dependencies {
    implementation(project(":model"))
}
