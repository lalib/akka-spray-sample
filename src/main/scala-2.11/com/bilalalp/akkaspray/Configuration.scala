package com.bilalalp.akkaspray

import com.typesafe.config.ConfigFactory

object Configuration {

  val c = ConfigFactory.load()

  val appInterface = c.getString("app.interface")
  val appPort = c.getInt("app.port")
}