package com.spothero.grpcjava.client

import com.grpc.v1.FortuneTellerAPICoroutineGrpc
import com.grpc.v1.FortuneTellerAPIGrpc
import com.grpc.v1.GetFortuneRequest
import com.grpc.v1.GetFortuneResponse
import io.grpc.ManagedChannel
import io.grpc.StatusRuntimeException
import io.grpc.stub.StreamObserver
import kotlinx.coroutines.*
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * A simple client that requests a fortune from the [FortuneTellerServer].
 */
fun fortuneTellerClientOf(managedChannel: ManagedChannel): FortuneTellerClient {
  val coroutineStub = FortuneTellerAPICoroutineGrpc.FortuneTellerAPICoroutineStub.newStub(managedChannel)
  return FortuneTellerClient(coroutineStub)
}

class FortuneTellerClient(
  val coroutineStub: FortuneTellerAPICoroutineGrpc.FortuneTellerAPICoroutineStub
) {

  fun requestFortunesAsync(): List<GetFortuneResponse> {
    println("Requesting fortunes Async...")

    val deferredFortunes = ArrayList<Deferred<GetFortuneResponse>>()

    val requestWithCar = buildFortuneRequestWithCar()
    deferredFortunes.add(GlobalScope.async(Dispatchers.Default) { coroutineStub.getFortune(requestWithCar) } )

    val requestWithBike = buildFortuneRequestWithBike()
    deferredFortunes.add(GlobalScope.async(Dispatchers.Default) { coroutineStub.getFortune(requestWithBike) } )

    return runBlocking {
      deferredFortunes.map { it.await() }
    }
  }

  private fun buildFortuneRequestWithCar(): GetFortuneRequest =
    GetFortuneRequest.newBuilder()
      .setName("Requesting with a Car")
      .setOptionalCar(
        GetFortuneRequest.Car.newBuilder()
          .setMake("Geo")
          .setModel("Metro")
          .setYear(1992)
          .build()
      )
      .setCarNickname("Best. Car. Ever.")
      .addAllFingerLengths(listOf(1, 2, 3))
      .build()

  private fun buildFortuneRequestWithBike(): GetFortuneRequest =
    GetFortuneRequest.newBuilder()
      .setName("Requesting with a Bike")
      .setBikeFrameSizeCm(90)
      .addAllFingerLengths(listOf(4, 5, 6))
      .build()
}
