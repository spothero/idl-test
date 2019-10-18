package com.spothero.grpcjava.client

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
  println("Client Hello World!")

  val managedChannel = managedChannelOf("localhost", 50051)
  val client = fortuneTellerClientOf(managedChannel)

  try {
    /* Access a service running on the local machine on port 50051 */
    client.requestFortunesAsync()
      .forEach { println("Received fortune:\n$it") }
  } finally {
    managedChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS)
  }
}

private fun managedChannelOf(host: String, port: Int): ManagedChannel =
  ManagedChannelBuilder.forAddress(host, port)
    // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
    // needing certificates.
    .usePlaintext()
    .build()
