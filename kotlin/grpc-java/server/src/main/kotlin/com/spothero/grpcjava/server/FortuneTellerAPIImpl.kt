package com.spothero.grpcjava.server

import com.grpc.v1.FortuneTellerAPIGrpc
import com.grpc.v1.GetFortuneRequest
import com.grpc.v1.GetFortuneResponse
import io.grpc.stub.StreamObserver

class FortuneTellerAPIImpl : FortuneTellerAPIGrpc.FortuneTellerAPIImplBase() {

  override fun getFortune(
    request: GetFortuneRequest,
    responseObserver: StreamObserver<GetFortuneResponse>
  ) {
    println("Getting Fortune!")
    val response = GetFortuneResponse.newBuilder()
      .setFortune("You're going to die")
      .setLuckyNumbers(0, 0)
      .setLuckyNumbers(1, 1)
      .setLuckyNumbers(2, 2)
      .setLuckyAnimal(GetFortuneResponse.Animal.ANIMAL_MONKEY)
      .build()
    responseObserver.onNext(response)
    responseObserver.onCompleted()
  }
}
