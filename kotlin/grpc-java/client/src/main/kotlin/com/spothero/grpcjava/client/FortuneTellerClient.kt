package com.spothero.grpcjava.client

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
  val blockingStub = FortuneTellerAPIGrpc.newBlockingStub(managedChannel)
  val stub = FortuneTellerAPIGrpc.newStub(managedChannel)
  return FortuneTellerClient(blockingStub, stub)
}

class FortuneTellerClient(
  val blockingStub: FortuneTellerAPIGrpc.FortuneTellerAPIBlockingStub,
  val stub: FortuneTellerAPIGrpc.FortuneTellerAPIStub
) {

  fun requestFortunesSync(): List<GetFortuneResponse> {
    println("Requesting fortunes...")
    val fortunes = ArrayList<GetFortuneResponse>()

    val requestWithCar = buildFortuneRequestWithCar()
    fortunes.add(requestFortuneSync(requestWithCar))

    val requestWithBike = buildFortuneRequestWithBike()
    fortunes.add(requestFortuneSync(requestWithBike))

    return fortunes
  }

  fun requestFortunesSyncViaIODispatcher(): List<GetFortuneResponse> {
    println("Requesting fortunes via IO Dispatcher...")

    val deferredFortunes = ArrayList<Deferred<GetFortuneResponse>>()

    val requestWithCar = buildFortuneRequestWithCar()
    deferredFortunes.add(requestFortuneBlockingInIODispatcher(requestWithCar))

    val requestWithBike = buildFortuneRequestWithBike()
    deferredFortunes.add(requestFortuneBlockingInIODispatcher(requestWithBike))

    return runBlocking {
      deferredFortunes.map { it.await() }
    }
  }

  private fun requestFortuneBlockingInIODispatcher(fortuneRequest: GetFortuneRequest): Deferred<GetFortuneResponse> {
    return GlobalScope.async(Dispatchers.IO) {
      requestFortuneSync(fortuneRequest)
    }
  }

  fun requestFortunesAsync(): List<GetFortuneResponse> {
    println("Requesting fortunes Async...")

    val deferredFortunes = ArrayList<Deferred<GetFortuneResponse>>()

    val requestWithCar = buildFortuneRequestWithCar()
    deferredFortunes.add(GlobalScope.async(Dispatchers.Default) { requestFortuneAsync(requestWithCar) } )

    val requestWithBike = buildFortuneRequestWithBike()
    deferredFortunes.add(GlobalScope.async(Dispatchers.Default) { requestFortuneAsync(requestWithBike) } )

    return runBlocking {
      deferredFortunes.map { it.await() }
    }
  }

  // TODO: async via streaming will work similarly.  onNext will pipe the element to a channel
  // TODO: onCompleted will close the channel
  private suspend fun requestFortuneAsync(fortuneRequest: GetFortuneRequest): GetFortuneResponse {
    return suspendCoroutine { cont ->
      stub.getFortune(fortuneRequest, object : StreamObserver<GetFortuneResponse> {
        var result: GetFortuneResponse? = null
        override fun onNext(value: GetFortuneResponse?) {
          result = value
        }

        override fun onError(t: Throwable?) {
          cont.resumeWithException(t!!)
        }

        override fun onCompleted() {
          cont.resume(result!!)
        }
      })
    }
  }

  private fun requestFortuneSync(fortuneRequest: GetFortuneRequest): GetFortuneResponse {
    return try {
      blockingStub.getFortune(fortuneRequest)
    } catch (e: StatusRuntimeException) {
      System.err.println("RPC failed: ${e.status}")
      throw e
    }
  }

//  private suspend fun requestFortuneAsync(fortuneRequest: GetFortuneRequest): GetFortuneResponse {
//    future {
//      val futureResult = futureStub.getFortune(fortuneRequest)
//    }
//    return try {
//      blockingStub.getFortune(fortuneRequest)
//    } catch (e: StatusRuntimeException) {
//      System.err.println("RPC failed: ${e.status}")
//      throw e
//    }
//  }

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
