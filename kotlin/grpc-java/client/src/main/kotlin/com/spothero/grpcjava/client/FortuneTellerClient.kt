package com.spothero.grpcjava.client

import com.grpc.v1.FortuneTellerAPIGrpc
import com.grpc.v1.GetFortuneRequest
import com.grpc.v1.GetFortuneResponse
import io.grpc.ManagedChannel
import io.grpc.StatusRuntimeException

/**
 * A simple client that requests a fortune from the [FortuneTellerServer].
 */
fun fortuneTellerClientOf(managedChannel: ManagedChannel): FortuneTellerClient {
  val blockingStub = FortuneTellerAPIGrpc.newBlockingStub(managedChannel)
  return FortuneTellerClient(blockingStub)
}

class FortuneTellerClient(val blockingStub: FortuneTellerAPIGrpc.FortuneTellerAPIBlockingStub) {

  fun requestFortunesSync(): List<GetFortuneResponse> {
    println("Requesting fortunes...")
    val fortunes = ArrayList<GetFortuneResponse>()

    val requestWithCar = buildFortuneRequestWithCar()
    fortunes.add(requestFortuneSync(requestWithCar))

    val requestWithBike = buildFortuneRequestWithBike()
    fortunes.add(requestFortuneSync(requestWithBike))

    return fortunes
  }

  private fun requestFortuneSync(fortuneRequest: GetFortuneRequest): GetFortuneResponse {
    return try {
      blockingStub.getFortune(fortuneRequest)
    } catch (e: StatusRuntimeException) {
      System.err.println("RPC failed: ${e.status}")
      throw e
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
