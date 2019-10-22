package com.spothero.krotoplus.micronautgrpc

import com.grpc.v1.FortuneTellerAPICoroutineGrpc
import com.grpc.v1.GetFortuneRequest
import com.grpc.v1.GetFortuneResponse
import javax.inject.Singleton

@Singleton
class FortuneTellerAPIImpl(val fortuneTellerService: FortuneTellerService) :
  FortuneTellerAPICoroutineGrpc.FortuneTellerAPIImplBase() {

  override suspend fun getFortune(request: GetFortuneRequest): GetFortuneResponse {
    return fortuneTellerService.getFortuneAsync(request).await()
  }
}
