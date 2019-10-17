package thriftserver

import fortune.Car
import fortune.FortuneRequest
import fortune.FortuneTeller
import fortune.VehicleDescription
import org.apache.thrift.server.TServer
import org.apache.thrift.server.TSimpleServer
import org.apache.thrift.transport.TServerSocket
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.random.Random

object Server {
    private val logger: Logger = LoggerFactory.getLogger("ServerLogger")

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
            logger.info("Starting server...")
            server.serve()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /*
    // Left this in here for now
    // Example to bypass the thrift server logic
    @JvmStatic
    fun main(_args: Array<String>) {
        val service = FortuneTellerService()

        val request = RequestFactory.create()
        val response = service.GetFortune(request)

        println(response)
    }
    */
}
