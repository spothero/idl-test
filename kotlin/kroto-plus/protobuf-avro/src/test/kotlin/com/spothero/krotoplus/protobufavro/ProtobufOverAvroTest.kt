package com.spothero.krotoplus.protobufavro

import com.grpc.v1.GetFortuneRequest
import org.apache.avro.Schema
import org.apache.avro.protobuf.ProtobufData
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import com.grpc.v1.GrpcProtoBuilders
import org.apache.avro.io.DecoderFactory
import org.apache.avro.io.EncoderFactory
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PipedInputStream
import java.io.PipedOutputStream

class ProtobufOverAvroTest {

  @Test
  fun `should get Avro Schema for Protobuf class`() {
    val expectedFields = listOf(
      "name",
      "optional_car",
      "car_nickname",
      "bike_frame_size_cm",
      "finger_lengths",
      "sibling_ages"
    )

    val schemaByClass = ProtobufData.get().getSchema(GetFortuneRequest::class.java)

    val actualFieldNames = schemaByClass.fields.map(Schema.Field::name)
    assertEquals(expectedFields, actualFieldNames)

    val schemaByDescriptor = ProtobufData.get().getSchema(GetFortuneRequest.getDescriptor())
    assertEquals(schemaByClass, schemaByDescriptor)
  }

  @Test
  fun `should roundtrip a Protobuf via Avro`() {
    val sourceGetFortune = GrpcProtoBuilders.GetFortuneRequest {
      name = "Request1"
      optionalCar = GrpcProtoBuilders.GetFortuneRequest.Car {
        make = "Geo"
        model = "Metro"
        year = 1992
      }
      carNickname = "Greatest. Car. Ever."
      bikeFrameSizeCm = 99 // Excluding this field works, but defaults to 0
      addAllFingerLengths(listOf(42, 24))
//      putAllSiblingAges(mapOf(
//        "Larry" to 30,
//        "Moe" to 31,
//        "Curly" to 32
//      ))
    }

    // SpecificData::getClass can't handle a protobuf map.  Protobuf treats map entries
    // as messages with 'key' and 'value' properties.  They are com.google.protobuf.MapEntry
    // objects and given names like 'com.grpc.v1.GetFortuneRequest.SiblingAgesEntry'.
    // SpecificData::getClass isn't set up to handle these map entries and fails to detect
    // the class.  That method is written with a recursive resolver which assumes the recursion
    // will terminate, but never does.

    val getFortuneRequestSchema = ProtobufData.get().getSchema(GetFortuneRequest.getDescriptor())

    // Binary streams to write to, then read from
    val outputStream = ByteArrayOutputStream(1024)
    val binaryEncoder = EncoderFactory.get().binaryEncoder(outputStream, null)
    val datumWriter = ProtobufData.get().createDatumWriter(getFortuneRequestSchema)
    datumWriter.write(sourceGetFortune, binaryEncoder)
    binaryEncoder.flush()
    outputStream.flush()
    outputStream.close()
    val binaryDataArray = outputStream.toByteArray()

    val binaryDecoder = DecoderFactory.get().binaryDecoder(binaryDataArray, null)
    val datumReader = ProtobufData.get().createDatumReader(getFortuneRequestSchema)

    val readGetFortune = datumReader.read(null, binaryDecoder)
    // Source and Read values should be equal
    assertEquals(sourceGetFortune, readGetFortune)
  }
}