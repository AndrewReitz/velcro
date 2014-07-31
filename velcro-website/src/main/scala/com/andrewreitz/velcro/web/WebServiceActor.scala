package com.andrewreitz.velcro.web

import java.io.File
import java.util.concurrent.TimeUnit

import akka.actor.{Actor, Props}
import akka.pattern.ask
import akka.util.Timeout
import com.andrewreitz.velcro.web.CreateVelcroActor.{Create, Ok}
import spray.http._
import spray.routing._
import spray.httpx.marshalling._

class WebServiceActor extends Actor with VelcroGeneration with StaticResources {
  def actorRefFactory = context

  def receive = runRoute(generator ~ staticResources)
}

trait VelcroGeneration extends HttpService {

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

  implicit val timeout = Timeout(100, TimeUnit.SECONDS)

  val worker = actorRefFactory.actorOf(Props[CreateVelcroActor], "worker")

  val generator = post {
    path("generate") {
      formFields('groupId, 'appName, 'artifactId) { (groupId, appName, artifactId) =>
        val pi = new PackageInfo(appName, groupId, artifactId)
        doCreate(pi)
      }
    }
  }

  def doCreate(pi: PackageInfo) = {
    val response = (worker ? Create(pi))
      .mapTo[Ok]
      .map(result => result.zi)

    complete(response)
  }
}