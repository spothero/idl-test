package com.spothero.grpcjava.server

import io.grpc.Server
import io.grpc.ServerBuilder
import java.io.IOException

internal class FortuneTellerServer {

  private lateinit var server: Server

  @Throws(IOException::class)
  internal fun start() {
    /* The port on which the server should run */
    val port = 50051
    // This would come from DI in a full implementation
    val fortuneTellerService = FortuneTellerService()
    server = ServerBuilder.forPort(port)
      .addService(FortuneTellerAPIImpl(fortuneTellerService))
      .build()
      .start()

    println("Server started, listening on $port")

    Runtime.getRuntime().addShutdownHook(object : Thread() {
      override fun run() {
        // Use stderr here since the logger may have been reset by its JVM shutdown hook.
        System.err.println("*** shutting down gRPC server since JVM is shutting down")
        this@FortuneTellerServer.stop()
        System.err.println("*** server shut down")
      }
    })
  }

  private fun stop() {
    server.shutdown()
  }

  /**
   * Await termination on the main thread since the grpc library uses daemon threads.
   */
  @Throws(InterruptedException::class)
  internal fun blockUntilShutdown() {
    server.awaitTermination()
  }
}
