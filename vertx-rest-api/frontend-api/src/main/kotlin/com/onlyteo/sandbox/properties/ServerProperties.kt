package com.onlyteo.sandbox.properties

data class ServerPropertiesHolder(val server: ServerProperties)

data class ServerProperties(val deployment: DeploymentProperties)

data class DeploymentProperties(val host: String, val port: Int)
