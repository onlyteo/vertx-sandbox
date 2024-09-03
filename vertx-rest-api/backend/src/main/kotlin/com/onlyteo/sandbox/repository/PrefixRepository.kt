package com.onlyteo.sandbox.repository

import com.onlyteo.sandbox.config.readCsvFile
import com.onlyteo.sandbox.model.Prefix
import io.vertx.core.Future
import kotlin.random.Random

class PrefixRepository(private val prefixes: List<Prefix>) {
    constructor(prefixesFile: String) : this(readCsvFile(prefixesFile))

    fun getPrefix(): Future<Prefix> {
        return Future.succeededFuture(Random.nextInt(prefixes.size))
            .map { index -> prefixes[index] }
    }
}