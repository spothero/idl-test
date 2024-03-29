import com.spothero.gradle.java.SpotHeroJavaPlugin
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.spothero.java").version("0.5.1")
    kotlin("jvm").version("1.3.41")
    java
    idea
}

spothero {
    coverage {
        validateAfterTest = false
        // Your coverage should be around 0.90, but this application is too simple get
        // reasonable test coverage on.
        minimum = BigDecimal(0.82)
    }
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()

        maven {
            url = uri(extra["nexusMavenUrl"] as String)
        }
    }
}

subprojects {
    apply<KotlinPlatformJvmPlugin>()
    apply<SpotHeroJavaPlugin>()
    apply(plugin = "java")
    apply(plugin = "idea")

    // Dependencies ///////////////////////////////////////////////////////////

    dependencies {
        // Platform dependencies do not add any dependencies; they just define versions of
        // dependencies that you pull in.
        implementation(kotlin("stdlib-jdk8"))
        implementation("javax.inject", "javax.inject", "1")

        testImplementation("io.mockk", "mockk", "1.9.3")
        testImplementation("org.hamcrest", "hamcrest", "2.1")
        testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.3.2")

        testRuntimeOnly("org.junit.jupiter", "junit-jupiter-engine", "5.3.2")

        //Micronaut grpc includes grpc 1.19.0.  The latest 1.24 netty-shaded is not compatible
        val grpcVersion = "1.19.0"

        constraints {
            implementation("io.grpc", "grpc-netty-shaded", grpcVersion)
            implementation("io.grpc", "grpc-protobuf", grpcVersion)
            implementation("io.grpc", "grpc-stub", grpcVersion)

            implementation("com.github.marcoferrer.krotoplus", "kroto-plus-coroutines", "0.5.0")

            implementation(platform("com.google.protobuf:protobuf-bom:3.10.0"))
            implementation("com.google.protobuf", "protobuf-java")
            implementation("javax.annotation", "javax.annotation-api", "1.3.2")

            implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core", "1.1.1")

            implementation("org.apache.avro", "avro-protobuf", "1.9.1")
        }
    }

    tasks {
        compileJava {
            // Turn on additional compiler warnings for bad practices.
            options.compilerArgs = listOf("-Xlint", "-Xlint:-auxiliaryclass,-processing,-serial")
        }

        withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = listOf(
                    "-Xjsr305=strict", // Take full advantage of nullability annotations
                    "-Xjvm-default=enable" // Enable the declaration of Java default methods
                )
                jvmTarget = "12"
            }
        }

        test {
            useJUnitPlatform()

            testLogging {
                events("passed", "skipped", "failed")
            }
        }


        jacocoTestCoverageVerification {
            violationRules {
                // We're not that concerned about individual subprojects failing coverage.
                isFailOnViolation = false
            }
        }
    }
}

// Test Coverage /////////////////////////////////////////////////////

tasks {
    wrapper {
        gradleVersion = "5.5.1"
        // Ensures Gradle sources get downloaded as well
        distributionType = Wrapper.DistributionType.ALL
    }

    val mergeCoverage by registering(JacocoMerge::class) {
        executionData = project.fileTree(
            "dir" to ".",
            "include" to "**/build/jacoco/test.exec"
        )
    }

    jacocoTestReport {
        executionData.setFrom(mergeCoverage.get().executionData)
        sourceDirectories.setFrom(subprojects.map { it.sourceSets.main.get().allSource.srcDirs })
        additionalSourceDirs.setFrom(subprojects.map { it.sourceSets.main.get().allSource.srcDirs })
        classDirectories.setFrom(subprojects.map { it.sourceSets.main.get().output })

        reports {
            xml.isEnabled = true
        }
    }

    jacocoTestCoverageVerification {
        dependsOn(subprojects.map { it.tasks.jacocoTestCoverageVerification })

        val jacocoTestReport = jacocoTestReport.get()

        executionData.setFrom(jacocoTestReport.executionData)
        sourceDirectories.setFrom(jacocoTestReport.sourceDirectories)
        classDirectories.setFrom(jacocoTestReport.classDirectories)
    }
}

