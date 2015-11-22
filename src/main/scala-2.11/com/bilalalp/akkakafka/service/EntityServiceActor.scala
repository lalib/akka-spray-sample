package com.bilalalp.akkakafka.service

import akka.actor.Actor
import akka.pattern.pipe
import com.bilalalp.akkakafka.model.PersonDao
import com.bilalalp.akkakafka.service.ServiceOperation.FIND_ALL

import scala.concurrent.ExecutionContext.Implicits.global

object ServiceOperation {

  case object FIND_ALL

}

class EntityServiceActor extends Actor {

  override def receive: Receive = {

    case FIND_ALL =>
      sender ! PersonDao.getAll
        .recover({ case err => List() })
        .pipeTo(sender)
  }
}