package com.bilalalp.akkakafka.server

import akka.util.Timeout

import spray.routing.HttpService

import scala.concurrent.duration._
import scala.language.postfixOps

import org.json4s.NoTypeHints
import org.json4s.native.Serialization._

trait WebServiceTrait extends HttpService {

  implicit def executionContext = actorRefFactory.dispatcher

  implicit val json4sFormats = formats(NoTypeHints)

  implicit val timeout = Timeout(120 seconds)
}