package com.bilalalp.akkakafka.webservice

import akka.actor.Props
import akka.pattern.ask
import com.bilalalp.akkakafka.model.Person
import com.bilalalp.akkakafka.server.WebServiceTrait
import com.bilalalp.akkakafka.service.EntityServiceActor
import com.bilalalp.akkakafka.service.ServiceOperation.FIND_ALL
import org.json4s.DefaultFormats
import spray.httpx.Json4sSupport

trait PersonWebService extends WebServiceTrait with Json4sSupport {

  val json3sFormats = DefaultFormats

  val entityServiceWorker = actorRefFactory.actorOf(Props[EntityServiceActor], "entityServiceActor")

  val entityServiceRoutes = {
    pathPrefix("person") {
      pathEndOrSingleSlash {
        get(ctx => ctx.complete((entityServiceWorker ? FIND_ALL).mapTo[List[Person]]))
      }
    }
  }
}