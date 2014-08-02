package com.andrewreitz.velcro.web

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http

object Boot extends App {
  implicit val system = ActorSystem("on-spray-can")
  val service = system.actorOf(Props[WebServiceActor], "velcro-website-service")

  import com.typesafe.config._
  val conf = ConfigFactory.load()
  val serverPort = conf.getInt("spray.can.server.port")

  IO(Http) ! Http.Bind(service, interface = "0.0.0.0", port = serverPort)
}
