package com.onlyteo.sandbox.routes

import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.FaviconHandler
import io.vertx.ext.web.handler.StaticHandler

fun Router.staticRoutes() {
    //route("/").handler(FaviconHandler.)
    route("/").handler(StaticHandler.create("static"))
}
