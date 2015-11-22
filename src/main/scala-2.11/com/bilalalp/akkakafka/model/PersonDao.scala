package com.bilalalp.akkakafka.model

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

case class Person(id: Int, name: String, surname: String)

object PersonDao {

  def getAll: Future[List[Person]] = Future[List[Person]] {
    List[Person](Person(1, "Bilal", "Alp"), Person(2, "Ahmet", "Alp"))
  }
}