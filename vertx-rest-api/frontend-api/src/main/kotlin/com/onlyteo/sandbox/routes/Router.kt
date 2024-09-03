package com.onlyteo.sandbox.routes

import com.onlyteo.sandbox.context.ApplicationContext
import com.onlyteo.sandbox.service.GreetingService
import io.vertx.core.Vertx
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.BodyHandler

context(ApplicationContext)
fun Vertx.createRouter(greetingService: GreetingService): Router {
    val router = Router.router(this)
    router.staticRoutes()
    router.route("/api/*").handler(BodyHandler.create())
    router.greetingRoutes(greetingService)
    return router
}