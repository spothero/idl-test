package com.spothero.grpcjava.server

fun main(args: Array<String>) {
  println("Server Hello World!")
  val server = FortuneTellerServer()
  server.start()
  server.blockUntilShutdown()
}
