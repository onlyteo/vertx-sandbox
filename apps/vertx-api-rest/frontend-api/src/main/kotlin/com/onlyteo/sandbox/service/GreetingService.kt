package com.onlyteo.sandbox.service

import com.onlyteo.sandbox.config.buildLogger
import com.onlyteo.sandbox.model.Greeting
import com.onlyteo.sandbox.model.Person
import com.onlyteo.sandbox.properties.ApplicationProperties
import io.vertx.core.Future
import io.vertx.ext.web.client.WebClient

class GreetingService(
    private val applicationProperties: ApplicationProperties,
    private val webClient: WebClient
) {
    private val logger = buildLogger

    fun getGreeting(person: Person): Future<Greeting> {
        with(applicationProperties) {
            logger.info("Fetching greeting for {}", person.name)
            return webClient.postAbs(integrations.backend.url)
                .sendJson(person)
                .map { res -> res.bodyAsJson(Greeting::class.java) }
        }
    }
}