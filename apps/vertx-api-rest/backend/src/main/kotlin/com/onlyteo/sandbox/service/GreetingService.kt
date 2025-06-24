package com.onlyteo.sandbox.service

import com.onlyteo.sandbox.config.buildLogger
import com.onlyteo.sandbox.model.Greeting
import com.onlyteo.sandbox.model.Person
import com.onlyteo.sandbox.repository.PrefixRepository
import io.vertx.core.Future

class GreetingService(private val prefixRepository: PrefixRepository) {

    private val logger = buildLogger

    fun getGreeting(person: Person): Future<Greeting> {
        return prefixRepository.getPrefix()
            .map { prefix -> Greeting("${prefix.greeting} ${person.name}!") }
            .onSuccess { logger.info("Returning greeting to \"{}\"", person.name) }
    }
}