package com.spothero.grpcjava.server

import com.grpc.v1.FortuneTellerAPICoroutineGrpc
import com.grpc.v1.FortuneTellerAPIGrpc
import com.grpc.v1.GetFortuneRequest
import com.grpc.v1.GetFortuneResponse
import io.grpc.stub.StreamObserver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FortuneTellerAPIImpl(val fortuneTellerService: FortuneTellerService) :
  FortuneTellerAPICoroutineGrpc.FortuneTellerAPIImplBase() {

  override suspend fun getFortune(request: GetFortuneRequest): GetFortuneResponse {
    return fortuneTellerService.getFortuneAsync(request).await()
  }
}
