package com.spothero.grpcjava.servercore

import com.grpc.v1.GetFortuneRequest
import com.grpc.v1.GetFortuneResponse
import kotlinx.coroutines.*
import kotlin.random.Random

class FortuneTellerService {

  val random = Random.Default

  fun getFortuneAsync(getFortuneRequest: GetFortuneRequest): Deferred<GetFortuneResponse> {
    return GlobalScope.async(Dispatchers.Default) {
      delay(random.nextLong(500, 1000))
      getFortune(getFortuneRequest)
    }
  }

  fun getFortune(getFortuneRequest: GetFortuneRequest): GetFortuneResponse {
    if (getFortuneRequest.hasOptionalCar()) {
      println("\nYou drive '${getFortuneRequest.carNickname}', which is a\n${getFortuneRequest.optionalCar}")
    } else {
      println("\nYou ride a bike with frame size ${getFortuneRequest.bikeFrameSizeCm} cm")
    }

    return newFortune()
  }

  private fun newFortune(): GetFortuneResponse {
    val luckyNumbers = (1..5)
      .map {
        random.nextInt(1, 100)
      }

    val luckyAnimalIndex = random.nextInt(1, GetFortuneResponse.Animal.values().size - 2)
    val luckyAnimal = GetFortuneResponse.Animal.forNumber(luckyAnimalIndex)

    return GetFortuneResponse.newBuilder()
      .setFortune("You're going to die")
      .addAllLuckyNumbers(luckyNumbers)
      .setLuckyAnimal(luckyAnimal)
      .build()
  }

}