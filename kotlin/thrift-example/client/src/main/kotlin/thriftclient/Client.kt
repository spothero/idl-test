package thriftclient

import fortune.Car
import fortune.FortuneRequest
import fortune.FortuneTeller
import fortune.VehicleDescription
import org.apache.thrift.TException
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.transport.TSocket

object Client {
    @JvmStatic
    fun main(_args: Array<String>) {
        try {
            val transport = TSocket("localhost", 9090)
            transport.open()

            val protocol = TBinaryProtocol(transport)
            val client = FortuneTeller.Client(protocol)

            perform(client)

            transport.close()
        } catch (x: TException) {
            x.printStackTrace()
        }
    }

    fun perform(client: FortuneTeller.Client) {
        println("From client...")
        val response = client.GetFortune(RequestFactory.create())
        println("The response is:")
        println(response)
    }

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
}

