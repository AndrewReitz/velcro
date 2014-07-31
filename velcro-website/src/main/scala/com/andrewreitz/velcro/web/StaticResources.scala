package com.andrewreitz.velcro.web

import spray.http.StatusCodes
import spray.routing.HttpService

trait StaticResources extends HttpService {
  val staticResources = get {
    path("") {
      redirect("/index.html", StatusCodes.MovedPermanently)
    } ~
    path("favicon.ico") {
      complete(StatusCodes.NotFound)
    } ~
    path(Rest) {
      path => getFromResource("www/%s" format path)
    }
  }
}
