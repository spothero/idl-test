package thriftexample

import fortune.*

fun main(args: Array<String>) {
    val service = FortuneTellerService()

    val request = RequestFactory.create()
    val response = service.GetFortune(request)

    println(response)
}

// Will likely live in the Client
object RequestFactory {
    private fun createCar(): Car {
        val car = Car()
        car.make = "Trabant"
        car.model = "601"
        car.year = 1981
        return car
    }

    private fun createVehicleDescription(): VehicleDescription {
        val vehDesc = VehicleDescription()
        vehDesc.car_nickname = "Trabi"
        return vehDesc;
    }

    fun create(): FortuneRequest {
        val request = FortuneRequest()

        request.name = "my fortune request"
        request.optional_car = createCar()
        request.vehicle_description = createVehicleDescription()

        request.finger_lengths = (1..6).toList()
        request.sibling_ages = hashMapOf(
                "Paul" to 24,
                "Amy" to 22,
                "Papa John" to 65
        )

        return request
    }
}
