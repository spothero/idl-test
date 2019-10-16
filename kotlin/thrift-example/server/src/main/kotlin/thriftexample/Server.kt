package thriftexample

import fortune.FortuneTeller
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
    // Left this in here for now
    // Example to bypass the thrift server logic
    fun consoleMain(_args: Array<String>) {
        val service = FortuneTellerService()

        val request = RequestFactory.create()
        val response = service.GetFortune(request)

        println(response)
    }
    */
}
