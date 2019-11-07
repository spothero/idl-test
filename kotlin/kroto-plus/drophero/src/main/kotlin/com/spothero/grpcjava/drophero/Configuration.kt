package com.spothero.grpcjava.drophero

import com.spothero.drophero.SpotHeroConfiguration
import io.dropwizard.grpc.server.GrpcServerFactory
//import io.dropwizard.grpc.server.GrpcServerFactory
import javax.validation.Valid
import javax.validation.constraints.NotNull

data class Configuration(
  @Valid @NotNull var grpcServer: GrpcServerFactory
)
  : SpotHeroConfiguration()
