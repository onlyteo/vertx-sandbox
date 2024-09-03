package com.onlyteo.sandbox.config

import com.sksamuel.hoplite.ConfigLoaderBuilder
import com.sksamuel.hoplite.addResourceSource
import com.sksamuel.hoplite.env.Environment

fun currentEnvironment(): Environment {
    val developmentFlag = System.getProperty("io.vertx.development")
    if (developmentFlag == "true") {
        return Environment.development
    }
    return Environment.fromEnvVar("VERTX_ENV", Environment.development)
}

inline fun <reified T : Any> loadProperties(): T {
    val environment = currentEnvironment()
    return ConfigLoaderBuilder.default()
        .addResourceSource("/application.yaml")
        .addResourceSource("/application-${environment.name}.yaml")
        .build()
        .loadConfigOrThrow<T>()
}
