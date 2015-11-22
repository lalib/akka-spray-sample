package com.bilalalp.akkakafka

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.io.IO
import com.bilalalp.akkakafka.server.ServerSupervisor
import spray.can.Http


object Application extends App {

  implicit val system = ActorSystem("actorSystem")

  val mainHandler: ActorRef = system.actorOf(Props[ServerSupervisor])
  IO(Http)! Http.Bind(mainHandler, interface = Configuration.appInterface, port = Configuration.appPort)

}