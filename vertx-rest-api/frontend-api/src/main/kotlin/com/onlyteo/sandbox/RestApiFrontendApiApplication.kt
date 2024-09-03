package com.onlyteo.sandbox

import com.onlyteo.sandbox.config.buildLogger
import com.onlyteo.sandbox.config.configureJackson
import com.onlyteo.sandbox.config.configureLogging
import com.onlyteo.sandbox.config.loadProperties
import com.onlyteo.sandbox.context.ApplicationContext
import com.onlyteo.sandbox.properties.ApplicationPropertiesHolder
import com.onlyteo.sandbox.properties.ServerPropertiesHolder
import com.onlyteo.sandbox.routes.createRouter
import com.onlyteo.sandbox.service.GreetingService
import io.vertx.core.AbstractVerticle
import io.vertx.core.Launcher
import io.vertx.ext.web.client.WebClient

fun main() {
    Launcher.executeCommand("run", MainVerticle::class.java.name)
}

class MainVerticle : AbstractVerticle() {

    private val logger = buildLogger

    override fun start() {
        val applicationProperties = loadProperties<ApplicationPropertiesHolder>().app
        with(ApplicationContext(applicationProperties)) {

            configureLogging()
            configureJackson()

            val webClient = WebClient.create(vertx)
            val greetingService = GreetingService(webClient)
            val router = vertx.createRouter(greetingService)

            val serverProperties = loadProperties<ServerPropertiesHolder>().server
            vertx.createHttpServer()
                .requestHandler(router)
                .listen(serverProperties.deployment.port)
                .onSuccess {
                    logger.info("HTTP server started on port ${it.actualPort()}")
                }
        }
    }
}
