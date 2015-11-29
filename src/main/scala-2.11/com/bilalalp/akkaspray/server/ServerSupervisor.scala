package com.bilalalp.akkaspray.server

import akka.actor.{Actor, ActorRefFactory}
import com.bilalalp.akkaspray.webservice.PersonWebService
import spray.routing.RejectionHandler.Default


class ServerSupervisor extends Actor with PersonWebService {

  implicit val system = context.system

  override def receive: Receive = runRoute(entityServiceRoutes)

  override implicit def actorRefFactory: ActorRefFactory = context
}