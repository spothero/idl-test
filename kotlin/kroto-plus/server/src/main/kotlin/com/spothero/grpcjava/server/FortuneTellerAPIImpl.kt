package com.spothero.grpcjava.server

import com.grpc.v1.FortuneTellerAPIGrpc
import com.grpc.v1.GetFortuneRequest
import com.grpc.v1.GetFortuneResponse
import io.grpc.stub.StreamObserver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FortuneTellerAPIImpl(val fortuneTellerService: FortuneTellerService)
  : FortuneTellerAPIGrpc.FortuneTellerAPIImplBase()
{

  override fun getFortune(
    request: GetFortuneRequest,
    responseObserver: StreamObserver<GetFortuneResponse>
  ) {
    GlobalScope.launch(Dispatchers.Default) {
      val response = fortuneTellerService.getFortuneAsync(request).await()
      responseObserver.onNext(response)
      responseObserver.onCompleted()
    }
  }
}
