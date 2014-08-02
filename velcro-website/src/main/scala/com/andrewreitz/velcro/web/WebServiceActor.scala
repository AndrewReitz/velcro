package com.andrewreitz.velcro.web

import java.util.concurrent.TimeUnit

import akka.actor.{Actor, Props}
import akka.pattern.ask
import akka.util.Timeout
import com.andrewreitz.velcro.web.CreateVelcroActor.{Create, Ok}
import spray.http._
import spray.httpx.marshalling._
import spray.routing._

class WebServiceActor extends Actor with VelcroGeneration with StaticResources {
  def actorRefFactory = context

  def receive = runRoute(generator ~ staticResources)
}

trait VelcroGeneration extends HttpService {

  /** Tells the complete method how to marshall the ZipInfo object */
  implicit val zipFileMarshaller: ToResponseMarshaller[ZipInfo] =
    ToResponseMarshaller.of(MediaTypes.`application/zip`) { (zi: ZipInfo, _, ctx) =>
      ctx.marshalTo(
        HttpResponse(
          StatusCodes.OK,
          HttpData(zi.file),
          List(HttpHeaders.`Content-Disposition`("attachment", Map("filename" -> s"${zi.name}.zip")))
        )
      )
    }

  implicit def executionContext = actorRefFactory.dispatcher

  implicit val timeout = Timeout(2, TimeUnit.MINUTES)

  val worker = actorRefFactory.actorOf(Props[CreateVelcroActor], "worker")

  val generator = post {
    path("generate") {
      formFields('groupId, 'appName) { (groupId: String, appName: String) =>
        val applicationName = appName.replace("-", " ").replaceAll("[^a-zA-Z0-9]", "")
          .split(" ").map(x => x.charAt(0).toUpper + x.substring(1)).mkString

        val pi = new PackageInfo(applicationName, groupId, applicationName)
        doCreate(pi)
      }
    }
  }

  /**
   * Creates the zip file of the maven project in a separate actor
   */
  def doCreate(pi: PackageInfo) = {
    val response = (worker ? Create(pi))
      .mapTo[Ok]
      .map(result => result.zi)

    complete(response)
  }
}