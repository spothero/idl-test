package com.spothero.grpcjava.server

import com.typesafe.config.ConfigBeanFactory
import com.typesafe.config.ConfigFactory

fun main(args: Array<String>) {
  println("Server Hello World!")

  val config = ConfigFactory.load()
  val configObj = ConfigBeanFactory.create(config, ConfigData::class.java)

  println("Config=$configObj")

  val server = FortuneTellerServer()
  server.start()
  server.blockUntilShutdown()
}
