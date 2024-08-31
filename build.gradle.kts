import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val jvmMajorVersion: String by project
val jvmVersion = JavaVersion.toVersion(jvmMajorVersion)
val projectGroupId: String by project
val projectVersion: String by project

plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.allopen) apply false
    alias(libs.plugins.kotlin.spring) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.spring.boot) apply false
    alias(libs.plugins.spring.dependencies) apply false
    alias(libs.plugins.google.cloud.jib) apply false
    alias(libs.plugins.git.properties) apply false
}

allprojects {
    group = projectGroupId
    version = projectVersion
}

subprojects {
    configurations {
        all {
            exclude(group = "junit", module = "junit")
            exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        }
    }

    tasks {
        withType<JavaCompile> {
            options.encoding = "UTF-8"
            sourceCompatibility = jvmVersion.toString()
            targetCompatibility = jvmVersion.toString()
        }

        withType<KotlinCompile> {
            compilerOptions {
                jvmTarget.set(JvmTarget.fromTarget(jvmVersion.toString()))
                freeCompilerArgs.addAll("-Xjsr305=strict", "-Xcontext-receivers")
            }
        }

        withType<Test> {
            useJUnitPlatform()
        }
    }
}
