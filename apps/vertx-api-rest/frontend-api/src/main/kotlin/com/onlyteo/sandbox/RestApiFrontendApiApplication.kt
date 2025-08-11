package com.onlyteo.sandbox

import com.onlyteo.sandbox.config.buildLogger
import com.onlyteo.sandbox.config.configureJackson
import com.onlyteo.sandbox.config.configureLogging
import com.onlyteo.sandbox.context.ApplicationContext
import com.onlyteo.sandbox.routes.createRouter
import com.onlyteo.sandbox.service.GreetingService
import io.vertx.core.AbstractVerticle
import io.vertx.core.Vertx
import io.vertx.ext.web.client.WebClient

fun main() {
    val applicationContext = ApplicationContext()
    Vertx.vertx()
        .deployVerticle(MainVerticle(applicationContext))
}

class MainVerticle(private val applicationContext: ApplicationContext) : AbstractVerticle() {

    private val logger = buildLogger

    override fun start() {
        with(applicationContext) {

            configureLogging()
            configureJackson()

            val webClient = WebClient.create(vertx)
            val greetingService = GreetingService(applicationProperties, webClient)
            val router = vertx.createRouter(greetingService)

            vertx.createHttpServer()
                .requestHandler(router)
                .listen(serverProperties.deployment.port)
                .onSuccess {
                    logger.info("HTTP server started on port ${it.actualPort()}")
                }
        }
    }
}
