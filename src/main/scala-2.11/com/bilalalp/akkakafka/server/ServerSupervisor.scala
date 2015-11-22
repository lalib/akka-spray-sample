package com.bilalalp.akkakafka.server

import akka.actor.{Actor, ActorRefFactory}
import com.bilalalp.akkakafka.webservice.PersonWebService
import spray.routing.RejectionHandler.Default


class ServerSupervisor extends Actor with PersonWebService {

  implicit val system = context.system

  override def receive: Receive = runRoute(entityServiceRoutes)

  override implicit def actorRefFactory: ActorRefFactory = context
}