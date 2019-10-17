package thriftclient

import fortune.Car
import fortune.FortuneRequest
import fortune.FortuneTeller
import fortune.UnfortunateException
import fortune.VehicleDescription
import kotlin.random.Random
import org.apache.thrift.TException
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.transport.TSocket
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Client {
    private val logger: Logger = LoggerFactory.getLogger("ServerLogger")

    @JvmStatic
    fun main(_args: Array<String>) {
        try {
            TSocket("localhost", 9090).use {
                it.open()

                val protocol = TBinaryProtocol(it)
                val client = FortuneTeller.Client(protocol)

                perform(client)
            }
        } catch (x: TException) {
            x.printStackTrace()
        }
    }

    fun perform(client: FortuneTeller.Client) {
        logger.info("From client...")
        try {
            val response = client.GetFortune(RequestFactory.create())
            logger.info("The response is:")
            logger.info(response.toString())
        } catch (_ex: UnfortunateException) {
            logger.error(
                "Sorry, UnfortunateException was thrown by the remote service")
        }
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
            return vehDesc
        }

        private fun createFingerLengths(upTo: Int): List<Int> {
            val random = Random.Default
            return 1.rangeTo(upTo).toList().map {
                random.nextInt(1, upTo + 1)
            }
        }

        fun create(): FortuneRequest {
            val request = FortuneRequest()

            request.name = "my fortune request"
            request.optional_car = createCar()
            request.vehicle_description = createVehicleDescription()
            request.finger_lengths = createFingerLengths(10)

            request.sibling_ages = hashMapOf(
                    "Paul" to 24,
                    "Amy" to 22,
                    "Papa John" to 65
            )

            return request
        }
    }
}
