package com.onlyteo.sandbox.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory

fun configureLogging() {
    val logFactory = System.getProperty(
        "org.vertx.logger-delegate-factory-class-name",
        "io.vertx.core.logging.SLF4JLogDelegateFactory"
    )
    System.setProperty("org.vertx.logger-delegate-factory-class-name", logFactory)
}

inline val <reified T> T.buildLogger: Logger get() = LoggerFactory.getLogger(T::class.java)