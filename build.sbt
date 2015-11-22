name := "akka-kafka"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.4.0"
libraryDependencies += "com.typesafe.akka" % "akka-slf4j_2.11" % "2.4.0"

libraryDependencies += "io.spray" % "spray-json_2.11" % "1.3.2"
libraryDependencies += "io.spray" % "spray-http_2.11" % "1.3.3"
libraryDependencies += "io.spray" % "spray-routing_2.11" % "1.3.3"
libraryDependencies += "io.spray" % "spray-can_2.11" % "1.3.3"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3"
libraryDependencies += "ch.qos.logback" % "logback-core" % "1.1.3"
libraryDependencies += "org.json4s" % "json4s-native_2.11" % "3.3.0"
