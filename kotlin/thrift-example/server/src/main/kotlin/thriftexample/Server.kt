package thriftexample

import fortune.Car
import fortune.FortuneRequest
import fortune.FortuneTeller
import fortune.VehicleDescription
import org.apache.thrift.server.TServer
import org.apache.thrift.server.TSimpleServer
import org.apache.thrift.transport.TServerSocket

object Server {
    @JvmStatic
    fun main(_args: Array<String>) {
        try {
            val service = FortuneTellerService()
            val processor = FortuneTeller.Processor(service)
            val simple = Runnable { runServer(processor) }
            Thread(simple).start()
        } catch (x: Exception) {
            x.printStackTrace()
        }
    }

    private fun runServer(processor: FortuneTeller.Processor<FortuneTellerService>) {
        try {
            val serverTransport = TServerSocket(9090)
            val server = TSimpleServer(TServer.Args(serverTransport).processor(processor))
            println("Starting a simple server...")
            server.serve()
        } catch (e: Exception) {
            e.printStackTrace()

        }
    }

    /*
    // Left this in here for now to bypass the thrift server logic
    fun consoleMain(_args: Array<String>) {
        val service = FortuneTellerService()

        val request = RequestFactory.create()
        val response = service.GetFortune(request)

        println(response)
    }
    */
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
