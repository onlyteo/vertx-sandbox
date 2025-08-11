package com.onlyteo.sandbox.context

import com.onlyteo.sandbox.config.loadProperties
import com.onlyteo.sandbox.properties.ApplicationProperties
import com.onlyteo.sandbox.properties.ApplicationPropertiesHolder
import com.onlyteo.sandbox.properties.ServerProperties
import com.onlyteo.sandbox.properties.ServerPropertiesHolder

data class ApplicationContext(
    val serverProperties: ServerProperties = loadProperties<ServerPropertiesHolder>().server,
    val applicationProperties: ApplicationProperties = loadProperties<ApplicationPropertiesHolder>().app
)
