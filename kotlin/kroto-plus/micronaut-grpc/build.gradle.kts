plugins {
  kotlin("kapt")
  kotlin("jvm")
  id("org.jetbrains.kotlin.plugin.allopen").version("1.3.50")
  id("com.github.johnrengelman.shadow").version("5.0.0")
  application
}

application {
  mainClassName = "com.spothero.krotoplus.micronautgrpc.Application"
}

allOpen {
  annotation("io.micronaut.aop.Around")
}

dependencies {
  val micronautVersion = "1.2.1"
  val kotlinVersion = "1.3.41"


  implementation(project(":model"))
  implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core")

  //Adds support for HTTP on 8080 along with GRPC on 50051
  implementation("io.micronaut:micronaut-http-server-netty")

  implementation(platform("io.micronaut:micronaut-bom:$micronautVersion"))
  implementation("io.micronaut.grpc:micronaut-grpc-runtime")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
  implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
  implementation("io.micronaut:micronaut-runtime")
  implementation("javax.annotation:javax.annotation-api")
  kapt(platform("io.micronaut:micronaut-bom:$micronautVersion"))
  kapt("io.micronaut:micronaut-inject-java")
  kapt("io.micronaut:micronaut-validation")
  kaptTest(platform("io.micronaut:micronaut-bom:$micronautVersion"))
  kaptTest("io.micronaut:micronaut-inject-java")
  runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")
  runtimeOnly("ch.qos.logback:logback-classic:1.2.3")
  testImplementation(platform("io.micronaut:micronaut-bom:$micronautVersion"))
  testImplementation("io.micronaut.test:micronaut-test-kotlintest")
  testImplementation("io.mockk:mockk:1.9.3")
  testImplementation("io.kotlintest:kotlintest-runner-junit5:3.3.2")
}

/*

test.classpath += configurations.developmentOnly

mainClassName = "helloworld.Application"

test {
    useJUnitPlatform()
}

shadowJar {
    mergeServiceFiles()
}

run.classpath += configurations.developmentOnly
run.jvmArgs('-noverify', '-XX:TieredStopAtLevel=1', '-Dcom.sun.management.jmxremote')

maven { url "https://jcenter.bintray.com" }

configurations {
    // for dependencies that are needed for development only
    developmentOnly
}
 */
