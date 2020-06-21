import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.72"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    // There is currently no Kotlin standard library that targets a JDK > 8
    implementation(kotlin("stdlib-jdk8"))

    // Unit testing
    val spekVersion = "2.0.11"
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spekVersion")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spekVersion")
    testImplementation("org.assertj:assertj-core:3.16.1")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "13"
        kotlinOptions.allWarningsAsErrors = true

        // Enable unsigned types, which are experimental in Kotlin 1.3
        kotlinOptions.freeCompilerArgs += "-Xuse-experimental=kotlin.ExperimentalUnsignedTypes"

        // Enable kotlin.time, which is experimental in Kotlin 1.3
        kotlinOptions.freeCompilerArgs += "-Xuse-experimental=kotlin.time.ExperimentalTime"

        // Enable inline classes, which are experimental in Kotlin 1.3
        kotlinOptions.freeCompilerArgs += "-Xinline-classes"
    }

    test {
        useJUnitPlatform {
            includeEngines("spek2")
        }
    }
}
