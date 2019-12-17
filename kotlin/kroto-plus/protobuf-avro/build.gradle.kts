dependencies {
  // avro-protobuf uses protobuf-java 3.6.1, which is incompatible with other stuff
  // force protobuf-java 3.10.0
  implementation("org.apache.avro", "avro-protobuf")
  implementation("com.google.protobuf", "protobuf-java", "3.10.0")
  implementation(project(":model"))
  implementation("org.apache.kafka", "kafka-clients")
  implementation("io.confluent", "kafka-avro-serializer")
  runtimeOnly("ch.qos.logback:logback-classic:1.2.3")
}