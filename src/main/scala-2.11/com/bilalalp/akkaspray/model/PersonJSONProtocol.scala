package com.bilalalp.akkaspray.model

import spray.json._

object PersonJSONProtocol extends DefaultJsonProtocol {

  implicit object PersonJsonFormat extends RootJsonFormat[Person] {
    def write(t: Person) = JsObject(
      "id" -> JsNumber(t.id),
      "name" -> JsString(t.name),
      "surname" -> JsString(t.surname)
    )

    def read(j: JsValue) = {
      j.asJsObject.getFields("id", "name", "surname") match {
        case Seq(JsNumber(id), JsString(name), JsString(surname)) =>
          new Person(id.toInt, name, surname)
        case _ => throw new DeserializationException("Improperly formed Task object")
      }
    }
  }
}