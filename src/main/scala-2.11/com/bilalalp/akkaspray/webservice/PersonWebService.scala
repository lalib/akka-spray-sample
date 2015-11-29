package com.bilalalp.akkaspray.webservice

import akka.actor.Props
import akka.pattern.ask
import com.bilalalp.akkaspray.model.Person
import com.bilalalp.akkaspray.server.WebServiceTrait
import com.bilalalp.akkaspray.service.EntityServiceActor
import com.bilalalp.akkaspray.service.ServiceOperation.FIND_ALL
import org.json4s.DefaultFormats
import spray.httpx.Json4sSupport

import scala.concurrent.Future

trait PersonWebService extends WebServiceTrait with Json4sSupport {

  val json3sFormats = DefaultFormats

  val entityServiceWorker = actorRefFactory.actorOf(Props[EntityServiceActor], "entityServiceActor")

  val entityServiceRoutes = {
    pathPrefix("person") {
      pathEndOrSingleSlash {
        get {
          complete {
            (entityServiceWorker ? FIND_ALL).mapTo[Future[List[Person]]]
          }
        }
      }
    }
  }
}