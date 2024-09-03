package com.onlyteo.sandbox.service

import com.onlyteo.sandbox.config.buildLogger
import com.onlyteo.sandbox.context.ApplicationContext
import com.onlyteo.sandbox.model.Greeting
import com.onlyteo.sandbox.model.Person
import io.vertx.core.Future
import io.vertx.ext.web.client.WebClient

class GreetingService(private val webClient: WebClient) {

    private val logger = buildLogger

    context(ApplicationContext)
    fun getGreeting(person: Person): Future<Greeting> {
        logger.info("Fetching greeting for {}", person.name)
        return webClient.postAbs(properties.integrations.backend.url)
            .sendJson(person)
            .map { res -> res.bodyAsJson(Greeting::class.java) }
    }
}