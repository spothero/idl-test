package com.spothero.grpcjava.client

import com.grpc.v1.GetFortuneRequest

fun main(args: Array<String>) {
  println("Client Hello World!")
  val fortuneRequest = GetFortuneRequest.newBuilder().build()
  println("fortuneRequest=$fortuneRequest")
}
