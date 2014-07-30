package com.andrewreitz.velcro.web

import akka.actor.Actor
import spray.routing.HttpService

class WebServiceActor extends Actor with VelcroGeneration with StaticResources {
  def actorRefFactory = context
  def receive = runRoute(generator ~ staticResources)
}

// this trait defines our service behavior independently from the service actor
trait VelcroGeneration extends HttpService {
    val generator = post {
      path("form") {
        formFields('groupId, 'appName, 'artifactId) { (groupId, appName, artifactId) =>
          complete {
            s"groupId: $groupId, appName: $appName, artifactId: $artifactId"
          }
        }
      }
    }

//  def largeTempFile(): File = {
//    val tempDir: Path = Files.createTempDirectory(null)
//    tempDir.toFile.deleteOnExit()
//    //Process( """mvn archetype:generate -B -DarchetypeArtifactId=velcro -DarchetypeGroupId=com.andrewreitz.velcro -DarchetypeVersion=2.1.0 -DgroupId=com.exemple -DartifactId=test -DapplicationName=Test -Dversion=1.0""", tempDir.toFile).run(connectInput = false).exitValue()
//
//    val file = File.createTempFile("streamingTest", ".txt")
//    FileUtils.writeAllText((1 to 1000) map ("This is line " + _) mkString "\n", file)
//    file.deleteOnExit()
//    file
//  }
}