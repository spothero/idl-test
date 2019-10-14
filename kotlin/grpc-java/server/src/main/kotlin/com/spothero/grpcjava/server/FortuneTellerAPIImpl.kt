package com.spothero.grpcjava.server

import com.grpc.v1.FortuneTellerAPIGrpc
import com.grpc.v1.GetFortuneRequest
import com.grpc.v1.GetFortuneResponse
import io.grpc.stub.StreamObserver

class FortuneTellerAPIImpl(val fortuneTellerService: FortuneTellerService)
  : FortuneTellerAPIGrpc.FortuneTellerAPIImplBase()
{

  override fun getFortune(
    request: GetFortuneRequest,
    responseObserver: StreamObserver<GetFortuneResponse>
  ) {
    println("Getting Fortune!")
    val response = fortuneTellerService.getFortune(request)
    responseObserver.onNext(response)
    responseObserver.onCompleted()
  }
}
