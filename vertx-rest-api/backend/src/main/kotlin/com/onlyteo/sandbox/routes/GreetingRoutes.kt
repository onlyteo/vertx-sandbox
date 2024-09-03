package com.onlyteo.sandbox.routes

import com.onlyteo.sandbox.config.buildLogger
import com.onlyteo.sandbox.model.Person
import com.onlyteo.sandbox.service.GreetingService
import io.vertx.core.json.Json
import io.vertx.ext.web.Router

fun Router.greetingRoutes(greetingService: GreetingService) {
    post("/api/greetings")
        .consumes("application/json")
        .produces("application/json")
        .handler { context ->
            val person = context.body().asPojo(Person::class.java)
            greetingService.getGreeting(person)
                .onSuccess { greeting ->
                    context.response().end(Json.encode(greeting))
                }
                .onFailure { throwable ->
                    buildLogger.error("Request failed", throwable)
                    context.response().setStatusCode(500).end()
                }
        }
}
