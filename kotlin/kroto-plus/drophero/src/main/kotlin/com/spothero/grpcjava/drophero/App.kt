package com.spothero.grpcjava.drophero

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.spothero.drophero.SpotHeroApplication
import com.spothero.grpcjava.servercore.FortuneTellerCoroutineAPIImpl
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import io.grpc.Server

fun main(args: Array<String>) {
  App().run(*args)
}

class App : SpotHeroApplication<Configuration>() {

  private lateinit var grpcServer: Server

  override fun runInternal(configuration: Configuration, environment: Environment) {
    val fortuneTellerAPI = this.injector.getInstance(FortuneTellerCoroutineAPIImpl::class.java)

    grpcServer = configuration.grpcServer
      .builder(environment)
      .addService(fortuneTellerAPI)
      .build()
  }

  override fun initializeInternal(bootstrap: Bootstrap<Configuration>) {
    configureObjectMapper(bootstrap.objectMapper)
  }

  private fun configureObjectMapper(objectMapper: ObjectMapper) {
    objectMapper
      .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
      .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
      .registerModule(Jdk8Module())
      .registerModule(KotlinModule())
  }
}
