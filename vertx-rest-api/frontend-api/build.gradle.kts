val jvmMajorVersion: String by project
val jvmVersion = JavaVersion.toVersion(jvmMajorVersion)

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.allopen)
}

dependencies {
    implementation(libs.bundles.vertx.webapp)
    implementation(libs.vertx.web.client)
    implementation(libs.bundles.jackson)
    implementation(libs.bundles.logging)
    implementation(libs.bundles.hoplite)
    implementation(libs.bundles.webjars)
    testImplementation(libs.bundles.kotest)
    testImplementation(libs.mockk)
}
