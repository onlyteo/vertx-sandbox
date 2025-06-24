import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val jvmMajorVersion: String by project
val jvmVersion = JavaVersion.toVersion(jvmMajorVersion)

// PLUGINS
plugins {
    kotlin("jvm")
    kotlin("plugin.allopen")
}

// DEPENDENCIES
dependencies {
    implementation(libs.bundles.vertx.webapp)
    implementation(libs.bundles.jackson)
    implementation(libs.bundles.logging)
    implementation(libs.bundles.hoplite)
    implementation(libs.jackson.dataformat.csv)
    implementation(libs.bundles.webjars)
    testImplementation(libs.bundles.kotest)
    testImplementation(libs.mockk)
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    sourceCompatibility = jvmVersion.toString()
    targetCompatibility = jvmVersion.toString()
}

tasks.withType<KotlinCompile> {
    compilerOptions {
        jvmTarget.set(JvmTarget.fromTarget(jvmVersion.toString()))
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
