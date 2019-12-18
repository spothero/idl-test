package com.spothero.krotoplus.protobufavro

import com.grpc.v1.GetFortuneRequest
import com.grpc.v1.GrpcProtoBuilders
import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig
import org.apache.avro.Schema
import org.apache.avro.io.DecoderFactory
import org.apache.avro.io.EncoderFactory
import org.apache.avro.protobuf.ProtobufData
import org.apache.kafka.clients.admin.AdminClient
import org.apache.kafka.clients.admin.NewTopic
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.LongDeserializer
import org.apache.kafka.common.serialization.LongSerializer
import org.apache.kafka.common.serialization.Serializer
import org.slf4j.LoggerFactory
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer
import java.time.Duration
import java.time.temporal.ChronoUnit
import java.util.concurrent.TimeUnit

val logger = LoggerFactory.getLogger(object{}.javaClass)
const val GET_FORTUNE_REQUESTS_TOPIC = "get-fortune-requests"
const val SCHEMA_REGISTRY_URL = "http://localhost:8081"
const val GET_FORTUNE_REQUESTS_VALUE_SUBJECT = "get-fortune-requests-value"
val bootstrapServers = "bootstrap.servers" to "localhost:9092"
val kafkaAdminClient = AdminClient.create(mapOf(bootstrapServers))
val getFortuneRequestProducer = KafkaProducer<Long, GetFortuneRequest>(mapOf(
  bootstrapServers,
  ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to LongSerializer::class.java.name,
  ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to GetFortuneRequestAvroSerializer::class.java.name,
  KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG to "http://localhost:8081"
))
val getFortuneRequestConsumer = KafkaConsumer<Long, GetFortuneRequest>(mapOf(
  bootstrapServers,
  ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to LongDeserializer::class.java.name,
  ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to GetFortuneRequestAvroDeserializer::class.java.name,
  KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG to "http://localhost:8081",
  KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG to true,
  ConsumerConfig.GROUP_ID_CONFIG to "sample-kotlin-consumer"
))
val getFortuneRequestSchema = createGetFortuneRequestSchema()
val schemaRegistryClient = CachedSchemaRegistryClient(SCHEMA_REGISTRY_URL, 100)

val getFortuneRequest = GrpcProtoBuilders.GetFortuneRequest {
  name = "Request1"
  optionalCar = GrpcProtoBuilders.GetFortuneRequest.Car {
    make = "Geo"
    model = "Metro"
    year = 1992
  }
  carNickname = "Greatest. Car. Ever."
  bikeFrameSizeCm = 99 // Excluding this field works, but defaults to 0
  addAllFingerLengths(listOf(42, 24))
}

fun main(args: Array<String>) {
//  createGetFortuneRequestsTopic()
  registerGetFortuneRequestSchema()
  subscribeConsumer()
  publishGetFortuneRequest()
  consumeGetFortuneRequest()
}

fun createGetFortuneRequestSchema(): Schema = ProtobufData.get().getSchema(GetFortuneRequest.getDescriptor())

fun createGetFortuneRequestsTopic() {
  val newTopic = NewTopic(GET_FORTUNE_REQUESTS_TOPIC, 1, 1)
  logger.info("Creating topic...")
  val futureResult = kafkaAdminClient.createTopics(listOf(newTopic))
  logger.info("Waiting on topic creation...")
  futureResult.all().get(4, TimeUnit.SECONDS)
  logger.info("Done!")
}

fun registerGetFortuneRequestSchema() {
  schemaRegistryClient.register(GET_FORTUNE_REQUESTS_VALUE_SUBJECT, getFortuneRequestSchema)
}

fun subscribeConsumer() {
  getFortuneRequestConsumer.subscribe(listOf(GET_FORTUNE_REQUESTS_TOPIC))
}

fun publishGetFortuneRequest() {
  logger.info("Sending getFortuneRequest...")
  val futureSend = getFortuneRequestProducer.send(
    ProducerRecord(
      GET_FORTUNE_REQUESTS_TOPIC,
      System.currentTimeMillis(),
      getFortuneRequest
    )
  )

  logger.info("Waiting on send...")
  val sendResult = futureSend.get(5, TimeUnit.SECONDS)

  logger.info("Done sending: $sendResult")
}

fun consumeGetFortuneRequest() {
  logger.info("Consuming getFortuneRequest...")
  var consumeCount = 0
  while (consumeCount == 0) {
    consumeCount = consumeRecordsInt()
    logger.info("Consumed $consumeCount records")
  }
}

private fun consumeRecordsInt(): Int {
  val records = getFortuneRequestConsumer.poll(Duration.of(10, ChronoUnit.SECONDS))
  records.forEach {
    logger.info("Consumed $it")
    assert(it.value().equals(getFortuneRequest)) {
      "Consumed message not equivalent to input!"
    }
  }
  return records.count()
}

class GetFortuneRequestAvroSerializer : Serializer<GetFortuneRequest> {

  private val getFortuneRequestSchema = createGetFortuneRequestSchema()
  private val datumWriter = ProtobufData.get().createDatumWriter(getFortuneRequestSchema)

  override fun serialize(topic: String, data: GetFortuneRequest): ByteArray {
    val outputStream = ByteArrayOutputStream(1024)
    val binaryEncoder = EncoderFactory.get().binaryEncoder(outputStream, null)

//    outputStream.write(0)
//    val schemaId = schemaRegistryClient.getId(GET_FORTUNE_REQUESTS_VALUE_SUBJECT, getFortuneRequestSchema)
//    outputStream.write(ByteBuffer.allocate(4).putInt(schemaId).array())

    datumWriter.write(data, binaryEncoder)
    binaryEncoder.flush()
    outputStream.flush()
    outputStream.close()
    return outputStream.toByteArray()
  }
}

class GetFortuneRequestAvroDeserializer : Deserializer<GetFortuneRequest> {

  private val datumReader = ProtobufData.get().createDatumReader(createGetFortuneRequestSchema())

  override fun deserialize(topic: String, data: ByteArray): GetFortuneRequest {
//    val buffer = ByteBuffer.wrap(data)
//    val magicNumber = buffer.get()
//    logger.info("magicNumber=$magicNumber")
//    val id = buffer.int
//    logger.info("schemaId=$id")
//
//    val length = buffer.limit() - 1 - 4
//    val start = buffer.position() + buffer.arrayOffset()
//    val binaryDecoder = DecoderFactory.get().binaryDecoder(buffer.array(), start, length, null)
//    return datumReader.read(null, binaryDecoder) as GetFortuneRequest

    val binaryDecoder = DecoderFactory.get().binaryDecoder(data, null)
    return datumReader.read(null, binaryDecoder) as GetFortuneRequest
  }
}
