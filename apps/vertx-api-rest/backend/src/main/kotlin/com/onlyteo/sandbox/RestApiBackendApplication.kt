package com.onlyteo.sandbox

import com.onlyteo.sandbox.config.buildLogger
import com.onlyteo.sandbox.config.configureJackson
import com.onlyteo.sandbox.config.configureLogging
import com.onlyteo.sandbox.context.ApplicationContext
import com.onlyteo.sandbox.routes.createRouter
import io.vertx.core.Future
import io.vertx.core.VerticleBase
import io.vertx.core.Vertx


fun main() {
    val applicationContext = ApplicationContext()
    Vertx.vertx()
        .deployVerticle(MainVerticle(applicationContext))
}

class MainVerticle(private val applicationContext: ApplicationContext) : VerticleBase() {

    private val logger = buildLogger

    override fun start(): Future<*> {
        with(applicationContext) {

            configureLogging()
            configureJackson()

            val router = vertx.createRouter(greetingService)

            return vertx.createHttpServer()
                .requestHandler(router)
                .listen(serverProperties.deployment.port)
                .onSuccess {
                    logger.info("HTTP server started on port ${it.actualPort()}")
                }
        }
    }
}
