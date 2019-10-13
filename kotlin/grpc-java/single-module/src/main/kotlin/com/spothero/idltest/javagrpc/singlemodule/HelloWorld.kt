package com.spothero.idltest.javagrpc.singlemodule

import com.grpc.v1.GetFortuneRequest

fun main(args: Array<String>) {
  println("Hello World!")
  val fortuneRequest = GetFortuneRequest.newBuilder().build()
  println("fortuneRequest=$fortuneRequest")
}
