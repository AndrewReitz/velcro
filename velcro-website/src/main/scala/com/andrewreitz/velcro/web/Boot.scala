package com.andrewreitz.velcro.web

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http

object Boot extends App {
  implicit val system = ActorSystem("on-spray-can")
  val service = system.actorOf(Props[WebServiceActor], "velcro-website-service")


  IO(Http) ! Http.Bind(service, interface = "0.0.0.0", port = 8080)

  /**
   * Ensure that the constructed ActorSystem is shut down when the JVM shuts down
   */
  sys.addShutdownHook(system.shutdown())
}
