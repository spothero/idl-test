package thriftexample

import fortune.Animal
import fortune.FortuneRequest
import fortune.FortuneResponse
import fortune.FortuneTeller
import kotlin.random.Random

class FortuneTellerService : FortuneTeller.Iface {
    override fun GetFortune(request: FortuneRequest): FortuneResponse {
        return ResponseBuilder.buildResponse(request)
    }

    object ResponseBuilder {
        fun buildResponse(request: FortuneRequest): FortuneResponse {
            val response = FortuneResponse()
            response.fortune = getFortune(request)
            response.lucky_numbers = request.finger_lengths.filter { it % 2 == 0}

            val random = Random.Default
            val luckyAnimalIndex = random.nextInt(0, Animal.values().size - 1)
            val luckyAnimal = Animal.values().get(luckyAnimalIndex)
            response.lucky_animal = luckyAnimal

            return response
        }

        fun getFortune(request: FortuneRequest): String {
            if (request.optional_car != null) {
                return """
                    You drive a '${request.vehicle_description.car_nickname}',
                    which is a ${request.optional_car}
                    """.trimIndent()
            }

            return "You ride a bike with frame size ${request.vehicle_description.bike_frame_size_cm} cm"
        }
    }
}

